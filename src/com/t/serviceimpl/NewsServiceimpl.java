package com.t.serviceimpl;

import java.util.List;

import com.t.bean.News;
import com.t.bean.Users;
import com.t.daoimpl.NewsDAOimpl;
import com.t.daoimpl.UserDAOimpl;
import com.t.service.NewsService;

public class NewsServiceimpl implements NewsService {

	private static NewsDAOimpl newsDAOimpl = null;
	private static NewsServiceimpl newsServiceimpl = new NewsServiceimpl();

	private NewsServiceimpl() {
		newsDAOimpl = NewsDAOimpl.getNew();
	}

	public static NewsServiceimpl getNew() {
		return newsServiceimpl;
	}

	//////////////////////////////////////////////////////////////////
	///////////////////////////////测试////////////////////////////////
	//////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		Users users = UserDAOimpl.getNew().queryByName("admin");
		System.out.println("试试看" + users);
	}

	//////////////////////////////////////////////////////////////////
	///////////////////////////////测试////////////////////////////////
	//////////////////////////////////////////////////////////////////
	
	
	
	
	@Override
	public News getNewsById(int id) {
		
		return newsDAOimpl.getNewsById(id);
	}

	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return newsDAOimpl.getAllNews();
	}

}
