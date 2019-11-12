package com.song.demo.controller;


import com.song.demo.bean.ResultBean;
import com.song.demo.bean.StudentBean;
import com.song.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/studentAdd")
    @ResponseBody
    public ResultBean studentAdd(StudentBean a) {
        ResultBean student = studentService.addStudent(a);
        return student;
    }
    @RequestMapping("/getListStudent")
    @ResponseBody
    public ResultBean getListStudent()  {
        ResultBean student = studentService.getStudent();
        return student;
    }

}
