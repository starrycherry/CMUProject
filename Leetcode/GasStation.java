/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.

1 ��i��ʼ��j�ǵ�ǰstation��ָ�룬sum += gas[j] �C cost[j] ����jվ�����ͣ������ϴ�i��ʼ�ߵ�jʣ���ͣ��ߵ�j+1վ����ʣ�¶����ͣ�
2 ���sum < 0��˵����i��ʼ�ǲ��еġ����ܲ��ܴ�i..j�м��ĳ��λ�ÿ�ʼ�أ������ܴ�k (i <=k<=j)�ߣ���ôi..j < 0����k..j >=0��˵��i..k �C 1����<0���Ǵ�k������öϿ��ˣ������ֲ���j��
3 ����һ��sum<0��i�͸���j + 1��sum���㡣
4 ���total��ʾ�ܲ�����һȦ��
 */
package Leetcode;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0;
        int total=0;
        int index=-1;
        for(int i=0;i<gas.length;i++){
            sum+=gas[i]-cost[i];
            total+=gas[i]-cost[i];
            if(sum<0){
                index=i;
                sum=0;
            }
           
        }
         if(total<0){
                return -1; 
            }else{
                return index+1;
            }
    }
}
