package com.tju.examsystem.web.servlet;

import com.tju.examsystem.service.QuestionService;
import com.tju.examsystem.service.impl.QuestionServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/question/delete")
public class DeleteQuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        QuestionService service=new QuestionServiceImpl();
        service.delete(Integer.parseInt(request.getParameter("questionId")));
        int category = Integer.parseInt(request.getParameter("category"));
        if(category==0){
            response.sendRedirect(request.getContextPath()+"/question/single");
        }else if(category==1){
            response.sendRedirect(request.getContextPath()+"/question/multiple");
        }else if(category==2){
            response.sendRedirect(request.getContextPath()+"/question/estimate");
        }else{
            response.sendRedirect(request.getContextPath()+"/question/fill");
        }
    }
}
