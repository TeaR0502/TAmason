package com.t.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.t.serviceimpl.UserServiceimpl;

/**
 * Servlet implementation class retrieveUserServlet
 */
@WebServlet("/retrieveUserServlet")
public class retrieveUserServlet extends HttpServlet {
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
		if (request.getParameter("action").equals("doJudgeUser")) {
			doJudgeUser(request, response);
		} else if (request.getParameter("action").equals("doUpdatePassword")) {
			doUpdatePassword(request, response);
		}
	}
	
	/**
	 * 判断用户是否符合找回密码的身份
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	void doJudgeUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer status = -1;
		if (UserServiceimpl.getNew().retrieveUser(request.getParameter("username"), request.getParameter("idcode"), request.getParameter("email"))) {
			status = 0;
		} else {
			status = 1;
		}
		response.getWriter().write(status.toString());
	}
	
	/**
	 * 给通过验证的用户修改密码
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	void doUpdatePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer status = -1;
		if (UserServiceimpl.getNew().updatePassword(request.getParameter("username"), request.getParameter("password"))) {
			status = 0;
		} else {
			status = 1;
		}
		response.getWriter().write(status.toString());
	}

}
