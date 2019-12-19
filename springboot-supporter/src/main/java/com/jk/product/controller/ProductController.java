package com.jk.product.controller;

import com.jk.product.model.*;
import com.jk.product.service.ProductService;
import com.jk.product.util.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ProductController
 * @Description
 * @Author
 * @Date 2019/12/13 10:33
 * @Version V1.0
 **/
@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("queryArea")
    @ResponseBody
    public List<Area> queryArea(){
        return productService.queryArea();
    }
    @RequestMapping("queryBrand")
    @ResponseBody
    public List<Brand> queryBrand(){
        return productService.queryBrand();
    }
    @RequestMapping("addProduct")
    @ResponseBody
    public void addProduct(Product product){
        productService.addProduct(product);
    }
    @RequestMapping("queryProduct")
    @ResponseBody
    public Map<String,Object> queryProduct(Integer page, Integer limit,Product product){
        return productService.queryProduct(page,limit,product);
    }
    @RequestMapping("queryProduct2")
    @ResponseBody
    public Map<String,Object> queryProduct2(Integer page, Integer limit,Product product){
        return productService.queryProduct2(page,limit,product);
    }
    @RequestMapping("queryDetailed")
    @ResponseBody
    public Map<String,Object> queryDetailed(Integer id){
        Map<String, Object> map = new HashMap<>();
        List<Color> list = productService.queryDetailed(id);
        map.put("code",0);
        map.put("msg","");
        map.put("data",list);
        return map;
    }

    @PostMapping("addColor")
    @ResponseBody
    public void addColor(Color color){
        productService.addColor(color);
    }

    @RequestMapping("deleteColor")
    @ResponseBody
    public void deleteColor(Integer colorid){
        productService.deleteColor(colorid);
    }

    @RequestMapping("querySize")
    @ResponseBody
    public Map<String,Object> querySize(Integer id){
        Map<String, Object> map = new HashMap<>();
        List<Size> list = productService.querySize(id);
        map.put("code",0);
        map.put("msg","");
        map.put("data",list);
        return map;
    }
    @RequestMapping("addsize")
    @ResponseBody
    public void  addSize(Size size){
        System.err.println(size);
         productService.addSize(size);
    }
    @RequestMapping("deleteSize")
    @ResponseBody
    public void  deleteSize(Integer sizeId){
        productService.deleteSize(sizeId);
    }

    @RequestMapping("lowerShelf")
    @ResponseBody
    public void lowerShelf(Integer id){
        productService.lowerShelf(id);
    }
    @RequestMapping("upperShelf")
    @ResponseBody
    public void upperShelf(Integer id){
        productService.upperShelf(id);
    }
    @RequestMapping("deleteProduct")
    @ResponseBody
    public void deleteProduct(Integer id){
        productService.deleteProduct(id);
    }
    @RequestMapping("notAll")
    @ResponseBody
    public void notAll(String ids){
        productService.notAll(ids);
    }
    @RequestMapping("putAll")
    @ResponseBody
    public void putAll(String ids){
        productService.putAll(ids);
    }
    @RequestMapping("toaddproduct")
    public String toAddProduct(){
        return "product/addProduct";
    }

    @RequestMapping("toQueryproduct")
    public String toQueryproduct(){

        return "product/show";
    }
    @RequestMapping("toNotOnShelves")
    public String toNotOnShelves()
    {
        return "product/notOnShelves";
    }
    @RequestMapping("toSpecifications")
    public String toSpecifications(Integer colorid,Model model){
        model.addAttribute("colorid",colorid);
        return "product/size";
    }
    @RequestMapping("toDetailed")
    public String toDetailed(Integer id, Model model){
        model.addAttribute("id",id);
        return "product/detailed";
    }

    @RequestMapping("addproduct")
    public String addproduct(Integer id,HttpSession session){
        session.setAttribute("id",id);
        return "product/add";
    }

    @RequestMapping("upload")
    @ResponseBody
    public Map<String,Object> uploadImage(@RequestParam("file") MultipartFile file, HttpSession session) {

        session.removeAttribute("img");
        Map<String,Object> map  = new HashMap<>();
        String uploadDir = "D:/picture";

        try {
            // 图片路径
            String imgUrl = null;
            //上传
            String filename = UploadUtils.upload(file, uploadDir, file.getOriginalFilename());
            if (filename != null) {
                imgUrl = new File(uploadDir).getName() + "/" + filename;
            }
            map.put("code",0);
            session.setAttribute("img",imgUrl);
            map.put("msg","上传成功");
            map.put("data",imgUrl);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code",500);
            map.put("msg","上传失败");
            map.put("data",null);
            return map;
        }
    }

}
