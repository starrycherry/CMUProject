package Leetcode;

public class JumpGame2 {
	public int jump(int[] A) {
	    if(A==null || A.length==0)
	        return 0;
	    int lastReach = 0;
	    int reach = 0;
	    int step = 0;
	    for(int i=0;i<=reach&&i<A.length;i++)
	    {
	        if(i>lastReach)
	        {
	            step++;
	            lastReach = reach;
	        }
	        reach = Math.max(reach,A[i]+i);
	    }
	    if(reach<A.length-1)
	        return 0;
	    return step;
	}
	
	public static void main(String[] args){
		JumpGame2 j=new JumpGame2();
		int[] A={2,3,1,1,4};
		j.jump(A);
	}
}
