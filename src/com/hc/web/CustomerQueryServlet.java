package com.hc.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hc.domain.Customer;
import com.hc.service.CustomerService;
import com.hc.service.CustomerServiceImpl;

public class CustomerQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String colname = request.getParameter("colname");
		String name = request.getParameter("name");
		System.out.println(colname);
		System.out.println(name);
		CustomerService service = new CustomerServiceImpl();
		if (colname == null || name == null || "none".equals(colname)) {
			request.setAttribute("showall.msg", "查询参数输入错误");
			request.getRequestDispatcher("/customer/list").forward(request, response);
			return;
		}
		List<Customer> list = service.selectList(colname, name);
		request.setAttribute("customers", list);
		request.getRequestDispatcher("/main/showall.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
