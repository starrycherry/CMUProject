/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 */
package Leetcode;

import java.util.ArrayList;

public class Partition {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
        if(s==null){
            return list;
        }
       
        ArrayList<String> item=new ArrayList<String>();
        partitionHelper(s,list,item);
         if(s.length()!=1&&isPalindrome(s)){
            item=new ArrayList<String>();
            item.add(s);
            list.add(item);
        }
        return list;
    }
    
    private void partitionHelper(String s, ArrayList<ArrayList<String>> list,ArrayList<String> item){
        if(s.length()==0){
            ArrayList<String> newItem=new ArrayList<String>();
            newItem.addAll(item);
            list.add(newItem);
            return;
        }
        
        for(int i=1;i<=s.length();i++){
            String subStr=s.substring(0,i);
            if(isPalindrome(subStr)){
                item.add(subStr);
                String restSubStr=s.substring(i);
                partitionHelper(restSubStr,list,item);
                item.remove(item.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
    
    public static void main(String[] args){
    	Partition p=new Partition();
    	p.partition("bb");
    }
}
