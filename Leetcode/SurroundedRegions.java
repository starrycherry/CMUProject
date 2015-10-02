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

�������˵һ��O��Χ����X��ô���O�͵ñ��X����ô�Ϳ��Է���������һȦ�����O�϶��������ܶ���X��Χ��ͬʱ���OҲ������Ǳ�ڵ��ڲ���O��ȱ�ڣ�
���ڲ���O���ܶ���X���ǡ���ˣ�˼·�����ȶ����ܵ�O�������⴦����BFS�ߣ����������O���ӵ�O���������O����Ϳ��#�������ӣ�����ԭ����������˵��
û�б��#��O��������û�б�O��Ⱦ�ģ����ܶ���X����ô������X��������#������Щԭ����O���ǲ������ܶ���X��Χ�ģ��������ٻ�ԭ��O��

������ǰ���Χ��O��bfs���ϱ�Ǳ��Y�Ĺ���.


��������õ����ĵݹ�,�����������ʱ��,�������overflow,����ֻ�в��ö��е���ʽ,����overflow
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
