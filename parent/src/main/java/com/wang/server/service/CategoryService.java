package com.wang.server.service;

import com.wang.server.entity.Category;

import java.util.List;

/**
 * @Auther: wl
 * @Date: 2019/5/17 12:05
 * @Description:
 */
public interface CategoryService {

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    Category selectByPrimaryKey(Integer id);

    List<Category> selectAll();

    int updateByPrimaryKey(Category record);
}
