package com.t.service;

import java.util.List;

import com.t.bean.Comment;

public interface CommentService {
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
