package com.t.bean;

public class Product {
	private int id;
	private String name;
	private String description;
	private double price;
	private int stock;
	private int parent_id;
	private int child_id;
	private String pictureFile_name;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public int getChild_id() {
		return child_id;
	}
	public void setChild_id(int child_id) {
		this.child_id = child_id;
	}
	public String getPictureFile_name() {
		return pictureFile_name;
	}
	public void setPictureFile_name(String pictureFile_name) {
		this.pictureFile_name = pictureFile_name;
	}
	public Product(int id, String name, String description, double price, int stock, int parent_id, int child_id,
			String pictureFile_name) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.parent_id = parent_id;
		this.child_id = child_id;
		this.pictureFile_name = pictureFile_name;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", stock="
				+ stock + ", parent_id=" + parent_id + ", child_id=" + child_id + ", pictureFile_name="
				+ pictureFile_name + "]";
	}

	
	
	
}
