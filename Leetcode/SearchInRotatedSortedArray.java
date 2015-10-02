package Leetcode;
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

1�����target==A[m]����ôm��������Ҫ�Ľ����ֱ�ӷ��أ�
��2�����A[m]<A[r]����ô˵����m��rһ��������ģ�û���ܵ�rotate��Ӱ�죩����ô����ֻ��Ҫ�ж�target�ǲ�����m��r֮�䣬�����������Ե�Ƶ�m+1�������target����һ�룬�����ұ�Ե�Ƶ�m-1��
��3�����A[m]>=A[r]����ô˵����l��mһ��������ģ�ͬ��ֻ��Ҫ�ж�target�Ƿ��������Χ�ڣ���Ӧ���ƶ���Ե���ɡ�
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
