/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
 */
package Leetcode;

import java.util.Arrays;

public class MajorityElement {
	  public int majorityElement(int[] nums) {
	        if(nums.length==0){
	            return 0;
	        }
	        
	        if(nums.length==1){
	            return nums[0];
	        }
	        
	        Arrays.sort(nums);
	        int left=0;
	        int right=nums.length/2;
	        while(left<right&&right<nums.length){
	            if(nums[left]==nums[right]){
	                return nums[left];
	            }
	            left++;
	            right++;
	        }
	        
	        return 0;
	    }
}
