/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

1.先确定第一行和第一列是否需要清零
即，看看第一行中是否有0，记下来。也同时记下来第一列中有没有0。
2.扫描剩下的矩阵元素，如果遇到了0，就将对应的第一行和第一列上的元素赋值为0
这里不用担心会将本来第一行或第一列的1改成了0，因为这些值最后注定要成为0的。
3.根据第一行和第一列的信息，已经可以将剩下的矩阵元素赋值为结果所需的值了
即，拿第一行为例，如果扫描到一个0，就将这一列都清0.
4.根据1中确定的状态，处理第一行和第一列。
如果最开始得到的第一行中有0的话，就整行清零。同理对列进行处理。
 */
package Leetcode;

public class SetMatrixZero {
	public void setZeroes(int[][] matrix) {
        if(matrix.length==0){
            return; 
        }
 
        boolean zeroRow=false;
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                zeroRow=true;
            }
        }
        boolean zeroColumn=false;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                zeroColumn=true;
            }
        }
        
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        for(int i=1;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                for(int j=1;j<matrix.length;j++){
                    matrix[j][i]=0;
                }
            }
        }
        
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }
        }
        
          for(int i=0;i<matrix[0].length;i++){
            if(zeroRow){
                matrix[0][i]=0;
            }
        }
         for(int i=0;i<matrix.length;i++){
            if(zeroColumn){
                matrix[i][0]=0;
            }
        }
        
    }
    
    public static void main(String[] args){
    	SetMatrixZero s=new SetMatrixZero();
    	int [][] matrix={{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
    	s.setZeroes(matrix);
    }
}
