/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

backtracking

N皇后问题是非常经典的问题了，记得当时搞竞赛第一道递归的题目就是N皇后。因为这个问题是典型的NP问题，所以在时间复杂度上就不用纠结了，肯定是指数量级的。下面我们来介绍这个题的基本思路。
主要思想就是一句话：用一个循环递归处理子问题。这个问题中，在每一层递归函数中，我们用一个循环把一个皇后填入对应行的某一列中，如果当前棋盘合法，我们就递归处理先一行，找到正确的棋盘我们就存储到结果集里面。
这种题目都是使用这个套路，就是用一个循环去枚举当前所有情况，然后把元素加入，递归，再把元素移除，这道题目中不用移除的原因是我们用一个一维数组去存皇后在对应行的哪一列，因为一行只能有一个皇后，如果二维数组，
那么就需要把那一行那一列在递归结束后设回没有皇后，所以道理是一样的。
这道题最后一个细节就是怎么实现检查当前棋盘合法性的问题，因为除了刚加进来的那个皇后，前面都是合法的，我们只需要检查当前行和前面行是否冲突即可。检查是否同列很简单，检查对角线就是行的差和列的差的绝对值不
要相等就可以。
 */
package Leetcode;

import java.util.ArrayList;

public class NQueens {
	 public ArrayList<ArrayList<String>> solveNQueens(int n) {
	        ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
	        if(n==0){
	            return list;
	        }
	        int[] columnForRow=new int[n];
	        solveNQueensHelper(n,0,columnForRow,list);
	        return list;
	    }
	    
	    private void solveNQueensHelper(int n,int row,int[] columnForRow,ArrayList<ArrayList<String>> list){
	        if(row==n){
	            ArrayList<String> item=new ArrayList<String>();
	            for(int i=0;i<n;i++){
	                StringBuilder sb=new StringBuilder();
	                for(int j=0;j<n;j++){
	                    if(columnForRow[i]==j){
	                        sb.append("Q");
	                    }else{
	                        sb.append(".");
	                    }
	                }
	                item.add(sb.toString());
	            }
	            list.add(item);
	            return;
	        }
	        
	        for(int i=0;i<n;i++){
	            columnForRow[row]=i;
	            if(check(row,columnForRow)){
	                solveNQueensHelper(n,row+1,columnForRow,list);
	            }
	        }
	       
	    }
	    
	     private boolean check(int row,int[] columnForRow){
	            for(int i=0;i<row;i++){
	                if(columnForRow[i]==columnForRow[row]||Math.abs(columnForRow[i]-columnForRow[row])==row-i){
	                    return false;
	                }
	            }
	            return true;
	        }
	
	public static void main(String[] args){
		NQueens n=new NQueens();
		n.solveNQueens(4);
	}
}
