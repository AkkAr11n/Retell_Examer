package com.tju.examsystem.dao.impl;

import com.tju.examsystem.dao.QuestionDao;
import com.tju.examsystem.domain.Question;
import com.tju.examsystem.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class QuestionDaoImpl implements QuestionDao {
    @Override
    public List<Question> getListByCategory(int category) {
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql="select * from tb_question where category=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,category);
            rs=ps.executeQuery();
            List<Question> list =new ArrayList<>();
            while(rs.next()){
                int questionId=rs.getInt("question_Id");
                String title=rs.getString("title");
                String content=rs.getString("content");
                String answer=rs.getString("answer");
                int difficulty=rs.getInt("difficulty");
                String teacherId=rs.getString("teacher_id");
                LocalDateTime createTime= (LocalDateTime) rs.getObject("create_time");
                Question que=new Question(questionId,null,title,content,answer,difficulty,teacherId,createTime);
                list.add(que);
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
    public void add(Question question) {
        Connection conn= null;
        PreparedStatement ps=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql="insert into tb_question values(null,?,?,?,?,?,?,?)";
            ps= conn.prepareStatement(sql);
            ps.setInt(1,question.getCategory());
            ps.setString(2,question.getTitle());
            ps.setString(3,question.getContent());
            ps.setString(4,question.getAnswer());
            ps.setInt(5,question.getDifficulty());
            ps.setString(6,question.getTeacherId());
            ps.setObject(7,question.getCreateTime());
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
    public void deleteById(int questionId) {
        Connection conn= null;
        PreparedStatement ps=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "delete from tb_question where question_id=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,questionId);
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
    public List<Integer> getQuestionIds() {
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql="select question_id from tb_question ";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            List<Integer> list =new ArrayList<>();
            while(rs.next()){
                int questionId=rs.getInt("question_Id");
                list.add(questionId);
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
    public List<Integer> getIdsByCateAndDiff(int category, int difficulty) {
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql="select question_id from tb_question where category=? and difficulty=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,category);
            ps.setInt(2,difficulty);
            rs=ps.executeQuery();
            List<Integer> list =new ArrayList<>();
            while(rs.next()){
                int questionId=rs.getInt("question_Id");
                list.add(questionId);
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
    public List<Question> getQuestionsByIdAndCategory(int paperId, int category) {
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql="select * from tb_question where category=? " +
                    "and question_id in" +
                    "(select question_id from paper_question where paper_id=?)";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,category);
            ps.setInt(2,paperId);
            rs=ps.executeQuery();
            List<Question> list =new ArrayList<>();
            while(rs.next()){
                int questionId=rs.getInt("question_Id");
                String title=rs.getString("title");
                String content=rs.getString("content");
                String answer=rs.getString("answer");
                int difficulty=rs.getInt("difficulty");
                String teacherId=rs.getString("teacher_id");
                LocalDateTime createTime= (LocalDateTime) rs.getObject("create_time");
                Question que=new Question(questionId,null,title,content,answer,difficulty,teacherId,createTime);
                list.add(que);
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
    public int getMark(int paperId, Integer questionId) {
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql="select mark from paper_question where paper_id=? and question_id=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,paperId);
            ps.setInt(2,questionId);
            rs=ps.executeQuery();
            int res=0;
            if(rs.next()){
                res=rs.getInt("mark");
            }
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
        return 0;
    }
}
