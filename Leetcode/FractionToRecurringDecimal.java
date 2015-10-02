/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
 */

package Leetcode;

import java.util.HashMap;

public class FractionToRecurringDecimal {
	 public String fractionToDecimal(int numerator, int denominator) {
	        if(denominator==0){
	            return "";
	        }
	        
	        if(numerator==0){
	            return "0";
	        }
	        
	        StringBuffer sb=new StringBuffer();
	        if((numerator<0&&denominator>0)||(numerator>0&&denominator<0)){
	            sb.append("-");
	        }
	        
	        long lnumerator=numerator;
	        long ldenominator=denominator;
	        lnumerator=Math.abs(lnumerator);
	        ldenominator=Math.abs(ldenominator);
	        
	        sb.append(lnumerator/ldenominator);
	        
	        long remainder=lnumerator%ldenominator;
	        if(remainder==0){
	            return sb.toString();
	        }
	        
	        sb.append(".");
	        HashMap<Long,Integer> map=new HashMap<Long,Integer>();
	        
	        while(remainder!=0){
	            if(map.containsKey(remainder)){
	                int pos=map.get(remainder);
	                String front=sb.substring(0,pos);
	                String back=sb.substring(pos,sb.length());
	                return front+"("+back+")";
	            }
	            
	            map.put(remainder,sb.length());
	            sb.append(remainder*10/ldenominator);
	            remainder=remainder*10%ldenominator;
	            
	        }
	        
	        return sb.toString();
	    }
	 
	 public static void main(String[] args){
		 FractionToRecurringDecimal f=new FractionToRecurringDecimal();
		 f.fractionToDecimal(1, 6);
	 }
}
