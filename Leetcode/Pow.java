/**
 * Implement pow(x, n).
 */
package Leetcode;

public class Pow {
	 public double myPow(double x, int n) {
	        if(n>0){
	            return myPowHelper(x,n);
	        }else{
	            return 1/myPowHelper(x,-n);
	        }
	    }
	    
	    private double myPowHelper(double x, int n){
	        if(n==0){
	            return 1;
	        }
	        
	        if(n==1){
	            return x;
	        }
	        
	        double temp=myPowHelper(x,n/2);
	        
	        if(n%2==0){
	            return temp*temp;
	        }else{
	            return temp*temp*x;
	        }
	    }
}
