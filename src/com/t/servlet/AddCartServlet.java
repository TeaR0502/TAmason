package com.t.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.t.bean.Cart;
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//System.out.println("成功访问SERVLET");
			Cart cart = new Cart();
			System.out.println("现在是第:"+request.getParameter("id")+"号商品");
			cart.setProduct_id(Integer.parseInt(request.getParameter("id")));
			cart.setQuantity(1);
			int userid = UserServiceimpl.getNew().queryUserId(request.getParameter("username"));
			cart.setUserid(userid);
			HttpSession session = request.getSession();
			Map<Integer, Cart> cartMap = null;
			
			if (session.getAttribute("CartMap") == null ) {
				//System.out.println("初次访问购物车");
				cartMap =  new HashMap<>();
			} else {
				cartMap = (Map<Integer, Cart>) session.getAttribute("CartMap");
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
				if (cartMap.containsKey(cart.getProduct_id())) {
					cart = cartMap.get(cart.getProduct_id());
					cart.setQuantity(cart.getQuantity()+1);
				//	System.out.println(cart);
				//	System.out.println("重复商品!");
				} 
			}
			//System.out.println(cart);
			cartMap.put(cart.getProduct_id(), cart);
		//	System.out.println("成功添加购物车");
			
			
			Set<Integer> keySet = cartMap.keySet();  
			//有了Set集合就可以获取其迭代器，取值  
	        Iterator<Integer> it = keySet.iterator();  
	        while (it.hasNext())  
	        {  
	            Integer i = it.next();  
	            Cart s = cartMap.get(i);  
	            System.out.println(i + " = " + s);  
	        } 
	        
	        
			
			session.setAttribute("CartMap", cartMap);
			response.getWriter().write("1");
		} catch (Exception e) {
			response.getWriter().write("0");
		}
		
	}

}
