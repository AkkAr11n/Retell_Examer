package com.tju.examsystem.service.impl;

import com.tju.examsystem.dao.QuestionDao;
import com.tju.examsystem.dao.impl.QuestionDaoImpl;
import com.tju.examsystem.domain.Question;
import com.tju.examsystem.service.QuestionService;

import java.util.List;


public class QuestionServiceImpl implements QuestionService {
    private QuestionDao dao= new QuestionDaoImpl();
    @Override
    public List<Question> getSingleList() {
        return dao.getListByCategory(0);
    }

    @Override
    public List<Question> getMultipleList() {
        return dao.getListByCategory(1);
    }

    @Override
    public List<Question> getEstimateList() {
        return dao.getListByCategory(2);
    }

    @Override
    public List<Question> getFillList() {
        return dao.getListByCategory(3);
    }

    @Override
    public void add(Question question) {
        dao.add(question);
    }

    @Override
    public void delete(int questionId) {
        dao.deleteById(questionId);
    }

    @Override
    public List<Integer> getQuestionIds() {
        return dao.getQuestionIds();
    }

    @Override
    public List<Integer> getIdsByCateAndDiff(int category, int difficulty) {
        return dao.getIdsByCateAndDiff(category, difficulty);
    }

    @Override
    public List<Question> getSinglesById(int paperId) {
        return dao.getQuestionsByIdAndCategory(paperId,0);
    }

    @Override
    public List<Question> getMultiplesById(int paperId) {
        return dao.getQuestionsByIdAndCategory(paperId,1);
    }

    @Override
    public List<Question> getEstimatesById(int paperId) {
        return dao.getQuestionsByIdAndCategory(paperId,2);
    }

    @Override
    public List<Question> getFillsById(int paperId) {
        return dao.getQuestionsByIdAndCategory(paperId,3);
    }

    @Override
    public int getMark(int paperId, Integer questionId) {
        return dao.getMark(paperId,questionId);
    }
}
