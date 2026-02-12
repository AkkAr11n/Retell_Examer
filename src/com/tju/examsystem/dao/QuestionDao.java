package com.tju.examsystem.dao;

import com.tju.examsystem.domain.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> getListByCategory(int category);

    void add(Question question);

    void deleteById(int questionId);

    List<Integer> getQuestionIds();

    List<Integer> getIdsByCateAndDiff(int category, int difficulty);

    List<Question> getQuestionsByIdAndCategory(int paperId, int category);

    int getMark(int paperId, Integer questionId);
}
