package com.t.bean;

import java.util.Date;

public class Users {
	private int id ;
	private String username;
	private String password;
	private String sex;
	private Date birthday;
	private String identity_code;
	private String email;
	private String mobile;
	private String address;
	private int status;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int id, String username, String password, String sex, Date birthday, String identity_code,
			String email, String mobile, String address, int status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.identity_code = identity_code;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getIdentity_code() {
		return identity_code;
	}
	public void setIdentity_code(String identity_code) {
		this.identity_code = identity_code;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", birthday="
				+ birthday + ", identity_code=" + identity_code + ", email=" + email + ", mobile=" + mobile
				+ ", address=" + address + ", status=" + status + "]";
	}
	
	
	
}
