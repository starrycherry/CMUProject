/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 */
package Leetcode;

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0){
            return false;
        }
        
        return searchMatrixHelper(matrix,target,0,matrix.length-1,0,matrix[0].length-1);
    }
    
    private boolean searchMatrixHelper(int [][] matrix,int target, int up, int down, int left, int right){
        if(up<0||down>matrix.length||left<0||right>matrix[0].length||up>down||left>right){
            return false;
        }
        
        if(up!=down){
            int mv=(up+down)/2;
            if(matrix[mv][right]<target){
                return searchMatrixHelper(matrix,target,mv+1,down, left, right);
            }
            if(matrix[mv][right]>target){
                return searchMatrixHelper(matrix,target,up, mv, left, right);
            }
            
            if(matrix[mv][right]==target){
                return true;
            }
        }else{
            int mh=(left+right)/2;
            if(matrix[up][mh]<target){
                return searchMatrixHelper(matrix,target,up, down, mh+1, right);
            }
            
            if(matrix[up][mh]>target){
                return searchMatrixHelper(matrix,target, up, down, left,mh-1);
            }
            
            if(matrix[up][mh]==target){
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args){
    	SearchA2DMatrix s=new SearchA2DMatrix();
    	int[][] matrix={{1}};
    	s.searchMatrix(matrix, 0);
    }
}
