package Chapter3;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {
	ArrayList<Stack> stacks=new ArrayList<Stack>();
	int stackIndex=0;
	int max=100;
	
	public SetOfStacks(){
		stacks.set(0,new Stack<Integer>() );
	}
	
	public void push(int v){
		if(stacks.get(stackIndex)!=null&&stacks.get(stackIndex).size()!=max){
			stacks.get(stackIndex).push(v);
		}else if(stacks.get(stackIndex).size()==max){
			stackIndex++;
			stacks.set(stackIndex, new Stack<Integer>());
		}
	}
	
	public int pop(){
		int v=(int) stacks.get(stackIndex).pop();
		
		if(stacks.get(stackIndex).isEmpty()){
			stacks.remove(stackIndex);
		}
		
		return v;
	}
	
	
	
}
