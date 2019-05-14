package com.wang.server.service.impl;

import com.wang.server.dao.ResourceMapper;
import com.wang.server.entity.Resource;
import com.wang.server.service.ResourceService;
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
