/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
dp:定义dp[i][j]:表示从左上点到[i,j]点所有路径中的最小和
由于只能向下和向右移动，所以[i,j]的最小路径只依赖于[i-1,j]和[i,j-1]两个位置
即dp[i][j]=min(dp[i-1][j]，dp[i][j-1])+grid[i][j]
但是第一行和第一列要特殊处理。 
 */
package Leetcode;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int[][] dp=new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        for(int i=1;i<dp.length;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for(int i=1;i<dp[0].length;i++){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        int sum=dp[dp.length-1][dp[0].length-1];
        return sum;
        
    }
    
    public static void main(String[] args){
    	MinimumPathSum m=new MinimumPathSum();
    	int[][] grid={{1,2},{5,6},{1,1}};
    	System.out.println(m.minPathSum(grid));
    }
}
