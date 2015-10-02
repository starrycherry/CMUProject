/**
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * dp
 */
package Leetcode;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s==null){
            return null;
        }
        boolean[][] dp=new boolean[s.length()][s.length()];
        int max=0;
        int start=s.length()-1;
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(i==j){
                    dp[i][j]=true;
                   
                }else if((j-i)==1&&s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
                }else if(s.charAt(i)==s.charAt(j)){
                     dp[i][j]=dp[i+1][j-1];
                }
               if(dp[i][j]&&max<(j-i)){
                    max=j-i;
                    start=i;
                    }
               }
            }
            return s.substring(start,start+max+1);
        }
    
    public static void main(String[] args){
    	LongestPalindromicSubstring l=new LongestPalindromicSubstring();
    	System.out.println(l.longestPalindrome("bb"));
    }
}
