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
import java.util.Stack;

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
	   
	   
	   //最优
	   static public int calculate3(String s) {
		    int res = 0, tempRes = 0, Option = 1, tempOp = 1;
		    for (int i = 0; i < s.length(); i++) {
		        switch (s.charAt(i)) {
		        case ' ':
		            break;
		        case '+':
		            Option = 1;
		            break;
		        case '-':
		            Option = -1;
		            break;
		        case '*':
		            Option = 2;
		            break;
		        case '/':
		            Option = 3;
		            break;
		        default:
		            int num = 0;
		            while (i < s.length() && Character.isDigit(s.charAt(i)))
		                num = num * 10 + s.charAt(i++) - '0';
		            i--;
		            switch (Option) {
		            case 1:
		                res += tempOp * tempRes;
		                tempRes = num;
		                tempOp = 1;
		                break;
		            case -1:
		                res += tempOp * tempRes;
		                tempRes = num;
		                tempOp = -1;
		                break;
		            case 2:
		                tempRes *= num;
		                break;
		            case 3:
		                tempRes /= num;
		            }
		 
		        }
		    }
		    res += tempOp * tempRes;
		    return res;
		}
	   //传统方法, 要注意stack和队列之间的转化. 虽然通过了,但是此方法不是最优. 用符号stack,和数据 stack两个stack进行操作. 
	    int i=0;
	    public int calculate4(String s) {
	        if(s==null||s.length()==0){
	            return 0;
	        }
	        Stack<Long> num=new Stack<Long>();
	        Stack<Character> ope=new Stack<Character>();
	        while(i<s.length()){
	            char c=s.charAt(i);
	            if(c==' '){
	                i++;
	                continue;
	            }else if(c=='+'||c=='-'){
	                ope.push(c);
	            }else if(c=='*'){
	                long n1=num.pop();
	                i++;
	                long n2=getNum(s);
	                long ans=n1*n2;
	                num.push(ans);
	            }else if(c=='/'){
	                 long n1=num.pop();
	                 i++;
	                long n2=getNum(s);
	                long ans=n1/n2;
	                num.push(ans);
	            }else{
	                num.push(getNum(s));
	            }
	            i++;
	        }
	        LinkedList<Long> numq=new LinkedList<Long>();
	        LinkedList<Character> opeq=new LinkedList<Character>();
	        numq.addAll(num);
	        opeq.addAll(ope);
	        while(!numq.isEmpty()&&!opeq.isEmpty()){
	            char o=opeq.poll();
	            if(o=='+'){
	                long ans=numq.poll()+numq.poll();
	                numq.addFirst(ans);
	            }else{
	                long ans=numq.poll()-numq.poll();
	                numq.addFirst(ans);
	            }
	        }
	        long ans=numq.poll();
	        if(ans>=Integer.MAX_VALUE){
	            return Integer.MAX_VALUE;
	        }else if(ans<=Integer.MIN_VALUE){
	            return Integer.MIN_VALUE;
	        }else{
	            return (int)ans;
	        }
	    }
	    public long getNum(String s){
	        long num=0;
	        while(i<s.length()&&s.charAt(i)==' '){
	            i++;
	        }
	        while(i<s.length()&&Character.isDigit(s.charAt(i))){
	            num=num*10+s.charAt(i++)-'0';
	        }
	        i--;
	        return num;
	    }
	   public static void main(String[] args){
		   BasicCalculator2 c=new BasicCalculator2();
		   System.out.println(c.calculate3("3-4-2*2"));
	   }
}
