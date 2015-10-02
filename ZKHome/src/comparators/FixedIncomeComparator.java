package comparators;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import bean.FixedIncome;
import bean.FixedIncomeFormat;


public class FixedIncomeComparator implements Comparator<FixedIncomeFormat>, Serializable {
	private static final long serialVersionUID = 1L;
	private boolean asc = true;
    private int type = 0;
    
    public FixedIncomeComparator(boolean asc, int type) {
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
    public int compare(FixedIncomeFormat o1, FixedIncomeFormat o2) {
    	
    	SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
    	NumberFormat nf = NumberFormat.getInstance();
        switch (type) {
        case 1:
            return o1.getClientName().compareTo(o2.getClientName()) * (asc ? 1 : -1);
        case 2:
            return o1.getCUSIP().compareTo(o2.getCUSIP()) * (asc ? 1 : -1);
        case 3:
        	  try {
  				return (int) (nf.parse((o1.getMarketPrice().substring(1))).doubleValue()-(nf.parse(o2.getMarketPrice().substring(1)).doubleValue())*(asc? 1 : -1));
  			} catch (ParseException e1) {
  				// TODO Auto-generated catch block
  				e1.printStackTrace();
  			}
        case 4:
            try {
            	Date date1=(Date) sdf.parse(o1.getPendingCall()==null?"00/00/0000":o1.getPendingCall());
            	Date date2=(Date) sdf.parse(o2.getPendingCall()==null?"00/00/0000":o2.getPendingCall());
				return date1.compareTo(date2)*(asc?1:-1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        case 5:
        	try {
				return sdf.parse(o1.getMaturity()).compareTo(sdf.parse(o2.getMaturity()))*(asc?1:-1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        case 6:
        	try {
				return (int)(nf.parse(o1.getQuantity()).doubleValue() - nf.parse(o2.getQuantity()).doubleValue())*(asc ? 1 : -1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        case 7:
        	try {
				return (int) (nf.parse(o1.getCoupon()).doubleValue() - nf.parse(o2.getCoupon()).doubleValue())*(asc ? 1 : -1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        default:
            return o1.getRating().compareTo(o2.getRating()) * (asc ? 1 : -1);
        }
 
    }
}
