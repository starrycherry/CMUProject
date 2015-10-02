/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */


package Leetcode;

import java.util.ArrayList;

public class SummaryRange {
	 public ArrayList<String> summaryRanges(int[] nums) {
	        ArrayList<String> list=new ArrayList<String>();
	        if(nums.length==0){
	            return list;
	        }

	        int start=0;
	        int end=0;
	        while(end<nums.length-1){
	            if(nums[end+1]-nums[end]==1){
	                end++;
	            }else{
	                if(start==end){
	                    list.add(String.valueOf(nums[start]));
	                }else{
	                    list.add(String.valueOf(nums[start])+"->"+String.valueOf(nums[end]));
	                }
	                end++;
	                start=end;
	            }
	        }
	        if(start==end){
	            list.add(String.valueOf(nums[start]));
	        }else{
	            list.add(String.valueOf(nums[start])+"->"+String.valueOf(nums[end]));
	            }
	        return list;
	    }
}
