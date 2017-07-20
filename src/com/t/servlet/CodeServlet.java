package com.t.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/codeServlet")
public class CodeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if ("color".equals(req.getParameter("color"))) {
			this.judgeColor(req, resp);
		} else {
			this.judgeCode(req, resp);
		}
	
	
	}
	
	private void judgeColor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Integer color = (int) session.getAttribute("color");
		resp.getWriter().write(color.toString());
	}
	
	private void judgeCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String  code = (String) session.getAttribute("validateCode");

		String userCode = req.getParameter("code");
		//System.out.println("生成的验证码"+code);
		//System.out.println("用户输入的验证码"+userCode);
		Integer status = -1;
		if (code.equals(userCode)) {
			status = 0;//通过验证
			session.removeAttribute("validateCode");
		} else {
			status = 1;//没通过验证
		}
		resp.getWriter().write(status.toString());
	}

}
