package com.tju.examsystem.web.servlet;

import com.tju.examsystem.service.UserService;
import com.tju.examsystem.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int permission = Integer.parseInt(request.getParameter("permission"));
        String username = request.getParameter("username");
        UserService service=new UserServiceImpl();
        String str=service.getPhoto(username);
        request.setAttribute("img",str);
        if(permission==0){
           request.getSession().setAttribute("studentId",username);
           request.getRequestDispatcher("/student.jsp").forward(request,response);
        }else if(permission==1){
            request.getSession().setAttribute("teacherId",username);
            request.getRequestDispatcher("/teacher.jsp").forward(request,response);
        }else{
           request.getSession().setAttribute("managerId",username);
            request.getRequestDispatcher("/manager.jsp").forward(request,response);
        }
    }
}
