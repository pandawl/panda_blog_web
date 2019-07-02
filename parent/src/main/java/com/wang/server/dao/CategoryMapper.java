package com.wang.server.dao;

import com.wang.server.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(@Param("record") Category record);

    Category selectByPrimaryKey(Integer id);

    List<Category> selectAll(@Param("search") String search);

    int updateByPrimaryKey(@Param("record") Category record);

    Category selectByName(@Param("name") String name);
}
