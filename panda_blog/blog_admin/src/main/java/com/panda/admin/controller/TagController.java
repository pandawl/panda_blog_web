package com.panda.admin.controller;


import com.panda.common.util.ResultCode;
import com.panda.common.util.ResultUtils;
import com.panda.pojo.blog.Tag;
import com.panda.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wl
 * @Date: 2019/5/17 14:32
 * @Description:
 */
@RestController
@RequestMapping("/panda/manage/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    /**查询所有**/
    @PostMapping("/list")
    public String getAll(String search){
        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "查询成功", tagService.selectAll(search));
    }

    /**根据id查询**/
    @PostMapping("/select")
    public String selete(Integer id){
        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "查询成功", tagService.selectByPrimaryKey(id));
    }

    /**新增**/
    @PostMapping("/add")
    public String add(Tag tag){
        int count = tagService.insert(tag);
        if (-1 == count){
            return  ResultUtils.resultFail(ResultCode.PARAM_ERROR,"该名称重复");
        }
        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "新增成功", null);
    }
    /**删除**/
    @PostMapping("/delete")
    public String deleteTag(Integer id){
        if (null == id){
            ResultUtils.resultFail(ResultCode.PARAM_ERROR,"id不能为空");
        }
        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "删除成功", tagService.deleteByPrimaryKey(id));
    }

    /**修改**/
    @PostMapping("/update")
    public String update(Tag tag){
        if (null ==tag || null == tag.getTagName() || "".equals(tag.getTagName().trim()) || null == tag.getId()){
            ResultUtils.resultFail(ResultCode.PARAM_ERROR,"参数异常");
        }

        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "修改成功", tagService.updateByPrimaryKey(tag));
    }
}
