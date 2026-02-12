package com.tju.examsystem.web.servlet;

import com.tju.examsystem.service.UserService;
import com.tju.examsystem.service.impl.UserServiceImpl;
import com.tju.examsystem.util.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@MultipartConfig
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn=null;
        PreparedStatement ps=null;
        InputStream inputStream=null;
        HttpSession session = request.getSession();
        int permission= Integer.parseInt(request.getParameter("permission"));
        String username=null;
        if(permission==0){
            username= (String) session.getAttribute("studentId");
        }else if(permission==1){
            username= (String) session.getAttribute("teacherId");
        }else{
            username= (String) session.getAttribute("managerId");
        }
        try {
            Part filePart = request.getPart("photo");  // 获取上传的文件
            if(filePart!=null)
            {
                inputStream = filePart.getInputStream();
            }
            conn= DBUtil.getConnection();
            String sql="update tb_user set img=? where username=?";
            ps=conn.prepareStatement(sql);
            if(inputStream!=null)
            {
                ps.setBlob(1,inputStream);
            }
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtil.close(conn,ps,null);
        }
        UserService service=new UserServiceImpl();
        String str=service.getPhoto(username);
        request.setAttribute("img",str);
        if(permission==0){
            request.getRequestDispatcher("/student.jsp").forward(request,response);
        }else if(permission==1){
            request.getRequestDispatcher("/teacher.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/manager.jsp").forward(request,response);
        }
    }
}
