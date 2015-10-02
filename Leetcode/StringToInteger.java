package Leetcode;

/**
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 * @author Cherrie
 *
 */
public class StringToInteger {
	public int myAtoi(String str) {
        if(str==null||str.length()==0){
            return 0;
        }
        
        str=str.trim();
        char[] sChar=str.toCharArray();
        int sum=0;
        boolean isN=false;
        boolean hasO=false;
        
        
        for(int i=0;i<str.length();i++){
           
            if((sChar[i]=='+'||sChar[i]=='-')&&hasO){
                return 0;
            }
            if(sChar[i]=='+'){
                hasO=true;
                continue;
            }
            if(sChar[i]=='-'){
                hasO=true;
                isN=true;
                continue;
            }
            
             if(sChar[i]>'9'||sChar[i]<'0'){
                 break;
             }
             if(sum>(Integer.MAX_VALUE-(sChar[i]-'0'))/10&&!isN){
                 return Integer.MAX_VALUE;
             }
             
             if(isN&&sum>-1*((Integer.MIN_VALUE+sChar[i]-'0')/10)){
                 return Integer.MIN_VALUE;
             }
            sum=sum*10+(sChar[i]-'0');    
        }
        if(isN){
            sum=sum*(-1);
            sum=sum<Integer.MIN_VALUE?Integer.MIN_VALUE:sum;
        }else{
            sum=sum>Integer.MAX_VALUE?Integer.MAX_VALUE:sum;
        }
        return sum;
    }
	public static void main(String[] args){
		StringToInteger s=new StringToInteger();
		s.myAtoi("    -00134");
	}
}
