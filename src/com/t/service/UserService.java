package com.t.service;

import java.text.ParseException;

public interface UserService {
	
	
	/**
	 * 根据用户名查询ID
	 * @param name
	 * @return
	 */
	int queryUserId(String name);
	
	
	/**
	 * 根据用户名和密码改修用户信息
	 * @param username
	 * @param password
	 * @return 
	 */
	boolean updatePassword(String username, String password);
	
	/**
	 * 根据用户名,身份证,邮箱欧安端用户身份
	 * @param username
	 * @param idcode
	 * @param email
	 * @return
	 */
	boolean retrieveUser(String username,String idcode,String email);
	
	/**
	 * 根据用户名判断用户是否存在
	 * @param name
	 * @return 
	 */
	boolean judgeUsernanme(String name);
	
	/**
	 * 根据用户输入的账号密码进行登录判断
	 * @param username
	 * @param password
	 * @return 反应相应的结果 //0,登陆成功;1,密码错误;2,无此用户或账号异常
	 */
	Integer userLogin(String username,String password); 
	/**
	 * 根据用户注册的信息进行注册
	 * @param name
	 * @param password
	 * @param sex
	 * @param birth
	 * @param idcode
	 * @param email
	 * @param mobile
	 * @param address
	 * @return 返回数据库修改的行数
	 */
	Integer userRegister(String name,String password,String sex,
			String birth,String idcode,String email,String mobile,String address) throws ParseException ;


}
