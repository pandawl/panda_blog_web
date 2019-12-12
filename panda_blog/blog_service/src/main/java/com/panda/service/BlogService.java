package com.panda.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.panda.pojo.QueryRequest;
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

    IPage<Blog> selectAll(SearchvVo search, QueryRequest request);

    int updateByPrimaryKey(Blog record);

    /**
     * 回显
     *
     * @param id
     * @return
     */
    BlogVo selectByid(Integer id);

    IPage<Blog> selectByTag(Integer pageNum, Integer pageSize, Integer search);

    IPage<Blog> selectByCategory(Integer pageNum, Integer pageSize, Integer search);

    IPage<Blog> getBlogByTime(Integer pageNum, Integer pageSize, String search);

    List<String> getBlogTime();

    void syncBlog();

    IPage<BlogES> searchBlog(Integer pageNum, Integer pageSize, String context);
}
