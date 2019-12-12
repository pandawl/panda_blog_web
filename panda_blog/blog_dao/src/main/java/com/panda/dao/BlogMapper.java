package com.panda.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.panda.pojo.blog.Blog;
import com.panda.vo.SearchvVo;
import com.panda.vo.es.BlogES;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogMapper extends BaseMapper<Blog> {
    int deleteByPrimaryKey(Integer id);


    Blog selectByPrimaryKey(Integer id);

    Blog selectById(Integer id);

    IPage<Blog> selectAll(Page page, @Param("search") SearchvVo search);

    int updateByPrimaryKey(Blog record);

    Blog getLast(Integer id);

    Blog getNext(Integer id);

    IPage<Blog> selectByTag(Page page, Integer search);

    IPage<Blog> selectByCategory(Page page, Integer search);

    IPage<Blog> getBlogByTime(Page page, String search);

    List<BlogES> getBlogEs(@Param("start") int start, @Param("size") int size);

    List<String> getBlogTime();

}
