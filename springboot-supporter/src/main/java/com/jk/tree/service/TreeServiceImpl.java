package com.jk.tree.service;/**
 * @创建人 原国庆
 * @创建时间 2019/12/13
 * @描述
 */

import com.jk.tree.mapper.TreeMapper;
import com.jk.tree.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@ClassName TreeServiceImpl
 *@Deacription TODO
 *@Author 原国庆
 *@Date 2019/12/13 10:45
 *@Version 1.0
 **/
@Service
public class TreeServiceImpl implements TreeService{

    @Autowired
    private TreeMapper treeMapper;

    @Override
    public List<Tree> queryTree() {
        List<Tree> list=treeMapper.queryTree();
        return list;
    }
}
