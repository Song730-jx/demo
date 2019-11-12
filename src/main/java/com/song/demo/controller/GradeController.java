package com.song.demo.controller;


import com.song.demo.bean.*;
import com.song.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GradeController {
    @Autowired
    private GradeService gradeService;
    @Autowired
    private UpdateService updateService;

    @RequestMapping("/update")
    @ResponseBody
    public ResultBean update(Bean bean) {
        ResultBean student = updateService.updateService(bean);
        return student;
    }
    @RequestMapping("/getListGrade")
    @ResponseBody
    public ResultBean getListGrade(Bean bean,String page,String limit)  {
        ResultBean student = gradeService.getList(bean,page,limit);
        int i = gradeService.countService();
        student.setCount(i);
        return student;
    }




}
