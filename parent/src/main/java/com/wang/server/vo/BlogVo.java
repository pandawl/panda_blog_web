package com.wang.server.vo;

import com.wang.server.entity.Blog;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Auther: wl
 * @Date: 2019-05-19 18:52
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BlogVo extends Blog {


    private List<Integer> tags;

    private Blog last;

    private Blog next;
}
