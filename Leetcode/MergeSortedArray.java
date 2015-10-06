/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2
 are m and n respectively.
 
 */
package Leetcode;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1==null&&nums2==null){
            return;
        }
    
        int index1=m-1;
        int index2=n-1;
        int index=n+m-1;
        while(index1>=0&&index2>=0){
            if(nums1[index1]>nums2[index2]){
                nums1[index]=nums1[index1];
                index1--;
                index--;
            }else{
                nums1[index]=nums2[index2];
                index2--;
                index--;
            }
        }
        while(index2>=0){
            nums1[index]=nums2[index2];
            index--;
            index2--;
        }
    }
}
