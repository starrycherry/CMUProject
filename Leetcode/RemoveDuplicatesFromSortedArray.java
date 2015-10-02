package Leetcode;
/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * @author Cherrie
 *
 */
public class RemoveDuplicatesFromSortedArray {
	  public int removeDuplicates(int[] nums) {
	        if(nums==null||nums.length<=1){
	            return nums.length;
	        }
	        
	        int pre=0;
	        int cur=1;
	        while(cur<nums.length){
	            if(nums[pre]==nums[cur]){
	                cur++;
	            }else{
	                pre++;
	                nums[pre]=nums[cur];
	                cur++;
	            }
	        }
	        return pre+1;
	    }
	  
	  public static void main(String[] args){
		  RemoveDuplicatesFromSortedArray r=new RemoveDuplicatesFromSortedArray();
		  int[] nums={3,4,5,6,8,8,8};
		  System.out.println(r.removeDuplicates(nums));
	  }
}
