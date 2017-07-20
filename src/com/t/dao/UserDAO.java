package com.t.dao;

import com.t.bean.Users;

public interface UserDAO {
	/**
	 * 根据用户名查询用户
	 * @param username 用户名
	 * @return 返回查询到的Users类型对象
	 */
	Users queryByName(String username);
}
