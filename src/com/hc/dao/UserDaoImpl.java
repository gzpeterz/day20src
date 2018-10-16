package com.hc.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hc.domain.User;
import com.hc.utils.DataSourceUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> selectAll() throws SQLException {
		String sql = "select * from user";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		List<User> list = runner.query(sql, new BeanListHandler<User>(User.class));
		return list;
	}

	@Override
	public int add(User user) throws SQLException {
		int ret = 0;
		String sql = "insert into user values(null, ?, ?, ?, ?)";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		ret = runner.update(sql, user.getUsername(), user.getPassword(),
				user.getNickname(), user.getEmail());
		return ret;
	}

	@Override
	public int update(User user) throws SQLException {
		int ret = 0;
		String sql = "update  user set username = ?, password = ?, nickname=?, email= ? " 
				+ " where id = ? ";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		ret = runner.update(sql, user.getUsername(), user.getPassword(),
				user.getNickname(), user.getEmail(), user.getId());
		return ret;
	}

	@Override
	public int deleteById(int id) throws SQLException {
		int ret = 0;
		String sql = "delete from user where id = ?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		ret = runner.update(sql, id);
		return ret;
	}

	@Override
	public User selectById(int id) throws SQLException {
		String sql = "select * from user where id = ?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		User user = runner.query(sql, new BeanHandler<User>(User.class), id);
		return user;
	}

	@Override
	public User selectByUsername(String username) throws SQLException {
		String sql = "select * from user where username = ?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		User user = runner.query(sql, new BeanHandler<User>(User.class), username);
		return user;
	}

}
