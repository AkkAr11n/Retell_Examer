package com.tju.examsystem.dao.impl;

import com.tju.examsystem.dao.PaperDao;
import com.tju.examsystem.dao.StudentDao;
import com.tju.examsystem.dao.TeacherDao;
import com.tju.examsystem.domain.PaperGrade;
import com.tju.examsystem.domain.PaperInfo;
import com.tju.examsystem.domain.Student;
import com.tju.examsystem.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<PaperInfo> getPaperInfo(String studentId) {
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "select S.paper_id as paper_id, T.teacher_id as teacher_id, start_time, end_time " +
                    "from paper_student as S, teacher_paper as T " +
                    "where student_id = ? and grade is null and S.paper_id = T.paper_id and S.teacher_id=T.teacher_id";

            ps=conn.prepareStatement(sql);
            ps.setString(1,studentId);
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
                String name=teacherDao.getNameById(teacher_id);
                PaperInfo info=new PaperInfo(paper_id,title,name,start_time,end_time);
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
    public List<PaperGrade> getPaperGrade(String studentId) {
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "select paper_id, teacher_id, grade " +
                    "from paper_student " +
                    "where student_id = ? and grade is not null ";

            ps=conn.prepareStatement(sql);
            ps.setString(1,studentId);
            rs=ps.executeQuery();
            List<PaperGrade> list =new ArrayList<>();
            PaperDao paperDao=new PaperDaoImpl();
            TeacherDao teacherDao=new TeacherDaoImpl();
            while(rs.next()){
                int paper_id=rs.getInt("paper_id");
                String teacher_id=rs.getString("teacher_id");
                int grade=rs.getInt("grade");
                String title= paperDao.getTitleById(paper_id);
                String name=teacherDao.getNameById(teacher_id);
                PaperGrade pg=new PaperGrade(paper_id,title,name,grade);
                list.add(pg);
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
    public List<Student> getAllStudent() {
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "select * from tb_student";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            List<Student> list =new ArrayList<>();
            while(rs.next()){
                String studentId=rs.getString("student_id");
                String name=rs.getString("name");
                String academy=rs.getString("academy");
                String major=rs.getString("major");
                String squad=rs.getString("squad");
                Student stu=new Student(studentId,name,academy,major,squad);
                list.add(stu);
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
    public void add(Student stu) {
        Connection conn= null;
        PreparedStatement ps=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into tb_student values(?,?,?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,stu.getStudentId());
            ps.setString(2,stu.getName());
            ps.setString(3, stu.getAcademy());
            ps.setString(4, stu.getMajor());
            ps.setString(5, stu.getSquad());
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
    public void deleteById(String studentId) {
        Connection conn= null;
        PreparedStatement ps=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "delete from tb_student where student_id=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,studentId);
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
    public void update(Student stu) {
        Connection conn= null;
        PreparedStatement ps=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "update tb_student set name=?,academy=? ,major=?,squad=?where student_id=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,stu.getName());
            ps.setString(2,stu.getAcademy());
            ps.setString(3,stu.getMajor());
            ps.setString(4,stu.getSquad());
            ps.setString(5,stu.getStudentId());
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
    public List<String> getSquad() {
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "select distinct squad from tb_student";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            List<String> list =new ArrayList<>();
            while(rs.next()){
                String squad=rs.getString("squad");
                list.add(squad);
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
    public List<String> getStudentIdBySquad(String squad) {
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "select student_id from tb_student where squad=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,squad);
            rs=ps.executeQuery();
            List<String> list =new ArrayList<>();
            while(rs.next()){
                String studentId=rs.getString("student_id");
                list.add(studentId);
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
    public void addGrade(int paperId, String studentId, int grade) {
        Connection conn= null;
        PreparedStatement ps=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "update paper_student set grade=? where paper_id=? and student_id=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,grade);
            ps.setInt(2,paperId);
            ps.setString(3,studentId);
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
    public int getStudentCnt() {
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "select COUNT(*) as cnt from tb_student";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            int cnt=0;
            if(rs.next())  cnt=rs.getInt("cnt");
            conn.commit();
            return cnt;
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
        return 0;
    }

    @Override
    public List<Student> getStudentByLimit(int pg) {
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            int size=6;
            int rk=(pg-1)*size;
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "select * from tb_student limit ?,?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,rk);
            ps.setInt(2,size);
            rs=ps.executeQuery();
            List<Student> list =new ArrayList<>();
            while(rs.next()){
                String studentId=rs.getString("student_id");
                String name=rs.getString("name");
                String academy=rs.getString("academy");
                String major=rs.getString("major");
                String squad=rs.getString("squad");
                Student stu=new Student(studentId,name,academy,major,squad);
                list.add(stu);
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
