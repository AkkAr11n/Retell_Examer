package com.tju.examsystem.domain;

import java.util.Objects;


public class Teacher {
    private String teacherId;
    private String name;
    private String academy;

    public Teacher() {
    }

    public Teacher(String teacherId, String name, String academy) {
        this.teacherId = teacherId;
        this.name = name;
        this.academy = academy;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher teacher)) return false;
        return Objects.equals(getTeacherId(), teacher.getTeacherId()) && Objects.equals(getName(), teacher.getName()) && Objects.equals(getAcademy(), teacher.getAcademy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTeacherId(), getName(), getAcademy());
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", name='" + name + '\'' +
                ", academy='" + academy + '\'' +
                '}';
    }
}
