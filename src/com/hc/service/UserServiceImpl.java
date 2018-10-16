package com.hc.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.hc.dao.UserDao;
import com.hc.dao.UserDaoImpl;
import com.hc.domain.User;

public class UserServiceImpl implements UserService {

	private UserDao dao = new UserDaoImpl();

	@Override
	/**
	 * return 0: 注册成功 1： 用户名已经存在 2: 用户添加失败
	 */
	public int register(User user) {
		String username = user.getUsername();
		try {
			User userDB = dao.selectByUsername(username);
			if (userDB != null) {
				return 1;
			}
			int ret = dao.add(user);
			if (ret == 1) {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 2;
	}

	@Override
	/**
	 *  return 0: 表示用户登录成功
	 *  	   1: 登录失败
	 *         2： 用户密码错误
	 *         3: 用户不存在
	 */
	public int login(User user, HttpServletRequest request)  {
		try {
			User userDB = dao.selectByUsername(user.getUsername());
			if (userDB == null) {
				return 3;
			}
			if (userDB.getPassword().equals(user.getPassword())) {
				request.getSession().setAttribute("user", userDB);
				request.setAttribute("user", userDB);
				return 0;
			} else {
				return 2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

}
