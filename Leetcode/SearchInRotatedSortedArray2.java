/**
 * Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.

binary searchӦ���ǳ�������Ҫ�Ľⷨ,����ֱ��search�����������,��ʵ����.
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
