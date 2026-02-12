package com.tju.examsystem.web.servlet;

import com.tju.examsystem.domain.PaperStudent;
import com.tju.examsystem.service.PaperService;
import com.tju.examsystem.service.impl.PaperServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/paper/showGrade")
public class ShowGradeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String teacherId = (String) request.getSession().getAttribute("teacherId");
        int paperId = Integer.parseInt(request.getParameter("paperId"));
        PaperService service=new PaperServiceImpl();
        List<PaperStudent>grades= service.getGradeList(paperId,teacherId);
        double aver=0;
        for(PaperStudent stu:grades){
            aver+=stu.getGrade();
        }
        if(grades.size()!=0) aver/=grades.size();
        request.setAttribute("grades",grades);
        request.setAttribute("aver",aver);
        request.getRequestDispatcher("/showGrade.jsp").forward(request,response);
    }
}
