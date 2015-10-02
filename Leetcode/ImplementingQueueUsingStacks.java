package Leetcode;

import java.util.LinkedList;

public class ImplementingQueueUsingStacks {
    LinkedList<Integer> in=new LinkedList<Integer>();
    LinkedList<Integer> out=new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        in.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int l=in.size();
        for(int i=0;i<l-1;i++){
            out.offer(in.poll());
        }
        in.poll();
        LinkedList<Integer> temp=in;
        in=out;
        out=temp;
    }

    // Get the top element.
    public int top() {
        int l=in.size();
        for(int i=0;i<l-1;i++){
            out.offer(in.poll());
        }
        int res=in.poll();
        out.offer(res);
        LinkedList<Integer> temp=in;
        in=out;
        out=temp;
        return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return in.isEmpty()&&out.isEmpty();
    }
}
