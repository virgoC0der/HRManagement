package com.ehr_.util;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlOperation {
    private Connection conn;
    
    private Statement stmt;
    
    private ResultSet rs;
    /**
     * 连接数据库
     * @author LinusPeng
     * 2018-07-08 14:17
     * @return conn
     */
    public Connection getConnection()
    {
    	String url = "jdbc:mysql://localhost:3306/EHR?useSSL=false";
    	String username = "root";
    	String password = "19720226csx";
    	//注册数据库驱动
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				//2.ͨ��DriverManger��ȡ���ݿ�����
				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("不能连接数据库");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("不能注册驱动");
		}
    	return conn;
    }
    /**
     * 员工表查询
     * @author LinusPeng
     * 2018-7-9 9:02
     */
    public ResultSet staffSelect(String sql) {
    	String[] resultString= null;
    	int count = 0;
    	//通过Connection对象获取Statement
    	try {
			stmt = this.getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//用Statement执行sql语句

    	try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//3.操作结果集ResultSet
//    	try {
//			while(rs.next()) {
//				ResultArray[count] = ""+rs.getInt("Id");
//				count = count + 1;
//				resultString[count] = rs.getString("Name");
//				count = count + 1;
//				ResultArray[count] = rs.getString("Post");
//				count = count + 1;
//				ResultArray[count] = rs.getString("Department");
//				count = count + 1;
//				ResultArray[count] = rs.getString("Level");
//				count = count + 1;
//				ResultArray[count] = rs.getString("Age");
//				count = count + 1;
//				ResultArray[count] = rs.getString("Language");
//				count = count + 1;
//				ResultArray[count] = rs.getString("Career");
//				count = count + 1;
//				ResultArray[count] = rs.getString("Relationship");
//				count = count + 1;
//				ResultArray[count] = rs.getString("In-data");
//				count = count + 1;
//	            ResultArray[count] = rs.getString("Exit-data");
//	            count = count + 1;
//	            ResultArray[count] = rs.getString("Begin-time");
//	            count = count + 1;
//	            ResultArray[count] = rs.getString("End-time");
//	            count = count + 1;
//
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	return rs;
    }
    
    /**
     * 员工表插入
     */
    public int staffInsert(int id,String name,String post,String department,int level,
    		int age,String language,String career,String relationship,Date in_Date,Date exit_Date,
    		Date Begin_Time,Date End_Time) {
    	int judge = 0;
    	//预处理操作
    	String sql = "insert into 员工表 values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

    		try {
				PreparedStatement pstmt = this.getConnection().prepareStatement(sql);
				pstmt.setInt(1,id );
				pstmt.setString(2, name);
				pstmt.setString(3, post);
				pstmt.setString(4, department);
				pstmt.setInt(5, level);
				pstmt.setInt(6, age);
				pstmt.setString(7, language);
				pstmt.setString(8, career);
				pstmt.setString(9, relationship);
				pstmt.setDate(10, in_Date);
				pstmt.setDate(11, exit_Date);
				pstmt.setDate(12, Begin_Time);
				pstmt.setDate(13, End_Time);
				judge = pstmt.executeUpdate();	
				System.out.println("成功执行了"+judge+"行数据");

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 	
    	return judge;
    }
    
    /**
     * Ա�������
     */
    public int staffUpdate(String sql) {
    	int judge = 0;
    	try {
			stmt = this.getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//String sql = "update 员工表 set Name = '������' where Id = 1607020218";
    	try {
			stmt.execute(sql);
			judge = stmt.getUpdateCount();
			System.out.println("更改了"+judge+"行");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	return judge;
    }
    
    /**
     * Ա����ɾ��
     */
    public int staffDelete() {
    	int judge = 0;
    	try {
			stmt = this.getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String sql = "delete from 员工表 where Id = '1607020220'";
    	try {
			 stmt.execute(sql);
			 judge = stmt.getUpdateCount();
			 System.out.println("�ɹ�ִ����"+judge+"������");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return judge;
    }
    
    
    
    /**
     * ��λ�������ѯ
     */
    public void postSelect() {
    	//1.ͨ��Connection��������ȡStatement����
    	try {
			stmt = this.getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//ʹ��statement����ִ��SQL���
    	String sql = "select * from 岗位调动表";
    	try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//3.���������ResultSet
    	System.out.println("result:");
    	try {
			while(rs.next()) {
				String id = rs.getString("Id");
				String name = rs.getString("Name");
				String ex_Post = rs.getString("Ex-post");
				String new_Post = rs.getString("New-post");
				System.out.println(id+name+ex_Post+new_Post);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    /**
     * ��λ���������
     */
    public int positionInsert(int id,String name,String pre_Post,String new_Post) {
    	//Ԥ����������
    	int judge = 0;
    	String sql = "insert into 岗位调动表 values(?,?,?,?)";
    		try {
				PreparedStatement pstmt = this.getConnection().prepareStatement(sql);
				pstmt.setInt(1,id );
				pstmt.setString(2, name);
				pstmt.setString(3, pre_Post);
				pstmt.setString(4, new_Post);
				judge = pstmt.executeUpdate();	
				System.out.println("�ɹ�ִ����"+judge+"������");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 	
    	return judge;
    }
    
    /**
     * ��λ���������
     */
    public int positionUpdate() {
    	int judge = 0;
    	try {
			stmt = this.getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//1.�������
    	String sql = "update 岗位调动表 set.. where..";
    	try {
			stmt.execute(sql);
			judge = stmt.getUpdateCount();
			System.out.println("�ɹ�ִ����"+judge+"������");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	return judge;
    }
    
    /**
     * ��λ������ɾ��
     */
    public int positionDelete() {
    	int judge = 0;
    	try {
			stmt = this.getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String sql = "delete from 岗位调动表 where ";
    	try {
			 stmt.execute(sql);
			 judge = stmt.getUpdateCount();
			 System.out.println("�ɹ�ִ����"+judge+"������");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return judge;
    }
    
    
    /**
     * ���ŵ������ѯ
     */
    public void departmentSelect() {
    	//1.ͨ��Connection��������ȡStatement����
    	try {
			stmt = this.getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//ʹ��statement����ִ��SQL���
    	String sql = "select * from ���ŵ�����";
    	try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//3.���������ResultSet
    	System.out.println("result");
    	try {
			while(rs.next()) {
				String id = rs.getString("Id");
				String name = rs.getString("Ex-department");
				String ex_Department = rs.getString("Ex-department");
				String new_Department = rs.getString("New-department");
				System.out.println(id+name+ex_Department+new_Department);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
    /**
     * ���ŵ��������
     */
    public int departmentInsert(int id,String name,String pre_Department,String new_Department) {
    	//Ԥ����������
    	int judge = 0;
    	String sql = "insert into 部门调动表 values(?,?,?,?)";
    		try {
				PreparedStatement pstmt = this.getConnection().prepareStatement(sql);
				pstmt.setInt(1,id );
				pstmt.setString(2, name);
				pstmt.setString(3, pre_Department);
				pstmt.setString(4, new_Department);
				judge = pstmt.executeUpdate();	
				System.out.println("更新了"+judge+"行");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 	
    	return judge;
    }
    
    /**
     * ���ŵ��������
     */
    public int departmentUpdate() {
    	int judge = 0;
    	try {
			stmt = this.getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//1.�������
    	String sql = "update ���ŵ����� set.. where..";
    	try {
			stmt.execute(sql);
			judge = stmt.getUpdateCount();
			System.out.println("�ɹ�ִ����"+judge+"������");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	return judge;
    }
    
    /**
     * ���ŵ�����ɾ��
     */
    public int departmentDelete() {
    	int judge = 0;
    	try {
			stmt = this.getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String sql = "delete from ���ŵ����� where ";
    	try {
			 stmt.execute(sql);
			 judge = stmt.getUpdateCount();
			 System.out.println("�ɹ�ִ����"+judge+"������");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return judge;
    }
    
    
    
    /**
     * ���ݿ�ر�����
     */
    
    public void closeConnection() {
    	if(rs!=null) {
    		try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    		if(stmt!=null) {
        		try {
    				stmt.close();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
    	if(conn!=null) {
    		try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
}