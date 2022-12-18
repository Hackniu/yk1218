package yk1217;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateInfo {
	private String date;	
	
	public DateInfo(String date) {
		super();
		this.date = date;
	}
	public boolean isWeekend() {
		Calendar cal = Calendar.getInstance();
		Util util = new Util();
		try {
			cal.setTime(util.convertStringToDate(date));
			//number ranges from 1 (Sunday) to 7 (Saturday).
			if(cal.get(Calendar.DAY_OF_WEEK)==1 || cal.get(Calendar.DAY_OF_WEEK)==7)
				return true;
		} catch (Throwable e) {
			e.printStackTrace();
		}		
		return false;
	}
	public boolean isWeekDay() {
		return !this.isWeekend();
	}
	public boolean isHoliday() {
		Calendar cal = Calendar.getInstance();
		Holiday h;
		Util util = new Util();
		try {
			cal.setTime(util.convertStringToDate(date));
			h = new Holiday(cal.get(Calendar.YEAR));
			if(h.isIndepDay(date)||h.isLaborDay(date))
				return true;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean isValidDate() {
		SimpleDateFormat f = new SimpleDateFormat("MM/dd/yy");
		f.setLenient(false);
		try {
			f.parse(date);
		}catch(ParseException e) {
			return false;
		}
		return true;
	}
}
