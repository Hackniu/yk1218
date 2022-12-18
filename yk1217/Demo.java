package yk1217;

public class Demo {

	public double finalCost(String toolCode, String checkoutDate, int rentalDate, int discount) {
				
		try {
			
			if(rentalDate<1)
				throw new NumberFormatException("Dear, Please could you enter Rental day greater or equal to 1, thanks");
			if(discount > 100 || discount<0)
				throw new NumberFormatException("Dear, Please could you enter discount in the range of 0-10, thanks");
		
			UserToolInfo userToolInfo = new UserToolInfo(toolCode, checkoutDate, rentalDate, discount);
			Tool tl = new Tool(toolCode);
			String toolType = tl.getToolType();
			String toolBrand = tl.getToolBrand();
			ToolCharge toolCharge = new ToolCharge(toolType);
			String dueDate = userToolInfo.getDueDate();
			double dailyRentalCharge = toolCharge.getDailyRentalCharge();
			int chargeDay = userToolInfo.getChargeDays();
			double preDiscountCharge = userToolInfo.getPreDiscountCharge();
			double disCountAmount = userToolInfo.getDiscountAmount();
			double finalCharge = userToolInfo.getFinalCharge();
			System.out.println("Tool code: " + toolCode +"\n" +
					   "Tool type: " + toolType + "\n" +
					   "Tool brand: " + toolBrand + "\n" +
					   "Rental days: " + rentalDate + "\n"+
					   "Check out date: " + checkoutDate + "\n"+
					   "dueDate: " + dueDate + "\n"+
					   "Daily rental charge: " + dailyRentalCharge + "\n"+
					   "Charge days: " + chargeDay + "\n" + 
					   "Pre-discount charge: " + preDiscountCharge + "\n" +
					   "Discount percent: " + discount +"%"+ "\n"+
					   "Discount amount: " + disCountAmount + "\n" +
					   "Final charge: " + finalCharge + "\n"		   
		);
		
			return finalCharge;
		}catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		return 0.0;
	}
	public void finalAgreement(String toolCode, String checkoutDate, int rentalDate, int discount) {
		
		finalCost(toolCode, checkoutDate,rentalDate,discount);
		
	}	
}
