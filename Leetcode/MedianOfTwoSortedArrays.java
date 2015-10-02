package Leetcode;
/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * @author Cherrie
 *
 */
public class MedianOfTwoSortedArrays {
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        int m = nums1.length;
	        int n = nums2.length;
	        int k = m + n;
	        
	        if((k%2)==1)
	        {
	            return find(nums1, 0, m, nums2, 0, n, k/2+1);
	        }else
	            return (find(nums1, 0, m, nums2, 0, n, k/2)+find(nums1, 0, m, nums2, 0, n, k/2+1))/2;
	    }
	    //递归算法，不断缩小两个数组的范围，同时k的值也相对两个搜索区间上限起始点而改变
	    public double find(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd,int kth)
	    {
	    //1. 统一将长度短的放置于find函数参数的前面项
	        if(aEnd>bEnd) 
	            return find(B, bStart, bEnd, A, aStart, aEnd, kth);
	        
	    //2. 长度短的为空，则答案等同于求另外一个数组的中位数
	        if(aEnd<=0) 
	            return B[bStart + kth -1];
	        
	    //3. 递归到终点，两个数组的aStart和bStart已经到了中位数的位置
	        if(kth==1)
	            return min(A[aStart],B[bStart]);
	        
	        int pa = min(kth/2,aEnd), pb = kth-pa;
	        
	        if(A[aStart + pa-1]< B[bStart +pb -1])
	            return find(A, aStart+pa, aEnd-pa, B, bStart, bEnd, kth-pa );
	        else
	            return find(A, aStart, aEnd, B, bStart + pb, bEnd - pb,kth-pb);
	        
	        
	    }
	    public int min(int a, int b)
	    {
	        return a>b?b:a;
	    }
	    
	    public static void main(String[] args) {
	        int[] a = new int[] { 1, 3, 5, 7 };
	        int[] b = new int[] { 2, 4, 6,8 };
	        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(a, b));
	 
	    }
}
