
/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 

backtracking
 */
package Leetcode;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
	 public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
	        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
	        if(candidates==null||candidates.length==0){
	            return list;
	        }
	        
	        Arrays.sort(candidates);
	        ArrayList<Integer> item=new ArrayList<Integer>();
	        combinationSumHelper(candidates,target,0,list,item,0);
	        return list;
	    }
	    
	    private void combinationSumHelper(int[] candidates,int target,int sum, ArrayList<ArrayList<Integer>> list,ArrayList<Integer> item, int start){
	        if(sum>target){
	            return;
	        }
	        if(sum==target){
	            if(!list.contains(item)){
	                ArrayList<Integer> newItem=new ArrayList<Integer>();
	                newItem.addAll(item);
	                list.add(newItem);
	            }
	            return;
	        }
	        
	        for(int i=start;i<candidates.length;i++){
	            sum+=candidates[i];
	            item.add(candidates[i]);
	            combinationSumHelper(candidates,target,sum,list,item,i);
	            if(sum>=target){
	                sum=sum-candidates[i];
	                item.remove(item.size()-1);
	                break;
	            }
	            sum=sum-candidates[i];
	            item.remove(item.size()-1);
	        }
	    }
	    
	    public static void main(String[] args){
	    	CombinationSum c=new CombinationSum();
	    	int[] candidates={3,4,5,8,23,20,9};
	    	c.combinationSum(candidates, 27);
	    }
}
