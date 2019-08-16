package com.example.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LoveToolsApplicationTests {
	private static Logger logger=LoggerFactory.getLogger(LoveToolsApplicationTests.class);
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	@Test
	public void contextLoads() {
		User user=new User();
		user.setAge("10");
		user.setName("zk");
		redisTemplate.opsForValue().set("te", user);
	}

}
