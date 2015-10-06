/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

1.��ȷ����һ�к͵�һ���Ƿ���Ҫ����
����������һ�����Ƿ���0����������Ҳͬʱ��������һ������û��0��
2.ɨ��ʣ�µľ���Ԫ�أ����������0���ͽ���Ӧ�ĵ�һ�к͵�һ���ϵ�Ԫ�ظ�ֵΪ0
���ﲻ�õ��ĻὫ������һ�л��һ�е�1�ĳ���0����Ϊ��Щֵ���ע��Ҫ��Ϊ0�ġ�
3.���ݵ�һ�к͵�һ�е���Ϣ���Ѿ����Խ�ʣ�µľ���Ԫ�ظ�ֵΪ��������ֵ��
�����õ�һ��Ϊ�������ɨ�赽һ��0���ͽ���һ�ж���0.
4.����1��ȷ����״̬�������һ�к͵�һ�С�
����ʼ�õ��ĵ�һ������0�Ļ������������㡣ͬ����н��д���
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
