/**
 * There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

所以得另外转换思路了。网上有一种巧妙的解法，只需要两次对数组进行两次扫描。

1）从左往右扫描，如果某个孩子的糖果数少于rating低的左邻居，那么就让他持有比左邻居多1的糖果数。

2）从右往左扫描，如果某个孩子的糖果数少于rating低的优邻居，那么就让他持有比右邻居多1的糖果数。

然后对数组求和即可。
 */

package Leetcode;

public class Candy {
	 public int candy(int[] ratings) {
	        if(ratings==null||ratings.length==0){
	            return 0;
	        }
	        
	        int[] candies=new int[ratings.length];
	        for(int i=0;i<candies.length;i++){
	            candies[i]=1;
	        }
	        
	        for(int i=1;i<candies.length;i++){
	            if(ratings[i]>ratings[i-1]){
	                candies[i]=candies[i-1]+1;
	            }
	        }
	        
	        for(int i=candies.length-2;i>=0;i--){
	            if(ratings[i]>ratings[i+1]){
	                candies[i]=Math.max(candies[i],candies[i+1]+1);
	            }
	        }
	        int sum=0;
	        for(int i=0;i<candies.length;i++){
	            sum+=candies[i];
	        }
	        return sum;
	    }
}
