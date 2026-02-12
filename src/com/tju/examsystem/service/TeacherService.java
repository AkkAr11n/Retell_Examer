package com.tju.examsystem.service;

import com.tju.examsystem.domain.Paper;
import com.tju.examsystem.domain.PaperInfo;
import com.tju.examsystem.domain.Teacher;

import java.util.List;

public interface TeacherService {
    public List<Teacher> getAllTeacher();

    void add(Teacher tea);

    void delete(String teacherId);

    void update(Teacher tea);

    List<PaperInfo> getPaperInfo(String teacherId);


    List<Paper> getUnpublishedPaperByInfo(String teacherId, String info);
}
