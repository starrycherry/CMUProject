package Leetcode;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        
        int l=0;
        int r=nums.length-1;
        int min=nums[0];
        while(l<r-1){
            int m=(l+r)/2;
            if(nums[l]<nums[m]){
                min=Math.min(nums[l],min);
                l=m+1;
            }else if(nums[l]>nums[m]){
                min=Math.min(nums[m],min);
                r=m-1;
            }else{
            	l++;
            }
        }
        min=Math.min(nums[r],min);
        min=Math.min(nums[l],min);
        return min;
    }
    
    public static void main(String[] args){
    	FindMinimumInRotatedSortedArray f=new FindMinimumInRotatedSortedArray();
    	int[] nums={6,7,0,1,2,4,5};
    	f.findMin(nums);
    }
}
