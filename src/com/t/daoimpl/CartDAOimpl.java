package com.t.daoimpl;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.t.bean.Cart;
import com.t.bean.Product_Category;
import com.t.dao.CartDAO;
import com.t.jdbc.JdbcUtil;

public class CartDAOimpl implements CartDAO{


	private static JdbcTemplate jdbcTemplate = null;
	private static CartDAOimpl cartDAOimpl = new CartDAOimpl();

	private CartDAOimpl() {
		jdbcTemplate = JdbcUtil.getJdbcTemplate();
	}

	public static CartDAOimpl getNew() {
		return cartDAOimpl;
	}

	//////////////////////////////////////////////////////////////////
	/////////////////////////////// 测试////////////////////////////////
	//////////////////////////////////////////////////////////////////

	public static void main(String[] args) throws ParseException {
		

	}

	//////////////////////////////////////////////////////////////////
	/////////////////////////////// 测试////////////////////////////////
	//////////////////////////////////////////////////////////////////
	
	
	

	
	
	
	
	
	@Override
	public Map<Integer, Cart> getAllCart(int userId) {
		Map<Integer, Cart> cartMap = new HashMap<>();
		String sql = "SELECT * FROM CART WHERE USERID = ?";
		List< Cart> cartList = jdbcTemplate.query(sql, new Object[] { userId },
				ParameterizedBeanPropertyRowMapper.newInstance(Cart.class));
		if (cartList != null && cartList.size() > 0) {
			for (Cart cart : cartList) {
				cartMap.put(cart.getProduct_id(), cart);
			}
		}
		return cartMap;
	}

	@Override
	public int addCart(Cart cart) {
		String sql = "insert into CART values (SEQ_CART_ID.nextval,?,?,?)";
		return jdbcTemplate.update(sql,cart.getProduct_id(),cart.getQuantity(),cart.getUserid());
	}

	@Override
	public int updateCart(int productId, int stock) {
		String sql = "UPDATE CART SET QUANTITY = ? WHERE PRODUCT_ID = ?";
		return jdbcTemplate.update(sql,stock,productId);
	}

	@Override
	public int deleteCart(int productId) {
		//  DELETE FROM 表名称 WHERE 列名称 = 值 
		String sql = "DELETE FROM CART WHERE PRODUCT_ID = ?";
		return jdbcTemplate.update(sql,productId);
	}

}
