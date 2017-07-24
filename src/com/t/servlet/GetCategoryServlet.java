package com.t.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.t.bean.Product_Category;
import com.t.serviceimpl.ProductServiceimpl;

/**
 * Servlet implementation class GetCategory
 */
@WebServlet("/getCategory")
public class GetCategoryServlet extends HttpServlet {
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
		if (request.getParameter("action").equals("get0")) {
			getFirstCategory(request, response);
		} 
		
		if (request.getParameter("action").equals("getName")) {
		//	System.out.println("准备获取名字");
			getCategoryName(request, response);
		} 
		if (request.getParameter("action").equals("getNumber")) {
		//	System.out.println("准备获取该类商品数量");
			getProductNumber(request, response);
		} 
		
	}
	

	private void getProductNumber(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		Integer rows = 0;
		if (request.getParameter("id") == null || request.getParameter("id").equals("")) {
			rows = ProductServiceimpl.getNew().getProductNumber("all", 0);
		} else if (request.getParameter("parent").equals("true") ) {
			rows = ProductServiceimpl.getNew().getProductNumber("parentId", Integer.parseInt(request.getParameter("id")));
		} else {
			rows = ProductServiceimpl.getNew().getProductNumber("childId", Integer.parseInt(request.getParameter("id")));
		}
	//	System.out.println(rows);
		response.getWriter().write(rows.toString());
		
	}

	private void getCategoryName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title= request.getParameter("id");
		if ( title == null || title.equals("") ||title.equals("all")) {
			title = "首页";
		} else {
			title =ProductServiceimpl.getNew().getCategoryName(Integer.parseInt(request.getParameter("id")));
		}
		//System.out.println(title);
		response.getWriter().write(title);
	}

	void getFirstCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Product_Category> list = (List<Product_Category>) session.getAttribute("firstCategory");
		List<Product_Category> secList = (List<Product_Category>) session.getAttribute("secCategory");
		if ( list == null || secList == null || list.size() == 0 || secList.size() == 0 ) {
			secList = new LinkedList<>();
			list = new LinkedList<>();
			
			//获取所有的父类ID
			list = ProductServiceimpl.getNew().getCategory(0);
			
			
			//获取对应的子类ID
			
			 for (Product_Category product_Category : list) {
				 List<Product_Category> temp;
				 temp = ProductServiceimpl.getNew().getCategory(product_Category.getId());
				 if (temp != null) {
					 secList.addAll(temp);
				 }
				
			 }
			 for (Product_Category product_Category : secList) {
				System.out.println(product_Category.getName());
			 }
			 
		}
		session.setAttribute("firstCategory", list);
		session.setAttribute("secCategory", secList);
		response.sendRedirect("index.jsp");
		
	}
	
	void getCategoryProductNumber(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title= request.getParameter("id");
		if ( title == null || title.equals("") ||title.equals("all")) {
			title = "首页";
		} else {
			title =ProductServiceimpl.getNew().getCategoryName(Integer.parseInt(request.getParameter("id")));
		}
		response.getWriter().write(title);
		
	}
	
	

}
