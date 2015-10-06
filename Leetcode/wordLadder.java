package Leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
/**
 * Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 * @author Cherrie
 *
 */
public class wordLadder {
	   public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
	        if(beginWord==null||endWord==null||wordDict==null||wordDict.size()==0){
	            return 0;
	        }
	        
	        Queue<String> queue=new LinkedList<String>();
	        queue.offer(beginWord);
	        wordDict.remove(beginWord);
	        int length=1;
	        
	        while(!queue.isEmpty()){
	            int count=queue.size();
	            
	            for(int j=0;j<count;j++){
	            String cur=queue.poll();
	            
	            for(int i=0;i<cur.length();i++){
	                for(char c='a';c<='z';c++){
	                    if(c==cur.charAt(i)){
	                        continue;
	                    }
	                    
	                    String temp=replace(cur,i,c);
	                    if(temp.equals(endWord)){
	                        return length+1;
	                    }
	                    
	                    if(wordDict.contains(temp)){
	                        queue.offer(temp);
	                        wordDict.remove(temp);
	                    }
	                }
	            }
	            }
	            length++;
	        }
	        return 0;
	    }
	    
	    private String replace(String s,int i,char c){
	        char[] array=s.toCharArray();
	        array[i]=c;
	        return new String(array);
	    }
}
