package com.t.service;

import java.util.List;

import com.t.bean.News;

public interface NewsService {
	/**
	 * 根据ID获取对应的新闻
	 * @param id
	 * @return
	 */
	News getNewsById(int id);
	/**
	 * 获取所有的新闻
	 * @return
	 */
	List<News> getAllNews();
}
