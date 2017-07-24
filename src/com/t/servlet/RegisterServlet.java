package com.t.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.t.serviceimpl.UserServiceimpl;

import oracle.net.aso.e;
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("接到请求");
		if ("register".equals(req.getParameter("action"))) {
			try {
				this.doRegister(req,resp);
			} catch (ParseException e) {
				System.out.println("生日转换出现异常");
			}
		} 
		
		if ("name".equals(req.getParameter("action"))) {
			this.doRegisterUsername(req, resp);
		}
		
		if ("email".equals(req.getParameter("action"))) {
			doRegisterEmail(req, resp);
		}
	}
	
	
	private void doRegisterEmail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		Integer status = -1;
		if (UserServiceimpl.getNew().judgeEmail(email)) {
			status = 0;//可以使用
		} else {
			status = 1;//邮箱已经存在
		}
		resp.getWriter().write(status.toString());
	}
	
	private void doRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String sex = req.getParameter("sex").equals("0")?"男":"女";
		String birthday = req.getParameter("birthday");
		String idcode = req.getParameter("idcode");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");
		Integer status = UserServiceimpl.getNew().userRegister(username, password, sex, birthday, idcode, email, mobile, address);
		if (status.equals(1)) {
			HttpSession	session = req.getSession();
			session.setAttribute("username", username);
		}
		resp.getWriter().write(status.toString());
	}
	
	private void doRegisterUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		Integer status = -1;
		if (UserServiceimpl.getNew().judgeUsernanme(username)) {
			status = 0;//可以使用
		} else {
			status = 1;//用户名已经存在
		}
		resp.getWriter().write(status.toString());
	}

}
