package com.hc.service;

import java.util.List;

import com.hc.domain.Customer;
import com.hc.domain.PageBean;

public interface CustomerService {
	public List<Customer> getAllCustomer() ;
	public int deleteCustomer(String id);
	public Customer getOneCustomer(String id);
	public int modifyCustomer(String id, Customer cust);
	public int addCustomer(Customer cust);
	public int deleteManyCustomer(String[] ids);
	public List<Customer> selectList(String colname, String name);
	public PageBean getPageCustomer(int pageNum, int numPerPage);
}
