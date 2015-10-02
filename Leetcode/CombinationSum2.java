/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
 */

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum2 {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        if(candidates.length==0){
            return list;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> item=new ArrayList<Integer>();
        combinationSum2Helper(candidates,target,list,item,0,0,candidates.length);
        return list;
    }
    
    private void combinationSum2Helper(int[] candidates,int target, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> item, int sum,int index,int right){
        if(sum==target){
            if(!list.contains(item)){
                ArrayList<Integer> newItem=new ArrayList<Integer>();
                newItem.addAll(item);
                list.add(newItem);
            }
            
            return;
        }
        
        if(sum>target){
            return;
        }
        
        for(int i=index;i<right;i++){
            if(target<candidates[i]){
                right=candidates[i];
                return; 
            }
            sum+=candidates[i];
            item.add(candidates[i]);
            combinationSum2Helper(candidates,target,list,item,sum, i+1,right);
            sum-=candidates[i];
            item.remove(item.size()-1);
        }
    }
    
    public static void main(String[] args){
    	CombinationSum2 c=new CombinationSum2();
    	int[] candidates={1,2};
    	c.combinationSum2(candidates, 4);
    }
    
}
