package com.t.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.t.bean.Cart;
import com.t.bean.Order_Detail;
import com.t.bean.Product;
import com.t.bean.Users;
import com.t.serviceimpl.CartServiceimpl;
import com.t.serviceimpl.OrderServiceimpl;
import com.t.serviceimpl.ProductServiceimpl;
import com.t.serviceimpl.UserServiceimpl;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/buyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		String username = request.getParameter("username");
		if (username == null || username.equals("")) {
			response.getWriter().write("2");//数据异常!
		} else {
			Users users = UserServiceimpl.getNew().queryUserByName(username);
			Map<Integer, Cart> cartsMap =  CartServiceimpl.getNew().getAllCart(users.getId());
			//List<Order_Detail> detialsList = new LinkedList<>();
			if (cartsMap == null || cartsMap.size() == 0) {
				response.getWriter().write("1");//该用户购物车为空
			} else if (OrderServiceimpl.getNew().doBuy(users, cartsMap)) {
				response.getWriter().write("0");//提交订单成功!
			} else {
				response.getWriter().write("3");//提交订单异常!
			}
		}
		
	}

}
