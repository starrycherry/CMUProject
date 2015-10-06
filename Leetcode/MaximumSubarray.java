package Leetcode;

public class MaximumSubarray {
	// Kadane算法
	public int maxSubArray(int[] A) {
		int max_ending_here = 0;
		int max_so_far = Integer.MIN_VALUE;

		for(int i = 0; i < A.length; i++){  
			if(max_ending_here < 0) 
				max_ending_here = 0;  
			max_ending_here += A[i];  
			max_so_far = Math.max(max_so_far, max_ending_here);   
		}  
		return max_so_far; 
	}


	/**
	 * 分治法
	 * @param A
	 * @return
	 */
	public int maxSubArray1(int[] A) {
		return divide(A, 0, A.length-1); 
	}

	public int divide(int A[], int low, int high){  
		if(low == high)
			return A[low];  
		if(low == high-1)  
			return Math.max(A[low]+A[high], Math.max(A[low], A[high]));

		int mid = (low+high)/2;  
		int lmax = divide(A, low, mid-1);  
		int rmax = divide(A, mid+1, high); 

		int mmax = A[mid];  
		int tmp = mmax;  
		for(int i = mid-1; i >=low; i--){  
			tmp += A[i];  
			if(tmp > mmax)
				mmax = tmp;  
		}  
		tmp = mmax;  
		for(int i = mid+1; i <= high; i++){  
			tmp += A[i];  
			if(tmp > mmax)
				mmax = tmp;  
		}  
		return Math.max(mmax, Math.max(lmax, rmax));  

	}
	public static void main(String[] args){
		MaximumSubarray m=new MaximumSubarray();
		int[] A={-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(m.maxSubArray1(A));
	}

}
