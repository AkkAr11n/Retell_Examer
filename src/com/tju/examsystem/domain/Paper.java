package com.tju.examsystem.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Paper {
    private Integer paperId;
    private String title;
    private LocalDateTime createTime;


    public Paper() {
    }

    public Paper(Integer paperId, String title, LocalDateTime createTime) {
        this.paperId = paperId;
        this.title = title;
        this.createTime = createTime;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paper paper)) return false;
        return Objects.equals(getPaperId(), paper.getPaperId()) && Objects.equals(getTitle(), paper.getTitle()) && Objects.equals(getCreateTime(), paper.getCreateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaperId(), getTitle(), getCreateTime());
    }

    @Override
    public String toString() {
        return "Paper{" +
                "paperId=" + paperId +
                ", title='" + title + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
