package com.tju.examsystem.dao.impl;

import com.tju.examsystem.dao.PaperDao;
import com.tju.examsystem.dao.TeacherDao;
import com.tju.examsystem.domain.Paper;
import com.tju.examsystem.domain.PaperInfo;
import com.tju.examsystem.domain.Teacher;
import com.tju.examsystem.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class TeacherDaoImpl implements TeacherDao {
    @Override
    public String getNameById(String teacherId) {
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql="select name from tb_teacher where teacher_id=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,teacherId);
            rs=ps.executeQuery();
            String name=null;
            if(rs.next()){
                name=rs.getString("name");
            }
            conn.commit();
            return name;
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
        return null;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "select * from tb_teacher";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            List<Teacher> list =new ArrayList<>();
            while(rs.next()){
                String teacherId=rs.getString("teacher_id");
                String name = rs.getString("name");
                String academy = rs.getString("academy");
                Teacher tea=new Teacher(teacherId,name,academy);
                list.add(tea);
            }
            conn.commit();
            return list;
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
        return null;
    }

    @Override
    public void add(Teacher tea) {
        Connection conn= null;
        PreparedStatement ps=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into tb_teacher values(?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,tea.getTeacherId());
            ps.setString(2,tea.getName());
            ps.setString(3, tea.getAcademy());
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
    public void deleteById(String teacherId) {
        Connection conn= null;
        PreparedStatement ps=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "delete from tb_teacher where teacher_id=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,teacherId);
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
    public void update(Teacher tea) {
        Connection conn= null;
        PreparedStatement ps=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "update tb_teacher set name=?,academy=? where teacher_id=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,tea.getName());
            ps.setString(2,tea.getAcademy());
            ps.setString(3,tea.getTeacherId());
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
    public List<PaperInfo> getPaperInfo(String teacherId) {
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "select paper_id, teacher_id, start_time, end_time " +
                    "from teacher_paper where teacher_id=?";

            ps=conn.prepareStatement(sql);
            ps.setString(1,teacherId);
            rs=ps.executeQuery();
            List<PaperInfo> list =new ArrayList<>();
            PaperDao paperDao=new PaperDaoImpl();
            TeacherDao teacherDao=new TeacherDaoImpl();
            while(rs.next()){
                int paper_id=rs.getInt("paper_id");
                String teacher_id=rs.getString("teacher_id");
                LocalDateTime start_time= (LocalDateTime) rs.getObject("start_time");
                LocalDateTime end_time=(LocalDateTime) rs.getObject("end_time");
                String title= paperDao.getTitleById(paper_id);
                PaperInfo info=new PaperInfo(paper_id,title,null,start_time,end_time);
                list.add(info);
            }
            conn.commit();
            return list;
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
        return null;
    }

    @Override
    public List<Paper> getUnpublishedPaperByInfo(String teacherId, String info) {
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql="select * from tb_paper where paper_id not in " +
                    "(select paper_id from teacher_paper where teacher_id=?)" +
                    "and title like ?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,teacherId);
            ps.setString(2,"%"+info+"%");
            rs=ps.executeQuery();
            List<Paper> list =new ArrayList<>();
            PaperDao paperDao=new PaperDaoImpl();
            while(rs.next()){
                int paperId=rs.getInt("paper_id");
                String title= paperDao.getTitleById(paperId);
                LocalDateTime createTime=(LocalDateTime) rs.getObject("create_time");
                Paper paper=new Paper(paperId,title,createTime);
                list.add(paper);
            }
            conn.commit();
            return list;
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
        return null;
    }

}
