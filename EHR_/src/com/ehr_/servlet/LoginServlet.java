package com.ehr_.servlet;

import com.ehr_.dao.BaseDao;
import com.ehr_.util.User;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;

    private Connection conn;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        //从前端获取数据
        String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");
        ServletContext ctx = request.getServletContext();
        List<Object> params = new ArrayList<>();


        User user = null;
        BaseDao baseDao = new BaseDao();
        String sql = "select name,password from userinfo where name = ? and password = ?";
        params.add(username);
        params.add(userpass);
        System.out.println(params);
        ResultSet rs = baseDao.executeQuery(sql, params);

        System.out.println(rs);
        //验证用户名密码
        try {
            if(rs.next()) {
                System.out.println("登录成功");
                //out.flush();
                out.println("<script>");
                out.println("alert('登陆成功！')");
                out.println("history.back()");
                out.println("</script>");
//                RequestDispatcher dispatcher = request.getRequestDispatcher("LoginSuccess.jsp");
//                dispatcher.forward(request,response);
                //跳转到下一页面
                response.sendRedirect("Main.jsp");
                out.close();
            } else {
                System.out.println("登录失败!");
                out.flush();
                out.println("<script>");
                out.println("alert('用户名或密码错误');");
                out.println("history.back();");
                out.println("</script>");
                out.close();
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.println("用户名："+username+"----------"+"密码"+userpass);





//        if (username.trim().equals("Tom") && userpass.equals("motherFucker")) {
//            Out.write("登陆成功！");
//        }
//        else Out.write("登录失败");

//        try {
//            if(rs != null && rs.next()) {
//                HttpSession session = request.getSession();
//                session.setAttribute("username", username);
//                RequestDispatcher dispatcher = request.getRequestDispatcher("MainServlet");
//                dispatcher.forward(request, response);
//            }
//            else {
//                out.print("登录失败");
//                out.print("<br><a href = 'index.jsp>重新登录</a>");
//            }
//        } catch(SQLException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    }

