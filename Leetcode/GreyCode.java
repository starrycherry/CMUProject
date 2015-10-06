package Leetcode;

import java.util.ArrayList;

public class GreyCode {
    public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		if (n <= 0) {
			if(n == 0)return list;
			else return new ArrayList<Integer>();
		}
			list.add(1);
		for (int i = 1; i < n; i++) {
			ArrayList<Integer> newList = new ArrayList<Integer>();
			for (int j = 0; j < list.size(); j++) {
				newList.add(list.get(j));
			}
			for (int k = list.size() - 1; k >= 0; k--) {
				newList.add((int) Math.pow(2, i) + list.get(k));
			}
			list = newList;
		}
		return list;
	}
    
    public static void main(String[] args){
    	GreyCode g=new GreyCode();
    	g.grayCode(3);
    }
}
