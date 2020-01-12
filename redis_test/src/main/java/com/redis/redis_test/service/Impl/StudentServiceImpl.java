package com.redis.redis_test.service.Impl;

import com.redis.redis_test.mapper.StudentMapper;
import com.redis.redis_test.pojo.Student;
import com.redis.redis_test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisTemplate myRedisTemplate;

    @Value("${REDIS_TEST}")
    private String REDIS_TEST;

    @Override
    public Student findById(Integer id) {

        try {
            Object redis_test = myRedisTemplate.opsForValue().get("REDIS_TEST");
            if(redis_test!=null){
                System.out.println("從緩存中取");
                System.out.println(redis_test);
                return (Student) redis_test;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Student student = studentMapper.getOne(id);

        try {
            myRedisTemplate.opsForValue().set(REDIS_TEST,student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }
}
