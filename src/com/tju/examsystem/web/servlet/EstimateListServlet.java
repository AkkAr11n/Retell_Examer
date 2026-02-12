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


@WebServlet("/question/estimate")
public class EstimateListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        QuestionService service=new QuestionServiceImpl();
        List<Question> estimates = service.getEstimateList();
        request.setAttribute("estimates",estimates);
        request.getRequestDispatcher("/estimate.jsp").forward(request,response);
    }
}
