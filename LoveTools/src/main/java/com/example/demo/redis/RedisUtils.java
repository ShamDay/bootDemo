package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	/**
	 * add
	 */
	public void add(String key,Object obj ,Long times) {
		redisTemplate.opsForValue().set(key, obj, times);
	}
	/**
	 * add
	 */
	public void add(String key,Object obj ) {
		redisTemplate.opsForValue().set(key, obj);
	}
	/**
	 * delete
	 */
	public void delete(String key) {
		redisTemplate.opsForValue().getOperations().delete(key);
	}
	/**
	 * get
	 */
	public Object get(String key) {
		return redisTemplate.opsForValue().get(key);
	}
}
