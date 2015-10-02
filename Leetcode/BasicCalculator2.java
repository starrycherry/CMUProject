/**
 * Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.
 */
package Leetcode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;

public class BasicCalculator2 {
	   public int calculate(String s) {
	        String[] array1=s.split("[+-/\\* ]+");
	        String[] array2=s.split("[^+-/\\*]+");
	        LinkedList<String> list1=new LinkedList<String>(Arrays.asList(array1));
	        if(list1.size()>0&&(list1.get(0).equals("")||list1.get(0).equals(" "))) list1.remove(0);
	        LinkedList<String> list2=new LinkedList<String>(Arrays.asList(array2));
	        if(list2.size()>0&&(list2.get(0).equals("")||list2.get(0).equals(" "))) list2.remove(0);
	        
	        
	        
	        for(int i=0;i<list2.size();i++){
	           if(list2.get(i)=="*"){
	                if(list1.get(i)!=null&&list1.get(i+1)!=null){
	                    list1.set(i,String.valueOf(Integer.valueOf(list1.get(i))*Integer.valueOf(list1.get(i+1))));
	                    list2.remove(i);
	                    list1.remove(i+1);  
	                }
	            }
	            
	             if(list2.get(i)=="/"){
	                if(list1.get(i)!=null&&list1.get(i+1)!=null){
	                    list1.set(i,String.valueOf(Integer.valueOf(list1.get(i))/Integer.valueOf(list1.get(i+1))));
	                    list2.remove(i);
	                    list1.remove(i+1);  
	                }
	            }
	        }
	          for(int i=0;i<list2.size();i++){
	           if(list2.get(i)=="+"){
	                if(list1.get(i)!=null&&list1.get(i+1)!=null){
	                    list1.set(i,String.valueOf(Integer.valueOf(list1.get(i))+Integer.valueOf(list1.get(i+1))));
	                    list2.remove(i);
	                    list1.remove(i+1);  
	                }
	            }
	            
	             if(list2.get(i).equals("-")){
	                if(list1.get(i)!=null&&list1.get(i+1)!=null){
	                    list1.set(i,String.valueOf(Integer.valueOf(list1.get(i))-Integer.valueOf(list1.get(i+1))));
	                    list2.remove(i);
	                    list1.remove(i+1);  
	                }
	            }
	        }
	        
	       return Integer.valueOf(list1.get(0)); 
	    }
	   
	   public int calculateAccept(String s) {
	        String[] array1=s.split("[+-/\\* ]+");
	        String[] array2=s.split("[^+-/\\*]+");
	        LinkedList<String> list1=new LinkedList<String>(Arrays.asList(array1));
	        if(list1.size()>0&&(list1.get(0).equals("")||list1.get(0).equals(" "))) list1.remove(0);
	        LinkedList<String> list2=new LinkedList<String>(Arrays.asList(array2));
	        if(list2.size()>0&&(list2.get(0).equals("")||list2.get(0).equals(" "))) list2.remove(0);

	        while(list2.contains("*")||list2.contains("/")){
	            int a=list2.indexOf("*");
	            int b=list2.indexOf("/");
	             int i=0;
	             if(a==-1){
		            	  i=b;
		              }else if(b==-1){
		            	  i=a;
		              }else{
		            	  i=a<b?a:b;
		              }
	            if(list1.get(i)!=null&&list1.get(i+1)!=null){
	                 if(list2.get(i).equals("*")){
	                    list1.set(i,String.valueOf(Integer.valueOf(list1.get(i))*Integer.valueOf(list1.get(i+1))));
	                    list2.remove(i);
	                    list1.remove(i+1);  
	                }else{
	                    list1.set(i,String.valueOf(Long.valueOf(list1.get(i))/Long.valueOf(list1.get(i+1))));
	                    list2.remove(i);
	                    list1.remove(i+1); 
	                }
	            }
	        }
	                
	          while(list2.contains("+")||list2.contains("-")){
	            int a=list2.indexOf("+");
	            int b=list2.indexOf("-");
	            int i=0;
	             if(a==-1){
		            	  i=b;
		              }else if(b==-1){
		            	  i=a;
		              }else{
		            	  i=a<b?a:b;
		              }
	            if(list1.get(i)!=null&&list1.get(i+1)!=null){
	                if(list2.get(i).equals("+")){
	                    list1.set(i,String.valueOf(Integer.valueOf(list1.get(i))+Integer.valueOf(list1.get(i+1))));
	                    list2.remove(i);
	                    list1.remove(i+1);  
	                }else{
	                    list1.set(i,String.valueOf(Long.valueOf(list1.get(i))-Long.valueOf(list1.get(i+1))));
	                    list2.remove(i);
	                    list1.remove(i+1); 
	                }
	            }
	        }
	       
	       return Integer.valueOf(list1.get(0)); 
	    }
	   public static void main(String[] args){
		   String a="-2147483648";
		   int b=Integer.parseInt(a);
		   BasicCalculator2 c=new BasicCalculator2();
		   System.out.println(c.calculateAccept("1 + 1"));
	   }
}
