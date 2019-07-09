package com.wang.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.server.dao.BlogMapper;
import com.wang.server.dao.BlogTagsMapper;
import com.wang.server.entity.Blog;
import com.wang.server.entity.BlogTags;
import com.wang.server.service.BlogService;
import com.wang.server.vo.BlogVo;
import com.wang.server.vo.SearchvVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

        //修改
        if (record.getId() != null){
            record.setUpdateTime(new Date());
            int count = blogMapper.updateByPrimaryKey(record);
            if (count <= 0) {
                return 0;
            }
                blogTagsMapper.deleteByBlogId(record.getId());
            if (record.getTags().size() > 0) {
                for (int i = 0; i < record.getTags().size(); i++) {
                    BlogTags blogTags = new BlogTags();
                    blogTags.setBlog_id(record.getId());
                    blogTags.setTag_id(record.getTags().get(i));
                    blogTagsMapper.insert(blogTags);
                }

            }
            return 1;
            //新增
        }else {
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


    }

    @Override
    public BlogVo selectByPrimaryKey(Integer id) {
        Blog blog = blogMapper.selectByPrimaryKey(id);
        BlogVo blogVo = convertBlogToVO(blog);

        //当上一篇或下一篇不存在时，设定id为-1000
        Blog noBlog = new Blog();
        noBlog.setId(-1000);
        noBlog.setTitle("");
        //上一篇 前端显示为倒叙
        Blog last = blogMapper.getNext(id);
        if (null != last){
            blogVo.setLast(last);
        }else {
            blogVo.setLast(noBlog);
        }
        //下一篇
        Blog next = blogMapper.getLast(id);
        if (null != next){
            blogVo.setNext(next);
        }else {
            blogVo.setNext(noBlog);
        }
        return blogVo;
    }

    @Override
    public PageInfo<Blog> selectAll(Integer pageNum, Integer pageSize, SearchvVo search) {
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> blogs = blogMapper.selectAll(search);
        PageInfo<Blog> info = new PageInfo<>(blogs);
        return info;
    }

    @Override
    public int updateByPrimaryKey(Blog record) {
        return 0;
    }

    @Override
    public BlogVo selectByid(Integer id) {
        Blog blog = blogMapper.selectById(id);
        List<BlogTags> tags = blogTagsMapper.selectByBlogId(id);
        List<Integer> tagIds = new ArrayList<>();
        for (BlogTags tag : tags) {
            tagIds.add(tag.getTag_id());
        }

        BlogVo blogVo = convertBlogToVO(blog);
        blogVo.setTags(tagIds);


        return blogVo;
    }

    @Override
    public PageInfo<Blog> selectByTag(Integer pageNum, Integer pageSize, Integer search) {
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> blogs = blogMapper.selectByTag(search);
        PageInfo<Blog> info = new PageInfo<>(blogs);
        return info;
    }
    @Override
    public PageInfo<Blog> selectByCategory(Integer pageNum, Integer pageSize, Integer search) {
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> blogs = blogMapper.selectByCategory(search);
        PageInfo<Blog> info = new PageInfo<>(blogs);
        return info;
    }

    @Override
    public PageInfo<Blog> getBlogByTime(Integer pageNum, Integer pageSize, String search) {
        return null;
    }

    @Override
    public List<String> getBlogTime() {
        return blogMapper.getBlogTime();
    }

    private BlogVo convertBlogToVO(Blog blog){
        BlogVo blogVo = new BlogVo();
        blogVo.setId(blog.getId());
        blogVo.setCategoryId(blog.getCategoryId());
        blogVo.setTitle(blog.getTitle());
        blogVo.setSummary(blog.getSummary());
        blogVo.setImgUrl(blog.getImgUrl());
        blogVo.setAuthor(blog.getAuthor());
        blogVo.setCode(blog.getCode());
        blogVo.setViewCount(blog.getViewCount());
        blogVo.setLikeCount(blog.getLikeCount());
        blogVo.setCommentCount(blog.getCommentCount());
        blogVo.setIsDeleted(blog.getIsDeleted());
        blogVo.setCreateTime(blog.getCreateTime());
        blogVo.setUpdateTime(blog.getUpdateTime());
        blogVo.setContent(blog.getContent());
        blogVo.setCategoryName(blog.getCategoryName());

        return blogVo;
    }
}
