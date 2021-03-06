package Leetcode;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
进行加一操作。但是可不要小看这个题，这个题被称为“Google最喜欢的题”，因为在google面试中出现的频率非常高。我们先说说这道题的解法。思路是维护一个进位，对每一位进行加一，然后判断进位，如果有继续到下一位，
否则就可以返回了，因为前面不需要计算了。有一个小细节就是如果到了最高位进位仍然存在，那么我们必须重新new一个数组，然后把第一个为赋成1（因为只是加一操作，其余位一定是0，否则不会进最高位）。因为只需要一次扫描，
所以算法复杂度是O(n)，n是数组的长度。而空间上，一般情况是O(1)，但是如果数是全9，那么是最坏情况，需
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
