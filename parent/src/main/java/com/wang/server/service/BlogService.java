package com.wang.server.service;

import com.wang.server.entity.Blog;

import java.util.List;

/**
 * @Auther: wl
 * @Date: 2019/5/15 15:58
 * @Description:
 */
public interface BlogService {

    int deleteByPrimaryKey(Integer id);

    int insert(Blog record);

    Blog selectByPrimaryKey(Integer id);

    List<Blog> selectAll();

    int updateByPrimaryKey(Blog record);
}
