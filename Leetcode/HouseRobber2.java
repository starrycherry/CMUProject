/**
 * Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:

设定：dp[i]:表示抢到第i个房间的时候没有惊动警察的最大钱数
第一个房子被偷：
    dp1[0]=nums[0];
    dp1[1]=nums[0];
    dp1[i]=Max(dp1[i-2]+nums[i],dp1[i-1])   2<=i<=nums.length-2
    dp1[nums.length-1]=dp1[nums.length-2]

第一个房子没有被偷：
    dp2[0]=0;
    dp2[1]=nums[1];
    dp2[i]=Max(dp2[i-2]+nums[i],dp2[i-1])   2<=i<=nums.length-1

最后的结果为 Max(dp1[nums.length-1],dp2[nums.length-1])
 */
package Leetcode;

public class HouseRobber2 {
	   public int rob(int[] nums) {
	        if(nums.length==0){
	            return 0;
	        }
	        
	        if(nums.length==1){
	            return nums[0];
	        }
	        
	        int[] dp1=new int[nums.length];
	        int[] dp2=new int[nums.length];
	        
	        dp1[0]=nums[0];
	        dp1[1]=nums[0];
	        for(int i=2;i<nums.length-1;i++){
	            dp1[i]=Math.max(dp1[i-2]+nums[i],dp1[i-1]);
	        }
	         dp1[nums.length-1]=dp1[nums.length-2];
	        
	        dp2[0]=0;
	        dp2[1]=nums[1];
	        for(int i=2;i<nums.length;i++){
	            dp2[i]=Math.max(dp2[i-2]+nums[i],dp2[i-1]);
	        }
	        
	        return Math.max(dp1[nums.length-1],dp2[nums.length-1]);
	    }
	   
	   public static void main(String[] args){
		   HouseRobber2 h=new HouseRobber2();
		   int[] nums={6,5,7,4,3,2};
		   h.rob(nums);   
	   }
}
