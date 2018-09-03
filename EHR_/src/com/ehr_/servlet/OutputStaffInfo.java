package com.ehr_.servlet;

import com.ehr_.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class OutputStaffInfo
 * ��ѯԱ����Ϣ�����
 * @author ������
 * 2018-7-15
 */
//@WebServlet("/OutputStaffInfo")
public class OutputStaffInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutputStaffInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("Id");
		String sqlSentence = "select * from Ա���� where Id = "+id;
		SqlOperation sql = new SqlOperation();
		sql.getConnection();
		ResultSet rs = sql.staffSelect(sqlSentence);
//		try {
//			String name = rs.getString("Name");
//			request.setAttribute("Name", name);
//			request.setAttribute("Id", id);
//			String post = rs.getString("Post");
//			request.setAttribute("Post", post);
//			String department = rs.getString("Department");
//			request.setAttribute("Department", department);
//			int level = rs.getInt("Level");
//			request.setAttribute("Level", level);
//			int age = rs.getInt("Age");
//			request.setAttribute("Age", age);
//			String language = rs.getString("Language");
//			request.setAttribute("Language", language);
//			String career = rs.getString("Career");
//			request.setAttribute("Career", career);
//			String relationship = rs.getString("relationship");
//			request.setAttribute("Relationship", relationship);
//			Date in_Date = rs.getDate("In-data");			
//			request.setAttribute("In-date", in_Date);
//			Date Exit_Date = rs.getDate("Exit-data");			
//			request.setAttribute("Exit-date", Exit_Date);
//			Date begin_Date = rs.getDate("Begin-time");			
//			request.setAttribute("Begin-date", begin_Date);
//			Date end_Date = rs.getDate("End-time");			
//			request.setAttribute("End-date", end_Date);
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
        try {
        	while(rs.next()) {       		
        		request.setAttribute("Id", rs.getInt("Id"));
        		request.setAttribute("Name", rs.getString("Name"));
        		request.setAttribute("Post", rs.getString("Post"));
        		request.setAttribute("Department", rs.getString("Department"));
        		request.setAttribute("Level", rs.getInt("Level"));
        		request.setAttribute("Age", rs.getInt("Age"));
        		request.setAttribute("Language", rs.getString("Language"));
        		request.setAttribute("Career", rs.getString("Career"));
        		request.setAttribute("Relationship", rs.getString("Relationship"));
        		request.setAttribute("In-date", rs.getDate("In-data"));
        		request.setAttribute("Exit-date", rs.getDate("Exit-data"));
        		request.setAttribute("Begin-date", rs.getDate("Begin-time"));
        		request.setAttribute("End-date", rs.getDate("End-time"));
        	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
        sql.closeConnection();
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
