package com.redis.redis_test.service;

import com.redis.redis_test.pojo.Student;

public interface StudentService {

    Student findById(Integer id);
}
