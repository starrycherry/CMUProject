/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.

题目大意：
给定一个二维01矩阵，从中找出最大的全1正方形矩阵并返回其面积。

例如给定题目描述中的矩阵，返回4。

解题思路：
动态规划（Dynamic Programming）

状态转移方程：

dp[x][y] = min(dp[x - 1][y - 1], dp[x][y - 1], dp[x - 1][y]) + 1
上式中，dp[x][y]表示以坐标(x, y)为右下角元素的全1正方形矩阵的最大长度（宽度）
 */
package Leetcode;

public class MaximalSqual {
	 public int maximalSquare(char[][] matrix) {
	        if(matrix.length==0){
	            return 0;
	        }
	        
	        int max=0;
	        int[][] dp=new int[matrix.length][matrix[0].length];
	        for(int i=0;i<matrix.length;i++){
	            if(matrix[i][0]=='1'){
	                dp[i][0]=1;
	                max=1;
	            }
	        }
	        
	        for(int i=0;i<matrix[0].length;i++){
	            if(matrix[0][i]=='1'){
	                dp[0][i]=1;
	                max=1;
	            }
	        }
	       
	       for(int i=1;i<matrix.length;i++){
	           for(int j=1;j<matrix[0].length;j++){
	               if(matrix[i][j]=='0'){
	                   dp[i][j]=0;
	               }else{
	                   dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
	                   max=Math.max(max,dp[i][j]);
	               }
	           }
	       }
	        
	    return max*max;
	        
	    }
}
