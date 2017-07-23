package com.t.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.t.bean.Product;
import com.t.serviceimpl.ProductServiceimpl;

/**
 * Servlet implementation class GetProduct
 */
@WebServlet("/getProduct")
public class GetProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("action").equals("getProductList")) {
			GetProductList(request, response);
		}
		if (request.getParameter("action").equals("getProductById")) {
			GetProductById(request, response);
		}
		
		
	}

	
	//获取商品详细信息
	private void GetProductById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = -1;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			if (id <= 0) {
				int i = 1/0;
			}
		} catch (Exception e) {
			System.out.println("非法参数!");
			response.sendRedirect("index.jsp");
		}
		Product product = ProductServiceimpl.getNew().getProduct("id", id);
		String strProduct = JSON.toJSONString(product);
		response.getWriter().write(strProduct);
	}
	
	
	
	//获取商品列表
	private void GetProductList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//System.out.println("获取商品中...");
		List<Product> productslist = null;
		String stringList = null;
		String parent = request.getParameter("parent");
		String strPage = request.getParameter("page");
		int page = -1;
		if (strPage.equals("")) {
			page = 1;
		}  else {
			page = Integer.parseInt(strPage);
		}
		// System.out.println("获取商品中..." + parent);
		if (request.getParameter("id") == null || request.getParameter("id").equals("")
				|| request.getParameter("id").equals("all")) {
			// System.out.println(idString);
			productslist = ProductServiceimpl.getNew().getProduct("all", 0,page);
		} else {
			int id = Integer.parseInt(request.getParameter("id"));
			// System.out.println(idString);
			if (parent != null && parent.equals("true")) {
				//System.out.println("是父类商品!");
				productslist = ProductServiceimpl.getNew().getProduct("parentId", id,page);
			} else {
				productslist = ProductServiceimpl.getNew().getProduct("childId", id,page);
			}
		}
		if (productslist != null) {
			stringList = JSON.toJSONString(productslist);
		}
		//System.out.println("json格式字符串+"+stringList);
		response.getWriter().write(stringList);
	}
	
}
