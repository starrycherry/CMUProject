/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */
package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoSum {
	   public int[] twoSum(int[] nums, int target) {
	        int[] re=new int[2];
	        if(nums.length==0){
	            return re;
	        }
	        ArrayList<Integer> list=new ArrayList<Integer>();
	        for(int i=0;i<nums.length;i++){
	            list.add(nums[i]);
	        }
	        
	        Arrays.sort(nums);
	        int sum=0;
	        int left=0;
	       
	        int right=nums.length-1;
	        while(left<=right){
	            sum=nums[left]+nums[right];
	            if(sum>target){
	                right--;
	            }
	            if(sum<target){
	                left++;
	            }
	            if(sum==target){
	                int index1=list.indexOf(nums[left])+1;
	                int index2=list.indexOf(nums[right])+1;
	                if(nums[left]==nums[right]){
	                    re[0]=list.indexOf(nums[left])+1;
	                    list.remove(re[0]-1);
	                    re[1]=list.indexOf(nums[right])+2;
	                }else{
	                    re[0]=Math.min(index1,index2);
	                    re[1]=Math.max(index1,index2);
	                }
	                
	                return re;
	            }
	        }
	        return re;
	    }
	 public static void main(String[] args){
		 TwoSum t=new TwoSum();
		 int[] nums={0,4,3,0};
		 t.twoSum(nums, 0);
	 }
}
