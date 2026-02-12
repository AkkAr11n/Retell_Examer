package com.tju.examsystem.web.servlet;

import com.tju.examsystem.service.StudentService;
import com.tju.examsystem.service.impl.StudentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/student/addGrade")
public class AddGradeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String studentId = (String) request.getSession().getAttribute("studentId");
        StudentService service=new StudentServiceImpl();
        int paperId = Integer.parseInt(request.getParameter("paperId"));
        int grade = Integer.parseInt(request.getParameter("grade"));
        service.addGrade(paperId,studentId,grade);
        response.sendRedirect(request.getContextPath()+"/student/paper/grade");
    }
}
