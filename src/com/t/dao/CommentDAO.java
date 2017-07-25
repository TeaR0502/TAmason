package com.t.dao;

import java.util.List;

import com.t.bean.Comment;

public interface CommentDAO {
	
	/**
	 * 添加一条留言
	 * @param comment
	 * @return
	 */
	int addComment(Comment comment);
	
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
