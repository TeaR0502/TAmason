package com.t.service;

import java.util.Map;

import com.t.bean.Cart;
import com.t.bean.Users;

public interface OrderService {
	
	/**
	 * 完成购买,增加订单,订单详情,同时清空购物车
	 * @param users
	 * @param cartsMap
	 * @return
	 */
	boolean doBuy(Users users,Map<Integer, Cart> cartsMap);
}
