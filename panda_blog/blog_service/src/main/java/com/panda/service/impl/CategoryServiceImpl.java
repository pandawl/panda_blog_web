package com.panda.service.impl;


import com.panda.dao.CategoryMapper;
import com.panda.pojo.blog.Category;
import com.panda.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Auther: wl
 * @Date: 2019/5/17 12:05
 * @Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Category record) {

        Category category = categoryMapper.selectByName(record.getCategoryName());
        if (null != category) {
            return -1;
        }
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        categoryMapper.insert(record);
        return 0;
    }

    @Override
    public Category selectByPrimaryKey(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Category> selectAll(String search) {
        return categoryMapper.selectAll(search);
    }

    @Override
    public int updateByPrimaryKey(Category record) {
        record.setUpdateTime(new Date());
        return categoryMapper.updateByPrimaryKey(record);
    }
}
