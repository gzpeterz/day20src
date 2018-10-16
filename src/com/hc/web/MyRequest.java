package com.hc.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

public class MyRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request;

	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		String str = super.getParameter(name);
		String ret = toChinese(str);
		return ret;
	}

	private String toChinese(String str) {
		if (str == null) {
			return null;
		}
		String ret = null;
		try {
			ret = new String(str.getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> map = super.getParameterMap();
		Set<String> keys = map.keySet();
		for (String key : keys) {
			String[] values = map.get(key);
			for (int i = 0; i < values.length; i++) {
				values[i] = toChinese(values[i]);
			}
		}
		return map;
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] values = super.getParameterValues(name);
		for (int i = 0; i < values.length; i++) {
			values[i] = toChinese(values[i]);
		}
		return values;
	}

}
