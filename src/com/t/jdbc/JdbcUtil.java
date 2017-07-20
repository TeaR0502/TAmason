package com.t.jdbc;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

public class JdbcUtil {
	private static String DRIVER;
	private static String URL;
	private static String UNAME;
	private static String UPASS;
	
	/**
	 * 静态代码块
	 * 获取文件中储存的SQL连接配置信息
	 * 驱动,URL,用户名,密码
	 */
	static {
		Properties pro = new Properties();
		try {
			pro.load(JdbcUtil.class.getResourceAsStream("jdbcinfo.properties"));
			DRIVER = pro.getProperty("DRIVER");
			URL = pro.getProperty("URL");
			UNAME = pro.getProperty("UNAME");
			UPASS = pro.getProperty("UPASS");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 得到一个TransactionTemplate对象,用来进行事物处理
	 * @return TransactionTemplate对象
	 */
	public static TransactionTemplate getTransactionTemplate(){
		TransactionTemplate transactionTemplate = new TransactionTemplate();
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		BasicDataSource basicDataSource = new BasicDataSource();
		
		basicDataSource.setDriverClassName(DRIVER);
		basicDataSource.setUrl(URL);
		basicDataSource.setUsername(UNAME);
		basicDataSource.setPassword(UPASS);
		
		dataSourceTransactionManager.setDataSource(basicDataSource);
		transactionTemplate.setTransactionManager(dataSourceTransactionManager);
		
		return transactionTemplate;
	}
	
	/**
	 * 得到一个JdbcTemplate对象,模板对象,用来对数据库进行操作
	 * @return JdbcTemplate对象
	 */
	public static JdbcTemplate getJdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		BasicDataSource basicDataSource = new BasicDataSource();
		
		basicDataSource.setDriverClassName(DRIVER);
		basicDataSource.setUrl(URL);
		basicDataSource.setUsername(UNAME);
		basicDataSource.setPassword(UPASS);
		
		jdbcTemplate.setDataSource(basicDataSource);
		
		return jdbcTemplate;
	}
	
}
