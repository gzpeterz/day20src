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

public class CustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService service = new CustomerServiceImpl();
		List<Customer> list = service.getAllCustomer();
		request.setAttribute("customers", list);
		request.getRequestDispatcher("/main/showall.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
