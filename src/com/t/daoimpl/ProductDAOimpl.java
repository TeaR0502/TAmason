package com.t.daoimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.t.bean.Product_Category;
import com.t.bean.Users;
import com.t.dao.Product;
import com.t.jdbc.JdbcUtil;

public class ProductDAOimpl implements Product {

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
	/////////////////////////////// 测试////////////////////////////////
	//////////////////////////////////////////////////////////////////

	@Override
	public List<Product_Category> getCategory(int id) {
		String sql = "SELECT * FROM TPRODUCT_CATEGORY WHERE PARENT_ID = ?";
		List<Product_Category> productList= jdbcTemplate.query(sql,new Object[] {id},
				ParameterizedBeanPropertyRowMapper.newInstance(Product_Category.class));
		return productList;
	}

}
