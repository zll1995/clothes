package com.jk.tree.controller;/**
 * @创建人 原国庆
 * @创建时间 2019/12/13
 * @描述
 */

import com.jk.tree.model.Tree;
import com.jk.tree.service.TreeService;
import com.jk.tree.util.LayuiTreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 *@ClassName TreeController
 *@Deacription TODO
 *@Author 原国庆
 *@Date 2019/12/13 10:42
 *@Version 1.0
 **/
@Controller
@RequestMapping("tree")
public class TreeController {

    @Autowired
    private TreeService treeService;

    @RequestMapping("queryTree")
    @ResponseBody
    public List<Tree> queryTree(){
        List<Tree> list  = treeService.queryTree();
        list = LayuiTreeUtil.getFatherNode(list);
        return list ;
    }

}
