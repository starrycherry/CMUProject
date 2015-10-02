package view_model;

public class IncomeFilter {
	private String pendingCall="",maturity="";

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
}
