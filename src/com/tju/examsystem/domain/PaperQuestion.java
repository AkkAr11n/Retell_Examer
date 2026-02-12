package com.tju.examsystem.domain;

import java.util.Objects;


public class PaperQuestion {
    private Integer paperId;
    private Integer questionId;
    private Integer mark;

    public PaperQuestion() {
    }

    public PaperQuestion(Integer paperId, Integer questionId, Integer mark) {
        this.paperId = paperId;
        this.questionId = questionId;
        this.mark = mark;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaperQuestion that)) return false;
        return Objects.equals(getPaperId(), that.getPaperId()) && Objects.equals(getQuestionId(), that.getQuestionId()) && Objects.equals(getMark(), that.getMark());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaperId(), getQuestionId(), getMark());
    }

    @Override
    public String toString() {
        return "PaperQuestion{" +
                "paperId=" + paperId +
                ", questionId=" + questionId +
                ", mark=" + mark +
                '}';
    }
}
