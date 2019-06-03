package com.wang.server.controller;

import com.wang.server.common.util.ResultCode;
import com.wang.server.common.util.ResultUtils;
import com.wang.server.service.BlogService;
import com.wang.server.vo.BlogVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wl
 * @Date: 2019/5/15 15:54
 * @Description:
 */
@RestController
@RequestMapping("/panda/manage/blog")
public class ManageBlogController {

    @Autowired
    private BlogService blogService;


    @PostMapping(value = "/add")
    public String addBlog(BlogVo blog){
        if (null ==blog || StringUtils.isEmpty(blog.getTitle()) ||StringUtils.isEmpty(blog.getContent())){
            return ResultUtils.generateResultStr(ResultCode.PARAM_ERROR, "博客标题、内容不能为空", 0);
        }

        int count = blogService.insert(blog);
        if (count <= 0){
            return ResultUtils.generateResultStr(ResultCode.DATA_ERROR, "插入异常", 0);
        }
        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "新增成功", 0);
    }

    @PostMapping("/list")
    public String getBlogs(Integer pageNum,Integer pageSize){
        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "查询成功", blogService.selectAll(pageNum,pageSize));
    }

    @PostMapping("/delete")
    public String delectBlog(Integer id){
        if(id <=0){
          return ResultUtils.generateResultStr(ResultCode.PARAM_ERROR, "id不能为空", 0);
        }
        int count = blogService.deleteByPrimaryKey(id);
        if (count == 0){
            return ResultUtils.generateResultStr(ResultCode.DATA_ERROR, "删除异常", 0);
        }
        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "删除成功", 0);
    }
}
