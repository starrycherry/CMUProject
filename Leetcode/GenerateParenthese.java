/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 */
package Leetcode;

import java.util.ArrayList;

public class GenerateParenthese {
	ArrayList<String> list = new ArrayList<String>();
	private void dfs(int length,int maxDep,int leftToken,int leftTokenCount,String s){
		//leftToken为所允许的"<"数目,leftTokenCount为"<"的实际数目
		if(leftTokenCount * 2 > maxDep){//剪枝
			return ;
		}
		if(length == maxDep){
			list.add(s);
			return;
		}
		for(int i = 0; i < 2; i++){
			if(i == 0){
				dfs(length + 1, maxDep, leftToken + 1, leftTokenCount + 1, s + "(");
			}else{
				if(leftToken > 0){
					dfs(length + 1, maxDep, leftToken - 1, leftTokenCount, s + ")");
				}
			}
		}
	}
	
	public ArrayList<String> generateParenthesis(int n) {
		dfs(0, 2*n, 0, 0, "");
		return list;
	}
	
	public static void main(String[] args){
		GenerateParenthese g=new GenerateParenthese();
		g.generateParenthesis(3);
	}
}
