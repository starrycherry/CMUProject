package dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import bean.Cash;
 
public class CashBalanceData {
 
    private static List<Cash> cash = new ArrayList<Cash>();
    static {
    	cash.add(new Cash(1,"0000001", "Cherrie Household", "Cherrie's IRA", "12333123","","","450000.00","15.98%","08/19/2013"));
    	cash.add(new Cash(2,"0000001", "John Household", "John's Joint", "62373123","","","11293.11","7.13%","08/19/2013"));
    	cash.add(new Cash(3,"0000001", "Sam Household", "Sam Joint", "86562452","","","9380.00","1.12%","07/28/2013"));
    	cash.add(new Cash(4,"0000001", "Cherrie Household", "Cherrie's Trading", "23423423","","","34332.21","5.14%","08/19/2013"));
    	cash.add(new Cash(5,"0000001", "Cherrie Household", "Cherrie's Joint", "65634523","","","2389.89","5.13%","08/19/2013"));
    	cash.add(new Cash(6,"0000001", "Sam Household", "Sam's IRA", "45634352","","","8986767.11","17.22%","08/19/2013"));
    	cash.add(new Cash(7,"0000001", "Terry Household", "Terry's Trading", "93463413","","","272822.77","33.24%","08/19/2013"));
    	cash.add(new Cash(8,"0000001", "Cherrie Household", "Cherrie's IRA", "12333123","","","900000.00","9.8%","08/22/2013"));
    	cash.add(new Cash(9,"0000001", "John Household", "John's Joint", "62373123","","","891010.14","8.23%","08/22/2013"));
    	cash.add(new Cash(10,"0000001", "Sam Household", "Sam Joint", "86562452","","","2987.00","0.12%","08/22/2013"));
    	cash.add(new Cash(11,"0000001", "Cherrie Household", "Cherrie's Trading", "23423423","","","2423332.22","10.14%","08/22/2013"));
    	cash.add(new Cash(12,"0000001", "Cherrie Household", "Cherrie's Joint", "65634523","","","12987.62","2.13%","08/22/2013"));
    	cash.add(new Cash(13,"0000001", "Sam Household", "Sam's IRA", "45634352","","","1892228.45","9.91%","08/22/2013"));
    	cash.add(new Cash(14,"0000001", "Terry Household", "Terry's Trading", "93463413","","","113222.19","30.21%","08/22/2013"));
    	cash.add(new Cash(15,"0000001", "Tom Household", "Tom's IRA", "65237898","","","883983.33","33.31%","08/22/2013"));
    	cash.add(new Cash(16,"0000001", "Tom Household", "Tom's Trading", "90879865","","","983938.11","12.25%","07/30/2013"));
    	cash.add(new Cash(17,"0000001", "Mike Household", "Mike Joint", "34565433","","","121.77","3.12%","07/30/2013"));
    	cash.add(new Cash(18,"0000001", "Mike Household", "Mike's Trading", "65745676","","","9876589.11","50.77%","07/30/2013"));
    	cash.add(new Cash(19,"0000001", "Cherrie Household", "Cherrie's IRA", "12333123","","","450000.00","15.98%","08/20/2013"));
    	cash.add(new Cash(20,"0000001", "John Household", "John's Joint", "62373123","","","11293.11","7.13%","08/20/2013"));
    	cash.add(new Cash(21,"0000001", "Sam Household", "Sam Joint", "86562452","","","9380.00","1.12%","08/20/2013"));
    	cash.add(new Cash(22,"0000001", "Cherrie Household", "Cherrie's Trading", "23423423","","","34332.21","5.14%","08/20/2013"));
    	cash.add(new Cash(23,"0000001", "Cherrie Household", "Cherrie's Joint", "65634523","","","2389.89","5.13%","08/20/2013"));
    	cash.add(new Cash(24,"0000001", "Sam Household", "Sam's IRA", "45634352","","","8986767.11","17.22%","08/20/2013"));
    	cash.add(new Cash(25,"0000001", "Terry Household", "Terry's Trading", "93463413","","","272822.77","33.24%","08/20/2013"));
    	cash.add(new Cash(26,"0000001", "Cherrie Household", "Cherrie's IRA", "12333123","","","450000.00","15.98%","08/21/2013"));
    	cash.add(new Cash(27,"0000001", "John Household", "John's Joint", "62373123","","","11293.11","7.13%","08/21/2013"));
    	cash.add(new Cash(28,"0000001", "Sam Household", "Sam Joint", "86562452","","","9380.00","1.12%","08/21/2013"));
    	cash.add(new Cash(29,"0000001", "Cherrie Household", "Cherrie's Trading", "23423423","","","34332.21","5.14%","08/21/2013"));
    	cash.add(new Cash(30,"0000001", "Cherrie Household", "Cherrie's Joint", "65634523","","","2389.89","5.13%","08/21/2013"));
    	cash.add(new Cash(31,"0000001", "Sam Household", "Sam's IRA", "45634352","","","8986767.11","17.22%","08/21/2013"));
    	cash.add(new Cash(32,"0000001", "Terry Household", "Terry's Trading", "93463413","","","272822.77","33.24%","08/21/2013"));
    }
 
    public static List<Cash> getAllCash() {
        return new ArrayList<Cash>(cash);
    }
    
	
	public static List<Cash> getAllCashByGreater(Double greaterA, Double greaterP,Date dateO) throws ParseException {
   	 List<Cash> someCash = new ArrayList<Cash>();
        for (Iterator<Cash> i = cash.iterator(); i.hasNext();) {
            Cash tmp = i.next();
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date date = df.parse(tmp.getDate());
            dateO = df.parse(df.format(dateO));
            Double percent = 0.0;
            percent = Double.parseDouble(tmp.getPercentage().substring(0, tmp.getPercentage().length()-1));
            if ((date.getTime() == dateO.getTime()) && Double.parseDouble(tmp.getAvailCash()) >= greaterA && percent >= greaterP) {
            	someCash.add(tmp);
            }
        }
        return someCash;
   }
    
    
    public static Cash[] getAllCashArray() {
        return cash.toArray(new Cash[cash.size()]);
    }
 
}