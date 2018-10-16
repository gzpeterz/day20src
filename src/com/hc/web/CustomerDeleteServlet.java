package com.hc.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hc.service.CustomerService;
import com.hc.service.CustomerServiceImpl;

public class CustomerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null) {
			response.getWriter().write("删除失败");
			return;
		}
		CustomerService service = new CustomerServiceImpl();
		int ret = service.deleteCustomer(id);
		if (ret == 0) {
			response.sendRedirect(request.getContextPath()+"/customer/list");
		} else {
			response.getWriter().write("删除失败");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
