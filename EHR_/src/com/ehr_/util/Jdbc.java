package com.ehr_.util;

import java.sql.*;

public class Jdbc {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    //打开连接
    public Connection getConn(String server,String dbname,String dbuser,String dbpwd){
        String DRIVER = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://"+server+":3306/"+dbname+"?"+"&useSSL=false&characterEncoding=utf8";

        try{
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,dbuser,dbpwd);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    //关闭连接
    public void closeAll(){
        try{
            if(rs != null){
                rs.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(ps != null){
                    ps.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                try{
                    if(conn != null){
                        conn.close();
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

    }
    //执行sql语句，可以进行查询
    public ResultSet executeQuery(String preparedSql,String []param){
        try{
            ps = conn.prepareStatement(preparedSql);
            if(param != null){
                for (int i = 0; i < param.length; i++) {
                    ps.setString(i + 1, param[i]);
                }
            }
            rs = ps.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;

    }
    //执行sql语句，增加，修改，删除
    public int executeUpdate(String preparedSql,String[]param){
        int num = 0;
        try{
            ps = conn.prepareStatement(preparedSql);
            if(ps != null){
                for (int i = 0; i < param.length; i++) {
                    ps.setString(i + 1, param[i]);
                }
            }
            num = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return num;
    }
}