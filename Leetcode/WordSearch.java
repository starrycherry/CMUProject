/**
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

Éî¶ÈËÑË÷
 */

package Leetcode;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board.length==0){
            return false;
        }
        
        if(word==null||word.length()==0){
            return true;
        }
        
        boolean[][] used=new boolean[board.length][board[0].length];
       
        
        for( int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
              if(searchBoard(board,word,0,used,i,j))  
                return true;
            }
        }
        
        
        
        return false;
    }
    
    private boolean searchBoard(char[][] board,String word, int index, boolean[][] used,int i,int j){
        if(index==word.length()){
            return true;
        }
        
        if(i<0||i>board.length-1||j<0||j>board[0].length-1||index>word.length()||used[i][j] || board[i][j]!=word.charAt(index)){
            return false;
        }
        
        if(board[i][j]==word.charAt(index)&&!used[i][j]){
            used[i][j]=true;
            boolean res=searchBoard(board,word,index+1,used,i+1,j)||
            searchBoard(board,word,index+1,used,i-1,j)||
            searchBoard(board,word,index+1,used,i,j+1)||
            searchBoard(board,word,index+1,used,i,j-1);
            used[i][j]=false;
            
            return res;
        }
        
        return false;
    }
    public static void main(String[] args){
    	WordSearch w=new WordSearch();
    	char[][] board={{'a','b'},{'c','d'}};
    	w.exist(board, "");
    }
}
