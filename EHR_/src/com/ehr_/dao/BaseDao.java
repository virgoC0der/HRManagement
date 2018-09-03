package com.ehr_.dao;


import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

/**
 * class_name: BaseDao
 * describe: 用来做数据的一个基础的连接、关闭、增、删、改、查
 * creat_user: Billy Chen
 * creat_date: 2018/7/9
 * creat_time: 9:55
 **/

public class BaseDao {

    private String driver = ResourceBundle.getBundle("jdbc").getString("driver");
    private String url = ResourceBundle.getBundle("jdbc").getString("url");
    private String username = ResourceBundle.getBundle("jdbc").getString("username");
    private String password = ResourceBundle.getBundle("jdbc").getString("password");

    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;


    public Connection getConnection() {
        try {
            Class.forName(driver);
            if (conn==null || conn.isClosed() ) {
                conn = DriverManager.getConnection(url, username, password);
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 数据库关闭连接
     */
    public void closeConnection(){
        try {
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            if(pst!=null){
                pst.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String sql, List<Object>params){
        if (getConnection()==null){
            return null;
        }
        try {
            pst = getConnection().prepareStatement(sql);
            if (params!=null&&params.size()>0){
                for (int i=0;i<params.size();i++){
                    pst.setObject(i+1,params.get(i));
                }
            }
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }


    public int executeUpdate(String sql,List<Object> params){
        int result = 0;
        //获取连接
        if(getConnection()==null){
            return -1;
        }
        try {
            //创建PreparedStatement对象
            pst = conn.prepareStatement(sql);
            //如果增、删、改，需要给SQL语句进行参数绑定
            if(params!=null && params.size()>0){
                //循环查询参数集合，因为不确定集合对象中每个字段带类型，因此采用pstmt.setObject()进行查询参数绑定
                for(int i=0;i<params.size();i++){
                    pst.setObject(i+1, params.get(i));
                }
            }
            result = pst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            //关闭数据库连接
            this.closeConnection();
        }
        return result;
    }

}
