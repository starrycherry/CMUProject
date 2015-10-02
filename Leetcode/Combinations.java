/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
package Leetcode;

import java.awt.List;
import java.util.ArrayList;

public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<Integer> item=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        if(n<=0||k>n)
        {return null;}
        backtrack(n,k,1,item,list);
        return list;
    }
    
    private void backtrack(int n, int k, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> list)
    {
        if (item.size()==k){
        	 ArrayList<Integer> itemNew=new ArrayList<Integer>();
             itemNew.addAll(item);
             list.add(itemNew);
            return;
        }
       for(int i=start;i<=n;i++){
           item.add(i);
           backtrack(n,k,i+1,item,list);
           item.remove(item.size()-1);
       }
    }
	    public static void main(String[] args){
	    	Combinations c=new Combinations();
	    	c.combine(1, 1);
	    }
	    
}
