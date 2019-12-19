package com.jk.tree.service;

import com.jk.tree.model.Tree;

import java.util.List;
import java.util.Map;

/**
 * @创建人 原国庆
 * @创建时间 2019/12/13
 * @描述
 */
public interface TreeService {
    /** @Author 原国庆
     * @Description: 后台的前台查询树
     * @Param: []
     * @Return: java.util.List
     * @Create: 2019/12/13 10:44
     */
    List<Tree> queryTree();
}
