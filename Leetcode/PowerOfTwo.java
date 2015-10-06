package Leetcode;
/**
 * Given an integer, write a function to determine if it is a power of two.
 * @author Cherrie
 *1     2       4         8         16 ����....

1    10    100    1000    10000��....

��ô���Ǻ����׿�����2�Ĵη�����ֻ��һ��1��ʣ�µĶ���0,�������������
��ô���Ķ�������Ȼ�����λΪ1��������Ϊ0����ô�����ʱ���Ǽ�1�Ļ��������λ�ήһλ������Ϊ0��λ���ڶ�Ϊ��Ϊ1����ô���ǰ��������룬�ͻ�õ�0�����������Ҳ�������⣬����ֻ��һ�д���Ϳ��Ը㶨
 */
public class PowerOfTwo {
	 public boolean isPowerOfTwo(int n) {
	        if(n>0&&(n&(n-1))==0){
	            return true;
	        }
	        return false;
	    }
}
