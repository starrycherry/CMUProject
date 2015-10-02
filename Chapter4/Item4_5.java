/**
 * implement a function to check if a binary tree is a binary search tree
 */
package Chapter4;

import java.util.ArrayList;

public class Item4_5 {
	static int index;
	public static void copyBST(Node root,int[] array){
		if(root==null) return;
		copyBST(root.left,array);
		array[index]=root.key;
		index++;
		copyBST(root.right,array);		
	}
	
	public static boolean checkBST(Node root){
		 int[] array=new int[100];
		 copyBST(root,array);
		 for(int i=1;i<array.length;i++){
			 if(array[i]<array[i-1]){
				 return false;
			 }
		 }
		 return true;
	}

}
