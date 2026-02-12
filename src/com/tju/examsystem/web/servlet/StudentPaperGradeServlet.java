package com.tju.examsystem.web.servlet;

import com.tju.examsystem.domain.PaperGrade;
import com.tju.examsystem.service.StudentService;
import com.tju.examsystem.service.impl.StudentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;


@WebServlet("/student/paper/grade")
public class StudentPaperGradeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String studentId= (String) session.getAttribute("studentId");
        StudentService service= new StudentServiceImpl();
        List<PaperGrade> paperGrade = service.getPaperGrade(studentId);
        request.setAttribute("paperGrade",paperGrade);
        request.getRequestDispatcher("/studentPaperGrade.jsp").forward(request,response);

    }
}
