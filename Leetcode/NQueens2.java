/**
 * Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.

此题和NQueens解法相似,只是不需要再把string放进去了而已. 
 */
package Leetcode;

public class NQueens2 {
    int total;
    public int totalNQueens(int n) {
        if(n<=0){
            return 0;
        }
        
        int[] columnForRow=new int[n];
        totalNQueensHelper(n,0,columnForRow);
        return total;
    }
    
    private void totalNQueensHelper(int n, int row, int[] columnForRow){
        if(row==n){
            total++;
            return;
        }
        for(int i=0;i<n;i++){
            columnForRow[row]=i;
            if(check(row,columnForRow)){
                totalNQueensHelper(n,row+1,columnForRow);
            }
        }
    }
    
    private boolean check(int row, int[] columnForRow){
        for(int i=0;i<row;i++){
            if(columnForRow[row]==columnForRow[i]||Math.abs(columnForRow[i]-columnForRow[row])==row-i){
                return false;
            }
        }
        return true;
    }
}
