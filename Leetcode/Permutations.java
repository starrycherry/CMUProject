/**
 * Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

backtracking
 */
package Leetcode;

import java.util.ArrayList;

public class Permutations {
	public ArrayList<ArrayList<Integer>> permute(int[] nums) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        
        if(nums.length==0){
            return null;
        }
        
        boolean isUsed[]=new boolean[nums.length];
        ArrayList<Integer> item=new ArrayList<Integer>();
        permuteHelper(nums,list,item,isUsed);
        
        return list;
    }
    
    private void permuteHelper(int[] nums,ArrayList<ArrayList<Integer>> list, ArrayList<Integer> item, boolean[] isUsed){
        if(item.size()>nums.length){
            return;
        }
        
        if(item.size()==nums.length){
            if(!list.contains(item)){
                ArrayList<Integer> newItem=new ArrayList<Integer>();
                newItem.addAll(item);
                list.add(newItem);
            }
            return;
        }
        
        for(int i=0;i<nums.length;i++){
        	if(isUsed[i]){
                continue;
            }
            item.add(nums[i]);
            permuteHelper(nums,list,item,isUsed);
            item.remove(item.size()-1);
            isUsed[i]=false;
        }
    }
    
    public static void main(String[] args){
    	Permutations p=new Permutations();
    	int[] nums={0,1};
    	p.permute(nums);
    }
}
