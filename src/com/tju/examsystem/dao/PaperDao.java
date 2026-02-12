package com.tju.examsystem.dao;

import com.tju.examsystem.domain.PaperStudent;
import com.tju.examsystem.domain.QMark;

import java.util.List;

public interface PaperDao {
    public String getTitleById(int paperId);

    void add(String title,List<QMark> qms);

    void publish(String teacherId, int paperId, Object startTime, Object endTime);


    void addStudent(int paperId, String studentId, String teacherId);

    List<PaperStudent> getGradeList(int paperId, String teacherId);
}
