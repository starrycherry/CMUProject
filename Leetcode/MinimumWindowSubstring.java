package Leetcode;
/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * @author Cherrie
 *
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s==null||s.length()==0||t==null||t.length()==0){
            return "";
        }
        int[] target=new int[256];
        int[] find=new int[256];
        for(int i=0;i<t.length();i++){
            target[t.charAt(i)]++;
        }
        int start=0;
        int end=0;
        int count=0;
        int length=s.length()+1;
        int index1=0;
        int index2=0;
        
        while(end<s.length()){
            if(find[s.charAt(end)]<=target[s.charAt(end)]){
                count++;
            }
            find[s.charAt(end)]++;
            if(count!=t.length()){
                end++;
                continue;
            }
            
            while(start<s.length()){
                if(find[s.charAt(start)]==0){
                    start++;
                    continue;
                }
                if(find[s.charAt(start)]==target[s.charAt(start)]){
                    break;
                }
                find[s.charAt(start)]--;
                start++;
            }
            
            if(length>end-start){
                length=end-start;
                index1=start;
                index2=end;
            }
            end++;
        }
        return length==(s.length()+1)?"":s.substring(index1,index2+1);
    }
	 
	 public static void main(String[] args){
		 MinimumWindowSubstring m=new MinimumWindowSubstring();
		 System.out.println(m.minWindow("acbbd", "ab"));
	 }
}
