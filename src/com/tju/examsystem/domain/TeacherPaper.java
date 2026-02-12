package com.tju.examsystem.domain;

import java.time.LocalDateTime;
import java.util.Objects;


public class TeacherPaper {
    private String teacherId;
    private Integer paperId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public TeacherPaper() {
    }

    public TeacherPaper(String teacherId, Integer paperId, LocalDateTime startTime, LocalDateTime endTime) {
        this.teacherId = teacherId;
        this.paperId = paperId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeacherPaper that)) return false;
        return Objects.equals(getTeacherId(), that.getTeacherId()) && Objects.equals(getPaperId(), that.getPaperId()) && Objects.equals(getStartTime(), that.getStartTime()) && Objects.equals(getEndTime(), that.getEndTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTeacherId(), getPaperId(), getStartTime(), getEndTime());
    }

    @Override
    public String toString() {
        return "TeacherPaper{" +
                "teacherId='" + teacherId + '\'' +
                ", paperId=" + paperId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
