package com.t.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.t.bean.News;
import com.t.serviceimpl.NewsServiceimpl;

import oracle.net.aso.e;

/**
 * Servlet implementation class NewsServlet
 */
@WebServlet("/newsServlet")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsServlet() {
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
		if("getAll".equals(request.getParameter("action"))) {
			getAll(request, response);
		}
		if("getNew".equals(request.getParameter("action"))) {
			getNew(request, response);
		}
	}
	
	
	private void getNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		//System.out.println(id);
		News news = NewsServiceimpl.getNew().getNewsById(id);
		if (news != null) {
			response.getWriter().write(JSON.toJSONString(news));//获取成功
		} else {
			response.getWriter().write("");//失败
		}
		
}
	
	
	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<News> list = NewsServiceimpl.getNew().getAllNews();
			if (list != null && list.size() > 0) {
				response.getWriter().write(JSON.toJSONString(list));//获取成功
			} else {
				response.getWriter().write("");//失败
			}
			
	}

}
