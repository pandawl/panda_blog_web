package com.wang.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerApplicationTests {

	@Test
	public void contextLoads() {

		String str = "2019年10月";
		String s = str.split("年")[1].split("月")[0];
		if(s.length() ==1){
			s= 0+s ;
		}
		str = str.split("年")[0]+'-'+s;
		System.out.println(str);

	}

}
