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
 * Servlet implementation class EmployManage
 */
//@WebServlet("/EmployManage")
public class EmployManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployManage() {
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
//		SqlOperation sql = new SqlOperation();
//		sql.getConnection();
//		ResultSet rs = sql.staffSelect(sqlSentence);
		List<Object> params = new ArrayList<>();
		params.add(id);

		BaseDao baseDao = new BaseDao();
		ResultSet rs = baseDao.executeQuery(sqlSentence, params);
		System.out.println(rs);
//		try {
//			String name = rs.getString("Name");
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
        try {
        	while(rs.next()) {     
        		request.setAttribute("Id", id);
        		request.setAttribute("Name", rs.getString("Name"));
        		request.setAttribute("Begin_date", rs.getString("Begin-time"));
        		request.setAttribute("End_date", rs.getString("End-time"));
        	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
        baseDao.closeConnection();
        request.getRequestDispatcher("EmployManage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
