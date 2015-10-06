/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
package Leetcode;

public class MinimumSizeSubarraySum {
	 public int minSubArrayLen(int s, int[] nums) {
	        if(nums.length==0 || nums==null) return 0;
	        //定义一个sum数组，其中存放当前位置之前的左右元素之和
	        int min=Integer.MAX_VALUE;
	        int[] sum=new int[nums.length+1];
	        for(int i=0;i<nums.length;i++)
	        {
	            sum[i+1]=sum[i]+nums[i];
	            if(sum[i+1]>=s){
	                int j=binarySearch(0,i,sum[i+1]-s+1,sum);
	                if(j>-1){
	                    min=Math.min(min,i-j+1);
	                }
	            }
	        }
	        return min==Integer.MAX_VALUE?0:min;
	    }


	    int binarySearch(int left, int right, int target, int[] sum) {  
	        int result = -1;  
	        while (left < right-1) {  
	            int m = left + (right-left)/2;  
	            if (sum[m] >= target) {  
	                right = m-1;  
	            } else if (sum[m] < target) {  
	                left = m;  
	            }  
	        }  
	        if (sum[right] < target) {  
	            return right;  
	        } else if (sum[left] < target) {  
	            return left;  
	        } else {  
	            return -1;  
	        }  
	    }  
	    
	    public int minSubArrayLen1(int s, int[] nums) {
	    	  if(nums.length==0){
	              return 0;
	          }
	          int left=0;
	          int length=Integer.MAX_VALUE;
	          int sum=0;
	          int i=0;
	          
	          while(i<nums.length&&left<nums.length){
	              sum+=nums[i];
	              if(sum>=s){
	                  length=Math.min(length,i-left+1);
	                  sum=0;
	                  left++;
	                  i=left;
	                  continue;
	              }
	              i++;
	             
	          }
	          return length==Integer.MAX_VALUE?0:length;
	    }
	    
	    public static void main(String[] args){
	    	MinimumSizeSubarraySum m=new MinimumSizeSubarraySum();
	    	int[] nums={2,3,1,2,1,5};
	    	System.out.println(m.minSubArrayLen1(7, nums));
	    }
}
