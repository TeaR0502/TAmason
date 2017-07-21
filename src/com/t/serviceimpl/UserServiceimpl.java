package com.t.serviceimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.catalina.User;

import com.t.bean.Users;
import com.t.daoimpl.UserDAOimpl;
import com.t.service.UserService;

public class UserServiceimpl implements UserService {

	private static UserDAOimpl userDAOimpl = null;
	private static UserServiceimpl userServiceimpl = new UserServiceimpl();

	private UserServiceimpl() {
		userDAOimpl = UserDAOimpl.getNew();
	}

	public static UserServiceimpl getNew() {
		return userServiceimpl;
	}

	//////////////////////////////////////////////////////////////////
	///////////////////////////////测试////////////////////////////////
	//////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		Users users = UserDAOimpl.getNew().queryByName("admin");
		System.out.println("试试看" + users);
	}

	//////////////////////////////////////////////////////////////////
	///////////////////////////////测试////////////////////////////////
	//////////////////////////////////////////////////////////////////

	@Override
	public Integer userLogin(String username, String password) {
		Users users = UserDAOimpl.getNew().queryByName(username);
		Integer status = -1;
		if (users == null) {
			status = 2;
		} else if (users.getPassword().equals(password)){
			status = 0;
		} else {
			status = 1;
		}
		return status;
	}

	@Override
	public Integer userRegister(String name, String password, String sex, String birth, 
			String idcode, String email,String mobile, String address) throws ParseException {
		Users users = new Users();
		users.setUsername(name);
		users.setPassword(password);
		users.setSex(sex);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date b =  simpleDateFormat.parse(birth);
		users.setBirthday(b);
		users.setIdentity_code(idcode);
		users.setEmail(email);
		users.setMobile(mobile);
		users.setAddress(address);
		System.out.println("获取用户注册数据"+users);
		Integer rows = UserDAOimpl.getNew().addUser(users);
		return rows;
	}

	@Override
	public boolean judgeUsernanme(String name) {
		Users users = UserDAOimpl.getNew().queryByName(name);
		
		return users == null ? true:false;
	}

}
