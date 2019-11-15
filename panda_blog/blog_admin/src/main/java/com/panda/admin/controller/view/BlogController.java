package com.panda.admin.controller.view;


import com.panda.common.util.ResultCode;
import com.panda.common.util.ResultUtils;
import com.panda.service.BlogService;
import com.panda.vo.SearchvVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wl
 * @Date: 2019-05-25 16:37
 * @Description:
 */
@RestController
@RequestMapping("/panda/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @PostMapping("/list")
    public String getList(Integer pageNum, Integer pageSize, SearchvVo search){

        return ResultUtils.generateResultStr(ResultCode.SUCCESS,"查询成功", blogService.selectAll(pageNum,pageSize,search));
    }

    @PostMapping("/getblog")
    public String getBlog(Integer id){

        return ResultUtils.generateResultStr(ResultCode.SUCCESS,"查询成功", blogService.selectByPrimaryKey(id));
    }


    @PostMapping("/tag/list")
    public String getTagList(Integer pageNum, Integer pageSize, Integer search){
        return ResultUtils.generateResultStr(ResultCode.SUCCESS,"查询成功", blogService.selectByTag(pageNum,pageSize,search));
    }

    @PostMapping("/category/list")
    public String getCategoryList(Integer pageNum, Integer pageSize, Integer search){
        return ResultUtils.generateResultStr(ResultCode.SUCCESS,"查询成功", blogService.selectByCategory(pageNum,pageSize,search));
    }

    /**
     * 文章归档
     * @param pageNum
     * @param pageSize
     * @param search
     * @return
     */
    @PostMapping("/time")
    public String getBlogByTime(Integer pageNum, Integer pageSize, String search){
        return ResultUtils.generateResultStr(ResultCode.SUCCESS,"查询成功", blogService.getBlogByTime(pageNum,pageSize,search));
    }

    /**
     * 获取归档时间
     * @return
     */
    @PostMapping("/gettime")
    public String getBlogTime(){
        return ResultUtils.generateResultStr(ResultCode.SUCCESS,"查询成功", blogService.getBlogTime());
    }

    /**
     * 获取归档时间
     * @return
     */
    @PostMapping("/search")
    public String getBlogTime(Integer pageNum, Integer pageSize,String search){
        return ResultUtils.generateResultStr(ResultCode.SUCCESS,"查询成功", blogService.searchBlog(pageNum,pageSize,search));
    }
}
