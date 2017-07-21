package com.t.service;

import java.util.List;

import com.t.bean.Product;
import com.t.bean.Product_Category;

public interface ProductService {
	
	
	/**
	 * 通过匹配父类ID或者子类ID来获取一个Product类的List集合
	 * @param whatId
	 * @param id
	 * @return
	 */
	List<Product> getProduct(String whatId, int id);

	/**
	 * 获取某一类的分类名
	 * @param id
	 * @return
	 */
	List<Product_Category> getCategory(int id);
	
	
}
