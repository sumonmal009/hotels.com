package com.hotels.project.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {

	public static String getCurrentDateTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return formatter.format(date);
	}
}
