package Leetcode;
/**
 * Given an integer, write a function to determine if it is a power of two.
 * @author Cherrie
 *1     2       4         8         16 　　....

1    10    100    1000    10000　....

那么我们很容易看出来2的次方数都只有一个1，剩下的都是0,根据上面分析，
那么它的二进数必然是最高位为1，其它都为0，那么如果此时我们减1的话，则最高位会降一位，其余为0的位现在都为变为1，那么我们把两数相与，就会得到0，用这个性质也能来解题，而且只需一行代码就可以搞定
 */
public class PowerOfTwo {
	 public boolean isPowerOfTwo(int n) {
	        if(n>0&&(n&(n-1))==0){
	            return true;
	        }
	        return false;
	    }
}
