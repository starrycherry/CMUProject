/**
 * Write a function to determine the number of bits required to convert integer A to integer B.
 */
package Chapter5;

public class Item5_5 {
	public int bitSwapRequired(int a, int b){
		int count=0;
		for(int i=a^b;i!=0;i=i&(i-1)){
			count++;
		}
		return count;
	}
}
