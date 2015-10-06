/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

����ÿ��A[i]��trapped water��������ȡ����A[i]�������ߵĸ߶ȣ�����չ����Сֵ��A[i]�Ĳ�ֵ����volume[i] = [min(left[i], right[i]) - A[i]] * 1�������1�ǿ�ȣ����the width of each bar is 2,�Ǿ�Ҫ����2��
 */
package Leetcode;

public class TrappingRainWater {
	 public int trap(int[] height) {
	        if(height.length<3){
	            return 0;
	        }
	        int[] left=new int[height.length];
	        int max=height[0];
	        int[] right=new int[height.length];
	    
	        for(int i=0;i<height.length;i++){
	            if(height[i]>max){
	                left[i]=height[i];
	                max=height[i];
	            }else{
	                left[i]=max;
	            }
	        }
	        
	        max=height[height.length-1];
	        for(int i=height.length-1;i>=0;i--){
	            if(height[i]>max){
	                right[i]=height[i];
	                max=height[i];
	            }else{
	                right[i]=max;
	            }
	        }
	        
	        int sum=0;
	        for(int i=0;i<height.length;i++){
	            sum+=Math.min(left[i],right[i])-height[i];
	        }
	        return sum;
	    }
	 
	 public static void main(String[] args){
		 TrappingRainWater t=new TrappingRainWater();
		 int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
		 t.trap(height);
	 }
}
