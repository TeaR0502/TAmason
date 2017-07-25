package com.t.service;

import java.util.List;

import com.t.bean.Comment;

public interface CommentService {
	
	/**
	 * 增加一条留言
	 * @param name 昵称
	 * @param content 正文
	 * @param title 标题
	 * @return 修改的数据库行数
	 */
	boolean addComment(String name ,String content,String title);
	/**
	 * 根据相对应的页码获取评论
	 * @param page
	 * @return
	 */
	List<Comment> getAllComment(int page);
	
	/**
	 * 获取所有的留言数量
	 * @return
	 */
	int getAllCommentNumber();
}
