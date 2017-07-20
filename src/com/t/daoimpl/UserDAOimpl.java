package com.t.daoimpl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.t.bean.Users;
import com.t.dao.UserDAO;
import com.t.jdbc.JdbcUtil;

public class UserDAOimpl implements UserDAO {
	
	private static JdbcTemplate jdbcTemplate= null;
	private static UserDAOimpl userDAOimpl = new UserDAOimpl();
	
	private UserDAOimpl() {
		jdbcTemplate = JdbcUtil.getJdbcTemplate();
	}
	
	public static UserDAOimpl getNew() {
		return userDAOimpl;
	}

	
	//////////////////////////////////////////////////////////////////
	///////////////////////////////测试////////////////////////////////	
	//////////////////////////////////////////////////////////////////	
	
	
	public static void main(String[] args) {
		Users users = UserDAOimpl.getNew().queryByName("admin");
		System.out.println("试试看"+users);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//////////////////////////////////////////////////////////////////
	///////////////////////////////测试////////////////////////////////	
	//////////////////////////////////////////////////////////////////
	
	@Override
	public Users queryByName(String username) {
		String sql = "SELECT * FROM tuser WHERE username = ?";
		Users user = null;
		List<Users> userlist= jdbcTemplate.query(sql,new Object[] {username},ParameterizedBeanPropertyRowMapper.newInstance(Users.class));
		if (userlist != null && userlist.size() > 0) {
			 user= userlist.get(0);
		}
		return user;
	}

}
