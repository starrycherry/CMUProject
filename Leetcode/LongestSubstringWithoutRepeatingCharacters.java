package Leetcode;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
	
	//Time Limit Exceeds
	   public int lengthOfLongestSubstring(String s) {
	        if(s==null){
	            return 0;
	        }
	        if(s.length()==1){
	            return 1;
	        }
	        
	        int longest=0;
	        int left=0;
	        StringBuffer sb=new StringBuffer();
	        for(int i=0;i<s.length();i++){
	            int index=sb.indexOf(s.substring(i,i+1));
	            if(index==-1){
	                 sb.append(s.charAt(i));
	            }else{
	                left=index+1;
	                sb=new StringBuffer(s.substring(left,i+1));
	            }
	            longest=longest>sb.length()?longest:sb.length();
	           
	        }
	        
	        return longest;
	    }
	 //Time limit exceeds  
	   public int lengthOfLongestSubstring1(String s) {
	        if(s==null){
	            return 0;
	        }
	        if(s.length()==1){
	            return 1;
	        }
	        
	        int longest=0;
	        int left=0;
	        HashSet<Character> set=new HashSet<Character>();
	        for(int i=0;i<s.length();i++){
	            if(!set.contains(s.charAt(i))){
	                 set.add(s.charAt(i));
	            }else{
	                while(left!=s.charAt(i)){
	                    set.remove(s.charAt(left));
	                    left++;
	                }
	                set.remove(s.charAt(left));
	                left++;
	            }
	            longest=longest>set.size()?longest:set.size();
	           
	        }
	        
	        return longest;
	    }
	   
	   public int lengthOfLongestSubstring2(String s) {
		    if(s==null || s.length()==0)
		        return 0;
		    HashSet<Character> set = new HashSet<Character>();
		    int max = 0;
		    int walker = 0;
		    int runner = 0;
		    while(runner<s.length())
		    {
		        if(set.contains(s.charAt(runner)))
		        {
		            if(max<runner-walker)
		            {
		                max = runner-walker;
		            }
		            while(s.charAt(walker)!=s.charAt(runner))
		            {
		                set.remove(s.charAt(walker));
		                walker++;
		            }
		            walker++;
		        }
		        else
		        {
		            set.add(s.charAt(runner));
		        }
		        runner++;
		    }
		    max = Math.max(max,runner-walker);
		    return max;
		}
	   
	   /**
	    * 这题可以用类似于MinimumWindowSubstring的方法. 
	    * @param s
	    * @return
	    */
	    public int lengthOfLongestSubstring3(String s) {
	        if(s==null||s.length()==0){
	            return 0;
	        }
	        int length=0;
	        int[] found=new int[256];
	        int start=0;
	        int end=0;
	        
	        while(end<s.length()){
	            found[s.charAt(end)]++;
	            
	            if(found[s.charAt(end)]>1){
	                while(start<s.length()){
	                    found[s.charAt(start)]--;
	                    start++;
	                
	                if(found[s.charAt(end)]==1){
	                    break;
	                    }
	                }
	            }
	            
	            if(length<end-start){
	                length=end-start;
	            }
	            end++;
	        }
	        return length+1;
	    }
	   public static void main(String[] args){
		   LongestSubstringWithoutRepeatingCharacters l=new LongestSubstringWithoutRepeatingCharacters();
		   l.lengthOfLongestSubstring1("aa");
	   }
}
