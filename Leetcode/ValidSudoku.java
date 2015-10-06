/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

±©Á¦Çó½â
 */
package Leetcode;

public class ValidSudoku {
	 public boolean isValidSudoku(char[][] board) {
	        if(board==null||board.length!=9||board[0].length!=9){
	            return false;
	        }
	        
	        for(int i=0;i<board.length;i++){
	            boolean[] checker=new boolean[9];
	            for(int j=0;j<board[0].length;j++){
	                if(board[i][j]=='.'){
	                    continue;
	                }
	                int n=board[i][j]-'1';
	                if(!checker[n]){
	                    checker[n]=true;
	                }else{
	                    return false;
	                }
	            }
	        }
	          for(int i=0;i<board.length;i++){
	            boolean[] checker=new boolean[9];
	            for(int j=0;j<board[0].length;j++){
	                if(board[j][i]=='.'){
	                    continue;
	                }
	                int n=board[j][i]-'1';
	                if(!checker[n]){
	                    checker[n]=true;
	                }else{
	                    return false;
	                }
	            }
	        }
	        
	       for(int block=0;block<9;block++){
	    	   boolean[] checker=new boolean[9];
	           for(int i=block/3*3;i<block/3*3+3;i++){
	               
	               for(int j=block%3*3;j<block%3*3+3;j++){
	                   if(board[i][j]=='.'){
	                       continue;
	                   }
	                   int n=board[i][j]-'1';
	                   if(!checker[n]){
	                       checker[n]=true;
	                   }else{
	                       return false;
	                   }
	               }
	           }
	       }
	        return true;
	    }
	 
	 public static void main(String[] args){
		 ValidSudoku v=new ValidSudoku();
		 char[][] board={{'.','8','7','6','5','4','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},{'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},
				 {'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}};
		 v.isValidSudoku(board);
	 }
}
