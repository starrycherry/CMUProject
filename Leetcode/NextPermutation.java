/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 �� 1,3,2
3,2,1 �� 1,2,3
1,1,5 �� 1,5,1


������Ǹ���һ�������һ�����У�����һ�����С��㷨����ʵû��ʲô�ر�ĵط�����Ҫ�������Ǿ�������һ��������������������˼·������������һ��������˵��������������(2,3,6,5,4,1)������һ�����еĻ���������������
1) �ȴӺ���ǰ�ҵ���һ����������������������¼��λ��p�����������е�3����Ӧ��λ����1;
2) �����������������
    (1) �����������ֶ������������ģ���ô˵���������һ�����У���һ�����ǵ�һ������ʵ���������ַ�ת��������(����(6,5,4,3,2,1)��һ����(1,2,3,4,5,6));
    (2) �������p���ڣ���p��ʼ�����ң��ҵ���һ�����ͱ�p��Ӧ����С�����֣�Ȼ����������λ�ã����������е�4������λ�ú�õ�(2,4,6,5,3,1)������p֮����������ֵ��򣬱��������еõ�(2,4,1,3,5,6), �������Ҫ�����һ�����С�
���Ϸ����У�������Ҫɨ���������Σ�����ʱ�临�Ӷ���O(3*n)=O(n)���ռ临�Ӷ���O(1)��
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
