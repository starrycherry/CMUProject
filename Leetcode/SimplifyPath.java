package Leetcode;

import java.util.Stack;

public class SimplifyPath {
	   public String simplifyPath(String path) {
	        if(path==null){
	            return null;
	        }
	        
	        String[] list = path.split("/");
	        Stack<String> stack=new Stack<String>();
	        
	        for(int i=0;i<list.length;i++){
	            String s=list[i];
	            if(s.equals("/")||s.equals(".")||s.equals(" ")||s.equals("")){
	                continue;
	            }else if(s.equals("..")){
	                if(!stack.isEmpty())
	                    stack.pop();
	            }else{
	                stack.push(s);
	            }
	        }
	        
	        if(stack.isEmpty()){
	            return "/";
	        }
	        
	        String result="";
	        while(!stack.isEmpty()){
	            result="/"+stack.pop()+result;
	        }
	        return result;
	        
	    }
	  
	  public static void main(String[] args){
		  SimplifyPath s=new SimplifyPath();
		  s.simplifyPath("/home//foo/");
	  }
}
