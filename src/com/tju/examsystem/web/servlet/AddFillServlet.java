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


@WebServlet("/question/addFill")
public class AddFillServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        String[] answers = request.getParameterValues("answer");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<answers.length;i++){
            String str=answers[i];
            if(str==null||str==""){
                str=" ";
            }
            if(i!=0) sb.append('#');
            sb.append(str);
        }
        String answer=sb.toString();
        int difficulty = Integer.parseInt(request.getParameter("difficulty"));
        QuestionService service=new QuestionServiceImpl();
        Question question=new Question(null,3,title,"",answer,difficulty
                , (String) request.getSession().getAttribute("teacherId"), LocalDateTime.now());
        service.add(question);
        response.sendRedirect(request.getContextPath()+"/question/fill");
    }
}
