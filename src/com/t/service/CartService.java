package com.t.service;

import java.util.Map;

import com.t.bean.Cart;

public interface CartService {
	
	
	/**
	 * 删除购物车信息
	 * @param productId
	 * @return
	 */
	boolean deleteCart(int productId);
	/**
	 * 更新购物车信息
	 * @param cart
	 * @return
	 */
	boolean updateCart(Cart cart);
	/**
	 * 增加一条购物车记录,并返回是否成功
	 * @param cart
	 * @return
	 */
	boolean addCart(Cart cart);
	/**
	 * 获取该用户所有的购物车
	 * @return
	 */
	Map<Integer, Cart> getAllCart(int userId);
}
