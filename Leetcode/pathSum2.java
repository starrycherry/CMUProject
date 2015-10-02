package Leetcode;

import java.util.ArrayList;

public class pathSum2 {
	  public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
          ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        if(root==null){
            return list;
        }
      
        ArrayList<Integer> item=new ArrayList<Integer>();
        pathSumHelper(root,sum,0,list,item);
        return list;
    }
    
    private void pathSumHelper(TreeNode node, int sum, int pathSum,ArrayList<ArrayList<Integer>> list,ArrayList<Integer> item){
        if(node==null){
            return;
        }
        
        pathSum+=node.val;
        item.add(node.val);
        if(node.left==null&&node.right==null&&sum==pathSum){
            ArrayList<Integer> newItem=new ArrayList<Integer>();
            newItem.addAll(item);
            list.add(newItem);
        }
    
       pathSumHelper(node.left,sum,pathSum,list,item);
       pathSumHelper(node.right,sum,pathSum,list,item);
       pathSum-=node.val;
       item.remove(item.size()-1);
    }
    
    public static void main(String[] args){
    	TreeNode root=new TreeNode(-2);
    	root.right=new TreeNode(-5);
    	pathSum2 p=new pathSum2();
    	p.pathSum(root, -5);
    }
}
