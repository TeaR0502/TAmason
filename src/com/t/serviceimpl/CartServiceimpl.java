package com.t.serviceimpl;

import java.util.Map;

import com.t.bean.Cart;
import com.t.daoimpl.CartDAOimpl;
import com.t.daoimpl.ProductDAOimpl;
import com.t.service.CartService;

import oracle.net.aso.f;

public class CartServiceimpl implements CartService {

	
	private static CartDAOimpl cartDAOimpl = null;
	private static CartServiceimpl cartServiceimpl = new CartServiceimpl();

	private CartServiceimpl() {
		cartDAOimpl = CartDAOimpl.getNew();
	}

	public static CartServiceimpl getNew() {
		return cartServiceimpl;
	}

	//////////////////////////////////////////////////////////////////
	/////////////////////////////// 测试////////////////////////////////
	//////////////////////////////////////////////////////////////////

	public static void main(String[] args) {

	}

	//////////////////////////////////////////////////////////////////
	/////////////////////////////// 测试///////////////////////////////
	//////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	@Override
	public Map<Integer, Cart> getAllCart(int userId) {
		return cartDAOimpl.getAllCart(userId);
	}

	@Override
	public boolean addCart(Cart cart) {
		return cartDAOimpl.addCart(cart) == 1 ? true : false;
	}

	@Override
	public boolean updateCart(Cart cart) {
		//System.out.println("更新数量为:"+cart.getQuantity());
		return cartDAOimpl.updateCart(cart.getProduct_id(), cart.getQuantity(),cart.getUserid()) == 1 ? true : false;
	}

	@Override
	public boolean deleteCart(int productId,int userId) {
		return cartDAOimpl.deleteCart(productId,userId) == 1?true:false;
	}

}
