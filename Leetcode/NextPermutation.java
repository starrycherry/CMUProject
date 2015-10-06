/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1


这道题是给定一个数组和一个排列，求下一个排列。算法上其实没有什么特别的地方，主要的问题是经常不是一见到这个题就能马上理清思路。下面我们用一个例子来说明，比如排列是(2,3,6,5,4,1)，求下一个排列的基本步骤是这样：
1) 先从后往前找到第一个不是依次增长的数，记录下位置p。比如例子中的3，对应的位置是1;
2) 接下来分两种情况：
    (1) 如果上面的数字都是依次增长的，那么说明这是最后一个排列，下一个就是第一个，其实把所有数字反转过来即可(比如(6,5,4,3,2,1)下一个是(1,2,3,4,5,6));
    (2) 否则，如果p存在，从p开始往后找，找到下一个数就比p对应的数小的数字，然后两个调换位置，比如例子中的4。调换位置后得到(2,4,6,5,3,1)。最后把p之后的所有数字倒序，比如例子中得到(2,4,1,3,5,6), 这个即是要求的下一个排列。
以上方法中，最坏情况需要扫描数组三次，所以时间复杂度是O(3*n)=O(n)，空间复杂度是O(1)。
 */


package Leetcode;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length==0||nums.length==1){
            return;
        }
        int i=nums.length-2;
        for(;i>=0;i--){
            if(nums[i]<nums[i+1]){
                break;
            }
        }
        int p=i;
        if(p==-1||(p==0&&p+1<nums.length&&nums[p]>=nums[p+1])){
            reverse(nums,0);
            return;
        }else{
            int j=p+1;
            for(;j<nums.length;j++){
                if(nums[j]<=nums[p]){
                    break;
                }
            }
            if(j==nums.length||(j==nums.length-1&&nums[j]>nums[p])){
                swap(nums,p,nums.length-1);
            }else{
                swap(nums,p,j-1);
            }
            if(p+1<nums.length-1){
                reverse(nums,p+1);
            }else{
                return;
            }
            
            return;
        }
    }
    
    private void reverse(int[] nums, int index){
        int j=nums.length-1;
        int i=index;
        while(i<j){
            int temp=nums[j];
            nums[j]=nums[i];
            nums[i]=temp;
            i++;
            j=j--;
        }
    }
    
    private void swap(int[] nums,int a, int b){
        int temp=nums[b];
        nums[b]=nums[a];
        nums[a]=temp;
    }
    
    public static void main(String[] args){
    	NextPermutation n=new NextPermutation();
    	int [] nums={5,4,7,5,3,2};
    	n.nextPermutation(nums);
    }
}
