/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

此题比较优化的思路应该是用binary search

 */
package Leetcode;


public class SearchInserPostion {
	 public int searchInsert(int[] nums, int target) {
	        if(nums.length==0){
	            return 0;
	        }
	        
	        for(int i=0;i<nums.length;i++){
	            if(target<=nums[i]){
	                return i;
	            }
	        }
	        
	        return nums.length;
	    }
	 
	 //binary search就是当循环结束时，如果没有找到目标元素，那么l一定停在恰好比目标大的index上，r一定停在恰好比目标小的index上，所以个人比较推荐这种实现方式。
	  public int searchInsert1(int[] nums, int target) {
	        if(nums==null||nums.length==0){
	            return 0;
	        }
	        
	        int l=0;
	        int r=nums.length-1;
	        while(l<=r){
	            int m=(l+r)/2;
	            if(nums[m]>target){
	                r=m-1;
	            }else if(nums[m]<target){
	                l=m+1;
	            }if(nums[m]==target){
	                return m;
	            }
	        }
	       return l;
	    }
}
