package com.panda.service;


import com.panda.pojo.blog.Category;

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

    List<Category> selectAll(String search);

    int updateByPrimaryKey(Category record);
}
