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
import com.t.daoimpl.UserDAOimpl;
import com.t.serviceimpl.CartServiceimpl;
import com.t.serviceimpl.UserServiceimpl;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer status = UserServiceimpl.getNew().userLogin(req.getParameter("username"), req.getParameter("password"));
		if (status.equals(0)) {
			HttpSession	session = req.getSession();
			session.setAttribute("username", req.getParameter("username"));
			int userId = UserServiceimpl.getNew().queryUserId(req.getParameter("username"));
			Map<Integer, Cart> cartMap = CartServiceimpl.getNew().getAllCart(userId);
			session.setAttribute("CartMap",cartMap);
		}
		resp.getWriter().write(status.toString());
	}

}
