package com.tju.examsystem.service;

import com.tju.examsystem.domain.PaperGrade;
import com.tju.examsystem.domain.PaperInfo;
import com.tju.examsystem.domain.Student;

import java.util.List;

public interface StudentService {
    public List<PaperInfo> getPaperInfo(String studentId);

    public List<PaperGrade> getPaperGrade(String studentId);
    public List<Student> getAllStudent();

    void add(Student stu);

    void delete(String studentId);

    void update(Student stu);

    List<String> getSquad();

    void addGrade(int paperId, String studentId, int grade);

    int getStudentCnt();

    List<Student> getStudentByLimit(int pg);
}
