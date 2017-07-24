package com.t.dao;

import java.util.Map;

import com.t.bean.Cart;

public interface CartDAO {
	/**
	 * 根据商品ID删除购物车信息
	 * @param productId
	 * @return
	 */
	int deleteCart(int productId);
	/**
	 * 根据商品ID更新购物车信息
	 * @param productId 商品编号
	 * @param  stock 数量
	 * @return
	 */
	int updateCart(int productId,int stock);
	
	/**
	 * 添加购物车信息
	 * @param cartMap
	 * @return
	 */
	int addCart(Cart cart);
	
	/**
	 * 获取该用户所有的购物车
	 * @return
	 */
	Map<Integer, Cart> getAllCart(int userId);
}
