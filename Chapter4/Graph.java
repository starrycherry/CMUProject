package Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;


class GraphNode{
	boolean visit=false;
	ArrayList<GraphNode> adjacent=new ArrayList<GraphNode>();
}
public class Graph {
	public void searchDFS(GraphNode root){
		root.visit=true;
		
		for(int i=0;i<root.adjacent.size();i++){
			if(root.adjacent.get(i).visit!=true){
				searchDFS(root.adjacent.get(i));
			}
		}
	}

	public void searchBFS(GraphNode root){
		root.visit=true;
		LinkedList<GraphNode> q= new LinkedList<GraphNode>();
		q.add(root);
		
		while(!q.isEmpty()){
			GraphNode node=q.getFirst();
			
			for(int i=0;i<node.adjacent.size();i++){
				if(node.visit!=true){
					node.visit=true;
					searchBFS(node);
				}
			}
		}
	}
}
