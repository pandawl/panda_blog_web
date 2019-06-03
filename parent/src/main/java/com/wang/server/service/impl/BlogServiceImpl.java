package com.wang.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.server.dao.BlogMapper;
import com.wang.server.dao.BlogTagsMapper;
import com.wang.server.entity.Blog;
import com.wang.server.entity.BlogTags;
import com.wang.server.service.BlogService;
import com.wang.server.vo.BlogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Auther: wl
 * @Date: 2019/5/15 15:58
 * @Description:
 */
@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private BlogTagsMapper blogTagsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return blogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BlogVo record) {
        record.setCreateTime(new Date());
        int count = blogMapper.insert(record);
        if (count <= 0) {
            return 0;
        }

        if (record.getTags().size() > 0) {
            for (int i = 0; i < record.getTags().size(); i++) {
                BlogTags blogTags = new BlogTags();
                blogTags.setBlog_id(record.getId());
                blogTags.setTag_id(record.getTags().get(i));
                blogTagsMapper.insert(blogTags);
            }

        }
        return 1;

    }

    @Override
    public Blog selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public PageInfo<Blog> selectAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> blogs = blogMapper.selectAll();
        PageInfo<Blog> info = new PageInfo<>(blogs);
        return info;
    }

    @Override
    public int updateByPrimaryKey(Blog record) {
        return 0;
    }
}
