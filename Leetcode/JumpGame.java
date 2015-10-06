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
    
    //������maxlength ά��һ���ӿ�ʼλ���ܵ������Զ���룬Ȼ���ж��ڵ�ǰλ���Ƿ��ܹ��������һ��λ�ú͵�ǰλ���Ƿ�ɴ����������������㣬��ô����true�������ǰλ����0��������Զ���벻�ܳ�����ǰλ�ã�
    //��ôֻ�ܷ���false �ˣ�������Զ����
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
			if(maxlength >= i && (i + A[i]) >= A.length - 1)//��ǰλ�ÿɴ�,�������λ�ÿɴ�
				return true;
			if(maxlength <= i && A[i] == 0)//��ǰλ�ò��ɴ�;
				return false;
			if((i + A[i]) > maxlength)//�и����length;
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
