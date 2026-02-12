package com.tju.examsystem.web.servlet;

import com.tju.examsystem.service.StudentService;
import com.tju.examsystem.service.impl.StudentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/student/class")
public class GetSquadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        StudentService service =new StudentServiceImpl();
        List<String> squads= service.getSquad();
        int paperId = Integer.parseInt(request.getParameter("paperId"));
        request.setAttribute("paperId",paperId);
        request.setAttribute("squads",squads);
        request.getRequestDispatcher("/publish.jsp").forward(request,response);
    }
}
