package com.panda.service;


import com.github.pagehelper.PageInfo;
import com.panda.pojo.blog.Blog;
import com.panda.vo.BlogVo;
import com.panda.vo.SearchvVo;
import com.panda.vo.es.BlogES;

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

    PageInfo<BlogES> searchBlog(Integer pageNum, Integer pageSize, String context);
}
