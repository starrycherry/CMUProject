/**
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */
package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	  public String largestNumber(int[] nums) {
	        String[] str=new String[nums.length];
	        for(int i=0;i<nums.length;i++){
	            str[i]=String.valueOf(nums[i]);
	        }  
	        
	        Arrays.sort(str,new Comp());
	        
	        StringBuffer re=new StringBuffer();
	        for(int i=0;i<str.length;i++){
	            re.append(str[i]);
	        }
	        
	        int i=0;
	        while(i<str.length&&re.charAt(i)=='0'){
	            i++;
	        }
	        if(i==str.length){
	            return "0";
	        }
	         return re.substring(i);
	    }
	    
	    class Comp implements Comparator<String>{
	        @Override
	        public int compare(String a, String b){
	            String ab=a.concat(b);
	            String ba=b.concat(a);
	            
	            return (int) (Long.parseLong(ba)-Long.parseLong(ab));
	        }
	    } 
	    
	    public static void main(String[] args){
	    	LargestNumber l=new LargestNumber();
	    	int[] nums={0,0};
	    	System.out.println(l.largestNumber(nums));
	    	
	    }
}
