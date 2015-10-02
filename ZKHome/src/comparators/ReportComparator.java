package comparators;

import java.io.Serializable;
import java.util.Comparator;

import bean.Report;


public class ReportComparator implements Comparator<Report>, Serializable {

	private static final long serialVersionUID = 1L;
	private boolean asc = true;
    private int type = 0;
    
    public ReportComparator(boolean asc, int type) {
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
    public int compare(Report o1, Report o2) {
        switch (type) {
        case 1:
            return o1.getName().compareTo(o2.getName()) * (asc ? 1 : -1);
        case 2:
            return o1.getDate().compareTo(o2.getDate()) * (asc ? 1 : -1);
        default:
            return o1.getDate().compareTo(o2.getDate()) * (asc ? 1 : -1);
        }
 
    }
}
