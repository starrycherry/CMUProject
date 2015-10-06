/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

此题的关键在于事先要找出所有没有前期要求的课程. 
 */
package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CouseSchedule2 {
	 public int[] findOrder(int numCourses, int[][] prerequisites) {
	        ArrayList<Set<Integer>> posts = new ArrayList<Set<Integer>>();   //初始化邻接链表
	        for(int i = 0 ; i < numCourses ; i++){
	            posts.add(new HashSet<Integer>());
	        }
	        
	        for(int i = 0 ; i < prerequisites.length ; i++){  //赋值   set中的为每个list点的后续.
	            posts.get(prerequisites[i][1]).add(prerequisites[i][0]);
	        }
	        
	       
	        int[] indegrees = new int[numCourses];//入度
	        for (int i = 0; i < numCourses; i++) {  
	            for (int x : posts.get(i)) {  
	                indegrees[x]++;  
	            }  
	        }
	        //此种方法不可,因为无法规避,此种情况{{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}},此时{1,9}被输入了两次
	       /* for(int i=0;i<prerequisites.length;i++){
	            indegrees[prerequisites[i][0]]++;
	        }*/
	        
	        LinkedList<Integer> queue = new LinkedList<Integer>();  //入度为0则进入队列.把没有要求的课首先加入队列.
	        for (int i = 0; i < numCourses; i++) {  
	            if (indegrees[i] == 0) {  
	                queue.add(i);  
	            }  
	        }
	        
	        int[] res = new int[numCourses];  
	        int count = 0;  
	        while (!queue.isEmpty()) {  
	            int cur = queue.poll();  //依次循环看那些没有要求的课是否有后续的课,如果有,依次取出,放入队列. 同时以此为顺序,输出结果.
	            for (int x : posts.get(cur)) {  
	                indegrees[x]--;  
	                if (indegrees[x] == 0) {  
	                    queue.add(x);  
	                }  
	            }  
	            res[count++] = cur;  
	        }  
	          
	        if (count == numCourses) return res;  
	        return new int[0];  
	        
	        
	    }
	 
	 public static void main(String[] args){
		 CouseSchedule2 c=new CouseSchedule2();
		 int[][] prerequisites={{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
		 int [] order=c.findOrder(10, prerequisites);
		 int l=order.length;
	 }
}
