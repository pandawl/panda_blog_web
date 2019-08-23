package com.wang.server.dao;

import com.wang.demo.elasticsearch.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Auther: wl
 * @Date: 2019/8/13 10:46
 * @Description:
 */
public interface EmployeeRepository extends ElasticsearchRepository<Employee,String> {
    Employee  queryEmployeeById(String id);
}
