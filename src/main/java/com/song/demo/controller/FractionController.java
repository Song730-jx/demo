package com.song.demo.controller;


import com.song.demo.bean.FractionBean;
import com.song.demo.bean.ResultBean;
import com.song.demo.bean.StudentBean;
import com.song.demo.service.FractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FractionController {
    @Autowired
    private FractionService fractionService;
    @Autowired
    private HttpServletRequest request;


    @RequestMapping("/fractionAdd")
    @ResponseBody
    public ResultBean fractionAdd(StudentBean a, FractionBean b) {
        ResultBean student = fractionService.addFraction(b,a);
        return student;
    }
    @RequestMapping("/getListFraction")
    @ResponseBody
    public ResultBean getListFraction()  {
        ResultBean student = fractionService.getFraction();
        return student;
    }

}
