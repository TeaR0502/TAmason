package com.t.dao;

import java.util.Map;

import com.t.bean.Cart;

public interface CartDAO {
	
	/**
	 * 根据用户ID清空用户的购物车数据
	 * @param userId
	 * @return
	 */
	int clearUserCart(int userId);
	/**
	 * 根据商品ID删除购物车信息
	 * @param productId
	 * @return
	 */
	int deleteCart(int productId,int userId);
	/**
	 * 根据商品ID更新购物车信息
	 * @param productId 商品编号
	 * @param  stock 数量
	 * @return
	 */
	int updateCart(int productId,int stock , int userId);
	
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
