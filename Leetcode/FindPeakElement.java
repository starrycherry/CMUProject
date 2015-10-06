/**
 * A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ¡Ù num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -¡Ş.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
package Leetcode;

public class FindPeakElement {
	
	//O(n)
	   public int findPeakElement(int[] nums) {
	        if(nums.length<2){
	            return 0;
	        }
	        if(nums[0]>nums[1]){
	            return 0;
	        }
	        int i=1;
	        while(i<nums.length){
	            if(nums[i]<nums[i-1]){
	                i++;
	              
	            }else{
	                if(i+1<nums.length&&nums[i]>nums[i+1]){
	                    return i;
	                }
	                if(i==nums.length-1){
	                    return i;
	                }
	                i++;
	            }
	        }
	        return 0;
	    }
	   //logN
	   public int findPeakElement1(int[] nums) {
           int start=0,end=nums.length-1,mid=0,mid1=0;
        while(start<end){
            mid=(start+end)/2;
            mid1=mid+1;
            if(nums[mid]<nums[mid1]) start=mid1;
            else end=mid;
        }
        return start;
    }
	   
	   public static void main(String[] args){
		   FindPeakElement f=new FindPeakElement();
		   int[] nums={1, 2, 3, 1};
		   System.out.println(f.findPeakElement1(nums));
	   }
}
