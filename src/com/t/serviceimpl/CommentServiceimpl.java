package com.t.serviceimpl;

import java.util.List;

import com.t.bean.Comment;
import com.t.daoimpl.CommentDAOimpl;
import com.t.service.CommentService;

public class CommentServiceimpl implements CommentService {

	private static CommentDAOimpl commentDAOimpl = null;
	private static CommentServiceimpl commentServiceimpl = new CommentServiceimpl();

	private CommentServiceimpl() {
		commentDAOimpl = CommentDAOimpl.getNew();
	}

	public static CommentServiceimpl getNew() {
		return commentServiceimpl;
	}

	//////////////////////////////////////////////////////////////////
	/////////////////////////////// 测试////////////////////////////////
	//////////////////////////////////////////////////////////////////

	public static void main(String[] args) {

	}

	//////////////////////////////////////////////////////////////////
	/////////////////////////////// 测试////////////////////////////////
	//////////////////////////////////////////////////////////////////
	
	@Override
	public List<Comment> getAllComment(int page) {
		return commentDAOimpl.getAllComment(page);
	}

	@Override
	public int getAllCommentNumber() {
		return commentDAOimpl.getAllCommentNumber();
	}

	@Override
	public boolean addComment(String name, String content, String title) {
		Comment comment = new Comment(0, title, content, name, null);
		return commentDAOimpl.addComment(comment) == 0 ? false:true;
	}

}
