package com.t.daoimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.t.bean.Comment;
import com.t.bean.Product;
import com.t.dao.CommentDAO;
import com.t.jdbc.JdbcUtil;

public class CommentDAOimpl implements CommentDAO {

	private static JdbcTemplate jdbcTemplate = null;
	private static CommentDAOimpl commentDAOimpl = new CommentDAOimpl();

	private CommentDAOimpl() {
		jdbcTemplate = JdbcUtil.getJdbcTemplate();
	}

	public static CommentDAOimpl getNew() {
		return commentDAOimpl;
	}

	//////////////////////////////////////////////////////////////////
	/////////////////////////////// 测试////////////////////////////////
	//////////////////////////////////////////////////////////////////

	public static void main(String[] args) throws ParseException {

	}

	//////////////////////////////////////////////////////////////////
	/////////////////////////////// 测试////////////////////////////////
	//////////////////////////////////////////////////////////////////
	
	@Override
	public int getAllCommentNumber() {
		final String sql = "SELECT COUNT(*) FROM TCOMMENT";
		int count= jdbcTemplate.queryForInt(sql);
		return count;
	}
	
	@Override
	public List<Comment> getAllComment(int page) {
		final  String sql = "SELECT * FROM "
		 		+ "( SELECT A.*, ROWNUM RN  FROM (SELECT * FROM TCOMMENT) A "
		 		+ "WHERE ROWNUM <= ?  "
		 		+ ") "
		 		+ "WHERE RN >= ? ";

		List<Comment> commentList = jdbcTemplate.query(sql, new Object[] { (page * 2) ,((page - 1) * 2 + 1)},
				ParameterizedBeanPropertyRowMapper.newInstance(Comment.class));
		return commentList;
	}

	@Override
	public int addComment(Comment comment) {
		final String sql = "INSERT INTO TCOMMENT values (SEQ_COMMENT_ID.nextval, ?, ?,to_date(?, 'yyyy-MM-dd HH24:mi:ss'), ?)";
		
		//获取当前系统时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String stringdata = df.format(new Date());
		int rows = jdbcTemplate.update(sql,comment.getReply(),comment.getContent(),stringdata,comment.getNick_name());
		return rows;
	}

}
