package Leetcode;

public class SearchForARange {
	  public int[] searchRange(int[] nums, int target) {
	        int left=0;
	        int right=nums.length-1;
	        int mid=(left+right)/2;
	        int[] re={-1,-1};
	        int start=-1;
	        while(left<=right){
	             if(target>nums[mid]){
	                left=mid+1;
	                mid=(left+right)/2;
	            }else if(target<nums[mid]){
	                right=mid-1;
	                mid=(left+right)/2;
	            }else{
	                start=mid;
	                break;
	            }
	        }
	        if(start!=-1){
	            for(int i=left;i<=right;i++){
	                if(target==nums[i]){
	                    if(re[0]==-1){
	                        re[0]=i;
	                        re[1]=i;
	                    }
	                }
	                if(re[0]!=-1&&re[0]!=i&&nums[i]==target){
	                    re[1]=i;
	                }
	            }
	        }
	       return re;
	    }
}
