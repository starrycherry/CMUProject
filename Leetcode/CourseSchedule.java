/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

click to show more hints.

Hints:
This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.


 */
package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0||prerequisites.length==0){
            return true;
        }
        
        ArrayList<Set<Integer>> list=new ArrayList<Set<Integer>>();
          for(int i=0;i<numCourses;i++){
           list.add(new HashSet<Integer>());
       }
       
       
        for(int i=0;i<prerequisites.length;i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] indegrees=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int x:list.get(i)){
                indegrees[x]++;
            }
        }
        
        Queue<Integer> q=new LinkedList<Integer>(); 
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                q.offer(i);
            }
        }
        
        int count=0;
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int x:list.get(cur)){
                indegrees[x]--;
                if(indegrees[x]==0){
                    q.add(x);
                }
            }
            count++;
        }
        if(count==numCourses){
            return true;
        }
        return false;
    }
}
