/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

Hint:

How many majority elements could it possibly have?
Do you have a better hint? Suggest it!

排序后用两个指针,中间相隔n/3个数遍历就可以了;
 */
package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class MajorityElement2 {
    public ArrayList<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(nums.length==0){
            return list;
        }
        
        if(nums.length<3){
            for(int i=0;i<nums.length;i++){
                if(!list.contains(nums[i]))
                    list.add(nums[i]);
            }
            return list;
        }
        
        Arrays.sort(nums);
        int left=0;
        int right=nums.length/3;
        
        while(left<right&&right<nums.length){
            if(nums[left]==nums[right]){
                if(!list.contains(nums[left]))
                    list.add(nums[left]);
            }
            left++;
            right++;
        }
        
        return list;
    }
	 
	 public static void main(String[] args){
		 MajorityElement2 m=new MajorityElement2();
		 int[] nums={1,1,1,3,3,2,2,2};
		 m.majorityElement(nums);
	 }
}
