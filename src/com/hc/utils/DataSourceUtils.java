package com.hc.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	
	public static DataSource ds = new ComboPooledDataSource();

	public static DataSource getDataSource() {
		return ds;
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn  = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
