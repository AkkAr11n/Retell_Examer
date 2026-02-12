package com.tju.examsystem.dao.impl;

import com.tju.examsystem.dao.UserDao;
import com.tju.examsystem.domain.User;
import com.tju.examsystem.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {
    @Override
    public boolean findUser(User user) {
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql="select * from tb_user where username=? and permission=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setInt(2,user.getPermission());
            rs=ps.executeQuery();
            boolean res=false;
            if(rs.next()) res=true;
            conn.commit();
            return res;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }
        return false;
    }

    @Override
    public void add(User user) {
        Connection conn= null;
        PreparedStatement ps=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into tb_user values(?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setInt(2,user.getPermission());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,null);
        }
    }

    @Override
    public void deleteByUsername(String username) {
        Connection conn= null;
        PreparedStatement ps=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "delete from tb_user where username=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,null);
        }
    }

    @Override
    public String getPhoto(String username) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            String sql="select TO_BASE64(img) AS base64_img  from tb_user where username=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            String str=null;
            rs=ps.executeQuery();
            String temp=null;
            if(rs.next())
            {
                temp=rs.getString("base64_img");
            }
            if(temp==null) str="/img/3d84e1a572d7a401ad5c01661b571b06.jpg";
            else str="data:image/png;base64,"+temp;
            return str;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtil.close(conn,ps,rs);
        }
        return null;
    }


}
