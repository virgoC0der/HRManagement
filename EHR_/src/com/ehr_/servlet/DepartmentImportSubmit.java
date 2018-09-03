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
 * Servlet implementation class DepartmentImportSubmit
 */
//@WebServlet("/DepartmentImportSubmit")
public class DepartmentImportSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentImportSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("Id");
		int intId = Integer.parseInt(id);
		String newDepartment = request.getParameter("newDepartment");
//		String date = request.getParameter("date");
		SqlOperation sql = new SqlOperation();
		sql.getConnection();
		String stringId = String.valueOf(intId);
		String sqlSentenceSelect = "select * from 员工表 where Id = ?";
		List<Object> params = new ArrayList<>();
		params.add(intId);

		BaseDao baseDao = new BaseDao();
		ResultSet rs = baseDao.executeQuery(sqlSentenceSelect, params);
		System.out.println(rs);
//		ResultSet rs = sql.staffSelect(sqlSentenceSelect);
		  try {
	        	while(rs.next()) {       		
	        		String name = rs.getString("Name");
	        		String preDepartment = rs.getString("Department");
	        		String post = rs.getString("Post");
	        		sql.departmentInsert(intId, name, preDepartment, newDepartment);
	        		request.setAttribute("Name", name);
	        		request.setAttribute("Post", post);
	        		request.setAttribute("Department", preDepartment);
	        	}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  String sqlSentenceUpdate ="update 员工表 set Department = '"+newDepartment+"' where Id= "+stringId ;


		sql.staffUpdate(sqlSentenceUpdate);
		sql.closeConnection();
	    request.getRequestDispatcher("DepartmentImport.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
