package Chapter1;

import java.util.Arrays;

public class Permutation {
	public boolean checkPermutation(String a, String b){
		if(a.length()!=b.length())
			return false;
		char[] aArray=a.toCharArray();
		char[] bArray=b.toCharArray();
		Arrays.sort(aArray);
		Arrays.sort(bArray);
		return Arrays.equals(aArray,bArray );
	}
	
	public boolean checkPermutation2(String a, String b){
		if(a.length()!=b.length())
			return false;
		int[] count=new int[256];
		
		for(int i=0;i<a.length();i++){
			count[a.charAt(i)]++;
		}
		
		for(int i=0;i<b.length();i++){
			count[b.charAt(i)]--;
			if(count[b.charAt(i)]<0)
				return false;
		}
		
		return true;
	}
}
