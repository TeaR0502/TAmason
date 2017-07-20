package com.t.service;

public interface UserService {
	/**
	 * 根据用户输入的账号密码进行登录判断
	 * @param username
	 * @param password
	 * @return 反应相应的结果 //0,登陆成功;1,密码错误;2,无此用户或账号异常
	 */
	Integer userLogin(String username,String password); 
}
