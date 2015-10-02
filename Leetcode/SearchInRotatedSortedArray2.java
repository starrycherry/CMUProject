/**
 * Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.

binary search应该是出题者想要的解法,不过直接search在这个问题中,其实更简单.
 */
package Leetcode;

public class SearchInRotatedSortedArray2 {
	 public boolean search(int[] nums, int target) {
	        if(nums.length==0){
	            return false;
	        }
	        
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]==target){
	                return true;
	            }
	        }
	        
	        return false;
	    }
}
