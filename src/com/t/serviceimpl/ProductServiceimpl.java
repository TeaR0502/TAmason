package com.t.serviceimpl;

import java.util.LinkedList;
import java.util.List;

import com.t.bean.Product;
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
	/////////////////////////////// 测试////////////////////////////////
	//////////////////////////////////////////////////////////////////

	public static void main(String[] args) {

	}

	//////////////////////////////////////////////////////////////////
	/////////////////////////////// 测试////////////////////////////////
	//////////////////////////////////////////////////////////////////

	@Override
	public List<Product_Category> getCategory(int id) {
		List<Product_Category> productList = productDAOimpl.getCategory(id);

		return productList;
	}

	@Override
	public List<Product> getProduct(String whatId, int id,int page) {
		List<Product> productslist = null;
		switch (whatId) {
		case "parentId":
			productslist = productDAOimpl.getProductByPID(id,page);
			break;
		case "childId":
			productslist = productDAOimpl.getProductByCID(id,page);
			break;
		case "all":
			productslist = productDAOimpl.getAllProduct(page);
			break;

		default:
			break;
		}
		return productslist;
	}

	@Override
	public String getCategoryName(int id) {
		
		return  productDAOimpl.getCategoryName(id).getName();
	}

	@Override
	public int getProductNumber(String whatId, int id) {
		int count = 0;
		switch (whatId) {
		case "parentId":
			count = productDAOimpl.getProductNumberByParentId(id);
			break;
		case "childId":
			count = productDAOimpl.getProductNumberByChildId(id);
			break;
		case "all":
			count = productDAOimpl.getAllProductNumber();
			break;

		default:
			break;
		}
		return count;
	}

	@Override
	public Product getProduct(String choice, int id) {
		Product product = null;
		switch (choice) {
		case "id":
			product = productDAOimpl.getProductById(id);
			break;


		default:
			break;
		}
		return product;
	}

}
