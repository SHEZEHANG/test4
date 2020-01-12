package com.redis.redis_test.mapper;

import com.redis.redis_test.pojo.Student;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface StudentMapper extends Mapper<Student>{

    @Select("select * from stu where id = #{id}")
    public Student getOne(Integer id);
}
