package com.panda.dao;


import com.panda.pojo.blog.BlogTags;

import java.util.List;

public interface BlogTagsMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByBlogId(Integer id);

    int insert(BlogTags record);

    BlogTags selectByPrimaryKey(Integer id);

    List<BlogTags> selectAll();

    List<BlogTags> selectByBlogId(Integer id);

    int updateByPrimaryKey(BlogTags record);
}