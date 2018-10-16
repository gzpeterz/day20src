package com.hc.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.hc.domain.User;
import com.hc.service.UserService;
import com.hc.service.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		Map<String, String[]> map = request.getParameterMap();
		UserService service = new UserServiceImpl();
		int ret = -1;
		try {
			BeanUtils.populate(user, map);
			System.out.println(user);
			ret = service.login(user, request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(ret == 0) {
			request.getRequestDispatcher("/main/success.jsp").forward(request, response);
		} else {
			request.setAttribute("login.msg", "用户登录失败 ！");
			request.setAttribute("user", user);
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
