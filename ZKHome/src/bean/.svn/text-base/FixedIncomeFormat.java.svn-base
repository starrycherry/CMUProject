package bean;

public class FixedIncomeFormat {
	String clientName;
	String CUSIP;
	String description;
	String marketPrice;
	String quantity;
	String pendingCall;
	String maturity;
	String coupon;
	String rating;
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getCUSIP() {
		return CUSIP;
	}
	public void setCUSIP(String cUSIP) {
		CUSIP = cUSIP;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(String marketPrice) {
		this.marketPrice = marketPrice;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPendingCall() {
		return pendingCall;
	}
	public void setPendingCall(String pendingCall) {
		this.pendingCall = pendingCall;
	}
	public String getMaturity() {
		return maturity;
	}
	public void setMaturity(String maturity) {
		this.maturity = maturity;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public FixedIncomeFormat(String clientName, String cUSIP,
			String description, String marketPrice, String quantity,
			String pendingCall, String maturity, String coupon, String rating) {
		super();
		this.clientName = clientName;
		this.CUSIP = cUSIP;
		this.description = description;
		this.marketPrice = marketPrice;
		this.quantity = quantity;
		this.pendingCall = pendingCall;
		this.maturity = maturity;
		this.coupon = coupon;
		this.rating = rating;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj==null) return false;
		else if(obj instanceof FixedIncomeFormat)
		{
			FixedIncomeFormat income=(FixedIncomeFormat )obj;
			return this.getCUSIP().equals(income.getCUSIP());
		}
		return false;
		
	}
	
}
