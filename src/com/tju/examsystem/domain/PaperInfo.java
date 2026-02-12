package com.tju.examsystem.domain;

import java.time.LocalDateTime;
import java.util.Objects;


public class PaperInfo {
    private int paperId;
    private String title;
    private String teacherName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Override
    public String toString() {
        return "PaperInfo{" +
                "paperId=" + paperId +
                ", title='" + title + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaperInfo paperInfo)) return false;
        return getPaperId() == paperInfo.getPaperId() && Objects.equals(getTitle(), paperInfo.getTitle()) && Objects.equals(getTeacherName(), paperInfo.getTeacherName()) && Objects.equals(getStartTime(), paperInfo.getStartTime()) && Objects.equals(getEndTime(), paperInfo.getEndTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaperId(), getTitle(), getTeacherName(), getStartTime(), getEndTime());
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

    public PaperInfo(int paperId, String title, String teacherName, LocalDateTime startTime, LocalDateTime endTime) {
        this.paperId = paperId;
        this.title = title;
        this.teacherName = teacherName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public PaperInfo() {
    }
}
