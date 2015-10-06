/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
] 
 */
package Leetcode;

public class Matrix2 {
    public int[][] generateMatrix(int n) {
        int [][] matrix=new int[n][n];
        if(n==0){
            return matrix;
        }
        
        if(n==1){
            matrix[0][0]=1;
            return matrix;
        }
        
        int levelNumber=n/2;
       
        int number=0;
        for(int level=0;level<levelNumber;level++){
            for(int i=level;i<n-level-1;i++){
                matrix[level][i]=++number;
            }
            
            for(int i=level;i<n-level-1;i++){
                matrix[i][n-level-1]=++number;
            }
            
            for(int i=n-level-1;i>level;i--){
                matrix[n-level-1][i]=++number;
            }
            
            for(int i=n-level-1;i>level;i--){
                matrix[i][level]=++number;
            }
        }
        
        if(n%2==1){
            matrix[levelNumber][levelNumber]=++number;
        }
        
        return matrix;
    }
    
    public static void main(String[] args){
    	Matrix2 m=new Matrix2();
    	m.generateMatrix(4);
    }
}
