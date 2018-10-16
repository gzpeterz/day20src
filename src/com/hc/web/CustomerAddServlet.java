package com.hc.web;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.hc.convertor.MyDateConverter;
import com.hc.domain.Customer;
import com.hc.service.CustomerService;
import com.hc.service.CustomerServiceImpl;

public class CustomerAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer cust = new Customer();
		CustomerService service = new CustomerServiceImpl();
		Map<String, String[]> map = request.getParameterMap();
		try {
			ConvertUtils.register(new MyDateConverter(), Date.class);
			BeanUtils.populate(cust, map);
			// String str = UUID.randomUUID().toString();
			// cust.setId(str);
			System.out.println(cust);
			int ret = service.addCustomer(cust);
			if (ret == 0) {
				request.setAttribute("showall.msg", cust.getId() + " 添加用户成功 ！");
				request.getRequestDispatcher("/customer/list").forward(request, response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().write("添加用户失败 ！");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
