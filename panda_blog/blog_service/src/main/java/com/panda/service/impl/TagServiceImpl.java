package com.panda.service.impl;

import com.panda.dao.TagMapper;
import com.panda.pojo.blog.Tag;
import com.panda.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Auther: wl
 * @Date: 2019/5/17 14:34
 * @Description:
 */
@Service
public class TagServiceImpl implements TagService {

    @Resource
    private TagMapper tagMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tagMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Tag record) {
        Tag tag = tagMapper.selectByName(record.getTagName());
        if (null !=tag){
            return -1;
        }
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        return tagMapper.insert(record);
    }

    @Override
    public Tag selectByPrimaryKey(Integer id) {
        Tag tag = tagMapper.selectByPrimaryKey(id);
        return tag;
    }

    @Override
    public List<Tag> selectAll(String search) {
        return tagMapper.selectAll(search);
    }

    @Override
    public int updateByPrimaryKey(Tag record) {
        record.setUpdateTime(new Date());
        return tagMapper.updateByPrimaryKey(record);
    }
}
