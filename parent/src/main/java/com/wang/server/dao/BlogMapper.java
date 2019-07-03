package com.wang.server.dao;

import com.wang.server.entity.Blog;
import com.wang.server.vo.SearchvVo;
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
}