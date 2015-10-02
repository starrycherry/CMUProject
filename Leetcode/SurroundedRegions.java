package Leetcode;

import java.util.LinkedList;
import java.util.Queue;
/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

这道题是说一个O周围都是X那么这个O就得变成X。那么就可以发现四周这一圈如果有O肯定不能四周都被X包围，同时这个O也将会是潜在的内部的O的缺口，
让内部的O不能都被X覆盖。因此，思路就是先对四周的O进行特殊处理，用BFS走，把所有这个O连接的O（包括这个O）都涂成#。这样子，对于原来的棋盘来说，
没有变成#的O就是四周没有被O污染的，四周都是X，那么对其变成X。而所有#就是那些原来是O但是不是四周都被X包围的，把它们再还原成O。

这题就是把周围的O用bfs不断标记变成Y的过程.


此题如果用单纯的递归,在数量过大的时候,容易造成overflow,所以只有采用队列的形式,消除overflow
 * @author Cherrie
 *
 */
public class SurroundedRegions {
	 public void solve(char[][] board) {
	        if(board==null||board.length==0){
	            return;
	        }
	        
	        for(int i=0;i<board[0].length;i++){
	            helper(board,0,i);
	            helper(board,board.length-1,i);
	        }
	        
	        for(int i=0;i<board.length;i++){
	            helper(board,i,0);
	            helper(board,i,board[0].length-1);
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
	        Queue<Integer> queue=new LinkedList<Integer>();
	        queue.add(i*board[0].length+j);
	        
	        while(!queue.isEmpty()){
	            int index=queue.poll();
	            int row=index/board[0].length;
	            int column=index%board[0].length;
	            
	            if(column+1<board[0].length&&board[row][column+1]=='O'){
	                queue.offer(index+1);
	                board[row][column+1]='Y';
	            }
	            
	            if(column-1>0&&board[row][column-1]=='O'){
	                queue.offer(index-1);
	                board[row][column-1]='Y';
	            }
	            
	            if(row+1<board.length&&board[row+1][column]=='O'){
	                queue.offer(index+board[0].length);
	                board[row+1][column]='Y';
	            }
	            
	            if(row-1>0&&board[row-1][column]=='O'){
	                queue.offer(index-board[0].length);
	                board[row-1][column]='Y';
	            }
	          
	        }
	        
	       
	    }
}
