package com.wang.server.service.impl;

import com.wang.server.dao.BlogMapper;
import com.wang.server.entity.Blog;
import com.wang.server.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: wl
 * @Date: 2019/5/15 15:58
 * @Description:
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return blogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Blog record) {
        return blogMapper.insert(record);
    }

    @Override
    public Blog selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Blog> selectAll() {
        return blogMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Blog record) {
        return 0;
    }
}
