package com.wang.server.service;

import com.github.pagehelper.PageInfo;
import com.wang.server.entity.Blog;
import com.wang.server.vo.BlogVo;

/**
 * @Auther: wl
 * @Date: 2019/5/15 15:58
 * @Description:
 */
public interface BlogService {

    int deleteByPrimaryKey(Integer id);

    int insert(BlogVo record);

    BlogVo selectByPrimaryKey(Integer id);

    PageInfo<Blog> selectAll(Integer pageNum, Integer pageSize);

    int updateByPrimaryKey(Blog record);
}
