package com.ehr_.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ehr_.util.User;
import com.ehr_.util.Jdbc;

public class UserDao extends Jdbc{

	 //获取用户列表
	public List<User> getUser() {
		List<User> userList = new ArrayList<User> ();
		User user = new User();
		String sql = "select * from userinfo";
		try {
			ResultSet rs = this.executeQuery(sql, null);
			while(rs.next()) {
				user.setUsername(rs.getString("username"));
				user.setUserpass(rs.getString("userpass"));
//				user.setSex(rs.getString("sex"));
//				user.setRegtime(rs.getString("regtime"));
//				user.setPhone(rs.getString("phone"));
				userList.add(user);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return userList;
	}
	
	//根据用户名获取用户
	public User getUserByName(String name) {
		User user = null;
		String sql = "select * from userinfo where name = ?";
		try {
			ResultSet rs = this.executeQuery(sql, new String[] {name});
			user.setUsername(rs.getString("username"));
			user.setUserpass(rs.getString("userpass"));
			user.setSex(rs.getString("sex"));
			user.setRegtime(rs.getString("regtime"));
			user.setPhone(rs.getString("phone"));
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return user;
	}
	
	//编辑用户
	public boolean editUser(User user) {
		boolean result = false;
		String sql = "update userinfo name = ?, password = ?, sex = ?, birthday = ?, phone = ?";
		try {
			int num = this.executeUpdate(sql, new String[] {user.getUserpass()," "+user.getSex()," "+user.getPhone(), " "+user.getRegtime(), " "+user.getUsername()});
			if(num > 0) {
				result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return result;
	}
	
	//添加用户
    public boolean addUser(User user){
        boolean result = false;
        String sql = "INSERT INTO tb_user(name,password,sex,birthday)VALUES(?,?,?,?) ";
        try{
            int num = this.executeUpdate(sql,new String[]{user.getUsername(),user.getUserpass(),""+user.getSex(),user.getRegtime()});
            if(num > 0){
                result = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.closeAll();
        }
        return result;
    }
    
    //删除指定用户
    public boolean delUser(String name){
        boolean result = false;
        String sql = "DELETE FROM tb_user WHERE name = ?";
        try{
            int num = this.executeUpdate(sql,new String[]{name});
            if(num > 0){
                result = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.closeAll();
        }
        return result;
    }
}


