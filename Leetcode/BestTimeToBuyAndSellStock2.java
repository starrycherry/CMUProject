/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


第i次买入，第i+1次卖出，如果prices[i+1] - prices[i] > 0，就可以累加到利润里。通俗来讲，就是现在知道每天的股票价格，那么不限次数的买入卖出，最大利润是多少。这样想的话，如果是自己去买股票的话，那么今天买，
发现明天比今天股价高了，就卖出，同时再买入，后天发现又比买的时候股价高了，再卖出，同时买入。不断的买入卖出，累加就是最大利润。
 */
package Leetcode;

public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int buy=0;
        int totalProfit=0;
        int profit=0;
        for(int i=0;i<prices.length;i++){
             int diff=prices[i]-prices[buy];
            if(diff>=0){
                 profit=profit>diff? profit:diff;
                if(i+1<prices.length&&prices[i]>prices[i+1]){
                    buy=i+1;
                    totalProfit+=profit;
                    profit=0;
                }
            }
            
            if(diff<0){
                buy=i;
            }
        }
        totalProfit+=profit;
        return totalProfit;
    }
}
