/**
 * Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

����x^x^x = x���޷�ֱ������I�ķ������⡣������Ӧ�����Ƶ�˼·��������λ�����������ظ�3�ε�������һ������[14 14 14 9]Ϊ������ÿ�������Զ����Ʊ�

1110
1110
1110
1001
_____
4331    ��ÿһλ�������
1001    ��ÿһλ�ĺ���%3���㣬����ȥ�����ظ�3�ε���
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
