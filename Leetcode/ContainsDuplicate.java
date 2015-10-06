package Leetcode;

import java.util.HashMap;
/**
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if 
 * any value appears at least twice in the array, and it should return false if every element is distinct.
 * @author Cherrie
 *
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null||nums.length==0){
            return false;
        }
        
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int n=nums[i];
            if(map.containsKey(n)){
                return true;
            }
            map.put(n,i);
        }
        return false;
    }
}
