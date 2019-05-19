package com.wang.server.vo;

import com.wang.server.entity.Blog;

import java.util.List;

/**
 * @Auther: wl
 * @Date: 2019-05-19 18:52
 * @Description:
 */
public class BlogVo extends Blog {

    private Integer categoryId;

    private List<Integer> tags;
}
