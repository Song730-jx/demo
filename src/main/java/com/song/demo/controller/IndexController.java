package com.song.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String admin(){
        return "land";
    }

    @RequestMapping("/doregister")
    public String register(){
        return "register";
    }

    @RequestMapping("/dostudentAdd")
    public String studentAdd(){
        return "studentAdd";
    }

    @RequestMapping("/dofractionAdd")
    public String fractionAdd(){
        return "fractionAdd";
    }

    @RequestMapping("/doquery")
    public String query(){
        return "query";
    }

    @RequestMapping("/dohome")
    public String hoem(){
        return "home";
    }


}
