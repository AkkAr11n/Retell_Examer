package com.tju.examsystem.web.servlet;

import com.tju.examsystem.service.TeacherService;
import com.tju.examsystem.service.UserService;
import com.tju.examsystem.service.impl.TeacherServiceImpl;
import com.tju.examsystem.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/teacher/delete")
public class DeleteTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String teacherId = request.getParameter("teacherId");
        TeacherService service= new TeacherServiceImpl();
        service.delete(teacherId);
        UserService userService=new UserServiceImpl();
        userService.delete(teacherId);
        response.sendRedirect(request.getContextPath()+"/teacher/displayTeacher");
    }
}
