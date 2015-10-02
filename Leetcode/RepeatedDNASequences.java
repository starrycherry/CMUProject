/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
 */
package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class RepeatedDNASequences {
	 public ArrayList<String> findRepeatedDnaSequences(String s) {
	        ArrayList<String> res=new ArrayList<String>();
	        if(s==null){
	            return res;
	        }
	        
	        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	        
	        for(int i=0;i<=s.length()-10;i++){
	            String subStr=s.substring(i,i+10);
	            int curint=transfer(subStr);
	            if(!map.containsKey(curint)){
	                map.put(curint,1);
	            }else{
	                if(map.get(curint)==1){
	                    res.add(subStr);
	                }
	                map.put(curint, map.get(curint)+1);
	            }
	        }
	        return res;
	    }
	    
	    private int transfer(String s){
	        int res=0;
	        for(int i=0;i<s.length();i++){
	            res*=10;
	            switch(s.charAt(i)){
	                case 'A': {res+=1;break;}
	                case 'C': {res+=2;break;}
	                case 'G': {res+=3;break;}
	                case 'T': {res+=4;break;}
	            }
	        }
	        return res;
	    }
	    
	    public static void main(String[] args){
	    	RepeatedDNASequences r=new RepeatedDNASequences();
	    	r.findRepeatedDnaSequences("AAAAAAAAAAA");
	    }
}
