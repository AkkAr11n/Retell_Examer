package com.tju.examsystem.web.servlet;

import com.tju.examsystem.service.StudentService;
import com.tju.examsystem.service.UserService;
import com.tju.examsystem.service.impl.StudentServiceImpl;
import com.tju.examsystem.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/student/delete")
public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String studentId = request.getParameter("studentId");
        StudentService service= new StudentServiceImpl();
        service.delete(studentId);
        UserService userService=new UserServiceImpl();
        userService.delete(studentId);
        response.sendRedirect(request.getContextPath()+"/student/displayStudent?now=1");
    }
}
