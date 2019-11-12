package com.panda.service;

import com.panda.pojo.blog.Tag;

import java.util.List;

/**
 * @Auther: wl
 * @Date: 2019/5/17 14:33
 * @Description:
 */
public interface TagService {

    int deleteByPrimaryKey(Integer id);

    int insert(Tag record);

    Tag selectByPrimaryKey(Integer id);

    List<Tag> selectAll(String search);

    int updateByPrimaryKey(Tag record);
}
