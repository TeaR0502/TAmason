package com.t.dao;

import java.util.List;

import com.t.bean.Product_Category;

public interface Product {
	
	/**
	 * 获取所有的根目录
	 * @return
	 */
	List<Product_Category> getCategory(int id);
}
