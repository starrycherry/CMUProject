/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

����˼·�ǣ�s1ȡһ����s2ȡһ���֣�����Ƿ���ƥ��s3��

��̬�滮������dp[i][j]����ʾ��s1ȡǰiλ��s2ȡǰjλ���Ƿ������s3��ǰi+jλ��

��ʼ���ǣ�����s1Ϊ�գ���ôs2ÿһλ��s3ƥ�����dp[0][j]������s2Ϊ�գ���ôs1ÿһλ��s3ƥ�����dp[i][0]��

 

����ͼ���ƥ�䡣���������ԣ� http://blog.csdn.net/u011095253/article/details/9248073

��

��ʲôʱ��ȡTrue��ʲôʱ��ȡFalse�أ�

False��ֱ�ۣ�������Ⱦ���False���

��True�أ����ȵ�һ������������ӵ��ַ���Ҫ����s3�����Ӧ��λ( i + j λ)���ڶ���������֮ǰ�Ǹ�����ҲҪ����True

�ٸ��򵥵�����s1 = ab, s2 = c, s3 = bbc ������s1�Ѿ�ȡ��2λ��c��ûȡ����ʱ��False��ab!=bb��������ȡs2���µ�һλc�������s3�е�c��ȣ�����֮ǰ��False��������һλҲ��False

ͬ�����s1 = ab, s2 = c, s3=abc ��ͬ���ļ��裬s1ȡ��2λ��c��ûȡ����ʱ��True��ab==ab��������ȡs2���µ�һλc,��s3�е�c��ȣ���֮ǰ��һλ����True����ʱ���ǿ��Է�����True ��abc==abc��

�� 
 */
package Leetcode;

public class InterleavingString {
	 public boolean isInterleave(String s1, String s2, String s3) {
	        if(s3.length()!=s1.length()+s2.length()){
	            return false;
	        }
	        
	        boolean[][] dp=new boolean[s1.length()+1][s2.length()+1];
	        dp[0][0]=true;
	        
	        for(int i=1;i<=s1.length();i++){
	            dp[i][0]=dp[i-1][0]&&s1.charAt(i-1)==s3.charAt(i-1);
	        }
	        
	        for(int i=1;i<=s2.length();i++){
	            dp[0][i]=dp[0][i-1]&&s2.charAt(i-1)==s3.charAt(i-1);
	        }
	        
	        for(int i=1;i<=s1.length();i++){
	            for(int j=1;j<=s2.length();j++){
	                dp[i][j]=(dp[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i+j-1)))||(dp[i][j-1]&&(s2.charAt(j-1)==s3.charAt(i+j-1)));
	            }
	        }
	        
	        return dp[s1.length()][s2.length()];
	    }
	  
	  public static void main(String[] args){
		  InterleavingString i=new InterleavingString();
		  i.isInterleave("db","b","cbb");
	  }
}
