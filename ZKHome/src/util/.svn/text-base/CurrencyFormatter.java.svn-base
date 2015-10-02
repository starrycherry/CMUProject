package util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CurrencyFormatter {
	static NumberFormat fmt = NumberFormat.getCurrencyInstance();
	public static String cashFormat(String str){

		DecimalFormat df = new DecimalFormat("#,##0.00");
		return "$"+df.format(Double.parseDouble(str));
	}

	public static String cashFormat(int i){
		DecimalFormat df = new DecimalFormat("#,##0.00");

		return fmt.format(Double.parseDouble(i+""));
		//		return "$"+df.format(Double.parseDouble(i+""));
	}


	public static double dblCash(String strCurr){
		Number number = null;  
		try  
		{  
			number = fmt.parse(strCurr);  
		}  
		catch (Exception e)  
		{  
			System.out.print(e);  
		} 
		return number.doubleValue();
	}
}
