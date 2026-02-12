package com.tju.examsystem.dao;

import com.tju.examsystem.domain.Paper;
import com.tju.examsystem.domain.PaperInfo;
import com.tju.examsystem.domain.Teacher;

import java.util.List;

public interface TeacherDao {
    String getNameById(String teacherId);

    List<Teacher> getAllTeacher();

    void add(Teacher tea);

    void deleteById(String teacherId);

    void update(Teacher tea);

    List<PaperInfo> getPaperInfo(String teacherId);


    List<Paper> getUnpublishedPaperByInfo(String teacherId, String info);
}
