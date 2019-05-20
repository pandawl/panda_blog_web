package com.wang.server.vo;

import com.wang.server.entity.Blog;
import lombok.Data;

import java.util.List;

/**
 * @Auther: wl
 * @Date: 2019-05-19 18:52
 * @Description:
 */
@Data
public class BlogVo extends Blog {


    private List<Integer> tags;
}
