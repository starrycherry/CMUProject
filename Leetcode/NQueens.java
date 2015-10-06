/**
 * The n-queens puzzle is the problem of placing n queens on an n��n chessboard such that no two queens attack each other.



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

N�ʺ������Ƿǳ�����������ˣ��ǵõ�ʱ�㾺����һ���ݹ����Ŀ����N�ʺ���Ϊ��������ǵ��͵�NP���⣬������ʱ�临�Ӷ��ϾͲ��þ����ˣ��϶���ָ�������ġ��������������������Ļ���˼·��
��Ҫ˼�����һ�仰����һ��ѭ���ݹ鴦�������⡣��������У���ÿһ��ݹ麯���У�������һ��ѭ����һ���ʺ������Ӧ�е�ĳһ���У������ǰ���̺Ϸ������Ǿ͵ݹ鴦����һ�У��ҵ���ȷ���������Ǿʹ洢����������档
������Ŀ����ʹ�������·��������һ��ѭ��ȥö�ٵ�ǰ���������Ȼ���Ԫ�ؼ��룬�ݹ飬�ٰ�Ԫ���Ƴ��������Ŀ�в����Ƴ���ԭ����������һ��һά����ȥ��ʺ��ڶ�Ӧ�е���һ�У���Ϊһ��ֻ����һ���ʺ������ά���飬
��ô����Ҫ����һ����һ���ڵݹ���������û�лʺ����Ե�����һ���ġ�
��������һ��ϸ�ھ�����ôʵ�ּ�鵱ǰ���̺Ϸ��Ե����⣬��Ϊ���˸ռӽ������Ǹ��ʺ�ǰ�涼�ǺϷ��ģ�����ֻ��Ҫ��鵱ǰ�к�ǰ�����Ƿ��ͻ���ɡ�����Ƿ�ͬ�кܼ򵥣����Խ��߾����еĲ���еĲ�ľ���ֵ��
Ҫ��ȾͿ��ԡ�
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
