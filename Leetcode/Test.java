package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {
	 public void solve(char[][] board) {
	        if(board==null||board.length==0){
	            return;
	        }
	        
	        for(int i=0;i<board[0].length;i++){
	            helper(board,0,i);
	            helper(board,board.length-1,i);
	        }
	        
	        for(int j=0;j<board.length;j++){
	            helper(board,j,0);
	            helper(board,j,board[0].length);
	        }
	        
	        for(int i=0;i<board.length;i++){
	            for(int j=0;j<board[0].length;j++){
	                if(board[i][j]=='O'){
	                    board[i][j]='X';
	                }else if(board[i][j]=='Y'){
	                    board[i][j]='O';
	                }
	            }
	        }
	    }
	    
	    private void helper(char[][] board,int i,int j){
	        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!='O'){
	            return;
	        }
	        
	        board[i][j]='Y';
	        Queue<Integer> q=new LinkedList<Integer>();
	        q.offer(j+i*board[0].length);
	        
	        while(!q.isEmpty()){
	            int n=q.poll();
	            int c=n%board[0].length;
	            int r=n/board[0].length;
	            
	            if(c+1<board[0].length&&board[c+1][r]=='O'){
	                q.offer(n+1);
	                board[r][c+1]='Y';
	            }
	            
	            if(c-1>0&&board[c-1][r]=='O'){
	                q.offer(n-1);
	                board[r][c-1]='Y';
	            }
	            
	            if(r+1<board.length&&board[c][r+1]=='O'){
	                q.offer(n+board[0].length);
	                board[r+1][c]='Y';
	            }
	            
	            if(r-1>0&&board[c][r-1]=='O'){
	                q.offer(n-board[0].length);
	                board[r-1][c]='Y';
	            }
	        }
	    }
    public static void main(String[] args){
    	Test c=new Test();
    	char[][] board={{'O','O','O'},{'O','O','O'},{'O','O','O'}};
    	c.solve(board);
    }
}
