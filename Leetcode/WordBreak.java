/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
使用dp,dp[i]表示s.substring(0,i),如果这个string在worDict存在为true,否则为false;
 */

package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	   public boolean wordBreak(String s, Set<String> wordDict) {
	        boolean[] t=new boolean[s.length()+1];
	        t[0]=true;
	        for(int i=0;i<s.length();i++){
	            if(!t[i]){
	                continue;
	            }
	            for(String x:wordDict){
	                int end=i+x.length();
	                if(end>s.length()){
	                    continue;
	                }
	                if(t[end]){
	                    continue;
	                }
	                if(s.substring(i,end).equals(x)){
	                    t[end]=true;
	                }
	            }
	        }
	        return t[s.length()];
	    }
	   
	   public static void main(String[] args){
		   WordBreak w=new WordBreak();
		   String s="leetcode";
		   Set<String> wordDict=new HashSet<String>();
		   wordDict.add("leet");
		   wordDict.add("code");
		   System.out.println(w.wordBreak(s, wordDict));
		   
	   }
}
