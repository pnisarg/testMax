package com.projects.testMax.view.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateAndTimeHelper {
	
	public Date ddmmyyyyToDate(String stringDate) {
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			formatter.setLenient(false);
			formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

			return (Date) formatter.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public long dateToEpoch(Date date){
		return date.getTime();
	}
	
}
