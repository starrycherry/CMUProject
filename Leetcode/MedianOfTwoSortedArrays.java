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
	    //�ݹ��㷨��������С��������ķ�Χ��ͬʱk��ֵҲ���������������������ʼ����ı�
	    public double find(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd,int kth)
	    {
	    //1. ͳһ�����ȶ̵ķ�����find����������ǰ����
	        if(aEnd>bEnd) 
	            return find(B, bStart, bEnd, A, aStart, aEnd, kth);
	        
	    //2. ���ȶ̵�Ϊ�գ���𰸵�ͬ��������һ���������λ��
	        if(aEnd<=0) 
	            return B[bStart + kth -1];
	        
	    //3. �ݹ鵽�յ㣬���������aStart��bStart�Ѿ�������λ����λ��
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
