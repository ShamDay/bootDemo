package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.example.demo.redis.RedisUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LoveToolsApplicationTests {
	private static Logger logger=LoggerFactory.getLogger(LoveToolsApplicationTests.class);
	@Autowired
	RedisUtils util;
	@Test
	public void contextLoads() {
		util.add("te", "test");
		System.out.println(util.get("te"));
		util.add("te", "test");
		System.out.println(util.get("te"));
		util.delete("te");
		System.out.println(util.get("te"));
	}

}
