/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
   Dynamic Programming
 */
package Leetcode;

public class UBST {
    public int numTrees(int n) {
        if(n==0){
           return 0;
       }
       int[] f=new int[n+1];
       return numTreesHelper(n,f);
       
   }
   
   private int numTreesHelper(int n,int[] f){
        if(n==0){
           return 1;
       }
       if(f[n]!=0){
           return f[n];
       }
       int sum=0;
       for(int i=0;i<n;i++){
           sum+=numTreesHelper(i,f)*numTreesHelper(n-i-1,f);
       }
       f[n]=sum;
       return f[n];
   }
}
