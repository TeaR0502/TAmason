package com.t.bean;

public class Cart {
	private int id ;
	private int product_id;
	private int quantity;
	private int userid;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int id, int product_id, int quantity, int userid) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.userid = userid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", product_id=" + product_id + ", quantity=" + quantity + ", userid=" + userid + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + product_id;
		result = prime * result + quantity;
		result = prime * result + userid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (id != other.id)
			return false;
		if (product_id != other.product_id)
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	
	
	
}
