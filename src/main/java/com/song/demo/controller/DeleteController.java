package com.song.demo.controller;


import com.song.demo.bean.Bean;
import com.song.demo.bean.ResultBean;
import com.song.demo.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeleteController {
    @Autowired
    private UpdateService updateService;

    @RequestMapping("/delete")
    @ResponseBody
    public ResultBean delete(Bean bean) {
        ResultBean student = updateService.deleteService(bean);
        return student;
    }

}
