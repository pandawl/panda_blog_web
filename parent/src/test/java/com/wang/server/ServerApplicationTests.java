package com.wang.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerApplicationTests {
@Autowired
private StringRedisTemplate stringRedisTemplate;
	@Test
	public void contextLoads() {
		String s = stringRedisTemplate.opsForValue().get("2b468527-1424-4f15-abaa-8cda24e8337c");
		System.err.println(s);
	}

}
