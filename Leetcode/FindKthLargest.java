/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.

 */
package Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        return findK(nums,nums.length-k,0,nums.length-1);
    }

    public int findK(int[] nums,int k,int i,int j)
    {
        if(i>=j) return nums[i];
        int m=partition(nums,i,j);
        if(m==k) return nums[m];
        if(m<k)
            return findK(nums,k,m+1,j);
        else
            return findK(nums,k,i,m-1);
    }

    //快速排序中的partition方法
    public int partition(int[] nums,int i,int j){
        int x=nums[i];
        int m=i;
        int n=i+1;
        while(n<=j){
            if(nums[n]<x)
            {
                m++;
                int tmp=nums[m];
                nums[m]=nums[n];
                nums[n]=tmp;
            }
            n++;
        }

        //将x与nums[m]进行互换
        int tmp=nums[m];
        nums[m]=nums[i];
        nums[i]=tmp;

        return m;

    }
    
    public int findKthLargest1(int[] nums, int k) {
        if(nums.length==0||k==0){
            return 0;
        }
        
        return recQuickSort(nums,0,nums.length-1,k);
    }
    
    private int recQuickSort(int[] nums,int left,int right,int k){
        if(right<left){
            return 0;
        }
        int pivot= nums[right];
        int partition=partition(nums,left,right,pivot,k);
        if(partition+1==k){
            return nums[partition];
        }else if(partition+1>k){
            return recQuickSort(nums,left,partition-1, k);
        }else{
            return recQuickSort(nums,partition+1,right,k);
        }
    }
    private int partition(int[] nums, int left, int right, int pivot, int k){
        int leftPointer=left-1;
        int rightPointer=right;
        
        while(true){
            while(leftPointer+1<=right&&nums[++leftPointer]>=pivot);
            while(rightPointer>0&&nums[--rightPointer]<pivot);
            if(leftPointer>=rightPointer) break;
            else{
                swap(nums,leftPointer, rightPointer);
            }
        }
        swap(nums,leftPointer,right);
        return leftPointer;
    }
    
    private void swap(int[] nums, int leftPointer, int rightPointer){
        int temp=nums[leftPointer];
        nums[leftPointer]=nums[rightPointer];
        nums[rightPointer]=temp;
    }
    
    //直接sort更简单
    public int findKthLargest3(int[] nums, int k) {
        if(nums==null||nums.length==0||k==0){
            return 0;
        }
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
  
    public static void main(String[] args){
    	FindKthLargest f=new FindKthLargest();
    	int[] nums={-1,2,0};
    	System.out.println(f.findKthLargest3(nums,3));
    }

}
