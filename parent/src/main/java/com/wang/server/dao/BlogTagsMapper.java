package com.wang.server.dao;

import com.wang.server.entity.BlogTags;
import java.util.List;

public interface BlogTagsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogTags record);

    BlogTags selectByPrimaryKey(Integer id);

    List<BlogTags> selectAll();

    int updateByPrimaryKey(BlogTags record);
}