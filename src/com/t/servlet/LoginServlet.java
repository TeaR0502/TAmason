package com.t.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.t.daoimpl.UserDAOimpl;
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
		}
		resp.getWriter().write(status.toString());
	}

}
