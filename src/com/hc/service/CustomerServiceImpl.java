package com.hc.service;

import java.sql.SQLException;
import java.util.List;

import com.hc.dao.CustomerDao;
import com.hc.dao.CustomerDaoImpl;
import com.hc.domain.Customer;
import com.hc.domain.PageBean;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao dao = new CustomerDaoImpl();

	@Override
	public List<Customer> getAllCustomer() {
		try {
			return dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteCustomer(String id) {
		try {
			Customer cust = dao.selectById(id);
			if (cust == null) {
				return 1;
			}
			int ret = dao.deleteById(id);
			if (ret == 1) {
				return 0;
			} else {
				return 2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 3;
	}

	@Override
	public Customer getOneCustomer(String id) {
		Customer cust = null;
		try {
			cust = dao.selectById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cust;
	}

	@Override
	public int modifyCustomer(String id, Customer cust) {
		try {
			Customer custDB = dao.selectById(id);
			if (custDB == null) {
				return 1;
			} else {
				cust.setId(id);
				int ret2 = dao.update(cust);
				if (ret2 == 1) {
					return 0;
				} else {
					return 2;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 3;
	}

	@Override
	public int addCustomer(Customer cust) {
		if (cust == null) {
			return 3;
		}
		try {
			int ret = dao.add(cust);
			if (ret == 1) {
				return 0;
			} else {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 2;
	}

	@Override
	public int deleteManyCustomer(String[] ids) {
		if (ids == null) {
			return 1;
		}
		/*
		for(String id : ids) {
			int ret = deleteCustomer(id);
			if (ret != 0) {
				throw new RuntimeException("删除部分记录失败了 ！");
			}
		}
		*/
		try {
			int rets[] = dao.deleteMany(ids);
			for(int ret : rets) {
				if (ret != 1) {
					throw new RuntimeException("删除部分记录失败了 ！");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Customer> selectList(String colname, String name) {
		try {
			return dao.selectCond(colname, name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PageBean getPageCustomer(int pageNum, int numPerPage) {
		PageBean pb = new PageBean();
		pb.setPageNum(pageNum);
		pb.setNumPerPage(numPerPage);
		try {
			List<Customer> list = dao.selectPage(pageNum, numPerPage);
			pb.setCustomers(list);
			Long count = dao.count();
			pb.setTotalCount(count.intValue());
			int totalPageNum = (int) Math.ceil(count.doubleValue()/numPerPage);
			pb.setTotalPageNum(totalPageNum);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return pb;
	}

}
