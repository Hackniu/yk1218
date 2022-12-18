package yk1217;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class UserToolInfo {
	private String toolCode;
	private String checkoutDate;
	private int rentalDate;
	private int discount;
	
	public UserToolInfo(String toolCode, String checkoutDate, int rentalDate, int discount) {
		super();
		this.toolCode = toolCode;
		this.checkoutDate = checkoutDate;
		this.rentalDate = rentalDate;
		this.discount = discount;
	}	

	/* dueDate = checkOutDate + returnDate*/
	public String getDueDate() {
		Util util = new Util();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
		LocalDate dueDate;
		try {
			Date date = util.convertStringToDate(checkoutDate);
			Calendar calCheckOutDate = Calendar.getInstance();
			calCheckOutDate.setTime(date);
			
			LocalDate startDate = LocalDate.of(calCheckOutDate.get(Calendar.YEAR), 
					getMonth(calCheckOutDate.get(Calendar.MONTH)), 
					calCheckOutDate.get(Calendar.DAY_OF_MONTH));
			
			dueDate = startDate.plusDays(rentalDate);
			
			return dueDate.format(formatter).toString();
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	private boolean isChargeDate(String date) {
		Tool tl = new Tool(toolCode);
		DateInfo dateInfo = new DateInfo(date);		
		
		if(tl.getToolType() == "Ladder" && dateInfo.isHoliday()) 
			return false;	
		if(tl.getToolType() == "Chainsaw" && dateInfo.isWeekend())
			return false;
		if(tl.getToolType() == "Jackhammer" && dateInfo.isWeekDay())
			return false;
		return true;
	}
	/* it need dateInfo, toolCode->toolType, checkoutDate, rentalDay */
	public int getChargeDays() {
		Util util = new Util();
		int counter = rentalDate;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
		Date date;
		LocalDate dateTemp;
		int chargeDays = 0;
		try {
			date = util.convertStringToDate(checkoutDate);
			Calendar calCheckOutDate = Calendar.getInstance();
			calCheckOutDate.setTime(date);
			
			LocalDate startDate = LocalDate.of(calCheckOutDate.get(Calendar.YEAR), 
					getMonth(calCheckOutDate.get(Calendar.MONTH)), 
					calCheckOutDate.get(Calendar.DAY_OF_MONTH));
			while(counter!=0) {
				dateTemp = startDate.plusDays(counter);
				if(isChargeDate(dateTemp.format(formatter).toString())) {
					chargeDays ++;
				}
				counter--;
			}
			return chargeDays;
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	/* getChargeDays*toolCharge.getDailyCharge*/
	public double getPreDiscountCharge() {
		Tool tl = new Tool(toolCode);
		ToolCharge toolCharge = new ToolCharge(tl.getToolType());
		return this.getChargeDays()* toolCharge.getDailyRentalCharge();
	}
	/* discount * getPreDiscountCharge*/
	public double getDiscountAmount() {
		DecimalFormat df = new DecimalFormat("###.##");
		if(discount >0)
			return Double.valueOf(df.format(this.getPreDiscountCharge() * discount/100));
		return 0.0;
	}
	/* getPreDiscountCharge - getDiscountAmount*/
	public double getFinalCharge() {
		DecimalFormat df = new DecimalFormat("###.##");
		return Double.valueOf(df.format(this.getPreDiscountCharge() - this.getDiscountAmount()));
	}
	private Month getMonth(int m) {
		switch(m) {
		case 0: return Month.JANUARY;
		case 1: return Month.FEBRUARY;
		case 2: return Month.MARCH;
		case 3: return Month.APRIL;
		case 4: return Month.MAY;
		case 5: return Month.JUNE;
		case 6: return Month.JULY;
		case 7: return Month.AUGUST;
		case 8: return Month.SEPTEMBER;
		case 9: return Month.OCTOBER;
		case 10: return Month.NOVEMBER;
		case 11: return Month.DECEMBER;
		}
		return null;
	}
}
