package Leetcode;

public class RotateImage {
	public void rotate(int[][] matrix, int n){
		for(int layer=0;layer<n/2;++layer){
			int first=layer;
			int last=n-1-layer;
			for(int i=first;i<last;++i){
				int offset=i-first;
				//save top
				int top=matrix[first][i];
				
				//left->top
				matrix[first][i]=matrix[last-offset][first];
				
				//bottom->left
				matrix[last-offset][first]=matrix[last][last-offset];
				
				//right->bottom
				matrix[last][last-offset]=matrix[i][last];
				
				//top->right
				matrix[i][last]=top;
			}
		}
	}
	
	public static void main(String[] args){
		RotateImage r=new RotateImage();
		int[][]matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		r.rotate(matrix, 4);
	}
}
