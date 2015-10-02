package bean;


public class FAProductionEntity {

	private String amount;
	private String reason;
	private String category;
	private String date;
	
	public FAProductionEntity(String amount, String reason, String category, String date){
		this.amount = amount;
		this.reason = reason;
		this.category = category;
		this.date = date;
	}
	
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
