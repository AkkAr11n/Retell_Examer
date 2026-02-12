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


@WebServlet("/question/addMultiple")
public class AddMultipleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        String[] contents = request.getParameterValues("content");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<contents.length;i++){
            String str=contents[i];
            if(str==null||str==""){
                str=" ";
            }
            if(i!=0) sb.append('#');
            sb.append(str);
        }
        String content=sb.toString();
        String[] answers = request.getParameterValues("answer");
        StringBuilder ansSb=new StringBuilder();
        for(String str:answers){
            if(str!=null&&str!="") ansSb.append(str);
        }
        String answer=ansSb.toString();
        int difficulty = Integer.parseInt(request.getParameter("difficulty"));
        QuestionService service=new QuestionServiceImpl();
        Question question=new Question(null,1,title,content,answer,difficulty
                , (String) request.getSession().getAttribute("teacherId"), LocalDateTime.now());
        service.add(question);
        response.sendRedirect(request.getContextPath()+"/question/multiple");
    }
}
