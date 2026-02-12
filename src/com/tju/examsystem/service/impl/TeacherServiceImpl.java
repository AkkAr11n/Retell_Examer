package com.tju.examsystem.service.impl;

import com.tju.examsystem.dao.TeacherDao;
import com.tju.examsystem.dao.impl.TeacherDaoImpl;
import com.tju.examsystem.domain.Paper;
import com.tju.examsystem.domain.PaperInfo;
import com.tju.examsystem.domain.Teacher;
import com.tju.examsystem.service.TeacherService;

import java.util.List;


public class TeacherServiceImpl implements TeacherService {
    private TeacherDao dao=new TeacherDaoImpl();
    @Override
    public List<Teacher> getAllTeacher() {
        return dao.getAllTeacher();
    }

    @Override
    public void add(Teacher tea) {
        dao.add(tea);
    }

    @Override
    public void delete(String teacherId) {
        dao.deleteById(teacherId);
    }

    @Override
    public void update(Teacher tea) {
        dao.update(tea);
    }

    @Override
    public List<PaperInfo> getPaperInfo(String teacherId) {
        return dao.getPaperInfo(teacherId);
    }


    @Override
    public List<Paper> getUnpublishedPaperByInfo(String teacherId, String info) {
        return dao.getUnpublishedPaperByInfo(teacherId,info);
    }
}
