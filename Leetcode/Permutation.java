package Leetcode;

import java.util.ArrayList;

public class Permutation {
	 public String getPermutation(int n, int k) {
	        int count=1;
	        StringBuffer sb=new StringBuffer();
	        ArrayList<Integer> list=new ArrayList<Integer>();
	        for(int i=1;i<n+1;i++){
	            list.add(i);
	            sb.append(n-i+1);
	        }
	        for(int i=0;i<n;i++){
	            count*=i+1;
	            if(k<=count){
	            int m=k/(count);
	            int m1=k%(count);
	            if(m1==0){
	            sb=sb.reverse();
	            }else{
	                sb.setCharAt(i+1,(char)(m+1+'0'));
	                list.remove(m);
	                sb.setCharAt(i,(char)(list.get(m1)+'0'));//TBD
	                list.remove(m1-1);
	                int j=i-1;
	                while(j>=0){
	                    sb.setCharAt(j,(char)(list.get(0)+'0'));
	                    list.remove(0);
	                    j--;
	                    }
	                sb=sb.reverse();
	                return sb.toString();
	                }
	        }
	        }
	        sb=sb.reverse();
	        return sb.toString();
	    }
	 
	 public static void main(String[] args){
		 Permutation p=new Permutation();
		 System.out.println(p.getPermutation(4,10));
	 }
}
