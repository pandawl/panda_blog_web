package com.wang.server;

import com.wang.server.quartz.entity.ScheduleJob;
import com.wang.server.quartz.service.ScheduleJobService;
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
    @Autowired
    private ScheduleJobService scheduleJobService;
	@Test
	public void contextLoads() {
/*        PageInfo<BlogES> vue = blogService.searchBlog(1, 2, "vue");
        System.out.println(vue.getTotal());
        System.out.println(vue.getList());
        System.out.println(vue.getList().size());*/
        ScheduleJob job = scheduleJobService.getScheduleJobById(3);
        System.err.println(job);

    }


}
