package util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateHelper {

	public static Date getDateWithoutTime(Date date) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.SECOND, 0);
	    cal.set(Calendar.MILLISECOND, 0);
	    return cal.getTime();
	}

	public static Date getTomorrowDate(Date date) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.DATE, 1);
	    return cal.getTime();
	}
	
	public static Date getYesterdayDate(Date date) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.DATE, -1);
	    return cal.getTime();
	}
	
	public static Date getYesterdayTwoDate(Date date) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.DATE, -2);
	    return cal.getTime();
	}
	
	public static Date getLastMonthDate(Date date) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.MONTH, -1);
	    return cal.getTime();
	}
	
	public static Date getLastYearDate(Date date) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.YEAR, -1);
	    return cal.getTime();
	}
	
	public static Date getLastTwoMonthDate(Date date) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.MONTH, -2);
	    return cal.getTime();
	}
	
	public static Date getLastTwoYearDate(Date date) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.YEAR, -2);
	    return cal.getTime();
	}
	
	public static Date randomDate(int year){
		Calendar cal = Calendar.getInstance();
		int month = cal.get(cal.MONTH) + 1;  
		return new GregorianCalendar(year, myMaxInt(month), myMaxInt(30)).getTime();
	}
	
	public static int myMaxInt(int max){
		int min = 0;
		int a = (int) (min + (Math.random() * (max - min)));

		return a;
	}
	
	public static Date randomDate(){
		int min = 2008;
		int max = 2013;
		int a = (int) (min + (Math.random() * (max - min)));
		return new GregorianCalendar(a, DateHelper.myMaxInt(12), DateHelper.myMaxInt(30)).getTime();
	}
}
