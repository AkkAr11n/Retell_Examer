package com.tju.examsystem.util;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtil {
    private static ResourceBundle bundle=ResourceBundle.getBundle("resources.jdbc");
    static{
        try {

            Class.forName(bundle.getString("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return 连接对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection conn= DriverManager.getConnection(bundle.getString("url"),bundle.getString("user"),bundle.getString("password"));
        return conn;
    }

    /**
     *
     * @param conn 连接对象
     * @param ps 数据库操作对象
     * @param rs 结果集对象
     */
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
