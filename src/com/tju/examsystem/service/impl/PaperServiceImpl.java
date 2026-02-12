package com.tju.examsystem.service.impl;

import com.tju.examsystem.dao.PaperDao;
import com.tju.examsystem.dao.StudentDao;
import com.tju.examsystem.dao.impl.PaperDaoImpl;
import com.tju.examsystem.dao.impl.StudentDaoImpl;
import com.tju.examsystem.domain.PaperStudent;
import com.tju.examsystem.domain.QMark;
import com.tju.examsystem.service.PaperService;

import java.util.List;


public class PaperServiceImpl implements PaperService {
    private PaperDao dao=new PaperDaoImpl();
    @Override
    public void add(String title,List<QMark> qms) {
        dao.add(title,qms);
    }

    @Override
    public void publish(String teacherId, int paperId, String[] squads, Object startTime, Object endTime) {
        dao.publish(teacherId,paperId,startTime,endTime);
        for(String squad:squads){
            StudentDao studentDao=new StudentDaoImpl();
            List<String> students=studentDao.getStudentIdBySquad(squad);
            for(String studentId:students){
                dao.addStudent(paperId,studentId,teacherId);
            }
        }
    }

    @Override
    public List<PaperStudent> getGradeList(int paperId, String teacherId) {
        return dao.getGradeList(paperId,teacherId);
    }


}
