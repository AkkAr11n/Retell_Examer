package com.tju.examsystem.domain;

import java.util.Objects;


public class QMark {
    private Integer questionId;
    private Integer mark;

    @Override
    public String toString() {
        return "QMark{" +
                "questionId=" + questionId +
                ", mark=" + mark +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QMark qMark)) return false;
        return Objects.equals(getQuestionId(), qMark.getQuestionId()) && Objects.equals(getMark(), qMark.getMark());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestionId(), getMark());
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public QMark(Integer questionId, Integer mark) {
        this.questionId = questionId;
        this.mark = mark;
    }

    public QMark() {
    }
}
