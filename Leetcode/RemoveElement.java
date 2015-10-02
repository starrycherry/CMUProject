/**
 * Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */

package Leetcode;

public class RemoveElement {
	  public int removeElement(int[] nums, int val) {
	        if(nums==null||nums.length==0){
	            return 0;
	        }
	        
	        int count=0;
	        int left=0;
	        int right=nums.length-1;
	        
	        if(left==right&&nums[left]==val){
	            return 0;
	        }
	         
	                
	        while(left<right){
	            while(right>left&&nums[right]==val){
	                right--;
	                count++;
	            }
	            if(nums[right]==val){
	                return nums.length-count-1;
	            }
	            if(nums[left]==val){
	                nums[left]=nums[right];
	                left++;
	                right--;
	                count++;
	            }else{
	                left++;
	            }
	        }
	        
	        if(left==right&&left>=0&&nums[left]==val){
	            count++;
	        }
	        
	        return nums.length-count;
	    }
	  
	  //second way
	   public int removeElement1(int[] nums, int val) {
	        int i=0;
	        int j=0;
	        while(j<nums.length){
	            if(nums[j]!=val){
	                nums[i]=nums[j];
	                i++;
	            }
	            j++;
	        }
	        return i;
	    }
	   
	   public static void main(String[] args){
		   RemoveElement r=new RemoveElement();
		   int[] nums={4,5};
		   r.removeElement(nums, 5);
	   }
}
