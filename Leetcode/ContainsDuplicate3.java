/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 */
package Leetcode;

import java.util.SortedSet;
import java.util.TreeSet;

public class ContainsDuplicate3 {
	   public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	        if(k < 1 || t < 0)
	            return false;
	        TreeSet<Integer> set = new TreeSet<Integer>();
	        for(int i = 0; i < nums.length; i++){
	            int n = nums[i];
	            Integer f=set.floor(n);
	            Integer c=set.ceiling(n);
	            if(set.floor(n) != null && n <= t + set.floor(n) || 
	                    set.ceiling(n) != null && set.ceiling(n) <= t + n)
	                return true;
	            set.add(n);
	            if (i >= k)
	                set.remove(nums[i - k]);
	        }
	        return false;
	    }
	 
	 public static void main(String[] args){
		 int nums[]={1,2,3,4,5,6};
		 ContainsDuplicate3 c=new ContainsDuplicate3();
		 c.containsNearbyAlmostDuplicate(nums, 4, 4);
	 }
}
