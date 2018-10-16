package com.hc.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hc.domain.Customer;
import com.hc.service.CustomerService;
import com.hc.service.CustomerServiceImpl;

public class CustomerEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null) {
			response.getWriter().write("无法进行编辑 ！");
			return;
		}
		CustomerService service = new CustomerServiceImpl();
		Customer cust  =  service.getOneCustomer(id);
		if (cust == null) {
			response.getWriter().write("无法进行编辑 ！");
			return;
	 	} else {
	 		request.setAttribute("customer", cust);
	 		request.getRequestDispatcher("/main/editCustomer.jsp").forward(request, response);
	 	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
