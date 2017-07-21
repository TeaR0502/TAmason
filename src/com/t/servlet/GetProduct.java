package com.t.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;
import com.t.bean.Product;
import com.t.serviceimpl.ProductServiceimpl;

/**
 * Servlet implementation class GetProduct
 */
@WebServlet("/getProduct")
public class GetProduct extends HttpServlet {
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
		System.out.println("获取商品中...");
		String idString;
		String url = "index.jsp?";
		List<Product> productslist = null;
		String parent = request.getParameter("parent");
		// System.out.println("获取商品中..." + parent);
		if (request.getParameter("id") == null || request.getParameter("id").equals("")
				|| request.getParameter("id").equals("all")) {
			String id = "all";
			idString = id;
			// System.out.println(idString);
			url += "id=" + idString;

			productslist = ProductServiceimpl.getNew().getProduct("all", 0);
		} else {
			int id = Integer.parseInt(request.getParameter("id"));
			idString = Integer.toString(id);
			// System.out.println(idString);
			url += "id=" + idString;
			if (parent != null && parent.equals("true")) {
				System.out.println("是父类商品!");
				url += "&parent=true";
				productslist = ProductServiceimpl.getNew().getProduct("parentId", id);
			} else {
				productslist = ProductServiceimpl.getNew().getProduct("childId", id);
			}
		}
		if (productslist != null) {
			// System.out.println(idString);
			HttpSession session = request.getSession();
			session.setAttribute("productParent", parent);
			session.setAttribute("productId", idString);
			session.setAttribute("productList", productslist);
		}
		response.sendRedirect(url);
	}

}
