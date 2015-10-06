package Leetcode;
/**
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * @author Cherrie
 *
 */
public class ClimingStairs {
    public int climbStairs(int n) {
        int[] stairs=new int[n+1];
        stairs[0]=1;
        stairs[1]=1;
        for(int i=2;i<=n;i++){
            stairs[i]=stairs[i-1]+stairs[i-2];
        }
        return stairs[n];
    }
    
    //更节省空间
	int climbStairs2(int n)  
    {  
        int[] res=new int[3];  
        res[0] = 1;  
        res[1] = 1;  
        for (int i = 2; i <= n; i++)  
        {  
            res[i%3] = res[(i-1)%3] + res[(i-2)%3];  
        }  
        return res[n%3];  
    }  
	
	public static void main(String[] args){
		ClimingStairs c=new ClimingStairs();
		c.climbStairs2(7);
	}
	
}
