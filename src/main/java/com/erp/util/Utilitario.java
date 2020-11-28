package com.erp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilitario {
	
	public static Date convertToDate(String data) throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 
		Date date = formatter.parse(data);
		
		return date;
	}

}
