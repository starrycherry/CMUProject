/**
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

 keyboard={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
package Leetcode;

import java.awt.List;
import java.util.ArrayList;

public class LetterCombinationsOfaPhoneNumber {
	   public ArrayList<String> letterCombinations(String digits) {
	        ArrayList<String> list=new ArrayList<String>();
	        if(digits==null||digits.length()==0){
	            return list;
	        }
	        
	        char[] digitArray=digits.toCharArray();
	        String[] keyboard={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	        String[] letters=new String[digitArray.length];
	        for(int i=0;i<digitArray.length;i++){
	            letters[i]=keyboard[digitArray[i]-'0'];
	        }
	  
	        StringBuffer sb=new StringBuffer();
	        letterCombinationsHelper(letters,0,list,sb);
	        return list;
	    }
	    
	    private void letterCombinationsHelper(String[] letters,int index,ArrayList<String> list,StringBuffer sb){
	        if(sb.length()==letters.length){
	            String newItem=sb.toString();
	            list.add(newItem);
	            return;
	        }
	      
	        for(int i=0;i<letters[index].length();i++){
	            sb.append(letters[index].charAt(i));
	            letterCombinationsHelper(letters,index+1,list,sb);
	            sb.deleteCharAt(sb.length()-1);
	        }
	    }
}
