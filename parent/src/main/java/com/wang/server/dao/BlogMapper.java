package com.wang.server.dao;

import com.wang.server.entity.Blog;
import java.util.List;

public interface BlogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Blog record);

    Blog selectByPrimaryKey(Integer id);

    List<Blog> selectAll();

    int updateByPrimaryKey(Blog record);
}