package com.t.daoimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	
	public static void main(String[] args) throws ParseException {
		Users users = UserDAOimpl.getNew().queryByName("admin");
		System.out.println("试试看"+users);
		
		
		String bir = "1994-05-02";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date b =  simpleDateFormat.parse(bir);
		users.setBirthday(b);
		int rows = UserDAOimpl.getNew().addUser(users);
		System.out.println(rows);
		
		
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

	@Override
	public int addUser(Users users) {
		String sql = "insert into tuser values(SEQ_USER_ID.nextval,?,?,?,to_date(?,'yyyy-MM-dd'),?,?,?,?,1)";
		//ID,USERNAME,PASSWORD,SEX,BIRTHDAY,IDCODE,EMAIL,MOBILE,ADDRESS,STATUS
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String bString = simpleDateFormat.format(users.getBirthday());
		int rows = jdbcTemplate.update(sql,users.getUsername(),users.getPassword(),users.getSex(),bString
				,users.getIdentity_code(),users.getEmail(),users.getMobile(),users.getAddress());
		return rows;
	}

	@Override
	public int updatePassword(String username, String password) {
		String sql = "UPDATE tuser SET password = ? WHERE username = ?";
		return jdbcTemplate.update(sql,password,username);
	}

	@Override
	public Users queryUserByEmail(String email) {
		String sql = "SELECT * FROM tuser WHERE EMAIL = ?";
		List<Users> list = jdbcTemplate.query(sql,new Object[] {email} ,
				ParameterizedBeanPropertyRowMapper.newInstance(Users.class));
		Users users = null;
		if (list != null && list.size() > 0) {
			users = list.get(0);
		} 
		
		return users;
	}

}
