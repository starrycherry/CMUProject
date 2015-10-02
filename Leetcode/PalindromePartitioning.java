package Leetcode;

import java.util.ArrayList;
/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 * @author Cherrie
 *
 */
public class PalindromePartitioning {
	 public ArrayList<ArrayList<String>> partition(String s) {
	        ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
	        if(s==null){
	            return list;
	        }
	        
	        ArrayList<String> item=new ArrayList<String>();
	        partitionHelper(s,list,item);
	        return list;
	    }
	    
	    private void partitionHelper(String s, ArrayList<ArrayList<String>> list,ArrayList<String> item){
	        if(s==null||s.length()==0){
	            if(!list.contains(item)){
	                ArrayList<String> newItem=new ArrayList<String>();
	                newItem.addAll(item);
	                list.add(newItem);
	                return;
	            }
	        }
	        
	        for(int i=1;i<=s.length();i++){
	            String sub=s.substring(0,i);
	            if(!isPalindrome(sub)){
	                continue;
	            }
	            item.add(sub);
	            partitionHelper(s.substring(i),list,item);
	            item.remove(item.size()-1);
	        }
	    }
	    
	    private boolean isPalindrome(String s){
	        int left=0;
	        int right=s.length()-1;
	        while(left<right){
	            if(s.charAt(left)!=s.charAt(right)){
	                return false;
	            }
	            left++;
	            right--;
	        }
	        return true;
	    }
}
