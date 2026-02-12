package com.tju.examsystem.web.servlet;

import com.tju.examsystem.domain.Teacher;
import com.tju.examsystem.domain.User;
import com.tju.examsystem.service.TeacherService;
import com.tju.examsystem.service.UserService;
import com.tju.examsystem.service.impl.TeacherServiceImpl;
import com.tju.examsystem.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@WebServlet("/teacher/add")
public class AddTeacherServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Teacher tea=new Teacher();
        try {
            BeanUtils.populate(tea,map);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        TeacherService service= new TeacherServiceImpl();
        service.add(tea);
        UserService userService=new UserServiceImpl();
        String username = request.getParameter("teacherId");
        User user=new User(username,1);
        userService.add(user);
        response.sendRedirect(request.getContextPath()+"/teacher/displayTeacher");
    }
}
