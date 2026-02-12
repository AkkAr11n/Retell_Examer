package com.tju.examsystem.domain;

import java.util.Objects;


public class PaperStudent {
    private Integer paperId;
    private String studentId;
    private String name;
    private Integer grade;

    @Override
    public String toString() {
        return "PaperStudent{" +
                "paperId=" + paperId +
                ", studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaperStudent that)) return false;
        return Objects.equals(getPaperId(), that.getPaperId()) && Objects.equals(getStudentId(), that.getStudentId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getGrade(), that.getGrade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaperId(), getStudentId(), getName(), getGrade());
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public PaperStudent(Integer paperId, String studentId, String name, Integer grade) {
        this.paperId = paperId;
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
    }

    public PaperStudent() {
    }
}
