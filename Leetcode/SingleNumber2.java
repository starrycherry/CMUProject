/**
 * Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

由于x^x^x = x，无法直接利用I的方法来解。但可以应用类似的思路，即利用位运算来消除重复3次的数。以一个数组[14 14 14 9]为例，将每个数字以二进制表达：

1110
1110
1110
1001
_____
4331    对每一位进行求和
1001    对每一位的和做%3运算，来消去所有重复3次的数
 */
package Leetcode;

public class SingleNumber2 {
	  public int singleNumber(int[] nums) {
	        if(nums.length==0){
	            return 0;
	        }
	        if(nums.length==1){
	            return nums[0];
	        }
	        
	        int res=0;
	        for(int i=0;i<32;i++){
	            int count=0;
	            int mask=1<<i;
	            
	            for(int j=0;j<nums.length;j++){
	                if((nums[j] & mask)==mask){
	                    count++;
	                }
	            }
	            
	            if(count%3==1){
	                res |=mask;
	            }
	           
	        }
	        return res;
	    }
}
