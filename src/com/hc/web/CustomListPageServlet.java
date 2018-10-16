package com.hc.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hc.domain.Customer;
import com.hc.domain.PageBean;
import com.hc.service.CustomerService;
import com.hc.service.CustomerServiceImpl;

public class CustomListPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService service = new CustomerServiceImpl();
		String strPageNum = request.getParameter("pageNum");
		int pageNum = 1;
		if (strPageNum != null) {
			pageNum = Integer.parseInt(strPageNum);
		}
		int numPerPage = 10;
		String strNumPerPage = request.getParameter("numPerPage");
		if (strNumPerPage != null) {
			numPerPage = Integer.parseInt(strNumPerPage);
		}
		PageBean page = service.getPageCustomer(pageNum, numPerPage);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/main/showpage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
