package Leetcode;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
���м�һ���������ǿɲ�ҪС������⣬����ⱻ��Ϊ��Google��ϲ�����⡱����Ϊ��google�����г��ֵ�Ƶ�ʷǳ��ߡ�������˵˵�����Ľⷨ��˼·��ά��һ����λ����ÿһλ���м�һ��Ȼ���жϽ�λ������м�������һλ��
����Ϳ��Է����ˣ���Ϊǰ�治��Ҫ�����ˡ���һ��Сϸ�ھ�������������λ��λ��Ȼ���ڣ���ô���Ǳ�������newһ�����飬Ȼ��ѵ�һ��Ϊ����1����Ϊֻ�Ǽ�һ����������λһ����0�����򲻻�����λ������Ϊֻ��Ҫһ��ɨ�裬
�����㷨���Ӷ���O(n)��n������ĳ��ȡ����ռ��ϣ�һ�������O(1)�������������ȫ9����ô����������
 * @author Cherrie
 *
 */
public class PlusOne {
	 public int[] plusOne(int[] digits) {
	       
	        if(digits==null||digits.length==0){
	            return digits;
	        }
	        
	        int carry=1;
	        for(int i=digits.length-1;i>=0;i--){
	            int sum=digits[i]+carry;
	            digits[i]=sum%10;
	            carry=sum/10;
	            if(carry==0){
	                return digits;
	            }
	        }
	        
	        int[] res=new int[digits.length+1];
	        res[0]=1;
	        return res;
	    }
}
