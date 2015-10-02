package comparators;

import java.io.Serializable;
import java.util.Comparator;

import bean.Cash;


public class CashComparator implements Comparator<Cash>, Serializable {

	private static final long serialVersionUID = 1L;
	private boolean asc = true;
	private int type = 0;

	public CashComparator(boolean asc, int type) {
		this.asc = asc;
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public int compare(Cash o1, Cash o2) {
		switch (type) {
		case 0:
			return (o1.getKey()-o2.getKey()) * (asc ? 1 : -1);
		case 1:
			return o1.getFANumber().compareTo(o2.getFANumber()) * (asc ? 1 : -1);
		case 2:
			return o1.getRelationship().compareTo(o2.getRelationship()) * (asc ? 1 : -1);
		case 3:
			return o1.getAccountName().compareTo(o2.getAccountName()) * (asc ? 1 : -1);
		case 4:
			return o1.getAccountNumber().compareTo(o2.getAccountNumber()) * (asc ? 1 : -1);
		case 5:
			return o1.getType().compareTo(o2.getType()) * (asc ? 1 : -1);
		case 6:
			return (int)(Double.parseDouble((o1.getAmount().substring(1)).replaceAll(",", "")) - Double.parseDouble((o2.getAmount().substring(1)).replaceAll(",", ""))) * (asc ? 1 : -1);
		case 7:
			return (int)(Double.parseDouble((o1.getAvailCash().substring(1)).replaceAll(",", "")) - Double.parseDouble((o2.getAvailCash().substring(1)).replaceAll(",", ""))) * (asc ? 1 : -1);
		case 8:
			return (int)(Double.parseDouble(o1.getPercentage().substring(0, o1.getPercentage().length() - 2)) - Double.parseDouble(o2.getPercentage().substring(0, o2.getPercentage().length() - 2))) * (asc ? 1 : -1);
		case 9:
			return o1.getDate().compareTo(o2.getDate()) * (asc ? 1 : -1);
		default:
			return o1.getRelationship().compareTo(o2.getRelationship()) * (asc ? 1 : -1);
		}

	}
}
