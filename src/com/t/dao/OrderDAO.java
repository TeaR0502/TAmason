package com.t.dao;

import com.t.bean.Order;
import com.t.bean.Order_Detail;

public interface OrderDAO {
	
	/**
	 * 插入一条订单详情
	 * @param order_Detail
	 * @return
	 */
	int addOrderDetail(Order_Detail order_Detail);
	
	/**
	 * 插入一条订单记录
	 * @param order
	 * @return 
	 */
	int addOrder(Order order);
	/**
	 * 获取当前SQE序列
	 * @return
	 */
	int getSqe();
}
