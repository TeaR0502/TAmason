package com.t.bean;

import java.util.Date;

public class Order {
	private int id;
	private int user_id;
	private String user_name;
	private String user_address;
	private Date create_time;
	private double cost;
	private int status;
	private int order_type;
	public Order(int id, int user_id, String user_name, String user_address, Date create_time, double cost, int status,
			int order_type) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_address = user_address;
		this.create_time = create_time;
		this.cost = cost;
		this.status = status;
		this.order_type = order_type;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getOrder_type() {
		return order_type;
	}
	public void setOrder_type(int order_type) {
		this.order_type = order_type;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", user_id=" + user_id + ", user_name=" + user_name + ", user_address="
				+ user_address + ", create_time=" + create_time + ", cost=" + cost + ", status=" + status
				+ ", order_type=" + order_type + "]";
	}

	

}
