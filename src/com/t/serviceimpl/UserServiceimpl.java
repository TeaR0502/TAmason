package com.t.serviceimpl;

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

}
