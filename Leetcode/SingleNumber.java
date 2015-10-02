/**
 * Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
package Leetcode;

public class SingleNumber {
	public int singleNumber(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        
        int res=0;
        for(int i=0;i<32;i++){
            int mask=1<<i;
            int count=0;
            for(int j=0;j<nums.length;j++){
                if((nums[j]&mask)==mask){
                    count++;
                }
            }
            if(count%2==1){
                res|=mask;
            }
        }
        return res;
    }
}
