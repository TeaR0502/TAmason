package com.t.dao;

import java.util.List;

import com.t.bean.Product;
import com.t.bean.Product_Category;

public interface ProductDAO {
	
	/**
	 * 获取全部Product类的List集合
	 * @return
	 */
	List<Product> getAllProduct();
	
	/**
	 * 通过匹配子类ID来获取一个Product类的List集合
	 * @param id child_id
	 * @return
	 */
	List<Product> getProductByCID(int id);
	
	/**
	 * 通过匹配父类ID来获取一个Product类的List集合
	 * @param id parent_id
	 * @return
	 */
	List<Product> getProductByPID(int id);
	
	/**
	 * 根据目录的id获取所有的分类
	 * @return
	 */
	List<Product_Category> getCategory(int id);
	
	/**
	 * 根据分类的id获取该分类
	 * @param id
	 * @return
	 */
	Product_Category  getCategoryName(int id);
}
