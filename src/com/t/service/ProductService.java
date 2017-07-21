package com.t.service;

import java.util.List;

import com.t.bean.Product_Category;

public interface ProductService {

	/**
	 * 获取某一类的分类名
	 * @param id
	 * @return
	 */
	List<Product_Category> getCategory(int id);
	
	
}
