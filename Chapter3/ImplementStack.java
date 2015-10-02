package Chapter3;

public class ImplementStack {
	private int top;
	private static int default_capacity=15;
	private int[] A;
	
	public ImplementStack(int capacity){
		if(capacity!=0){
			A=new int[capacity];
		}else{
			A=new int[default_capacity];
		}
	}
	
	public void push(int v) throws Exception{
		if(top==A.length-1) {
			throw new Exception("The stack is overflowed");
		}
		
		top++;
		A[top]=v;
	}
	
	public int pop() throws Exception{
		if(A.length==0){
			throw new Exception("The stack is empty");
		}
		int n=A[top];
		A[top]=0;
		top--;
		return n;
	}
	
	public int peek() throws Exception{
		if(A.length==0){
			throw new Exception("The stack is empty");
		}
		return A[top];
	}
}
