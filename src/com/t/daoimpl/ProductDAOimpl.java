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
		//List<Product> productList = ProductDAOimpl.getNew().getAllProduct(1);
		//System.out.println(ProductDAOimpl.getNew().getProductNumberByChildId(1));
		System.out.println(ProductDAOimpl.getNew().getProductById(1));

	}

	//////////////////////////////////////////////////////////////////
	/////////////////////////////// 测试////////////////////////////////
	//////////////////////////////////////////////////////////////////

	@Override
	public List<Product_Category> getCategory(int id) {
		final String sql = "SELECT * FROM TPRODUCT_CATEGORY WHERE PARENT_ID = ?";
		List<Product_Category> productList = jdbcTemplate.query(sql, new Object[] { id },
				ParameterizedBeanPropertyRowMapper.newInstance(Product_Category.class));
		return productList;
	}

	@Override
	public List<Product> getProductByCID(int id, int page) {
		final String sql = "SELECT * FROM ( SELECT t.*, ROWNUM RN FROM (SELECT * FROM TPRODUCT WHERE CHILD_ID = ?) t WHERE ROWNUM <=?) WHERE RN >=?";
		List<Product> productList = jdbcTemplate.query(sql, new Object[] { id, (page * 12) ,((page - 1) * 12 + 1)},
				ParameterizedBeanPropertyRowMapper.newInstance(Product.class));
		return productList;
	}

	@Override
	public List<Product> getProductByPID(int id, int page) {
		final String sql = "SELECT * FROM ( SELECT t.*, ROWNUM RN FROM (SELECT * FROM TPRODUCT WHERE PARENT_ID = ?) t WHERE ROWNUM <=?) WHERE RN >=?";
		List<Product> productList = jdbcTemplate.query(sql, new Object[] { id,  (page * 12) ,((page - 1) * 12 + 1)},
				ParameterizedBeanPropertyRowMapper.newInstance(Product.class));
		return productList;
	}

	@Override
	public List<Product> getAllProduct(int page) {
		
		final  String sql = "SELECT * FROM "
		 		+ "( SELECT A.*, ROWNUM RN  FROM (SELECT * FROM TPRODUCT) A "
		 		+ "WHERE ROWNUM <= ?  "
		 		+ ") "
		 		+ "WHERE RN >= ? ";
		/*
		 * "SELECT * FROM ( SELECT t.*, ROWNUM RN FROM (SELECT * FROM TPRODUCT WHERE PARENT_ID = ?) t WHERE ROWNUM <=?) WHERE RN >=?"
		 * ;
		 * 
		 */
		List<Product> productList = jdbcTemplate.query(sql, new Object[] { (page * 12) ,((page - 1) * 12 + 1)},
				ParameterizedBeanPropertyRowMapper.newInstance(Product.class));
		return productList;
	}

	@Override
	public Product_Category getCategoryName(int id) {
		final String sql = "SELECT * FROM TPRODUCT_CATEGORY WHERE ID = ?";
		List<Product_Category> productList = jdbcTemplate.query(sql, new Object[] { id },
				ParameterizedBeanPropertyRowMapper.newInstance(Product_Category.class));

		return productList.get(0);
	}

	@Override
	public int getAllProductNumber() {
		final String sql = "SELECT COUNT(*) FROM TPRODUCT";
		int count= jdbcTemplate.queryForInt(sql);
		return count;
	}

	@Override
	public int getProductNumberByParentId(int id) {
		final String sql = "SELECT COUNT(*) FROM TPRODUCT WHERE parent_id = ?";
		int count= jdbcTemplate.queryForInt(sql,new Object[] {id});
		return count;
	}

	@Override
	public int getProductNumberByChildId(int id) {
		final String sql = "SELECT COUNT(*) FROM TPRODUCT WHERE child_id = ?";
		int count= jdbcTemplate.queryForInt(sql,new Object[] {id});
		return count;
	}

	@Override
	public Product getProductById(int id) {
		final String sql = "SELECT * FROM TPRODUCT WHERE id = ?";
		Product product = null;
		product = jdbcTemplate.queryForObject(sql,new Object[] {id},
				ParameterizedBeanPropertyRowMapper.newInstance(Product.class));
		return product;
	}

}
