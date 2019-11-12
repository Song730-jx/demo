package com.song.demo.bean;

import org.springframework.stereotype.Component;

@Component
public class GradeBean {
    private int id;
    private String grade;  //班级

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
