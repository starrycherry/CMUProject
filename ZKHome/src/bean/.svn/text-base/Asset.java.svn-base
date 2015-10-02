package bean;

import java.text.DecimalFormat;

public class Asset {
    private String type;
    private String subType;
    private String assetValue;
    private double percent;
    DecimalFormat df = new DecimalFormat("#.##");
    
    public Asset(String type, String subType, String assetValue, 
            double percent) {
        this.type = type;
        this.subType = subType;
        this.assetValue = assetValue;
        this.percent = percent;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(String assetValue) {
		this.assetValue = assetValue;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		 this.percent = Double.parseDouble(df.format(percent));
	}
 
}