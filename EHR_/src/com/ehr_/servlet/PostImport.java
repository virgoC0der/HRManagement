package com.ehr_.servlet;

import com.ehr_.dao.BaseDao;
import com.ehr_.util.SqlOperation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class PostImport
 */
//@WebServlet("/PostImport")
public class PostImport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostImport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("Id");
		String sqlSentence = "select * from 员工表 where Id = ? ";
		List<Object> params = new ArrayList<>();
		params.add(id);

		BaseDao baseDao = new BaseDao();
		ResultSet rs = baseDao.executeQuery(sqlSentence, params);
		System.out.println(rs);
//		try {
//			System.out.println(rs.getString("Name"));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			String name = rs.getString("Name");
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
        try {
        	while(rs.next()) {
				//System.out.println(rs.getString("Name"));
        		request.setAttribute("Name", rs.getString("Name"));
        		request.setAttribute("Post", rs.getString("Post"));
        		request.setAttribute("Department", rs.getString("Department"));
        	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
        baseDao.closeConnection();
        request.getRequestDispatcher("PostImport.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
