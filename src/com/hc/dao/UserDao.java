package com.hc.dao;

import java.sql.SQLException;
import java.util.List;

import com.hc.domain.User;

public interface UserDao {
	public List<User> selectAll() throws SQLException;
	public int add(User user) throws SQLException;
	public int update(User user) throws SQLException;
	public int deleteById(int id) throws SQLException;
	public User selectById(int id) throws SQLException;
	public User selectByUsername(String username) throws SQLException;
}
