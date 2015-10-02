/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

  利用动态规划，声明两个数组arrayA，arrayB，其中arrayA[i]表示从0到i买卖一次的最大利润，arrayA[i]可根据arrayA[i-1]计算得到。
        arrayB[i]表示从i到len-1买卖一次的最大利润，逆向思维来求解arrayB[i]，arrayB[i]可根据arrayB[i+1]计算得到。
        这样针对每个i，累加就可以得到最大利润。
 */
package Leetcode;

public class BestTimeToBuyAndSellStock3 {
	   public int maxProfit(int[] prices) {
	        if(prices==null||prices.length==0){
	            return 0;
	        }
	        int[] A=new int[prices.length];
	        int[] B=new int[prices.length];
	        int min=prices[0];
	        A[0]=0;
	        for(int i=1;i<prices.length;i++){
	            A[i]=prices[i]-min;
	            A[i]=A[i]>A[i-1]?A[i]:A[i-1];
	            min=prices[i]<min?prices[i]:min;
	        }
	        
	        B[prices.length-1]=0;
	        int max=prices[prices.length-1];
	        for(int i=prices.length-2;i>=0;i--){
	            B[i]=max-prices[i];
	            B[i]=B[i]>B[i+1]?B[i]:B[i+1];
	            max=prices[i]>max?prices[i]:max;
	        }
	        
	        max=0;
	        int total=0;
	        for(int i=0;i<prices.length;i++){
	            total=A[i]+B[i];
	            max=total>max?total:max;
	        }
	        
	        return max;
	    }
}
