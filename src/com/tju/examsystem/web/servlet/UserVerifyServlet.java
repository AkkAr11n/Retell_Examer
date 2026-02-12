package com.tju.examsystem.web.servlet;

import com.tju.examsystem.domain.User;
import com.tju.examsystem.service.UserService;
import com.tju.examsystem.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/verify")
public class UserVerifyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String inputCode=request.getParameter("checkCode");
        String realCode= (String) request.getSession().getAttribute("checkCode");
        if(!inputCode.equals(realCode))
        {
            out.print("验证码错误");
            return;
        }
        Map<String, String[]> map = request.getParameterMap();
        User loginUser =new User();
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        UserService service=new UserServiceImpl();

        if(service.login(loginUser)){
            out.print("success");
        }else{
            out.print("用户名错误！！");
        }
    }
}
