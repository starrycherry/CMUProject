package bean;

public class TopFA {
	private boolean isCategory;
	private String fa_name;
	private String category;
	private String assetValue;
	private String today;
	private String yesterday;
	private String mtd;
	private String prev_month;
	private String ytd;
	private String prev_year;

	public TopFA(boolean isCategory, String fa_name, String category, String assetValue, String today,String yesterday,  
			String mtd, String prev_month, String ytd, String prev_year){
		this.isCategory = isCategory;
		this.fa_name = fa_name;
		this.category = category;
		this.assetValue = assetValue;
		this.today = today;
		this.yesterday = yesterday;
		this.mtd = mtd;
		this.prev_month = prev_month;
		this.ytd = ytd;
		this.prev_year = prev_year;
	}
	
	

	public boolean isCategory() {
		return isCategory;
	}

	public void setCategory(boolean isCategory) {
		this.isCategory = isCategory;
	}

	public String getFa_name() {
		return fa_name;
	}

	public void setFa_name(String fa_name) {
		this.fa_name = fa_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(String assetValue) {
		this.assetValue = assetValue;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public String getYesterday() {
		return yesterday;
	}

	public void setYesterday(String yesterday) {
		this.yesterday = yesterday;
	}

	public String getMtd() {
		return mtd;
	}

	public void setMtd(String mtd) {
		this.mtd = mtd;
	}

	public String getPrev_month() {
		return prev_month;
	}

	public void setPrev_month(String prev_month) {
		this.prev_month = prev_month;
	}

	public String getYtd() {
		return ytd;
	}

	public void setYtd(String ytd) {
		this.ytd = ytd;
	}

	public String getPrev_year() {
		return prev_year;
	}

	public void setPrev_year(String prev_year) {
		this.prev_year = prev_year;
	}

}