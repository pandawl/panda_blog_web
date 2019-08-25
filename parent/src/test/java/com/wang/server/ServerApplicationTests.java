package com.wang.server;

import com.wang.server.common.util.EsUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ServerApplication.class)
public class ServerApplicationTests {


   @Autowired
	EsUtil esUtil;
	@Test
	public void contextLoads() {
		esUtil.init();
	}



}
