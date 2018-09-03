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
 * Servlet implementation class PostImportSubmit
 */
//@WebServlet("/PostImportSubmit")
public class PostImportSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostImportSubmit() {
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
		String newPost = request.getParameter("Post");
		System.out.println(newPost);
		String newDepartment = request.getParameter("Department");
		SqlOperation sql = new SqlOperation();
		sql.getConnection();
		String stringId = String.valueOf(intId);
		String sqlSentenceSelect = "select * from 员工表 where Id = ?";
		//ResultSet rs = sql.staffSelect(sqlSentenceSelect);
		List<Object> params = new ArrayList<>();
		params.add(intId);

		BaseDao baseDao = new BaseDao();
		ResultSet rs = baseDao.executeQuery(sqlSentenceSelect, params);
		System.out.println(rs);
		  try {
	        	while(rs.next()) {       		
	        		String name = rs.getString("Name");
	        		String prePost = rs.getString("Post");
	        		String preDepartment = rs.getString("Department");
	        		sql.departmentInsert(intId, name, prePost, newPost);
	        		sql.departmentInsert(intId, name, preDepartment, newDepartment);
	        	}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  String sqlSentenceUpdatePost ="update 员工表 set Post = '"+newPost+"'"+" where Id="+stringId ;
		sql.staffUpdate(sqlSentenceUpdatePost);
		String sqlSentenceUpdateDepart ="update 员工表 set Department = '"+newDepartment+"'"+" where Id="+stringId ;
		sql.staffUpdate(sqlSentenceUpdateDepart);
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
