/**
 * Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Related problem: Reverse Words in a String II

①将整个数组反转 
②将由分割点分割的两个数组分别反转 
即：1 2 3 4 5 6 7 -> 7 6 5 | 4 3 2 1 -> 5 6 7 | 1 2 3 4 
时间复杂度为O(n)，空间复杂度为O(1)。
 */

package Leetcode;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums.length==0||k<1){
	            return;
	        }
	    k=k%nums.length;
       rotateHelper(nums,0,nums.length-1);
       rotateHelper(nums,0,k-1);
       rotateHelper(nums,k,nums.length-1);
   }
   
   private void rotateHelper(int[] nums,int start,int end){
       while(start<end){
           int temp=nums[start];
           nums[start]=nums[end];
           nums[end]=temp;
           start++;
           end--;
       }
   }
	   
	   public static void main(String[] args){
		   RotateArray r=new RotateArray();
		   int[] nums={1,2};
		   r.rotate(nums, 1);
	   }
}
