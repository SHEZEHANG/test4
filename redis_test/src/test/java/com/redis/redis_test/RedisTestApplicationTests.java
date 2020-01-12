package com.redis.redis_test;

import com.redis.redis_test.pojo.Student;
import com.redis.redis_test.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashMap;

@SpringBootTest
@RunWith(SpringRunner.class)
class RedisTestApplicationTests {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private DataSource dataSource;

	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisTemplate myRedisTemplate;

	@Autowired
	private StudentService studentService;
	@Test
	public void  redisTest(){
		//stringRedisTemplate.opsForValue().append("msg","hello");
		String msg = stringRedisTemplate.opsForValue().get("msg");
		System.out.println(msg);
	}

	@Test
	public void test2(){

		//Student student = studentService.findById(1);
		//myRedisTemplate.opsForValue().set("stu-1",student);
		Student msg = (Student) myRedisTemplate.opsForValue().get("stu-1");
		System.out.println(msg);
	}

	@Test
	public void  testLog4j(){
		logger.trace("---trace日志记录---");
		logger.debug("---debug日志记录---");
		logger.info("---info日志记录---");
		logger.warn("---warn日志记录---");
		logger.error("---error日志记录---");
	}

	@Test
	public void testDruid() throws SQLException {
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}
}
