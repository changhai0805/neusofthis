package com.neusoft.his.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBConnection {

	private DBConnection(){
		
	}
	
//	使用dbcp连接池产品建立与数据库的连接
	public static Connection getConnection(ServletContext context){
		Connection  connection = null;
		//创建属性文件对象
		Properties prop = new Properties();
		
		try {
			//加载src下的dbcp_config.properties
			prop.load(context.getResourceAsStream("/WEB-INF/classes/dbcp_config.properties"));
			//获取数据源
			DataSource dataSource = BasicDataSourceFactory.createDataSource(prop);
			//获取数据库的连接
			connection = dataSource.getConnection();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void closeAll(ResultSet rs , PreparedStatement pstmt,Connection connection){
		try {
			if(null != rs){
				rs.close();
			}
			if(null != pstmt){
				rs.close();
			}
			if(null != connection){
				rs.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	使用c3p0连接池获取数据库的连接
	public static Connection getConnection(){
		ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql-config");
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
