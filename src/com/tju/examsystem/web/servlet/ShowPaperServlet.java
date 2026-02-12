package com.tju.examsystem.web.servlet;

import com.tju.examsystem.domain.Question;
import com.tju.examsystem.service.QuestionService;
import com.tju.examsystem.service.impl.QuestionServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/paper/showPaper")
public class ShowPaperServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int paperId = Integer.parseInt(request.getParameter("paperId"));
        QuestionService service=new QuestionServiceImpl();
        List<Question> singles=service.getSinglesById(paperId);
        List<Question> multiples=service.getMultiplesById(paperId);
        List<Question> estimates=service.getEstimatesById(paperId);
        List<Question> fills=service.getFillsById(paperId);
        request.setAttribute("singles",singles);
        request.setAttribute("multiples",multiples);
        request.setAttribute("estimates",estimates);
        request.setAttribute("fills",fills);


        request.getRequestDispatcher("/paper.jsp").forward(request,response);
    }
}
