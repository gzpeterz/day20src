package com.hc.utils;

import javax.servlet.http.Cookie;

public class CookieUtil {

	public static Cookie getCookie(Cookie[] cookies, String name) {
		if (cookies == null) { return null; }
		for(Cookie cookie : cookies) {
			if (name.equals(cookie.getName())) {
				return cookie;
			}
		}
		return null;
	}

}
