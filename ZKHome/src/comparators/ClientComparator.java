package comparators;

import java.io.Serializable;
import java.util.Comparator;

import bean.Client;


public class ClientComparator implements Comparator<Client>, Serializable {

	private static final long serialVersionUID = 1L;
	private boolean asc = true;
    private int type = 0;
    
    public ClientComparator(boolean asc, int type) {
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
    public int compare(Client o1, Client o2) {
        switch (type) {
        case 1:
            return o1.getName().compareTo(o2.getName()) * (asc ? 1 : -1);
        case 2:
            return o1.getType().compareTo(o2.getType()) * (asc ? 1 : -1);
        case 3:
            return o1.getResearch().compareTo(o2.getResearch()) * (asc ? 1 : -1);
        case 5:
            return o1.getQuantity() > (o2.getQuantity()) ? 1 : -1;
        case 6:
            return o1.getValue() > (o2.getValue()) ? 1 : -1;
        default:
            return o1.getDate().compareTo(o2.getDate()) * (asc ? 1 : -1);
        }
 
    }
}
