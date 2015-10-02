package bean;


public class Stock {

	String label;
	double prevPrice;
	double todayPrice;
	double change;
	
	public Stock(String label, double price) {
		this(label,price,price);
	}
	
	public Stock(String label, double todayPrice, double change) {
		super();
		this.label = label;
		this.todayPrice = todayPrice;
		this.change = change;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public double getPrviousPrice() {
		return prevPrice;
	}
	public void setPrviousPrice(double prevPrice) {
		this.prevPrice = prevPrice;
	}
	public double getCurrentPrice() {
		return todayPrice;
	}
	public void setCurrentPrice(double todayPrice) {
		this.todayPrice = todayPrice;
	}

	public double getRatio() {
		return change;
	}

	public void setRatio(double change) {
		this.change = change;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}
	
	
	
}
