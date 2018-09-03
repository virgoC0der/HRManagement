package com.ehr_.servlet;

import com.ehr_.dao.BaseDao;
import com.ehr_.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Queryinfo
 */
//@WebServlet("/Queryinfo")
public class Queryinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Queryinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("Id");
		System.out.println(id);
		int id_int = Integer.parseInt(id);
		BaseDao baseDao = new BaseDao();
		String sql = "select * from 员工表 where Id = ?";
		List<Object> params = new ArrayList<>();
		params.add(id_int);
		ResultSet rs = baseDao.executeQuery(sql,params);
		try {
			while(rs.next()) {
				String name = rs.getString("Name");
				String preDepartment = rs.getString("Department");
				String post = rs.getString("Post");
				String level = rs.getString("Level");
				String age = rs.getString("Age");
				String language = rs.getString("Language");
				String career = rs.getString("Career");
				String relationship = rs.getString("Relationship");
				String in = rs.getString("In-data");
				String exit = rs.getString("Exit-data");
				String begin = rs.getString("Begin-time");
				String end = rs.getString("End-time");
				System.out.println(name);
				request.setAttribute("Id",id_int);
				request.setAttribute("Name", name);
				request.setAttribute("Post", post);
				request.setAttribute("Department", preDepartment);
				request.setAttribute("Level", level);
				request.setAttribute("Age", age);
				request.setAttribute("Language", language);
				request.setAttribute("Career", career);
				request.setAttribute("Relationship", relationship);
				request.setAttribute("In-date", in);
				request.setAttribute("Exit-date", exit);
				request.setAttribute("Begin-date", begin);
				request.setAttribute("End-date", end);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		baseDao.closeConnection();
		request.getRequestDispatcher("QueryStaff.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
