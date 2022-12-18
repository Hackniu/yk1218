package yk1217;

public class ToolCharge {
	private String toolType; /*key*/
	private double dailyRentalCharge;
	
	public ToolCharge(String toolType) {
		super();
		this.toolType = toolType;
		switch(this.toolType) {
		case "Ladder": 
			this.setDailyCharge(1.99);
			break;
		case "Chainsaw": 
			this.setDailyCharge(1.49);
			break;
		case "Jackhammer": 
			this.setDailyCharge(2.99);
			break;
		default:
			this.setDailyCharge(0.0);
		}
		
	}
	
	/* basic on the tool type*/
	public double getDailyRentalCharge() {
		return this.dailyRentalCharge;
	}

	public void setDailyCharge(double dailyRentalCharge) {
		this.dailyRentalCharge = dailyRentalCharge;
	}
}
