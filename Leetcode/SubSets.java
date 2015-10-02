/**
 * Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

backtracking
 */

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSets {
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        if(nums.length==0){
            return list;
        }
        
        ArrayList<Integer> item=new ArrayList<Integer>();
        Arrays.sort(nums);
        subsetsHelper(nums,list,item,0);
        
        return list;
    }
    
    private void subsetsHelper(int[] nums, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> item, int index){
        if(index>nums.length){
            return;
        }
        
        if(!list.contains(item)){
            ArrayList<Integer> newItem=new ArrayList<Integer>();
            newItem.addAll(item);
            list.add(newItem);
        }
        
        for(int i=index;i<nums.length;i++){
            item.add(nums[i]);
            subsetsHelper(nums,list,item,i+1);
            item.remove(item.size()-1);
        }
    }
    
    public static void main(String[] args){
    	SubSets s=new SubSets();
    	int[] nums={0};
    	s.subsets(nums);
    }
}
