package com.panda.dao;


import com.panda.pojo.blog.Blog;
import com.panda.vo.SearchvVo;
import com.panda.vo.es.BlogES;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Blog record);

    Blog selectByPrimaryKey(Integer id);

    Blog selectById(Integer id);

    List<Blog> selectAll(@Param("search") SearchvVo search);

    int updateByPrimaryKey(Blog record);

    Blog getLast(Integer id);

    Blog getNext(Integer id);

    List<Blog> selectByTag(Integer search);

    List<Blog> selectByCategory(Integer search);

    List<Blog> getBlogByTime(String search);

    List<BlogES> getBlogEs(@Param("start") int start, @Param("size") int size);

    List<String> getBlogTime();

}
