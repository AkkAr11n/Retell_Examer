package com.tju.examsystem.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpRequest;


@WebFilter("/kgsljgsl")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) req;
        String uri=request.getRequestURI();
        if(uri.contains("/login")||uri.contains("/css/")||uri.contains("/js/")||uri.contains("/img/")||uri.contains("/verify")){
            chain.doFilter(req,resp);
        }else{
            HttpSession session = request.getSession();
            if(session!=null&&session.getAttribute("username")!=null){
                chain.doFilter(req,resp);
            }else{
                request.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }
    }
}
