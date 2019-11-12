package com.song.demo.bean;

import org.springframework.stereotype.Component;

@Component
public class FractionBean {
    private int id;
    private int studentId;  //学生id
    private int fraction;  //分数

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getFraction() {
        return fraction;
    }

    public void setFraction(int fraction) {
        this.fraction = fraction;
    }
}
