package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams {
	public ArrayList<String> anagrams(String[] strs) {
        HashMap<String,ArrayList<String>> table=new HashMap<String, ArrayList<String>>();
        ArrayList<String> AnagramsList=new ArrayList<String>();
        for(int i=0;i<strs.length;i++){
            String key=getKey(strs[i]);
            if(table.containsKey(key)){
                table.get(key).add(strs[i]);
            }else{
                ArrayList<String> list=new ArrayList<String>();
                list.add(strs[i]);
                table.put(key, list);
            }
        }
        
        for(String key:table.keySet()){
            if(table.get(key).size()>1){
                AnagramsList.addAll(table.get(key));
            }
        }
        return AnagramsList;
    }
    
    private String getKey(String str){
        char[] keyArray=str.toCharArray();
        Arrays.sort(keyArray);
        return new String(keyArray);
    	
    }
}
