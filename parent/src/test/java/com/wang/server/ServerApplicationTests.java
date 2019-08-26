package com.wang.server;

import com.github.pagehelper.PageInfo;
import com.wang.server.entity.es.BlogES;
import com.wang.server.service.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ServerApplication.class)
public class ServerApplicationTests {


	@Autowired
	private BlogService blogService;
	@Test
	public void contextLoads() {
        PageInfo<BlogES> vue = blogService.searchBlog(1, 2, "vue");
        System.out.println(vue.getTotal());
        System.out.println(vue.getList());
        System.out.println(vue.getList().size());


    }



}
