package com.redis.redis_test.Controller;

import com.redis.redis_test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/test/{id}")
    public  String getStudent(@PathVariable("id")Integer id){
        System.out.println(studentService.findById(id).toString());
        return "test";
    }

}
