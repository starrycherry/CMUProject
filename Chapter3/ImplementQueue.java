package Chapter3;

public class ImplementQueue {
	private int[] A;
	private static int default_capacity;
	private int front;
	private int back;
	private int nItem;
	private int max;
	
	public ImplementQueue(int capacity){
		if(capacity!=0){
			max=capacity;
		}else{
			max=default_capacity;
		}
		A=new int[max];
		front=0;
		back=-1;
		nItem=0;
	}
	
	public void enqueue(int v){
		back++;
		int index=back%max;
		A[index]=v;
		nItem++;
	}
	
	public int dequeue(){
		int index=front%max;
		int v=A[index];
		A[index]=0;
		front++;
		nItem--;
		return v;
	}
	
	public int peek(){
		int index=front%max;
		return A[index];
	}
	
	
}
