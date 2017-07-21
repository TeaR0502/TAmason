package com.t.dao;

import com.t.bean.Users;

public interface UserDAO {
	
	/**
	 * 根据用户名修改用户密码
	 * @param username
	 * @param password
	 * @return
	 */
	int updatePassword(String username,String password);
	/**
	 * 根据用户名查询用户
	 * @param username 用户名
	 * @return 返回查询到的Users类型对象
	 */
	Users queryByName(String username);
	
	/**
	 * 新增用户资料
	 * @param users 需要添加的Users类型的对象
	 * @return 数据库修改的行数
	 */
	int addUser(Users users);
}
