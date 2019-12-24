package com.jk.lcw.controller;

import com.jk.lcw.model.Advertising;
import com.jk.lcw.model.Cart;
import com.jk.lcw.model.Product;
import com.jk.lcw.model.UserCarts;
import com.jk.lcw.service.ProductService;
import com.jk.lcw.service.ProductServiceEntity;
import com.jk.lcw.utils.Conf;
import com.jk.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

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
    @ResponseBody
    public void  removeCart(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(request.getSession().getId());
        mongoTemplate.remove(new Query().addCriteria(Criteria.where("userid").is(user.getUserid())),UserCarts.class);
    }



    @RequestMapping("queryadvertising")
    @ResponseBody
    public List<Advertising> queryadvertising(){

        return productService.queryadvertising();
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


    @RequestMapping("xiu")
    @ResponseBody
    public void xiu(User user){
        productService.xiu(user);
    }


}
