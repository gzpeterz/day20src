package com.hc.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class CustomerDaoTest {

	@Test
	public void testCount() throws SQLException {
		CustomerDao dao = new CustomerDaoImpl();
		long count = dao.count();
		System.out.println(count);
	}

}
