package com.tju.examsystem.domain;

import java.util.Objects;


public class PaperGrade {
    private int paperId;
    private String title;
    private String teacherName;
    Integer grade;

    @Override
    public String toString() {
        return "PaperGrade{" +
                "paperId=" + paperId +
                ", title='" + title + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaperGrade that)) return false;
        return getPaperId() == that.getPaperId() && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getTeacherName(), that.getTeacherName()) && Objects.equals(getGrade(), that.getGrade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaperId(), getTitle(), getTeacherName(), getGrade());
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public PaperGrade(int paperId, String title, String teacherName, Integer grade) {
        this.paperId = paperId;
        this.title = title;
        this.teacherName = teacherName;
        this.grade = grade;
    }

    public PaperGrade() {
    }
}
