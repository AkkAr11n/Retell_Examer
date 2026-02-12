package com.tju.examsystem.domain;

import java.util.Objects;


public class Student {
    private String studentId;
    private String name;
    private String academy;
    private String major;
    private String squad;

    public Student() {
    }

    public Student(String studentId, String name, String academy, String major, String squad) {
        this.studentId = studentId;
        this.name = name;
        this.academy = academy;
        this.major = major;
        this.squad = squad;
    }



    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSquad() {
        return squad;
    }

    public void setSquad(String squad) {
        this.squad = squad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(getStudentId(), student.getStudentId()) && Objects.equals(getName(), student.getName()) && Objects.equals(getAcademy(), student.getAcademy()) && Objects.equals(getMajor(), student.getMajor()) && Objects.equals(getSquad(), student.getSquad());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getName(), getAcademy(), getMajor(), getSquad());
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", academy='" + academy + '\'' +
                ", major='" + major + '\'' +
                ", squad='" + squad + '\'' +
                '}';
    }
}
