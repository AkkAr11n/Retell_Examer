package com.tju.examsystem.web.servlet;

import com.tju.examsystem.domain.QMark;
import com.tju.examsystem.service.PaperService;
import com.tju.examsystem.service.QuestionService;
import com.tju.examsystem.service.impl.PaperServiceImpl;
import com.tju.examsystem.service.impl.QuestionServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@WebServlet("/paper/addPaper")
public class AddPaperServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int difficulty = Integer.parseInt(request.getParameter("difficulty"));
        QuestionService service=new QuestionServiceImpl();
        if(difficulty==3){
            //什么参数都没给，随意抽十题
            List<Integer> ids=service.getQuestionIds();
            if(ids.size()<10){
                response.sendRedirect(request.getContextPath()+"/teacher/unpublished");
                return;
            }
            Collections.shuffle(ids);
            List<QMark> qms=new ArrayList<>();
            for(int i=0;i<10;i++){
                QMark q=new QMark(ids.get(i),10);
                qms.add(q);
            }
            PaperService pService=new PaperServiceImpl();
            pService.add(request.getParameter("title"),qms);
        }else{
            List<Integer> singles=service.getIdsByCateAndDiff
                    (0,Integer.parseInt(request.getParameter("difficulty")));
            Collections.shuffle(singles);
            List<Integer> multiples=service.getIdsByCateAndDiff
                    (1,Integer.parseInt(request.getParameter("difficulty")));
            Collections.shuffle(multiples);
            List<Integer> estimates=service.getIdsByCateAndDiff
                    (2,Integer.parseInt(request.getParameter("difficulty")));
            Collections.shuffle(estimates);
            List<Integer> fills=service.getIdsByCateAndDiff
                    (3,Integer.parseInt(request.getParameter("difficulty")));
            Collections.shuffle(fills);
            if(singles.size()<Integer.parseInt(request.getParameter("singleCnt"))
            ||multiples.size()<Integer.parseInt(request.getParameter("multipleCnt"))
            ||estimates.size()<Integer.parseInt(request.getParameter("estimateCnt"))
            ||fills.size()<Integer.parseInt(request.getParameter("fillCnt"))){
                response.sendRedirect(request.getContextPath()+"/teacher/unpublished");
                return;
            }
            List<QMark> qms=new ArrayList<>();
            for(int i=0;i<Integer.parseInt(request.getParameter("singleCnt"));i++){
                QMark q=new QMark(singles.get(i),Integer.parseInt(request.getParameter("singleMark")));
                qms.add(q);
            }
            for(int i=0;i<Integer.parseInt(request.getParameter("multipleCnt"));i++){
                QMark q=new QMark(multiples.get(i),Integer.parseInt(request.getParameter("multipleMark")));
                qms.add(q);
            }
            for(int i=0;i<Integer.parseInt(request.getParameter("estimateCnt"));i++){
                QMark q=new QMark(estimates.get(i),Integer.parseInt(request.getParameter("estimateMark")));
                qms.add(q);
            }
            for(int i=0;i<Integer.parseInt(request.getParameter("fillCnt"));i++){
                QMark q=new QMark(fills.get(i),Integer.parseInt(request.getParameter("fillMark")));
                qms.add(q);
            }
            PaperService pService=new PaperServiceImpl();
            pService.add(request.getParameter("title"),qms);
        }
        response.sendRedirect(request.getContextPath()+"/teacher/unpublished");
    }
}
