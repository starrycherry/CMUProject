/**
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 * 
 * 以算百位上1为例子:   假设百位上是0, 1, 和 >=2 三种情况: 
    case 1: n=3141092, a= 31410, b=92. 计算百位上1的个数应该为 3141 *100 次.
    case 2: n=3141192, a= 31411, b=92. 计算百位上1的个数应该为 3141 *100 + (92+1) 次. 
    case 3: n=3141592, a= 31415, b=92. 计算百位上1的个数应该为 (3141+1) *100 次. 
以上三种情况可以用 一个公式概括:
(a + 8) / 10 * m + (a % 10 == 1) * (b + 1);
 */

package Leetcode;

public class NumberOfDigitOne {
	    public int countDigitOne(int n) {
	        int ones = 0;
	        for (long m = 1; m <= n; m *= 10) {
	            long a = n/m, b = n%m;
	            ones += (a + 8) / 10 * m;
	            if(a % 10 == 1) ones += b + 1;
	        }
	        return ones;
	}
	
	public static void main(String[] args){
		NumberOfDigitOne n=new NumberOfDigitOne();
		n.countDigitOne(11);
	}
}
