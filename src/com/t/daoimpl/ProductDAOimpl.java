package com.t.daoimpl;

import java.text.ParseException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.t.bean.Product;
import com.t.bean.Product_Category;
import com.t.jdbc.JdbcUtil;

public class ProductDAOimpl implements com.t.dao.ProductDAO {

	private static JdbcTemplate jdbcTemplate = null;
	private static ProductDAOimpl productDAOimpl = new ProductDAOimpl();

	private ProductDAOimpl() {
		jdbcTemplate = JdbcUtil.getJdbcTemplate();
	}

	public static ProductDAOimpl getNew() {
		return productDAOimpl;
	}

	//////////////////////////////////////////////////////////////////
	/////////////////////////////// 测试////////////////////////////////
	//////////////////////////////////////////////////////////////////

	public static void main(String[] args) throws ParseException {
		List<Product_Category> productList = ProductDAOimpl.getNew().getCategory(0);
		for (Product_Category string : productList) {
			System.out.println(string.getName());
		}

	}

	//////////////////////////////////////////////////////////////////
	///////////////////////////////测试////////////////////////////////
	//////////////////////////////////////////////////////////////////

	@Override
	public List<Product_Category> getCategory(int id) {
		String sql = "SELECT * FROM TPRODUCT_CATEGORY WHERE PARENT_ID = ?";
		List<Product_Category> productList= jdbcTemplate.query(sql,new Object[] {id},
				ParameterizedBeanPropertyRowMapper.newInstance(Product_Category.class));
		return productList;
	}


	@Override
	public List<Product> getProductByCID(int id) {
		String sql = "SELECT * FROM TPRODUCT WHERE CHILD_ID = ?";
		List<Product> productList= jdbcTemplate.query(sql,new Object[] {id},
				ParameterizedBeanPropertyRowMapper.newInstance(Product.class));
		return productList;
	}

	@Override
	public List<Product> getProductByPID(int id) {
		String sql = "SELECT * FROM TPRODUCT WHERE PARENT_ID = ?";
		List<Product> productList= jdbcTemplate.query(sql,new Object[] {id},
				ParameterizedBeanPropertyRowMapper.newInstance(Product.class));
		return productList;
	}

	@Override
	public List<Product> getAllProduct() {
		String sql = "SELECT * FROM TPRODUCT ";
		List<Product> productList= jdbcTemplate.query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Product.class));
		return productList;
	}

}
