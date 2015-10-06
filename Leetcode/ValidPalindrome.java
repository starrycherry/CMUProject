package Leetcode;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s==null||s.length()==0){
            return true;
        }
        
        int left=0;
        int right=s.length()-1;
        s=s.toLowerCase();
        char[] sChar=s.toCharArray();
        
        while(left<right){
            if(!isAlpha(sChar[left])){
                left++;
                continue;
            }
            if(!isAlpha(sChar[right])){
                right--;
                continue;
            }
            if(sChar[left]!=sChar[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private boolean isAlpha(char c){
        if((c<='z'&&c>='a')||(c>='0'&&c<='9')){
            return true;
        }
        return false;
    }
	    
	    public static void main(String[] args){
	    	ValidPalindrome v=new ValidPalindrome();
	    	v.isPalindrome("ab@a");
	    }
}
