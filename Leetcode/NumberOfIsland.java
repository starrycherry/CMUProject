/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
 */
package Leetcode;

public class NumberOfIsland {
	    public int numIslands(char[][] grid) {
	        if(grid == null || grid.length == 0 || grid[0].length == 0){
	            return 0;
	        }
	        
	        int cnt = 0;
	        for(int i = 0;i< grid.length;i++){
	            for(int j = 0;j<grid[0].length;j++){
	                if(grid[i][j] == '1'){
	                    dfs(grid,i,j,grid.length-1,grid[0].length - 1);
	                    cnt++;
	                }
	            }
	        }
	        return cnt;
	    }
	    
	    private void dfs(char[][] grid,int i,int j,int m,int n){
	        if(i > m || i < 0 || j > n || j < 0 || grid[i][j] != '1')
	            return;
	        
	        grid[i][j] = '0';
	        
	        dfs(grid,i,j+1,m,n);
	        dfs(grid,i,j-1,m,n);
	        dfs(grid,i+1,j,m,n);
	        dfs(grid,i-1,j,m,n);
	        
	        return;
	    }

	
	public static void main(String[] args){
		NumberOfIsland n=new NumberOfIsland();
		char[][] grid={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		System.out.println(n.numIslands(grid));
	}
}
