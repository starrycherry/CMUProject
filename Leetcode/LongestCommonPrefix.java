/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 此题用array中的第一个元素和剩余元素做比较
 */
package Leetcode;

public class LongestCommonPrefix {
	    public String longestCommonPrefix(String[] strs) {
	        int n = strs.length;
	        if(n<1)
	            return "";
	        int len0 = strs[0].length();
	        int i, j;
	        outer: for (i = 0; i < len0; i++) {
	            char cur = strs[0].charAt(i);
	            for (j = 1; j < n; j++) {
	                if (i >= strs[j].length() || strs[j].charAt(i) != cur) {
	                    break outer;
	                }
	 
	            }
	        }
	        return strs[0].substring(0, i);
	 
	    }
	 
	    public static void main(String[] args) {
	    	LongestCommonPrefix l=new LongestCommonPrefix();
	       /* System.out.println(l.longestCommonPrefix(new String[] {
	                "abbasda", "abb", "abbc" }));*/
	        System.out.println(l.longestCommonPrefix(new String[] {
	                "", "ab", "ac" }));
	        System.out.println(l.longestCommonPrefix(new String[] { "abc" }));
	        System.out.println(l.longestCommonPrefix(new String[] {}));
	 
	    }
}
