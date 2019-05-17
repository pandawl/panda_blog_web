package com.wang.server.service.impl;

import com.wang.server.dao.CategoryMapper;
import com.wang.server.entity.Category;
import com.wang.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: wl
 * @Date: 2019/5/17 12:05
 * @Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Category record) {
        return 0;
    }

    @Override
    public Category selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Category> selectAll() {
        return categoryMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Category record) {
        return 0;
    }
}
