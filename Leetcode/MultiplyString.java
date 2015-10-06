/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.

ֱ�ӳ˻����������ÿ�ζ�Ҫ����single digit��ˣ����81�����������
����385 * 97, ���Ǹ�λ=5 * 7��ʮλ=8 * 7 + 5 * 9 ����λ=3 * 7 + 8 * 9 ��
����ÿһλ��һ��Int��ʾ������һ��int[]���档
���������󳤶���num1.len + num2.len������99 * 99����󲻻ᳬ��10000������4λ�͹��ˡ�
���ָ�λ�ں���ģ���������10��0�η�����ϧ��Ӧλ������index����0����n-1����
���Ըɴ��Ȱ�string reverse�˴���������öࡣ
�����ǰ���0Ҫ�����
 */
package Leetcode;

public class MultiplyString {
	 public String multiply(String num1, String num2) {
	        if(num1==null||num2==null){
	            return null;
	        }
	        
	        num1=new StringBuffer(num1).reverse().toString();
	        num2=new StringBuffer(num2).reverse().toString();
	        int[] num3=new int[num1.length()+num2.length()];
	        for(int i=0;i<num1.length();i++){
	            int a=num1.charAt(i)-'0';
	            for(int j=0;j<num2.length();j++){
	                int b=num2.charAt(j)-'0';
	                num3[i+j]+=a*b;
	            }
	        }
	        StringBuffer sb=new StringBuffer();
	        int carry=0;
	        for(int i=0;i<num3.length;i++){
	            int digit=(num3[i]+carry)%10;
	            sb.insert(0,digit);
	            carry=(num3[i]+carry)/10;
	        }
	        
	        while(sb.length()>1&&sb.charAt(0)=='0'){
	            sb.deleteCharAt(0);
	        }
	        
	        return sb.toString();
	    }
}
