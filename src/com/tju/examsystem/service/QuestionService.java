package com.tju.examsystem.service;

import com.tju.examsystem.domain.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getSingleList();

    List<Question> getMultipleList();

    List<Question> getEstimateList();

    List<Question> getFillList();

    void add(Question question);

    void delete(int questionId);

    List<Integer> getQuestionIds();

    List<Integer> getIdsByCateAndDiff(int category, int difficulty);

    List<Question> getSinglesById(int paperId);

    List<Question> getMultiplesById(int paperId);

    List<Question> getEstimatesById(int paperId);

    List<Question> getFillsById(int paperId);

    int getMark(int paperId, Integer questionId);
}
