/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.

直接乘会溢出，所以每次都要两个single digit相乘，最大81，不会溢出。
比如385 * 97, 就是个位=5 * 7，十位=8 * 7 + 5 * 9 ，百位=3 * 7 + 8 * 9 …
可以每一位用一个Int表示，存在一个int[]里面。
这个数组最大长度是num1.len + num2.len，比如99 * 99，最大不会超过10000，所以4位就够了。
这种个位在后面的，不好做（10的0次方，可惜对应位的数组index不是0而是n-1），
所以干脆先把string reverse了代码就清晰好多。
最后结果前面的0要清掉。
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
