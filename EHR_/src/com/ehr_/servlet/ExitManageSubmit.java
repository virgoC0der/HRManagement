package com.ehr_.servlet;

import com.ehr_.dao.BaseDao;
import com.ehr_.util.SqlOperation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Servlet implementation class ExitManageSubmit
 */
//@WebServlet("/ExitManageSubmit")
public class ExitManageSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExitManageSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("Id");
		int id_int = Integer.parseInt(id);
		String year = request.getParameter("Year");
		String month = request.getParameter("Month");
		String day = request.getParameter("Day");
		Date date = null;
		AddStaffServlet a = new AddStaffServlet();
		date = a.switchDate(year, month, day);
		SqlOperation sql = new SqlOperation();
		sql.getConnection();
		String sqlSentenceUpdatePost ="update 员工表 set `Exit-data` = "+"'"+date.toString()+"'"+" where Id= "+id_int ;
		sql.staffUpdate(sqlSentenceUpdatePost);

		sql.closeConnection();
		request.getRequestDispatcher("fireSomeone.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
