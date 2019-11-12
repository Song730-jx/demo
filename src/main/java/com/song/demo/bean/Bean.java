package com.song.demo.bean;

public class Bean {
    private int id;
    private int studentId;
    private int fraction;
    private String name;
    private int age;
    private String grade;
    private int gradeId;
private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "id=" + id +
                ", studentid=" + studentId +
                ", fraction=" + fraction +
                ", xname='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", gradeid=" + gradeId +
                '}';
    }

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

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }
}
