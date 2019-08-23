package com.wang.server;

import com.wang.server.dao.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ServerApplication.class)
public class ServerApplicationTests {


	@Resource
	EmployeeRepository ep;
	@Test
	public void contextLoads() {

	}



}
