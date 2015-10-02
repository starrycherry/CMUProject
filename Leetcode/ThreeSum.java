package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	   public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
	        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
	        if(nums.length==0){
	            return list;
	        }
	        
	        Arrays.sort(nums);
	        int left=0;
	        int right=nums.length-1;
	        int sum=0;
	        for(int i=0;i<nums.length;i++){
	           
	            left=i+1;
	            right=nums.length-1;
	            if(nums[i]==0){
	                 if(+2<nums.length&&nums[i+1]==0&&nums[i+2]==0){
	                    ArrayList<Integer> item=new ArrayList<Integer>();
	                    item.add(nums[i]);
	                    item.add(nums[i+1]);
	                    item.add(nums[i+2]);
	                    if(!list.contains(item))
	                        list.add(item);
	                 }
	                continue;
	            }
	            
	            if(nums[i]>0||nums[right]<0){
	                break;
	            }
	            if(i-1>0&&nums[i]==nums[i-1]){
	                continue;
	            }
	            while(left<right){
	                sum=nums[left]+nums[i]+nums[right];
	              
	               
	                if(sum==0){
	                    ArrayList<Integer> item=new ArrayList<Integer>();
	                     item.add(nums[i]);
	                    item.add(nums[left]);
	                    item.add(nums[right]);
	                    if(!list.contains(item))
	                        list.add(item);
	                    left++;
	                    right--;
	                    while(right>i&&nums[right]==nums[right+1]){
	                        right--;
	                    }
	                    while(left<right&&nums[left]==nums[left-1]){
	                        left++;
	                    }
	                }
	              
	                if(sum<0){
	                    left++;
	                }
	                 if(sum>0){
	                    right--;
	                }
	            }
	         
	        }
	        return list;
	    }
    
    public static void main(String[] args){
    	ThreeSum t=new ThreeSum();
    	int[] nums={-3,-4,-2,0,2,2,-2,1,-1,2,3,-1,-5,-4,-5,1};
    	
    	t.threeSum(nums);
    }
    
}
