package com.tju.examsystem.domain;

import java.time.LocalDateTime;
import java.util.Objects;


public class Question {
    private Integer questionId;
    private Integer category;
    private String title;
    private String content;
    private String answer;
    private Integer difficulty;
    private String teacherId;
    private LocalDateTime createTime;

    public Question() {
    }

    public Question(Integer questionId, Integer category, String title, String content, String answer, Integer difficulty, String teacherId, LocalDateTime createTime) {
        this.questionId = questionId;
        this.category = category;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.difficulty = difficulty;
        this.teacherId = teacherId;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", answer='" + answer + '\'' +
                ", difficulty=" + difficulty +
                ", teacherId='" + teacherId + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question question)) return false;
        return Objects.equals(getQuestionId(), question.getQuestionId()) && Objects.equals(getCategory(), question.getCategory()) && Objects.equals(getTitle(), question.getTitle()) && Objects.equals(getContent(), question.getContent()) && Objects.equals(getAnswer(), question.getAnswer()) && Objects.equals(getDifficulty(), question.getDifficulty()) && Objects.equals(getTeacherId(), question.getTeacherId()) && Objects.equals(getCreateTime(), question.getCreateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestionId(), getCategory(), getTitle(), getContent(), getAnswer(), getDifficulty(), getTeacherId(), getCreateTime());
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
