package com.tju.examsystem.dao;

import com.tju.examsystem.domain.PaperGrade;
import com.tju.examsystem.domain.PaperInfo;
import com.tju.examsystem.domain.Student;

import java.util.List;

public interface StudentDao {
    List<PaperInfo> getPaperInfo(String studentId);

    List<PaperGrade> getPaperGrade(String studentId);

    List<Student> getAllStudent();

    void add(Student stu);

    void deleteById(String studentId);

    void update(Student stu);

    List<String> getSquad();

    List<String> getStudentIdBySquad(String squad);

    void addGrade(int paperId, String studentId, int grade);

    int getStudentCnt();

    List<Student> getStudentByLimit(int pg);
}
