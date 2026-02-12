package com.tju.examsystem.web.servlet;

import com.tju.examsystem.service.PaperService;
import com.tju.examsystem.service.impl.PaperServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/paper/publishPaper")
public class PublishPaperServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int paperId = Integer.parseInt(request.getParameter("paperId"));
        String[] squads = request.getParameterValues("squad");
        Object startTime = request.getParameter("startTime");
        Object endTime = request.getParameter("endTime");
        String teacherId = (String) request.getSession().getAttribute("teacherId");
        PaperService service=new PaperServiceImpl();
        service.publish(teacherId,paperId,squads,startTime,endTime);
        response.sendRedirect(request.getContextPath()+"/teacher/hasPublished");
    }
}
