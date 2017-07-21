package com.t.serviceimpl;

import java.util.LinkedList;
import java.util.List;

import com.t.bean.Product_Category;
import com.t.daoimpl.ProductDAOimpl;
import com.t.service.ProductService;

public class ProductServiceimpl implements ProductService {
	private static ProductDAOimpl productDAOimpl = null;
	private static ProductServiceimpl productServiceimpl = new ProductServiceimpl();

	private ProductServiceimpl() {
		productDAOimpl = ProductDAOimpl.getNew();
	}

	public static ProductServiceimpl getNew() {
		return productServiceimpl;
	}

	//////////////////////////////////////////////////////////////////
	///////////////////////////////测试////////////////////////////////
	//////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
	
	}

	//////////////////////////////////////////////////////////////////
	///////////////////////////////测试////////////////////////////////
	//////////////////////////////////////////////////////////////////
	
	@Override
	public List<Product_Category> getCategory(int id) {
		List<Product_Category> productList = productDAOimpl.getCategory(id);
		
		return productList;
	}

}
