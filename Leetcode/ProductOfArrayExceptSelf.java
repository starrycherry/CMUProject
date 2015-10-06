/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
package Leetcode;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] left=new int[nums.length];
        int[] right=new int[nums.length];
        int[] product=new int[nums.length];
        int sumLeft=1;
        int sumRight=1;
        left[0]=1;
        for(int i=1;i<nums.length;i++){
        	sumLeft*=nums[i-1];
            left[i]=sumLeft;
        }
        
        right[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--){
        	sumRight*=nums[i+1];
            right[i]=sumRight;
            product[i]=right[i]*left[i];
        }
        product[0]=left[0]*right[0];
        product[nums.length-1]=left[nums.length-1]*right[nums.length-1];
        return product;
    }
    
    public static void main(String[] args){
    	ProductOfArrayExceptSelf p=new ProductOfArrayExceptSelf();
    	int[] nums={1,0};
    	p.productExceptSelf(nums);
    }
}
