package com.panda.dao;

import com.panda.pojo.blog.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(@Param("record") Tag record);

    Tag selectByPrimaryKey(Integer id);

    List<Tag> selectAll(@Param("search") String search);

    int updateByPrimaryKey(@Param("record") Tag record);

    Tag selectByName(String name);
}
