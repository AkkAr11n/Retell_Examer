package com.tju.examsystem.web.servlet;

import com.tju.examsystem.domain.Student;
import com.tju.examsystem.domain.User;
import com.tju.examsystem.service.StudentService;
import com.tju.examsystem.service.UserService;
import com.tju.examsystem.service.impl.StudentServiceImpl;
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


@WebServlet("/student/add")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Student stu=new Student();
        try {
            BeanUtils.populate(stu,map);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        StudentService service= new StudentServiceImpl();
        service.add(stu);
        UserService userService=new UserServiceImpl();
        String username = request.getParameter("studentId");
        User user=new User(username,0);
        userService.add(user);
        response.sendRedirect(request.getContextPath()+"/student/displayStudent?now=1");
    }
}
