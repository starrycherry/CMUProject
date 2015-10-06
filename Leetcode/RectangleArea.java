package Leetcode;
/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
求出overlap的区域,然后剪去,就可以了;
 * @author Cherrie
 *
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int l1=C-A;
        int w1=D-B;
        long area1=(long)l1*w1;
        
        int l2=G-E;
        int w2=H-F;
        long area2=l2*w2;
        
        long area3=0;
        if(C<=E||A>=G||B>=H||D<=F){
            area3=0;
        }else{
            area3=(Math.min(C,G)-Math.max(A,E))*(Math.min(D,H)-Math.max(B,F));
        }
       
        long ans=area1+area2-area3;
        return (int)ans;
    }
}
