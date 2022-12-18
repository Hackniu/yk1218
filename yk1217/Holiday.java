package yk1217;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class Holiday {

	private int year;
	
	public Holiday(int year) {
		super();
		this.year = year;
	}
	
	public boolean isIndepDay(String dateStr) {
		Util util = new Util();
		Date date;
		LocalDate indepDay;
		LocalDate inputDate;
		
		try {
			date = util.convertStringToDate(dateStr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			
			indepDay = LocalDate.of(year, Month.JULY, 4);
			/* calendar month is from 0 to 11, localDate month is from 1 to 12 */
			inputDate = LocalDate.of(year, cal.get(Calendar.MONTH)+ 1, cal.get(Calendar.DAY_OF_MONTH));
			
			/*1 (Monday) to 7 (Sunday)
			 * if the independent day fall into the Sat, Fri is holiday as well
			 */
			
			if(indepDay.getDayOfWeek().getValue() == 6){
				indepDay = indepDay.minusDays(1);
			}
			/*1 (Monday) to 7 (Sunday)
			 * if the independent day fall into the Sun, Mon is holiday as well
			 */
			if(indepDay.getDayOfWeek().getValue() == 7){
				indepDay = indepDay.plusDays(1);
			}
						
			if(inputDate.getMonthValue() == 7 && 
					(inputDate.getDayOfMonth()== indepDay.getDayOfMonth()||
							inputDate.getDayOfMonth() == 4)) {
				
				return true;
			}
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean isLaborDay(String dateStr) {
		Util util = new Util();
		Date inputDate;
		try {
			inputDate = util.convertStringToDate(dateStr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(inputDate);
			if(cal.get(Calendar.MONTH)==8) {
				LocalDate laborDate = LocalDate.of(year, Month.SEPTEMBER, cal.get(Calendar.DAY_OF_MONTH));
				LocalDate dateOfFirstMonday = laborDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
				if(dateOfFirstMonday.getDayOfMonth()== cal.get(Calendar.DAY_OF_MONTH))
					return true;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
