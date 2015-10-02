package Leetcode;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
此题的关键是使用双向链表和map;
将最常用的放在链表的最后,链表的最前部是最不常用的.
每次存取都把所存取的内容放链表的最后进行处理,最后剩下的表头总是最不常用的.
 * @author Cherrie
 *
 */
public class LRUCache {
	 class Node {
	    	Node pre;
	    	Node next;
	    	Integer key;
	    	Integer val;
	    	
	    	Node(Integer k, Integer v) {
	    		key = k;
	    		val = v;
	    	}
	    }
	    
	    Map<Integer, Node> map = new HashMap<Integer, Node>();
	    // The head (eldest) of the doubly linked list.
	    Node head;
	    // The tail (youngest) of the doubly linked list.
	    Node tail;
	    int cap;
	    public LRUCache(int capacity) {
	        cap = capacity;
	        head = new Node(null, null);
	        tail = new Node(null, null);
	        head.next = tail;
	        tail.pre = head;
	    }
	    
	    public int get(int key) {
	        Node n = map.get(key);
	        if(n!=null) {
	        	n.pre.next = n.next;
	        	n.next.pre = n.pre;
	        	appendTail(n);
	        	return n.val;
	        }
	        return -1;
	    }
	    
	    public void set(int key, int value) {
	        Node n = map.get(key);
	        // existed
	        if(n!=null) {
		        n.val = value;
		        map.put(key, n);
	        	n.pre.next = n.next;
	        	n.next.pre = n.pre;
	        	appendTail(n);
	        	return;
	        }
	        // else {
	        if(map.size() == cap) {
	        	Node tmp = head.next;
	        	head.next = head.next.next;
	        	head.next.pre = head;
	        	map.remove(tmp.key);
	        }
	        n = new Node(key, value);
	        // youngest node append taill
	        appendTail(n);
	        map.put(key, n);
	    }

	    private void appendTail(Node n) {
	    	n.next = tail;
	    	n.pre = tail.pre;
	    	tail.pre.next = n;
	    	tail.pre = n;
	    }
    
    public static void main(String[] args){
    	LRUCache l=new LRUCache(2);
    	l.set(2, 1);
    	l.set(2, 2);
    	l.get(2);
    	l.set(1, 1);
    	l.set(4, 1);
    	l.get(2);
    }
}
