package com.song.demo.service;

import com.song.demo.bean.ResultBean;
import com.song.demo.bean.StudentBean;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        StudentService s = new StudentService();
        ResultBean studentBean1=s.getStudent();
        System.out.println(studentBean1);
        /*for (int j = 0; j < a.size(); ++j) {
            System.out.println(a.get(j).getId() + "\t\t" + a.get(j).getxName() + "\t\t" + a.get(j).getAge() + "\t\t" + a.get(j).getGradeId());
        }*/
    }
}
