package com.jk.lcw.controller;

import com.jk.lcw.model.*;
import com.jk.lcw.repository.ProductResopitory;
import com.jk.lcw.service.ProductService;
import com.jk.lcw.service.ProductServiceEntity;
import com.jk.lcw.utils.Conf;
import com.jk.user.model.User;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");



    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ProductResopitory productResopitory;

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("queryProduct")
    @ResponseBody
    public List queryProduct(){
        List a=productService.queryProduct();
        return  a;
    }

    /** @Author 原国庆
     * @Description: 新增购物车
     * @Param: [cart]
     * @Return: void
     * @Create: 2019/12/18 9:07
     */
    @RequestMapping("addCart")
    @ResponseBody
    public void  addCart(Cart cart,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(request.getSession().getId());
        Query query = new Query();
        query.addCriteria(Criteria.where("userid").is(user.getUserid()));
        boolean b = mongoTemplate.exists(query, UserCarts.class);
        System.out.println(b);
        UserCarts userCarts = new UserCarts();
        if(!b){
            userCarts.setUserid(user.getUserid());
            List<Cart> list = new ArrayList<>();
            list.add(cart);
            userCarts.setList(list);
            mongoTemplate.save(userCarts);
        }else{
            List<UserCarts> carts = mongoTemplate.find(query, UserCarts.class);
            System.out.println(carts);
            List<Cart> list = carts.get(0).getList();
            userCarts.setUserid(user.getUserid());
            list.add(cart);
            userCarts.setList(list);
            mongoTemplate.save(userCarts);
        }
    }

    /** @Author 原国庆
     * @Description: 查询购物车
     * @Param: []
     * @Return: java.util.List<com.jk.lcw.model.Cart>
     * @Create: 2019/12/18 9:08
     */
    @RequestMapping("queryCart")
    @ResponseBody
    public List<Cart> queryCart(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(request.getSession().getId());
        List<UserCarts> list = mongoTemplate.find(new Query().addCriteria(Criteria.where("userid").is(user.getUserid())),UserCarts.class);
        return list.get(0).getList();
    }

    /** @Author 原国庆
     * @Description: 清空购物车
     * @Param: [request]
     * @Return: void
     * @Create: 2019/12/18 13:47
     */
    @RequestMapping("removeCart")
    public String  removeCart(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(request.getSession().getId());
        mongoTemplate.remove(new Query().addCriteria(Criteria.where("userid").is(user.getUserid())),UserCarts.class);
        return "lcw/cart";
    }


    @Scheduled(fixedRate = 900000000)
    @RequestMapping("queryadvertising")
    @ResponseBody
    public List<Advertising> queryadvertising(){
        List l=productService.queryadvertising();
        return l;
    }

    @RequestMapping("addShouCang")
    @ResponseBody
    public void addShouCang(HttpServletRequest request, Cart cart){
       String key= Conf.SHOUCANG;
        User user = (User) request.getSession().getAttribute(request.getSession().getId());
        Query query = new Query();
        query.addCriteria(Criteria.where("userid").is(user.getUserid()));
        boolean exists = mongoTemplate.exists(query, UserCarts.class);
        UserCarts userCarts = new UserCarts();
        userCarts.setShoucangid(key);
        if(!exists){
            userCarts.setUserid(user.getUserid());
            List<Cart> carts = new ArrayList<>();
            carts.add(cart);
            userCarts.setList(carts);
            mongoTemplate.save(userCarts);
        }else{
            List<UserCarts> userCarts1 = mongoTemplate.find(query, UserCarts.class);
            List<Cart> list = userCarts1.get(0).getList();
            list.add(cart);
            userCarts.setUserid(user.getUserid());
            userCarts.setList(list);
            mongoTemplate.save(userCarts);
        }

    }
    @RequestMapping("queryshou")
    @ResponseBody
    public List<Cart> queryshou(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(request.getSession().getId());
        List<UserCarts> list = mongoTemplate.find(new Query().addCriteria(Criteria.where("userid").is(user.getUserid())),UserCarts.class);
        return list.get(0).getList();
    }

    /** @Author 原国庆
     * @Description: Es所有商品搜索引擎
     * @Param: [page, rows, c]
     * @Return: Map<String,Object>
     * @Create: 2019/12/23 14:04
     */
    @RequestMapping("queryProductAll")
    @ResponseBody
    public Map<String,Object> queryProductEs(Integer page, Integer rows, ProductEs c){
        //可以对 名称  介绍 类型 模糊匹配  并且 高亮
        //对名称  介绍 类型  价格区间进行过滤
        //对价格进行排序  desc
        //分页

        //处理参数
        if (page == 0)
            page = 1;
        if (rows == null)
            rows = 12;

        //创建 返回体
        HashMap<String, Object> result = new HashMap<>();

        //获取 查询组件
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        //汽车名称
        if (c.getProductname() != null && !"".equals(c.getProductname())){
            boolQueryBuilder.must(QueryBuilders.matchQuery("productname",c.getProductname()));
        }

        //获取高亮的组件
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("productname");
        highlightBuilder.preTags("<span style='color:red;'>");
        highlightBuilder.postTags("</span>");

        //通过模板  获取搜索请求组件
        SearchRequestBuilder carindex1 = elasticsearchTemplate.getClient().prepareSearch("productindex1")
                .setExplain(true)  //设置是否对相关度进行排序   这里设置的是 是
                .highlighter(highlightBuilder)// 设置高亮策略
                .setQuery(boolQueryBuilder) //设置查询策略
                .setTypes("product1")    //设置 索引中的类名
                .addSort("sizeprice", SortOrder.DESC) //设置 排序 策略  这里是对  商品价格  进行  逆序排序
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH) //设置查询的类型  有四种
                .setFrom((page - 1)*rows) //设置分页其实位置
                .setSize(rows);//设置每页条数

        //获取响应体
        SearchResponse searchResponse = carindex1.get();

        SearchHits hits = searchResponse.getHits();

        //获取总条数
        int totalHits = (int) hits.totalHits;

        //获取数据存放的组件
        SearchHit[] hitsHits = hits.getHits();

        List<ProductEs> carList = new ArrayList<>();

        for (SearchHit searchHit : hitsHits){
            //创建一个实体
            ProductEs car = new ProductEs();

            Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();

            HighlightField productName = highlightFields.get("productname");

            //处理高亮字段
            if (productName == null){//如果高亮字段是空  那么 就用查找出的 普通的 字段
                car.setProductname(searchHit.getSourceAsMap().get("productname").toString());
            }else{ //如果 不是空那么 就用 高亮字段  替换掉  普通的字段
                car.setProductname(productName.fragments()[0].toString());
            }

            car.setId((Integer) searchHit.getSourceAsMap().get("id"));
            car.setSizeimg((String) searchHit.getSourceAsMap().get("sizeimg"));
            car.setSizeprice((Double) searchHit.getSourceAsMap().get("sizeprice"));
            carList.add(car);
        }
        result.put("total",totalHits);
        result.put("rows",carList);
        return result;
    }


    @RequestMapping("shou")
    public String shou(){
      return "lcw/shou";
    }

    @RequestMapping("users")
    public String queryusers(HttpServletRequest request, HttpSession session, Model model){
    User user1= (User) request.getSession().getAttribute(request.getSession().getId());

    session.setAttribute("list",user1);
        return "lcw/users";
    }

    /** @Author 原国庆
     * @Description:删除Es数据
     * @Param: []
     * @Return: void
     * @Create: 2019/12/23 20:12
     */
    @RequestMapping("deleteEs")
    @ResponseBody
    public void deleteEs(){
        productResopitory.deleteAll();
    }

    /** @Author 原国庆
     * @Description:新增Es
     * @Param: []
     * @Return: void
     * @Create: 2019/12/23 20:12
     */
    @RequestMapping("addEs")
    @ResponseBody
    public void addEs(){
        List<ProductEs> list=productService.queryProductAll();
        for (int i=0;i<list.size();i++){
            productResopitory.save(list.get(i));
        }
        System.out.println(list);
    }

    @RequestMapping("toEsCategory")
    public String toEsCategory(){
        return "lcw/category";
    }

    /** @Author 原国庆
     * @Description:跳转购物车
     * @Param: []
     * @Return: java.lang.String
     * @Create: 2019/12/23 20:12
     */
    @RequestMapping("toCarts")
    public String toCarts(){
        return "lcw/cart";
    }


    @RequestMapping("xiu")
    @ResponseBody
    public void xiu(User user){
        productService.xiu(user);
    }


}
