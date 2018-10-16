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

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String[]> map = request.getParameterMap();
		User user = new User();
		UserService service = new UserServiceImpl();
		try {
			BeanUtils.populate(user, map);
			int ret = service.register(user);
			if (ret == 1) {
				request.setAttribute("register.msg", "username 已经存在 !");
				request.setAttribute("user", user);
				request.getRequestDispatcher("/login/Register.jsp").forward(request, response);
				return;
			}

			if (ret == 0) {
				request.setAttribute("user", user);
				request.getRequestDispatcher("/login/registersucc.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(user);
		request.setAttribute("register.msg", "注册失败  ！请 修改注册信息  ！");
		request.setAttribute("user", user);
		request.getRequestDispatcher("/login/Register.jsp").forward(request, response);
		// response.getWriter().write(user.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
