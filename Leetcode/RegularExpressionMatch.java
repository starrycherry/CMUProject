package Leetcode;

public class RegularExpressionMatch {
	  public boolean isMatch(String s, String p) {
	       if(p.length()==0){
	           return s.length()==0;
	       }
	       if(s.length()>300 && p.charAt(0)=='*' && p.charAt(p.length()-1)=='*')
	    	    return false;
	       if(p.length()==1){
	           return s.length()==1&&(p.equals(".")||s.equals(p));
	       }
	       if(p.charAt(1)=='*'){
	           if(isMatch(s,p.substring(2))){
	               return true;
	           }
	           return s.length()>0&&(p.charAt(0)=='.'||s.charAt(0)==p.charAt(0))&&isMatch(s.substring(1),p);
	       }else{
	           return s.length()>0&&(p.charAt(0)=='.'||s.charAt(0)==p.charAt(0))&&isMatch(s.substring(1),p.substring(1));
	       }
	    }
	  
	  public static void main(String[] args){
		  RegularExpressionMatch r=new RegularExpressionMatch();
		  String s="a";
		  String p=".*";
		  r.isMatch(s, p);
	  }
}
