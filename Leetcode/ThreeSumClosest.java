package Leetcode;

import java.util.Arrays;
/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @author Cherrie
 *
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length<3){
            return 0;
        }
        
        int closest=0;
        int comp=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(comp>Math.abs(sum-target)){
                    comp=Math.abs(sum-target);
                    closest=sum;
                }
                if(sum>target){
                    right--;
                }else if(sum<target){
                    left++;
                }else{
                    return target;
                }
            }
        }
        return closest;
    }
}
