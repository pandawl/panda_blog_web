package com.panda.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.panda.pojo.blog.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {

    List<Role> findUserRole(String userName);

}