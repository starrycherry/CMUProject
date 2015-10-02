package action;

import java.util.Calendar;

import org.zkoss.calendar.api.CalendarEvent;
import org.zkoss.calendar.impl.SimpleCalendarEvent;
import org.zkoss.calendar.impl.SimpleCalendarModel;

public class CalMaxController {
	SimpleCalendarModel sm=new SimpleCalendarModel();
	public CalMaxController(){
		sm=new SimpleCalendarModel();
		CalendarEvent cal=create();
		addTM(cal);
	}
	
	public void addTM(CalendarEvent ce){
		sm.add(ce);
	}
	public CalendarEvent create(){
	Calendar ca=Calendar.getInstance();
	SimpleCalendarEvent se=new SimpleCalendarEvent();
	se.setContentColor("red");
	se.setHeaderColor("red");
	se.setContent("event content");
	se.setTitle("event title");
	se.setBeginDate(ca.getTime());
	System.out.print(ca.getTime());
	return se;
	
	}

}
