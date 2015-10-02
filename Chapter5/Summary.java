package Chapter5;

public class Summary {
	
	public boolean getBit(int n, int i){
		 return (n&(1<<i))!=0;
	}

	public int setBit(int n,int i){
		return n|(1<<i);
	}
	
	public int clearBit(int n,int i){
		int mask=~(1<<i);
		return n&mask;
	}
	
	/**
	 * clear all bits from the most significant bit through i (inclusive)
	 */
	public int clearBitsMSBthroughI(int n,int i){
		int mask=(1<<i)-1;
		return n&mask;
	}
	
	/**
	 * clear all bits from i through 0(inclusive)
	 */
	public int clearBitsIthrough0(int n, int i){
		int mask=~((1<<(i+1))-1);
		return n&mask;
	}
	
	int updateBit(int n, int i, int v){
		int mask=~(1<<i);
		return (n&mask)|(v<<i);
	}
}
