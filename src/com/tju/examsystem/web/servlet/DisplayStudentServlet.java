package com.tju.examsystem.web.servlet;

import com.tju.examsystem.domain.Student;
import com.tju.examsystem.service.StudentService;
import com.tju.examsystem.service.impl.StudentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/student/displayStudent")
public class DisplayStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        StudentService  service=new StudentServiceImpl();
        int cnt=service.getStudentCnt();
        int maxPage=(cnt+4)/6;
        if(maxPage==0) maxPage=1;
        int now= Integer.parseInt(request.getParameter("now"));
        if(now==0) now=1;
        if(now>maxPage) now--;
        List<Student> allStudent = service.getStudentByLimit(now);
        request.setAttribute("allStudent",allStudent);
        request.setAttribute("now",now);
        request.getRequestDispatcher("/displayStudent.jsp").forward(request,response);
//        List<Student> allStudent = service.getAllStudent();
//        request.setAttribute("allStudent",allStudent);
//        request.getRequestDispatcher("/displayStudent.jsp").forward(request,response);
    }
}
