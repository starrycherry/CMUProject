/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]

backtracking
 */
package Leetcode;

import java.util.ArrayList;

public class CombinationSum3 {
	  public ArrayList<ArrayList<Integer>> combinationSum3(int k, int n) {
	        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
	        if(n>45||n<6){
	            return list;
	        }
	        ArrayList<Integer> item=new ArrayList<Integer>();
	        combinationSum3Helper(k,n,1,list,item,0);
	        return list;
	    }
	    private void combinationSum3Helper(int k,int n,int start,ArrayList<ArrayList<Integer>> list,ArrayList<Integer> item,int sum){
	        if(item.size()==k){
	            if(sum==n){
	                ArrayList<Integer> newItem=new ArrayList<Integer>();
	                newItem.addAll(item);
	                list.add(newItem);
	            }
	            return;
	        }
	        for(int i=start;i<=9;i++){
	            if(n<i){
	                return;
	            }
	            sum+=i;
	            item.add(i);
	            combinationSum3Helper(k,n,++start,list,item,sum);
	            sum=sum-item.get(item.size()-1);
	            item.remove(item.size()-1);
	        }
	        
	    }
	    
	    public static void main(String[] args){
	    	CombinationSum3 c=new CombinationSum3();
	    	c.combinationSum3(3, 28);
	    }
}
