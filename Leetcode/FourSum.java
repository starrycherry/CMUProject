package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
    
    和3Sum方法类似,只是多了一个外面的循环
 * @author Cherrie
 *
 */

public class FourSum {
	 public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
	        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
	        Arrays.sort(nums);
	        if(nums==null||nums.length==0){
	            return list;
	        }
	        
	        for(int i=0;i<=nums.length-4;i++){
	            for(int j=i+1;j<=nums.length-3;j++){
	                int left=j+1;
	                int right=nums.length-1;
	                while(left<right){
	                    int sum=nums[i]+nums[j]+nums[left]+nums[right];
	                    ArrayList<Integer> item=new ArrayList<Integer>();
	                    if(sum>target){
	                        right--;
	                    }else if(sum<target){
	                        left++;
	                    }else if(sum==target){
	                        item.add(nums[i]);
	                        item.add(nums[j]);
	                        item.add(nums[left]);
	                        item.add(nums[right]);
	                    
	                    
	                        if(!list.contains(item)){
	                            list.add(item);
	                        }
	                        left++;
	                        right--;
	                    }
	                }
	            }
	        }
	     return list;
	    }
	 
	 public static void main(String[] args){
		 FourSum f=new FourSum();
		 int[] nums={0,0,0,0};
		 f.fourSum(nums, 0);
	 }
}
