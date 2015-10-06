/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


��i�����룬��i+1�����������prices[i+1] - prices[i] > 0���Ϳ����ۼӵ������ͨ����������������֪��ÿ��Ĺ�Ʊ�۸���ô���޴�����������������������Ƕ��١�������Ļ���������Լ�ȥ���Ʊ�Ļ�����ô������
��������Ƚ���ɼ۸��ˣ���������ͬʱ�����룬���췢���ֱ����ʱ��ɼ۸��ˣ���������ͬʱ���롣���ϵ������������ۼӾ����������
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
