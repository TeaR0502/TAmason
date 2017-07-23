package com.t.service;

import java.util.List;

import com.t.bean.Product;
import com.t.bean.Product_Category;

public interface ProductService {
	
	
	/**
	 * 查找相对应的商品并返回一个Product类对象
	 * @param choice 条件列
	 * @param id 值
	 * @return
	 */
	Product getProduct(String choice, int id);
	
	/**
	 * 通过匹配父类ID或者子类ID来获取一个Product类的数量
	 * @param whatId
	 * @param id
	 * @return
	 */
	int getProductNumber(String whatId, int id);
	
	
	/**
	 * 通过匹配父类ID或者子类ID来获取一个Product类的List集合
	 * @param whatId
	 * @param id
	 * @return
	 */
	List<Product> getProduct(String whatId, int id,int page);

	/**
	 * 获取某一类的分类
	 * @param id
	 * @return
	 */
	List<Product_Category> getCategory(int id);
	
	/**
	 * 根据分类的id获取该分类名字
	 * @param id
	 * @return
	 */
	String  getCategoryName(int id);
	
	
}
