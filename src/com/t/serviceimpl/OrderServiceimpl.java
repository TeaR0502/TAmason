package com.t.serviceimpl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.t.bean.Cart;
import com.t.bean.Order;
import com.t.bean.Order_Detail;
import com.t.bean.Product;
import com.t.bean.Users;
import com.t.daoimpl.CartDAOimpl;
import com.t.daoimpl.OrderDAOimpl;
import com.t.jdbc.JdbcUtil;
import com.t.service.OrderService;

public class OrderServiceimpl implements OrderService {

	//事务控制,事务状态标识符
	TransactionTemplate transactionTemplate  = JdbcUtil.getTransactionTemplate();
	private static boolean status = true;
	
	private static OrderDAOimpl orderDAOimpl = null;
	private static OrderServiceimpl orderServiceimpl = new OrderServiceimpl();

	private OrderServiceimpl() {
		orderDAOimpl = OrderDAOimpl.getNew();
	}

	public static OrderServiceimpl getNew() {
		return orderServiceimpl;
	}

	//////////////////////////////////////////////////////////////////
	///////////////////////////////测试////////////////////////////////
	//////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		
	}

	//////////////////////////////////////////////////////////////////
	///////////////////////////////测试////////////////////////////////
	//////////////////////////////////////////////////////////////////
	
	
	
	@Override
	public boolean doBuy(Users users, Map<Integer, Cart> cartsMap) {
		//开始事务控制
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				try {
					
					//生成本订单对象
					Order order = new Order();
					//获取所有的orderdetail
					List<Order_Detail> detialsList = new LinkedList<>();
					//获取map集合中的所有键的Set集合  
			        Set<Integer> keySet = cartsMap.keySet();  
			        //有了Set集合就可以获取其迭代器，取值  
			        Iterator<Integer> it = keySet.iterator();  
			        while (it.hasNext())  
			        {  
			            Integer i = it.next(); 
			            Cart cart = cartsMap.get(i); 
			            int productId = cart.getProduct_id();
			            int productQuantity = cart.getQuantity();
			            Product product = ProductServiceimpl.getNew().getProduct("id", productId);
			            double cost = product.getPrice()*productQuantity;
			            //对应购物车生成订单详情对象
			            Order_Detail order_Detail = new 
			            		Order_Detail(0, 0,productId , productQuantity, cost);
			            detialsList.add(order_Detail);
			        } 
			        
			        //获取到总金额
			        double finalCost = 0;
			        for (Order_Detail order_Detail : detialsList) {
			        	 finalCost += order_Detail.getCost();
					}
					//设置本订单并提交本订单
			        int orderId = OrderDAOimpl.getNew().getSqe();
			        order.setId(orderId);
			        order.setUser_id(users.getId());
			        order.setUser_name(users.getUsername());
			        order.setUser_address(users.getAddress());
			        order.setCreate_time(null);//提交时会自动获取当前时间
			        order.setCost(finalCost);
			        if (OrderDAOimpl.getNew().addOrder(order)== 0) {
			        	throw new Exception("订单提交失败!");
			        }
			        //提交所有订单详情
			        for (Order_Detail order_Detail : detialsList) {
						order_Detail.setOrder_id(orderId);
						if (OrderDAOimpl.getNew().addOrderDetail(order_Detail) == 0) {
				        	throw new Exception("订单详情提交失败!");
				        }
					}
			        
					//清空该用户的购物车
			        if (CartDAOimpl.getNew().clearUserCart(users.getId())== 0) {
			        	throw new Exception("购物车清空失败!");
			        }
					
					
					
				} catch (Exception e) {
					status = false;
					e.printStackTrace();
					arg0.setRollbackOnly();
				} 
			}
		});
		return status;
	}

}
