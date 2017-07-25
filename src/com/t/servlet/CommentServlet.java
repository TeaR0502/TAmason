package com.t.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.t.bean.Comment;
import com.t.serviceimpl.CommentServiceimpl;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/commentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ("getAll".equals(request.getParameter("action"))) {
			getAll(request, response);
		}
		if ("getNumber".equals(request.getParameter("action"))) {
			getNumber(request, response);
		}
		if ("submit".equals(request.getParameter("action"))) {
			submitComment(request, response);
		}
	}
	
	
	private void submitComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Integer status = -1;//提交失败
		if (CommentServiceimpl.getNew().addComment(name, content, title)) {
			status = 0;//提交成功
		}
		//System.out.println(status);
		response.getWriter().write(status.toString());
	}

	private void getNumber(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer rows = 0;
		rows = CommentServiceimpl.getNew().getAllCommentNumber();
		response.getWriter().write(rows.toString());
	}
	
	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strPage = request.getParameter("page");
		if (strPage == null || strPage.equals("")) {
			strPage = "1";
		}
		int page = Integer.parseInt(strPage);
		List<Comment> list = CommentServiceimpl.getNew().getAllComment(page);
		//
		/*
		for (Comment comment : list) {
			System.out.println(comment);
		}
		*/
		//
		
		if (list != null && list.size() > 0) {
			response.getWriter().write(JSON.toJSONString(list));
		}else {
			response.getWriter().write("");
		}
		
	}

}
