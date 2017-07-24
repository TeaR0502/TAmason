package com.t.daoimpl;

import java.text.ParseException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.t.bean.News;
import com.t.dao.NewsDAO;
import com.t.jdbc.JdbcUtil;

public class NewsDAOimpl implements NewsDAO {
	private static JdbcTemplate jdbcTemplate = null;
	private static NewsDAOimpl newsDAOimpl = new NewsDAOimpl();

	private NewsDAOimpl() {
		jdbcTemplate = JdbcUtil.getJdbcTemplate();
	}

	public static NewsDAOimpl getNew() {
		return newsDAOimpl;
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
	public News getNewsById(int id) {
		String sql = "SELECT * FROM TNEWS WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql,new Object[] {id},
				ParameterizedBeanPropertyRowMapper.newInstance(News.class));
	}

	@Override
	public List<News> getAllNews() {
		String sql = "SELECT * FROM TNEWS ";
		return jdbcTemplate.query(sql,ParameterizedBeanPropertyRowMapper.newInstance(News.class));
	}

}
