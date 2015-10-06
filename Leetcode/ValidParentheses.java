package Leetcode;

import java.util.Stack;
/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * @author Cherrie
 *
 */
public class ValidParentheses {
	  public boolean isValid(String s) {
	        if(s==null||s.length()==0){
	            return false;
	        }
	        if(s.length()%2!=0){
	            return false;
	        }
	        Stack<Character> stack=new Stack<Character>();
	        for(int i=0;i<s.length();i++){
	            char c=s.charAt(i);
	            if(c=='('||c=='{'||c=='['){
	                stack.push(c);
	            }else{
	                if(stack.isEmpty()){
	                    return false;
	                }
	                char p=stack.pop();
	                if(c==')'&&p!='('){
	                    return false;
	                }
	                if(c=='}'&&p!='{'){
	                    return false;
	                }
	                if(c==']'&&p!='['){
	                    return false;
	                }
	            }
	        }
	        
	        if(stack.isEmpty()){
	            return true;
	        }
	        return false;
	    }
}
