package Leetcode;
/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
 * and the difference between i and j is at most k.
 */
import java.util.HashMap;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null||nums.length==0||k<1){
            return false;
        }
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int n=nums[i];
            if(map.containsKey(n)){
                return true;
            }
            map.put(n,i);
            if(i>=k){
                map.remove(nums[i-k]);
            }
        }
        return false;
    }
}
