/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
package Leetcode;

public class BestTimeToBuyAndSellStock {
	 public int maxProfit(int[] prices) {
	        if(prices.length==0||prices.length==1){
	            return 0;
	        }
	        int maxProfit=0;
	        int profit=0;
	        int start=0;
	        for(int i=1;i<prices.length;i++){
	            profit=prices[i]-prices[start];
	            if(profit>maxProfit){
	                maxProfit=profit;
	            }
	            if(profit<0){
	                start=i;
	            }
	        }
	        return maxProfit;
	    }
    
    public static void main(String[] args){
    	BestTimeToBuyAndSellStock b=new BestTimeToBuyAndSellStock();
    	int[] prices={6,1,3,2,4,7};
    	System.out.println(b.maxProfit(prices));
    }
}
