package com.hc.dao;

import java.sql.SQLException;
import java.util.List;

import com.hc.domain.Customer;

public interface CustomerDao {
	public List<Customer> selectAll() throws SQLException;
	public List<Customer> selectCond(String colname, String name) throws SQLException;
	public int add(Customer cust) throws SQLException;
	public int update(Customer cust) throws SQLException;
	public int deleteById(String id) throws SQLException;
	public Customer selectById(String id) throws SQLException;
	public Customer selectByName(String name) throws SQLException;
	public int[] deleteMany(String ids[]) throws SQLException;
	public List<Customer> selectPage(int pageNum, int numPerPage) throws SQLException;
	public long count() throws SQLException;
}
