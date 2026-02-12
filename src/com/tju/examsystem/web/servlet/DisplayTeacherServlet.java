package com.tju.examsystem.web.servlet;

import com.tju.examsystem.domain.Teacher;
import com.tju.examsystem.service.TeacherService;
import com.tju.examsystem.service.impl.TeacherServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/teacher/displayTeacher")
public class DisplayTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        TeacherService service=new TeacherServiceImpl();
        List<Teacher> allTeacher = service.getAllTeacher();
        request.setAttribute("allTeacher",allTeacher);
        request.getRequestDispatcher("/displayTeacher.jsp").forward(request,response);
    }
}
