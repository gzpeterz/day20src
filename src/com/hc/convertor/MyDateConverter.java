package com.hc.convertor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

public class MyDateConverter implements Converter{

	@Override
	public Object convert(Class clazz, Object str) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = df.parse((String) str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
