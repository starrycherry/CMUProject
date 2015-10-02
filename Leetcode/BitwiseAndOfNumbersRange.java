/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
��λ�����ٵ��Ǹ����ֵ�1Ϊ��׼λ.
 */

package Leetcode;

public class BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==0||n==0){
            return 0;
        }
        int i=0;
        while(m!=n&&m!=0){
            m>>=1;
            n>>=1;
            i++;
        }
        
        return m<<i;
    }
}
