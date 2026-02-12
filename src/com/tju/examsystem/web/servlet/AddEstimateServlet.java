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
import java.time.LocalDateTime;


@WebServlet("/question/addEstimate")
public class AddEstimateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        String answer = request.getParameter("answer");
        int difficulty = Integer.parseInt(request.getParameter("difficulty"));
        QuestionService service=new QuestionServiceImpl();
        Question question=new Question(null,2,title,"",answer,difficulty
                , (String) request.getSession().getAttribute("teacherId"), LocalDateTime.now());
        service.add(question);
        response.sendRedirect(request.getContextPath()+"/question/estimate");
    }
}
