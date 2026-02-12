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
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;


@WebServlet("/paper/test")
public class ShowTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


       LocalDateTime  startTime= LocalDateTime.parse(request.getParameter("startTime"));
       LocalDateTime  endTime= LocalDateTime.parse(request.getParameter("endTime"));
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, startTime);
        long seconds = duration.getSeconds();
        if(seconds>0) {
            response.sendRedirect(request.getContextPath()+"/student/paper/info");
            return;
        }
        duration = Duration.between(now, endTime);
        seconds = duration.getSeconds();
        if(seconds<=0) {
            response.sendRedirect("/exam/student/paper/info");
            return;
        }
        request.setAttribute("seconds",seconds);
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
        request.setAttribute("paperId",paperId);
        int singleMark=0,multipleMark=0,estimateMark=0,fillMark=0;
        if(singles.size()!=0){
            singleMark=service.getMark(paperId,singles.get(0).getQuestionId());
        }
        if(multiples.size()!=0){
            multipleMark=service.getMark(paperId,multiples.get(0).getQuestionId());
        }
        if(estimates.size()!=0){
            estimateMark=service.getMark(paperId,estimates.get(0).getQuestionId());
        }
        if(fills.size()!=0){
            fillMark=service.getMark(paperId,fills.get(0).getQuestionId());
        }
        request.setAttribute("singleMark",singleMark);
        request.setAttribute("multipleMark",multipleMark);
        request.setAttribute("estimateMark",estimateMark);
        request.setAttribute("fillMark",fillMark);

        request.getRequestDispatcher("/test.jsp").forward(request,response);
    }
}
