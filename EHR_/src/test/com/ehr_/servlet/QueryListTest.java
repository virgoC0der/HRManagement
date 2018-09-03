package test.com.ehr_.servlet; 

import com.ehr_.servlet.AddStaffServlet;
import com.ehr_.util.SqlOperation;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
* QueryList Tester. 
* 
* @author <Authors name> 
* @since <pre>七月 17, 2018</pre> 
* @version 1.0 
*/ 
public class QueryListTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: doGet(HttpServletRequest request, HttpServletResponse response) 
* 
*/ 
@Test
public void testDoGet() throws Exception { 
//TODO: Test goes here...
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
    Date date  =  new Date();
    String time = df.format(date);
    String currentYear = time.substring(0,4);
    String currentMonth = time.substring(5,7);
    String currentDay = time.substring(8,10);
    java.sql.Date sqlTime = null;


    SqlOperation sql = new SqlOperation();
    sql.getConnection();
    ResultSet rs = null;

    //ת������
    AddStaffServlet add = new AddStaffServlet();
    sqlTime = add.switchDate(currentYear, currentMonth, "00");
    String sqlTimeString1 = sqlTime.toString();
    sqlTime = add.switchDate(currentYear, currentMonth, "31");
    String sqlTimeString2 = sqlTime.toString();

    //��ְ����
    StringBuffer buff = new StringBuffer();
//    rs = sql.staffSelect("select * from 员工表 where `In-data` > '"+sqlTimeString1+"' and `In-data` < '"+sqlTimeString2+"'");
    rs = sql.staffSelect("select * from 员工表 where `In-data` > '2018-6-30' and `In-data` < '2018-7-31'");
    System.out.println(rs);
    try {
//        int aaa = rs.getInt(1);
        while(rs.next())
        {

            buff.append("Id:");
            int intId = rs.getInt(1);
            String stringId = String.valueOf(intId);
            buff.append(stringId);
            buff.append("Name:");
            buff.append(rs.getString(2));
            buff.append("   ");
            System.out.println(buff);
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    String EmployNum = buff.toString();
    System.out.println(EmployNum);
    sql.closeConnection();
} 

/** 
* 
* Method: doPost(HttpServletRequest request, HttpServletResponse response) 
* 
*/ 
@Test
public void testDoPost() throws Exception { 
//TODO: Test goes here... 
} 


} 
