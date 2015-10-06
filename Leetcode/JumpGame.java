package Leetcode;

public class JumpGame {
	public boolean canJump(int[] nums) {
        if(nums==null){
            return false;
        }
        return canJumpHelper(nums,0,0);
    }
    
    private boolean canJumpHelper(int[] nums,int index,int min){
        if(index>nums.length){
            return false;
        }
        if(index==nums.length){
            return true;
        }
        for(int i=min;i<=nums[index];i++){
            boolean r=canJumpHelper(nums,index+i,++i);
            if(r){
                return true;
            }
        }
        return false;
    }
    
    //我们用maxlength 维护一个从开始位置能到达的最远距离，然后判断在当前位置是否能够到底最后一个位置和当前位置是否可达，如果两个条件都满足，那么返回true，如果当前位置是0，并且最远距离不能超过当前位置，
    //那么只能返回false 了，更新最远距离
    public boolean canJump1(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(A.length <= 1)
			return true;
		if(A[0] >= (A.length - 1))
			return true;
		int maxlength = A[0];
		if(maxlength == 0)
		    return false;
		for(int i = 1; i < A.length - 1; i++)
		{
			if(maxlength >= i && (i + A[i]) >= A.length - 1)//当前位置可达,并且最后位置可达
				return true;
			if(maxlength <= i && A[i] == 0)//当前位置不可达;
				return false;
			if((i + A[i]) > maxlength)//有更大的length;
				maxlength = i + A[i];
		}
		return false;
    }
    
    public static void main(String[] args){
    	JumpGame j=new JumpGame();
    	int[] nums={3,2,1,0,4};
    	System.out.println(j.canJump1(nums));
    }
}
