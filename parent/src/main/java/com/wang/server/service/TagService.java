package com.wang.server.service;

import com.wang.server.entity.Tag;

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

    List<Tag> selectAll();

    int updateByPrimaryKey(Tag record);
}
