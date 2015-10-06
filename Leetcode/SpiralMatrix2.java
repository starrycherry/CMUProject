package Leetcode;

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n];
        if(n==0){
            return ans;
        }
        
        if(n==1){
            ans[0][0]=1;
            return ans;
        }
        int number=0;
        for(int layer=0;layer<n/2;layer++){
            for(int i=layer;i<n-layer-1;i++){
                ans[layer][i]=++number;
            }
            
            for(int j=layer;j<n-layer-1;j++){
                ans[j][n-layer-1]=++number;
            }
            
            for(int i=n-layer-1;i>layer;i--){
                ans[n-layer-1][i]=++number;
            }
            
            for(int j=n-layer-1;j>layer;j--){
                ans[j][layer]=++number;
            }
        }
        
        if(n%2==1){
            ans[n/2][n/2]=++number;
        }
        return ans;
    }
}
