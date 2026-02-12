package com.tju.examsystem.dao.impl;

import com.tju.examsystem.dao.PaperDao;
import com.tju.examsystem.domain.PaperStudent;
import com.tju.examsystem.domain.QMark;
import com.tju.examsystem.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PaperDaoImpl implements PaperDao {
    @Override
    public String getTitleById(int paperId) {
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql="select title from tb_paper where paper_id=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,paperId);
            rs=ps.executeQuery();
            String title=null;
            if(rs.next()){
                title=rs.getString("title");
            }
            conn.commit();
            return title;
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
    public void add(String title,List<QMark> qms) {
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql="insert into tb_paper (title,create_time) values(?,?)";
            ps = conn.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, title);
            ps.setObject(2, LocalDateTime.now());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            int cId=0;
            if (rs.next()) {
                //获取插入数据的Id(主键，自增长)
                cId= rs.getInt(1) ;
            }
            for(QMark q:qms){
                addQuestion(conn,cId,q.getQuestionId(),q.getMark());
            }
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
    public void publish(String teacherId, int paperId, Object startTime, Object endTime) {
        Connection conn= null;
        PreparedStatement ps=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql="insert into teacher_paper values(?,?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,teacherId);
            ps.setInt(2,paperId);
            ps.setObject(3,startTime);
            ps.setObject(4,endTime);
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
    public void addStudent(int paperId, String studentId, String teacherId) {
        Connection conn= null;
        PreparedStatement ps=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql="insert into paper_student values(?,?,?,null)";
            ps= conn.prepareStatement(sql);
            ps.setInt(1,paperId);
            ps.setString(2,studentId);
            ps.setString(3,teacherId);

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
    public List<PaperStudent> getGradeList(int paperId, String teacherId) {
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "select P.student_id as student_id, T.name as name, COALESCE(P.grade, 0) as grade " +
                    "from paper_student as P, tb_student as T " +
                    "where P.paper_id = ? and P.teacher_id = ? and P.student_id = T.student_id  " +
                    "order by grade desc";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,paperId);
            ps.setString(2,teacherId);
            List<PaperStudent> list=new ArrayList<>();
            rs=ps.executeQuery();
            while(rs.next()){
                String studentId=rs.getString("student_id");
                String name=rs.getString("name");
                int grade=rs.getInt("grade");
                PaperStudent stu=new PaperStudent(paperId,studentId,name,grade);
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


    private void addQuestion(Connection conn,  int cId, Integer questionId, Integer mark) throws SQLException {
        String sql="insert into paper_question values(?,?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,cId);
        ps.setInt(2,questionId);
        ps.setInt(3,mark);
        ps.executeUpdate();
    }
}
