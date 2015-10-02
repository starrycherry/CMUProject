package Leetcode;
/**
 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 * @author Cherrie
 *
 */
public class RomanToInt {
	    public int romanToInt(String s) {
	        int index=0,num=0,temp=0;
	        while(index<s.length()){
	            char c=s.charAt(index++);
	            switch(c){
	                case 'I':num+=1;temp=1;break;
	                case 'V':num+=temp==1?3:5;break;
	                case 'X':num+=temp==1?8:10;temp=10;break;
	                case 'L':num+=temp==10?30:50;break;
	                case 'C':num+=temp==10?80:100;temp=100;break;
	                case 'D':num+=temp==100?300:500;break;
	                case 'M':num+=temp==100?800:1000;break;
	            }
	        }
	        return num;
	    }
	
	public static void main(String[] args){
		RomanToInt r=new RomanToInt();
		r.romanToInt("IV");
	}
}
