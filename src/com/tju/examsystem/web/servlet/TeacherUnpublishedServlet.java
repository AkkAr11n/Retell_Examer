package com.tju.examsystem.web.servlet;

import com.tju.examsystem.domain.Paper;
import com.tju.examsystem.service.TeacherService;
import com.tju.examsystem.service.impl.TeacherServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/teacher/unpublished")
public class TeacherUnpublishedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String teacherId = (String) request.getSession().getAttribute("teacherId");
        TeacherService service=new TeacherServiceImpl();
        List<Paper> papers=service.getUnpublishedPaperByInfo(teacherId,"");
        request.setAttribute("papers",papers);
        request.getRequestDispatcher("/unpublished.jsp").forward(request,response);
    }
}
