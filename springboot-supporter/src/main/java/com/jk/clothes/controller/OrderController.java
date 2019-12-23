package com.jk.clothes.controller;

import com.github.pagehelper.PageInfo;
import com.jk.clothes.model.Advertising;
import com.jk.clothes.model.Order;
import com.jk.clothes.service.AreaService;
import com.jk.clothes.util.ExportExcel;
import com.jk.clothes.util.LayuiUtil;
import com.jk.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    private AreaService areaService;

    @RequestMapping("queryorder")
    @ResponseBody
    public LayuiUtil queryorder(Integer page, Integer limit){
        PageInfo<Order> info  = areaService.queryorder(page,limit);
        LayuiUtil layuiUtil = new LayuiUtil();

        layuiUtil.setCount(info.getTotal());

        layuiUtil.setData(info.getList());

        return layuiUtil ;
    }
    @RequestMapping("delorder")
    @ResponseBody
    public  void delorder(String [] ids){
        areaService.delorder(ids);
    }


    @RequestMapping("addorder")
    @ResponseBody
    public void addorder(Order order, HttpServletRequest request){
     /*   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(new Date()));
        long timeStamp = System.currentTimeMillis();
        String aa=timeStamp+"";
        System.out.println(aa);*/
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(uuid);
        User user = (User) request.getSession().getAttribute("user");
        System.err.println(user.getId());
        order.setUserId(user.getId());
        order.setOrderNum(uuid);
        areaService.addorder(order);

    }




    @RequestMapping("export")
    public void export(HttpServletResponse response){
        List<Order> list= new ArrayList<Order>();
        try {
            list = areaService.queryorders();

            //定义表格的标题
            String title ="订单信息";
            //定义列名
            String[] rowName={"用户id","订单编号","名称","价格","图片","尺码"};
            //定义工具类要的数据
            List<Object[]>  dataList = new ArrayList<Object[]>();

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            //循环数据把数据存放到 List<Object[]>
            for (Order order:list) {
                Object[] obj=new Object[rowName.length];
                obj[0]=order.getUserId();
                obj[1]= order.getOrderNum();
                obj[2]=order.getProductName();
                obj[3]=order.getSizePrice();
                obj[4]=order.getSizeImg();
                obj[5]=order.getSizeName();
                dataList.add(obj);
            }
            ExportExcel exportExcel=new ExportExcel(title,rowName,dataList,response);
            exportExcel.export();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
