package com.t.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(
		urlPatterns={"/addCartServlet","/shopping.jsp","/shopping-result.jsp"}
			
				)

public class DoSession implements Filter{
	
	@Override
	public void destroy() {
		/**
		 * 页面销毁的时候调用本函数
		 */
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		/**
		 * 过滤器
		 */
		HttpServletResponse response = (HttpServletResponse) arg1;//类型转换
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpSession session = request.getSession(false);
		if (session == null ||   session.getAttribute("username") == null ||((String)session.getAttribute("username")).equals("") ){
				response.sendRedirect("nologin.jsp");
		} else {
			chain.doFilter(request, response);//返还对象至servlet
		}
		
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		/**
		 * 页面初始化的时候调用本函数
		 */
		
	}

}
