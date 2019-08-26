package com.wang.server.service;

import com.github.pagehelper.PageInfo;
import com.wang.server.entity.Blog;
import com.wang.server.entity.es.BlogES;
import com.wang.server.vo.BlogVo;
import com.wang.server.vo.SearchvVo;

import java.util.List;

/**
 * @Auther: wl
 * @Date: 2019/5/15 15:58
 * @Description:
 */
public interface BlogService {

    int deleteByPrimaryKey(Integer id);

    int insert(BlogVo record);

    BlogVo selectByPrimaryKey(Integer id);

    PageInfo<Blog> selectAll(Integer pageNum, Integer pageSize, SearchvVo search);

    int updateByPrimaryKey(Blog record);

    /**
     * 回显
     * @param id
     * @return
     */
    BlogVo selectByid(Integer id);

    PageInfo<Blog> selectByTag(Integer pageNum, Integer pageSize, Integer search);

    PageInfo<Blog> selectByCategory(Integer pageNum, Integer pageSize, Integer search);

    PageInfo<Blog> getBlogByTime(Integer pageNum, Integer pageSize, String search);

    List<String> getBlogTime();

    void syncBlog();

    PageInfo<BlogES> searchBlog(Integer pageNum, Integer pageSize,String context);
}
