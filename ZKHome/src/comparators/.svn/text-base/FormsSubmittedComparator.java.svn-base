package comparators;

import java.io.Serializable;
import java.util.Comparator;

import bean.FormsSubmitted;


public class FormsSubmittedComparator implements Comparator<FormsSubmitted>, Serializable {

	private static final long serialVersionUID = 1L;
	private boolean asc = true;
    private int type = 0;
    
    public FormsSubmittedComparator(boolean asc, int type) {
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
    public int compare(FormsSubmitted o1, FormsSubmitted o2) {
        switch (type) {
        case 1:
            return o1.getNumber().compareTo(o2.getNumber()) * (asc ? 1 : -1);
        case 2:
            return o1.getName().compareTo(o2.getName()) * (asc ? 1 : -1);
        case 3:
            return o1.getAccount().compareTo(o2.getAccount()) * (asc ? 1 : -1);
        case 4:
            return o1.getSubmitted().compareTo(o2.getSubmitted()) * (asc ? 1 : -1);
        default:
            return o1.getName().compareTo(o2.getName()) * (asc ? 1 : -1);
        }
 
    }
}
