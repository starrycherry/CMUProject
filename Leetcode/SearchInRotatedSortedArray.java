package Leetcode;
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

1）如果target==A[m]，那么m就是我们要的结果，直接返回；
（2）如果A[m]<A[r]，那么说明从m到r一定是有序的（没有受到rotate的影响），那么我们只需要判断target是不是在m到r之间，如果是则把左边缘移到m+1，否则就target在另一半，即把右边缘移到m-1。
（3）如果A[m]>=A[r]，那么说明从l到m一定是有序的，同样只需要判断target是否在这个范围内，相应的移动边缘即可。
 * @author Cherrie
 *
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int l=0;
        int r=nums.length-1;
        
        while(l<=r){
            int m=(l+r)/2;
            
            if(nums[m]==target){
                return m;
            }
            if(nums[m]<nums[r]){
                if(target>nums[m]&&target<=nums[r]){
                     l=m+1;
                }else{
                    r=m-1;
                }
            }else{
                if(target>=nums[l]&&target<nums[m]){
                    r=m-1;
                }else{
                    l=m+1;
                }
            }
        }
        return -1;
    }
}
