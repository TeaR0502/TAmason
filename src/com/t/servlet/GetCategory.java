package com.t.servlet;

import java.io.IOException;
import java.util.List;

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
public class GetCategory extends HttpServlet {
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
		
	}
	
	void getFirstCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("firstCategory") == null) {
			List<Product_Category> list = ProductServiceimpl.getNew().getCategory(0);
			session.setAttribute("firstCategory", list);
		}
		response.sendRedirect("index.jsp");
		
	}
	

}