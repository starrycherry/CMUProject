/**
 * Given a positive integer, print the next smallest and the next largest number that have the same number of 1 bits in their binary representation
 */
package Chapter5;

public class Item5_3 {
	public int printNext(int n){
		int c=n;
		int c0=0;
		int c1=0;
		
		while(((c&1)==0)&&c!=0){
			c0++;
			c0>>=1;
		}
		
		while((c&1)==1){
			c1++;
			c1>>=1;
		}
		
		int p=c1+c0;
		if(p==31||p==0){
			return -1;
		}
		
		int r=n|(1<<p);
		r=r|(~((1<<p)-1));
		return r|(1<<(c1-1)-1);
	}
	
	public int printPrev(int n){
		int c=n;
		int c0=0;
		int c1=0;
		
		while((c&1)==1){
			c1++;
			c>>=1;
		}
		
		if(c==0) return -1;
		
		while((c&1)==0&&c!=0){
			c0++;
			c0>>=1;
		}
		
		int p=c0+c1;
		
		int r=n|(0<<p);
		r|=(~(1<<p)-1);
		return r|(1<<(c1+1)-1);
		
		
	}
}
