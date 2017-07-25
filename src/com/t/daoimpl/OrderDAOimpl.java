package com.t.daoimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;

import com.t.bean.Order;
import com.t.bean.Order_Detail;
import com.t.dao.OrderDAO;
import com.t.jdbc.JdbcUtil;

public class OrderDAOimpl implements OrderDAO{

	private static JdbcTemplate jdbcTemplate = null;
	private static OrderDAOimpl orderDAOimpl = new OrderDAOimpl();

	private OrderDAOimpl() {
		jdbcTemplate = JdbcUtil.getJdbcTemplate();
	}

	public static OrderDAOimpl getNew() {
		return orderDAOimpl;
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
	public int addOrder(Order order) {
		final String sql = "INSERT INTO TORDER values (?, ?, ?, ?, to_date(?, 'yyyy-MM-dd HH24:mi:ss'), ?, 1, 1)";
		//获取当前系统时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String stringdata = df.format(new Date());
		int rows = jdbcTemplate.update(sql,order.getId(),order.getUser_id(),order.getUser_name(),order.getUser_address(),stringdata,order.getCost());
		return rows;
	}

	@Override
	public int getSqe() {
		final String sql = "SELECT SEQ_ORDER_ID.nextval FROM dual";
		return jdbcTemplate.queryForInt(sql);
	}

	@Override
	public int addOrderDetail(Order_Detail order_Detail) {
		final String sql = "INSERT INTO ORDER_DETAIL values (SEQ_DETAIL_ID.nextval,?,?,?,?)";
		int rows = jdbcTemplate.update(sql,order_Detail.getOrder_id(),order_Detail.getProduct_id()
				,order_Detail.getQuantity(),order_Detail.getCost());
		return rows;
	}

}
