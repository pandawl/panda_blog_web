package com.wang.server.service.impl;

import com.wang.server.dao.TagMapper;
import com.wang.server.entity.Tag;
import com.wang.server.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: wl
 * @Date: 2019/5/17 14:34
 * @Description:
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Tag record) {
        return 0;
    }

    @Override
    public Tag selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Tag> selectAll() {
        return tagMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Tag record) {
        return 0;
    }
}
