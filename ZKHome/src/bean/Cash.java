package bean;

public class Cash {
	private int key;
	private String FANumber;
	private String relationship;   
	private String accountName;
	private String accountNumber;
	private String type;
	private String amount;
	private String availCash;
	private String percentage;    
	private String date;   

	public Cash(int key, String FANumber,  String relationship, String accountName, String accountNumber, String type, String amount, String availCash, String percentage, String date) {
		this.setKey(key);
		this.FANumber = FANumber;
		this.relationship = relationship;
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.type = type;
		this.amount = amount;
		this.availCash = availCash;
		this.percentage = percentage;
		this.date = date;
	}

	public String getFANumber() {
		return FANumber;
	}

	public void setFANumber(String fANumber) {
		FANumber = fANumber;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAvailCash() {
		return availCash;
	}

	public void setAvailCash(String availCash) {
		this.availCash = availCash;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	



}