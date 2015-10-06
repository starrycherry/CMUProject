/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?

һ��ʼ�뵽�ľ��Ǽ������򣬵��Ǽ���������Ҫ����ɨ�裬��һ��ͳ�ƺ죬�ף�������Ŀ���ڶ������������顣

���ǵ���ĿҪ��one pass�������ζ�������������˫ָ�����⣬����ҲҪtrack����index��һ����red��index��һ����blue��index���������м��ߡ�

i��0��blue indexɨ�裬
����0������red indexλ�ã�red index���ƣ�
����2������blue indexλ�ã�blue indexǰ�ƣ�
����1��i���ơ�
ɨ��һ��õ��ź�������顣ʱ��O(n)���ռ�O(1)��
 */
package Leetcode;

public class sortColors {
	  public void sortColors(int[] nums) {
	        if(nums.length<2){
	            return;
	        }
	        
	        int p=0;
	        int p2=nums.length-1;
	        int p0=0;
	        while(p<nums.length&&p<=p2&&p0<=p2){
	            if(nums[p]==0){
	                int temp=nums[p0];
	                nums[p0]=nums[p];
	                nums[p]=temp;
	                if(p==p0){
	                    p++;
	                }
	                p0++;
	            }else if(nums[p]==2){
	                int temp=nums[p2];
	                nums[p2]=nums[p];
	                nums[p]=temp;
	                p2--;
	            }else{
	                p++;
	            }
	        }
	    }
}
