package com.ehr_.servlet;

import com.ehr_.util.SqlOperation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class AddStaffServlet
 */
//@WebServlet("/AddStaffServlet")
public class AddStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  //�������ݿ�
		  SqlOperation sql = new SqlOperation();
		  sql.getConnection();
		  
		
		  //���÷��ͽ������ݸ�ʽ
		  request.setCharacterEncoding("utf-8"); //1
		  response.setContentType("text/html;charset=utf-8"); //2
		  response.setCharacterEncoding("utf-8"); //3
		  
		  
          //��ҳ���������
		  int idInt = Integer.parseInt(request.getParameter("Id"));
	      String name = request.getParameter("Name");
	      int age = Integer.parseInt(request.getParameter("Age"));
	      String department = request.getParameter("Department");
	      String post = request.getParameter("Post");
	      int level = Integer.parseInt(request.getParameter("Level"));
	      String[] languageArray = request.getParameterValues("Language");

	      StringBuffer stringBuff = new StringBuffer();
	      for(int i = 0;i<languageArray.length;i++)
	      {
	    	  if(i != languageArray.length - 1)
	    	  {
	    		  stringBuff.append(languageArray[i]);
	    		  stringBuff.append(',');
	    	  }
	    	  else
	    	  {
	    		  stringBuff.append(languageArray[i]);
	    	  }
	      }
	      String language = stringBuff.toString();
	      String career = request.getParameter("Career");
	      String relationship = request.getParameter("Relationship");
	      String in_Time_Year = request.getParameter("In-time-year");
	      String in_Time_Month = request.getParameter("In-time-month");
	      String in_Time_Day = request.getParameter("In-time-day");
	      String begin_Time_Year = request.getParameter("Begin-time-year");
	      String begin_Time_Month = request.getParameter("Begin-time-month");
	      String begin_Time_Day = request.getParameter("Begin-time-day");
	      String end_Time_Year = request.getParameter("End-time-year");
	      String end_Time_Month = request.getParameter("End-time-month");
	      String end_Time_Day = request.getParameter("End-time-day");
	      String exit_Time_Year = request.getParameter("Exit-time-year");
	      String exit_Time_Month = request.getParameter("Exit-time-month");
	      String exit_Time_Day = request.getParameter("Exit-time-year");
	      
	      
	      //������ʱ��ת��Ϊsql.Date���Ͳ��������ݿ�
	      Date begin_Time = null;
	      Date end_Time = null;
	      Date exit_Time = null;
	      Date in_Time = switchDate(in_Time_Year,in_Time_Month,in_Time_Day);
	      if(!begin_Time_Year.equals("null")) {
	    	  begin_Time = switchDate(begin_Time_Year,begin_Time_Month,begin_Time_Day);
	      }
	      if(!end_Time_Year.equals("null")) {
	    	  end_Time = switchDate(end_Time_Year,end_Time_Month,end_Time_Day);
	      }
	      if(!exit_Time_Year.equals("null")) {
	    	  exit_Time = switchDate(exit_Time_Year,exit_Time_Month,exit_Time_Day);
	      }
	      sql.staffInsert(idInt, name, post, department, level, age, language, career, relationship, in_Time, exit_Time, begin_Time, end_Time);


	      //�ر����ݿ�����
	      sql.closeConnection();
		request.getRequestDispatcher("AddStaff.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	//��java�е�DATE����ת��ΪSQL��DATE����
	public Date switchDate(String year,String month,String day){
        StringBuffer begin_Time = new StringBuffer();
        begin_Time.append(year);
        begin_Time.append('-');
        begin_Time.append(month);
        begin_Time.append('-');
        begin_Time.append(day);
        String begin_Time_S = begin_Time.toString();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date  begin_Time_D1 = null;
        try {
			begin_Time_D1 = format.parse(begin_Time_S);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Date begin_Time_D = new Date(begin_Time_D1.getTime());
        return begin_Time_D;
	}

}
