package com.song.demo.controller;

import com.song.demo.bean.AdminBean;
import com.song.demo.bean.ResultBean;
import com.song.demo.service.AdmainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    @Autowired
    private AdmainService admainService;
    @Autowired
    private HttpServletRequest request;


    @RequestMapping("/land1")
    @ResponseBody
    public ResultBean admin(AdminBean a) {
        ResultBean admin = admainService.getService(a);
        if (admin.getSuccess() == true) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);
            AdminBean adminBeanSession = (AdminBean) admin.getData();
            session.setAttribute("name", adminBeanSession.getNumber());
        }
        return admin;
    }

    @RequestMapping("/register2")
    @ResponseBody
    public ResultBean register(AdminBean a)  {
        ResultBean admin = admainService.addService(a);
        return admin;
    }
}
