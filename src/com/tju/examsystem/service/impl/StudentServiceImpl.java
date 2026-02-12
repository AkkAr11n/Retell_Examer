package com.tju.examsystem.service.impl;

import com.tju.examsystem.dao.StudentDao;
import com.tju.examsystem.dao.impl.StudentDaoImpl;
import com.tju.examsystem.domain.PaperGrade;
import com.tju.examsystem.domain.PaperInfo;
import com.tju.examsystem.domain.Student;
import com.tju.examsystem.service.StudentService;

import java.util.List;


public class StudentServiceImpl implements StudentService {
    private StudentDao dao=new StudentDaoImpl();

    @Override
    public List<PaperInfo> getPaperInfo(String studentId) {
        return dao.getPaperInfo(studentId);
    }

    @Override
    public List<PaperGrade> getPaperGrade(String studentId) {
        return dao.getPaperGrade(studentId);
    }

    @Override
    public List<Student> getAllStudent() {
        return dao.getAllStudent();
    }

    @Override
    public void add(Student stu) {
        dao.add(stu);
    }

    @Override
    public void delete(String studentId) {
        dao.deleteById(studentId);
    }

    @Override
    public void update(Student stu) {
        dao.update(stu);
    }

    @Override
    public List<String> getSquad() {
        return dao.getSquad();
    }

    @Override
    public void addGrade(int paperId, String studentId, int grade) {
        dao.addGrade(paperId,studentId,grade);
    }

    @Override
    public int getStudentCnt() {
        return dao.getStudentCnt();
    }

    @Override
    public List<Student> getStudentByLimit(int pg) {
        return dao.getStudentByLimit(pg);
    }
}
