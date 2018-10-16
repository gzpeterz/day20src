package com.hc.service;

import javax.servlet.http.HttpServletRequest;

import com.hc.domain.User;

public interface UserService {
	public int register(User user) ;

	public int login(User user, HttpServletRequest request);
}
