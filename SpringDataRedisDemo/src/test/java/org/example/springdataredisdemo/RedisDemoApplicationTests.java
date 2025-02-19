package org.example.springdataredisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisDemoApplicationTests {

	@Autowired
	private RedisTemplate<String,Object> redisTemplate;

	@Test
	void testString(){
		// 写入String类型
		redisTemplate.opsForValue().set("name","张老二");

		// 获取数据
		Object name=redisTemplate.opsForValue().get("name"); //张老二
		System.out.println(name);
	}

}