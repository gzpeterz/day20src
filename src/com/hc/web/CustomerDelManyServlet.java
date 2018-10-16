package com.hc.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hc.service.CustomerService;
import com.hc.service.CustomerServiceImpl;

public class CustomerDelManyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ids = request.getParameterValues("ids");
		System.out.println(Arrays.toString(ids));
		CustomerService service = new CustomerServiceImpl();
		int ret = service.deleteManyCustomer(ids);
		if (ret == 0) {
			request.setAttribute("showall.msg",  " 删除用户成功 ！");
			request.getRequestDispatcher("/customer/list").forward(request, response);
			return;
		}
		response.getWriter().write("delete failed");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
