package com.hc.web;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

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

public class CustomUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer cust = new Customer();
		CustomerService service = new CustomerServiceImpl();
		Map<String, String[]> map = request.getParameterMap();
		try {
			// DateConverter dc = new DateConverter("yyyy-MM-dd");
			ConvertUtils.register(new MyDateConverter(), Date.class);
			BeanUtils.populate(cust, map);
			System.out.println(cust);
			int ret = service.modifyCustomer(cust.getId(), cust);
			if (ret == 0) {
				request.setAttribute("showall.msg", cust.getId() + " 修改成功 ！");
				request.getRequestDispatcher("/customer/list").forward(request, response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().write("修改失败 ！");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
