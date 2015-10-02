package comparators;

import java.io.Serializable;
import java.util.Comparator;

import bean.Holding;


public class HoldingComparator implements Comparator<Holding>, Serializable {

	private static final long serialVersionUID = 1L;
	private boolean asc = true;
    private int type = 0;
    
    public HoldingComparator(boolean asc, int type) {
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
    public int compare(Holding o1, Holding o2) {
        switch (type) {
        case 1:
            return o1.getHolding().compareTo(o2.getHolding()) * (asc ? 1 : -1);
        case 2:
            return o1.getType().compareTo(o2.getType()) * (asc ? 1 : -1);
        case 3:
            return o1.getResearch().compareTo(o2.getResearch()) * (asc ? 1 : -1);
        case 4:
            return o1.getClients().compareTo(o2.getClients()) * (asc ? 1 : -1);
        case 6:
        	return o1.getQuantity() > o2.getQuantity() ? 1 : -1;
        case 7:
        	return o1.getValue() > o2.getValue() ? 1 : -1;
        default:
            return o1.getDate().compareTo(o2.getDate()) * (asc ? 1 : -1);
        }
 
    }
}
