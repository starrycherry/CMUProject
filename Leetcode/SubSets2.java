package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSets2 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        if(nums.length==0){
            return list;
        }
        Arrays.sort(nums);
        ArrayList<Integer> item=new ArrayList<Integer>();
        subsetsWithDupHelper(nums,list,item,0);
        return list;
    }
    
    private void subsetsWithDupHelper(int[]nums,ArrayList<ArrayList<Integer>> list,ArrayList<Integer> item,int index){
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
            subsetsWithDupHelper(nums,list,item,i+1);
            item.remove(item.size()-1);
        }
    }
}
