package com.hc.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hc.domain.Customer;
import com.hc.utils.DataSourceUtils;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Customer> selectAll() throws SQLException {
		String sql = "select * from customer";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		List<Customer> list = runner.query(sql, new BeanListHandler<Customer>(Customer.class));
		return list;
	}

	@Override
	public int add(Customer cust) throws SQLException {
		int ret = 0;
		String sql = "insert into customer values (UUID(),?,?,?,?,?,?,?,?)  "; 
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		ret = runner.update(sql, 
				cust.getName(),
				cust.getGender(),
				cust.getBirthday(),
				cust.getCellphone(),
				cust.getEmail(),
				cust.getPreference(),
				cust.getType(),
				cust.getDescription()
				);
		return ret;
	}

	@Override
	public int update(Customer cust) throws SQLException {
		int ret = 0;
		String sql = "update  customer set  " +
				" name = ?, " +
				" gender = ?, " +
				" birthday = ?, " +
				" cellphone = ?, " +
				" email = ?, " +
				" preference = ?, " +
				" type = ?, " +
				" description = ? " +
				" where id = ?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		ret = runner.update(sql, 
				cust.getName(),
				cust.getGender(),
				cust.getBirthday(),
				cust.getCellphone(),
				cust.getEmail(),
				cust.getPreference(),
				cust.getType(),
				cust.getDescription(),
				cust.getId());
				
		return ret;
	}

	@Override
	public int deleteById(String id) throws SQLException {
		int ret = 0;
		String sql = "delete from customer where id = ?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		ret = runner.update(sql, id);
		return ret;
	}

	@Override
	public Customer selectById(String id) throws SQLException {
		String sql = "select * from customer where id = ?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		Customer cust = runner.query(sql, new BeanHandler<Customer>(Customer.class), id);
		return cust;
	}

	@Override
	public Customer selectByName(String username) throws SQLException {
		String sql = "select * from customer where name = ?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		Customer user = runner.query(sql, new BeanHandler<Customer>(Customer.class), username);
		return user;
	}

	@Override
	public int[] deleteMany(String[] ids) throws SQLException {
		if (ids == null) {
			return null;
		}
		String sql = "delete from customer where id = ?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String[][] params = new String[ids.length][1];
		for(int i = 0; i < ids.length; i++) {
			params[i][0] = ids[i];
		}
		int rets[] = runner.batch(sql, params);
		return rets;
	}

	@Override
	public List<Customer> selectCond(String colname, String name) throws SQLException {
		String sql = "select * from customer where " + colname + " like ?  ";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		List<Customer> list = runner.query(sql, 
				new BeanListHandler<Customer>(Customer.class), "%" + name + "%");
		return list;
	}

	@Override
	public List<Customer> selectPage(int pageNum, int numPerPage) throws SQLException {
		String sql = "select * from customer limit ?, ? ";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		List<Customer> list = runner.query(sql, new BeanListHandler<Customer>(Customer.class),
				(pageNum - 1)*numPerPage, numPerPage);
		return list;
	}

	@Override
	public long count() throws SQLException {
		String sql = "select count(*) from customer";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		Long ret =  (Long) runner.query(sql, new ScalarHandler());
		return ret;
	}

}
