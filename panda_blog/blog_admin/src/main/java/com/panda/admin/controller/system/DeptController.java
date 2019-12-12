package com.panda.admin.controller.system;

import com.panda.PandaResponse;
import com.panda.base.controller.BaseController;
import com.panda.pojo.QueryRequest;
import com.panda.pojo.blog.Dept;
import com.panda.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wl
 * @Date: 2019/12/10 09:45
 * @Description:
 */
@RestController
@RequestMapping("panda/dept")
public class DeptController extends BaseController {

    private String message;

    @Autowired
    private DeptService deptService;

    @RequestMapping
    public PandaResponse deptList(QueryRequest query, Dept dept) {
        return new PandaResponse().data(this.deptService.findDepts(query, dept));

    }
}
