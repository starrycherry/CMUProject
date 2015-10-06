package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {
	  // Push element x onto stack.
    Queue<Integer> in=new LinkedList<Integer>();
    Queue<Integer> out=new LinkedList<Integer>();
    public void push(int x) {
        in.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(in.size()!=1){
            out.offer(in.poll());
        }
        in.poll();
        in=out;
        out=new LinkedList<Integer>();
    }

    // Get the top element.
    public int top() {
         while(in.size()!=1){
            out.offer(in.poll());
        }
        int ans=in.poll();
        in=out;
        out=new LinkedList<Integer>();
        return ans;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(in.isEmpty()&&out.isEmpty()){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
    	Test c=new Test();
    	//char[][] board={{'O','O','O'},{'O','O','O'},{'O','O','O'}};
    	c.push(1);
    	c.push(2);
    	c.top();
    	c.pop();
    	c.pop();
    	c.empty();
    }
}
