package com.wang.server.dao;

import com.wang.server.entity.Resource;
import java.util.List;

public interface ResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    Resource selectByPrimaryKey(Long id);

    List<Resource> selectAll();

    int updateByPrimaryKey(Resource record);
}