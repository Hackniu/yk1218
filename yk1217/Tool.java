package yk1217;

public class Tool {
	private String toolCode; /* key*/
	private String toolType;
	private String toolBrand;
	
	public Tool(String toolCode) {
		super();
		this.toolCode = toolCode;
		switch(this.toolCode) {
		case "CHNS":
			this.setToolType("Chainsaw");
			this.setToolBrand("Stihl");
			break;
		case "LADW":
			this.setToolType("Ladder");
			this.setToolBrand("Werner");
			break;
		case "JAKD":
			this.setToolType("Jackhammer");
			this.setToolBrand("DeWalt");
			break;
		case "JAKR":
			this.setToolType("Jackhammer");
			this.setToolBrand("Ridgid");
			break;
		default: 
			this.setToolType("");
			this.setToolBrand("");
		}
	}
	
	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

	public void setToolBrand(String toolBrand) {
		this.toolBrand = toolBrand;
	}

	public String getToolType() {
		return this.toolType;
	}
	public String getToolBrand() {
		return this.toolBrand;
	}
}
