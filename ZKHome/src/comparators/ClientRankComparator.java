package comparators;

import java.io.Serializable;
import java.util.Comparator;

import bean.ClientRank;


public class ClientRankComparator implements Comparator<ClientRank>, Serializable {

	private static final long serialVersionUID = 1L;
	private boolean asc = true;
    private int type = 0;
    
    public ClientRankComparator(boolean asc, int type) {
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
    public int compare(ClientRank o1, ClientRank o2) {
        switch (type) {
        case 1:
            return o1.getName().compareTo(o2.getName()) * (asc ? 1 : -1);
        case 2:
            return (int)(Double.parseDouble((o1.getAssets().substring(1)).replaceAll(",", "")) - Double.parseDouble((o2.getAssets().substring(1)).replaceAll(",", ""))) * (asc ? 1 : -1);
        case 3:
            return o1.getPriority().compareTo(o2.getPriority()) * (asc ? 1 : -1);
        case 4:
            return o1.getAttitude().compareTo(o2.getAttitude()) * (asc ? 1 : -1);
        case 5:
            return o1.getReferrer().compareTo(o2.getReferrer()) * (asc ? 1 : -1);
        default:
            return o1.getName().compareTo(o2.getName()) * (asc ? 1 : -1);
        }
 
    }
}
