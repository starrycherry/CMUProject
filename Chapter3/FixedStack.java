package Chapter3;

public class FixedStack {
	public int stackSize=100;
	public int stackNumber;
	public int[] stackPointer={-1,-1,-1};
	public int[] stackBuffer=new int[stackSize*3];
	
	public void push(int stackNumber,int v){
		if(stackPointer[stackNumber]+1>=stackSize) return;
		stackPointer[stackNumber]++;
		stackBuffer[stackSize*stackNumber+stackPointer[stackNumber]]=v;
	}
	
	public int pop(){
		if(stackPointer[stackNumber]==-1) return 0;
		int v=stackBuffer[stackSize*stackNumber+stackPointer[stackNumber]];
		stackPointer[stackNumber]--;
		stackBuffer[stackSize*stackNumber+stackPointer[stackNumber]]=0;
		return v;
	}
	
	
}
