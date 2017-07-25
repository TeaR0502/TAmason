package com.t.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.t.bean.Cart;
import com.t.serviceimpl.CartServiceimpl;
import com.t.serviceimpl.UserServiceimpl;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/addCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//System.out.println("成功访问该SERVLET");
		if("addCart".equals(request.getParameter("action"))) {
			
			Add2CartServlet(request,response);
		} 
		if ("deleteCart".equals(request.getParameter("action"))) {
			deleteCartServlet(request,response);
		}  
		if ("modifyCart".equals(request.getParameter("action"))) {
			modifyCartServlet(request,response);
		}  

		
		
		
		
		
	}

	private void modifyCartServlet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int userid = UserServiceimpl.getNew().queryUserId(request.getParameter("username"));
		int id = Integer.parseInt(request.getParameter("id"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		//System.out.println("更新数量为:"+stock);
		HttpSession session = request.getSession();
		Map<Integer, Cart> cartMap = CartServiceimpl.getNew().getAllCart(userid);
		Integer status = -1;
		if (cartMap != null ) {
			Cart cart = cartMap.get(id);
			if (cart != null) {
				cart.setQuantity(stock);
				if (CartServiceimpl.getNew().updateCart(cart)) {
					status = 0;//修改成功!
				}else {
					status = 1;//修改失败!
				}
				
			} 
			//cartMap.put(id, cart);
		} else {
			status = 2;//无购物车信息!
		}
		cartMap = CartServiceimpl.getNew().getAllCart(userid);
		session.setAttribute("CartMap", cartMap);
		response.getWriter().write(status.toString());
	}

	private void deleteCartServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		int userId = UserServiceimpl.getNew().queryUserId(username);
		
		HttpSession session = request.getSession();
		Map<Integer, Cart> cartMap = CartServiceimpl.getNew().getAllCart(userId);
		Integer status = -1;
		if (cartMap.containsKey(id)) {
			if (CartServiceimpl.getNew().deleteCart(id,userId)) {
				status = 0;
				//删除成功
			} else {
				status = 1;//删除失败
			}
			
		} else {
			status = 2;//购物车中无此商品,请不要重复删除
		}
		
			/*
			if (cartMap.remove(id) != null ){
				
				if (cartMap.containsKey(id) && cartMap.get(id) != null) {
					//System.out.println("删除失败!");
					
					status = 1;//删除失败
				} else {
					status = 0;
					//删除成功
				}
			} else {
				status = 2;//购物车中无此商品,请不要重复删除
			}
			*/
			cartMap = CartServiceimpl.getNew().getAllCart(userId);
			session.setAttribute("CartMap", cartMap);
			response.getWriter().write(status.toString());
		}
		

	private void Add2CartServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		try {
			//System.out.println("成功访问该ADDCART");
			Integer status = 0;
			Cart cart = new Cart();
			//System.out.println("现在是第:"+request.getParameter("id")+"号商品");
			cart.setProduct_id(Integer.parseInt(request.getParameter("id")));
			cart.setQuantity(1);
			int userid = UserServiceimpl.getNew().queryUserId(request.getParameter("username"));
			cart.setUserid(userid);
			HttpSession session = request.getSession();
			Map<Integer, Cart> cartMap = CartServiceimpl.getNew().getAllCart(userid);
			
			if (cartMap == null || cartMap.size() == 0) {
				//System.out.println("初次访问购物车");
				//cartMap =  new HashMap<>();
				
				if (CartServiceimpl.getNew().addCart(cart)) {
					//System.out.println("添加成功");
					status = 1;
					}
			} else {
				if (cartMap.containsKey(cart.getProduct_id())) {
					cart = cartMap.get(cart.getProduct_id());
					cart.setQuantity(cart.getQuantity()+1);
					if (CartServiceimpl.getNew().updateCart(cart)) {status = 1;}
				} else if (CartServiceimpl.getNew().addCart(cart)) {
					//System.out.println("添加成功");
					status = 1;
					}
				
			}

				/*
				//获取map集合中的所有键的Set集合  
		        Set<Integer> keySet = cartMap.keySet();  
		        //有了Set集合就可以获取其迭代器，取值  
		        Iterator<Integer> it = keySet.iterator();  
		        while (it.hasNext())  
		        {  
		            Integer i = it.next();  
		            Cart s = cartMap.get(i);  
		            System.out.println(i + " = " + s);  
		        }  
				 */
			/*
			if (cartMap.containsKey(cart.getProduct_id())) {
				cart = cartMap.get(cart.getProduct_id());
				cart.setQuantity(cart.getQuantity()+1);
			//	System.out.println(cart);
			//	System.out.println("重复商品!");
			} 
			*/
			//System.out.println(cart);
			//cartMap.put(cart.getProduct_id(), cart);
		//	System.out.println("成功添加购物车");
			
			/*
			Set<Integer> keySet = cartMap.keySet();  
			//有了Set集合就可以获取其迭代器，取值  
	        Iterator<Integer> it = keySet.iterator();  
	        while (it.hasNext())  
	        {  
	            Integer i = it.next();  
	            Cart s = cartMap.get(i);  
	            System.out.println(i + " = " + s);  
	        } 
	        */
	        
			cartMap = CartServiceimpl.getNew().getAllCart(userid);
			session.setAttribute("CartMap", cartMap);
			response.getWriter().write(status.toString());
		} catch (Exception e) {
			response.getWriter().write("0");
		}
	}

}
