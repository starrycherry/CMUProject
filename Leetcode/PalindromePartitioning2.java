/**
 * ���������ȶ��弸�������������⼸������һ����˵����Ϊ�˷�����⣬������ЩΪα��!!!
len  = str.length();   // �ַ����ĳ���

int[] cuts = new int[len + 1]; //cuts���飬cuts[i] ��ʾ �� i ��ͷ��len��β���Ӵ� Ҫ�ﵽ������Ҫ�������и��������������� cuts[0]��������Ҫ�Ľ����
����ʼ�� cuts[i] = len - i, ��Ϊ������ i ��ͷ��len��β���Ӵ�Ҫ�и�������ÿ���ַ�����һ�Ρ�

int[][] matrix = new  int[len][len]; //���ó�һ���ڽӾ������飬������ʾ����˼����matrix[i][j] = true, ��ʾ �Ӵ� sub(i, j) ����������ַ��������ģ�

��ô�ж�matrix[i][j] �Ƿ���������ַ����������ǣ� 



matrix[i+1][j-1] == true (��ʾsub(i+1,j-1)����������ַ���) && str[i] == str[j] 

���� 

j - i < 2 && str[i] == str[j] �������j - i == 1ʱ��Ϊ�����ַ���ȣ����j - i == 0ʱ��Ϊͬһ���ַ��� 



��������������Ƕ���matrix[i][j]���ó�true��������һ�ε�DP���������ǿ��������С���и����

cuts[i] = min{cuts[i], cuts[j+1] + 1};  ״̬ת�Ʒ���ʽ

�������cuts[0] - 1��Ϊ �ַ���str����С���и�����������
 */

package Leetcode;

public class PalindromePartitioning2 {
	   public int minCut(String s) {
	        if(s==null||s.length()<=1){
	            return 0;
	        }
	        
	        int[] cuts=new int[s.length()+1];
	        boolean[][] matrix=new boolean[s.length()][s.length()];
	        for(int i=0;i<s.length();i++){
	            cuts[i]=s.length()-i;
	        }
	        for(int i=s.length()-1;i>=0;i--){
	            for(int j=i;j<s.length();j++){
	                if((j-i<2&&s.charAt(j)==s.charAt(i))||(matrix[i+1][j-1]&&s.charAt(i)==s.charAt(j))){
	                    matrix[i][j]=true;
	                    cuts[i]=Math.min(cuts[i],cuts[j+1]+1);
	                }
	            }
	        }
	        return cuts[0]-1;
	    }
	   
	   public static void main(String[] args){
		   PalindromePartitioning2 p=new PalindromePartitioning2();
		   p.minCut("aab");
	   }
}
