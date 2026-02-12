package com.tju.examsystem.service;

import com.tju.examsystem.domain.PaperStudent;
import com.tju.examsystem.domain.QMark;

import java.util.List;

public interface PaperService {
    void add(String title,List<QMark> qms);

    void publish(String teacherId ,int paperId, String[] squads, Object startTime, Object endTime);

    List<PaperStudent> getGradeList(int paperId, String teacherId);
}
