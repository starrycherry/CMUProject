package dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import bean.Cash;
 
public class CashData {
 
    private static List<Cash> cash = new ArrayList<Cash>();
    static {
    	cash.add(new Cash(3,"0000001", "Mark Household", "Mark's IRA", "12333123","ACATS In","1000.00","900000.00","9.8%","08/19/2013"));
    	cash.add(new Cash(4,"0000001", "Mark Household", "Mark's IRA", "12333123","Buys","-8989.86","891010.14","8.23%","08/19/2013"));
    	cash.add(new Cash(5,"0000001", "Sam Household", "Sam Joint", "86562452","Withdrawals","-3000.00","2987.00","0.12%","08/19/2013"));
    	cash.add(new Cash(6,"0000001", "Mark Household", "Mark's Trading", "23423423","Sells","121.11","2423332.22","10.14%","08/19/2013"));
    	cash.add(new Cash(7,"0000001", "Mark Household", "Mark's Joint", "45634523","ACATS Out","-200.00","12987.62","2.13%","08/19/2013"));
    	cash.add(new Cash(2,"0000001", "Sam Household", "Sam's IRA", "45634352","Dividends","1211.15","1892228.45","9.91%","08/10/2013"));
    	cash.add(new Cash(1,"0000001", "Terry Household", "Terry's Trading", "93463413","Interest","5.02","113222.19","30.21%","07/24/2013"));
    	cash.add(new Cash(8,"0000001", "John Household", "John's IRA", "43567876","ACATS In","3001.10","900000.00","9.8%","08/18/2013"));
    	cash.add(new Cash(9,"0000001", "Jonh Household", "John's IRA", "43567876","Buys","-89222.86","82291010.14","8.23%","08/18/2013"));
    	cash.add(new Cash(10,"0000001", "Mike Household", "Mike Joint", "98742476","Withdrawals","-4030.00","22537.00","0.12%","08/18/2013"));
    	cash.add(new Cash(11,"0000001", "Tom Household", "Tom's Trading", "12342124","Sells","4534.22","2423332.22","10.14%","08/18/2013"));
    	cash.add(new Cash(12,"0000001", "Tom Household", "Tom's Joint", "41980986","ACATS Out","-11.14","12987.62","2.13%","08/18/2013"));
    	cash.add(new Cash(13,"0000001", "Mark Household", "Mark's IRA", "12333123","ACATS In","1000.00","900000.00","9.8%","08/20/2013"));
    	cash.add(new Cash(14,"0000001", "Mark Household", "Mark's IRA", "12333123","Buys","-8989.86","891010.14","8.23%","08/20/2013"));
    	cash.add(new Cash(15,"0000001", "Sam Household", "Sam Joint", "86562452","Withdrawals","-3000.00","2987.00","0.12%","08/20/2013"));
    	cash.add(new Cash(16,"0000001", "Mark Household", "Mark's Trading", "23423423","Sells","121.11","2423332.22","10.14%","08/20/2013"));
    	cash.add(new Cash(17,"0000001", "Mark Household", "Mark's Joint", "45634523","ACATS Out","-200.00","12987.62","2.13%","08/20/2013"));
    	cash.add(new Cash(18,"0000001", "Mark Household", "Mark's IRA", "12333123","ACATS In","1000.00","900000.00","9.8%","08/21/2013"));
    	cash.add(new Cash(19,"0000001", "Mark Household", "Mark's IRA", "12333123","Buys","-8989.86","891010.14","8.23%","08/21/2013"));
    	cash.add(new Cash(20,"0000001", "Sam Household", "Sam Joint", "86562452","Withdrawals","-3000.00","2987.00","0.12%","08/21/2013"));
    	cash.add(new Cash(21,"0000001", "Mark Household", "Mark's Trading", "23423423","Sells","121.11","2423332.22","10.14%","08/21/2013"));
    	cash.add(new Cash(22,"0000001", "Mark Household", "Mark's Joint", "45634523","ACATS Out","-200.00","12987.62","2.13%","08/21/2013"));    	
    	cash.add(new Cash(23,"0000001", "Mark Household", "Mark's IRA", "12333123","ACATS In","1000.00","900000.00","9.8%","08/22/2013"));
    	cash.add(new Cash(24,"0000001", "Mark Household", "Mark's IRA", "12333123","Buys","-8989.86","891010.14","8.23%","08/22/2013"));
    	cash.add(new Cash(25,"0000001", "Sam Household", "Sam Joint", "86562452","Withdrawals","-3000.00","2987.00","0.12%","08/22/2013"));
    	cash.add(new Cash(26,"0000001", "Mark Household", "Mark's Trading", "23423423","Sells","121.11","2423332.22","10.14%","08/22/2013"));
    	cash.add(new Cash(27,"0000001", "Mark Household", "Mark's Joint", "45634523","ACATS Out","-200.00","12987.62","2.13%","08/22/2013"));
    	cash.add(new Cash(28,"0000001", "Sam Household", "Sam's IRA", "45634352","Dividends","1211.15","1892228.45","9.91%","08/22/2013"));
    	cash.add(new Cash(29,"0000001", "Terry Household", "Terry's Trading", "93463413","Interest","5.02","113222.19","30.21%","08/22/2013"));
    	cash.add(new Cash(30,"0000001", "John Household", "John's IRA", "43567876","ACATS In","3001.10","900000.00","9.8%","08/22/2013"));
    	cash.add(new Cash(31,"0000001", "Jonh Household", "John's IRA", "43567876","Buys","-89222.86","82291010.14","8.23%","08/22/2013"));
    }
 
    public static List<Cash> getAllCash() {
        return new ArrayList<Cash>(cash);
    }
    
	public static List<Cash> getAllCashByDate(Double greater, Date dateF, Date dateT) throws ParseException {
    	 List<Cash> someCash = new ArrayList<Cash>();
         for (Iterator<Cash> i = cash.iterator(); i.hasNext();) {
             Cash tmp = i.next();
             DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
             Date date = df.parse(tmp.getDate());
             dateF = df.parse(df.format(dateF));
             dateT = df.parse(df.format(dateT));
             String amount = tmp.getAmount();
             if(Double.parseDouble(tmp.getAmount()) < 0) {
             	amount = (tmp.getAmount()).substring(1);
             }
             if ((date.getTime() >= dateF.getTime()) && (date.getTime() <= dateT.getTime()) && Double.parseDouble(amount) >= greater) {
             	someCash.add(tmp);
             }
         }
         return someCash;
    }
    
    
    public static Cash[] getAllCashArray() {
        return cash.toArray(new Cash[cash.size()]);
    }
 
	public static List<Cash> getCashByType(String type, Double greater, Date dateF, Date dateT) throws ParseException {
        List<Cash> someCash = new ArrayList<Cash>();
        for (Iterator<Cash> i = cash.iterator(); i.hasNext();) {
            Cash tmp = i.next();
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date date = df.parse(tmp.getDate());
            dateF = df.parse(df.format(dateF));
            dateT = df.parse(df.format(dateT));
            String amount = tmp.getAmount();
            if(Double.parseDouble(tmp.getAmount()) < 0) {
            	amount = (tmp.getAmount()).substring(1);
            }
            if (tmp.getType().equals(type) && (date.getTime() >= dateF.getTime()) && (date.getTime() <= dateT.getTime()) && Double.parseDouble(amount) >= greater){
            	someCash.add(tmp);
            }
        }
        return someCash;
    }
 
}