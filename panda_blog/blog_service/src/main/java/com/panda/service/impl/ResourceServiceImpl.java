package com.panda.service.impl;


import com.panda.dao.ResourceMapper;
import com.panda.pojo.blog.Resource;
import com.panda.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: wl
 * @Date: 2019/5/14 17:43
 * @Description:
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public List<Resource> getResource() {
        return resourceMapper.selectAll();
    }
}
