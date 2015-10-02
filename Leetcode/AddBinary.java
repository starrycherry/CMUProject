package Leetcode;
/**
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 * @author Cherrie
 *
 */
public class AddBinary {
	   public String addBinary(String a, String b) {
	        if(a==null||a.length()==0){
	            return b;
	        }
	        if(b==null||b.length()==0){
	            return a;
	        }
	        
	        int i=a.length()-1;
	        int j=b.length()-1;
	        int k=0;
	        int c=0;
	        
	        char[] aChar=a.toCharArray();
	        char[] bChar=b.toCharArray();
	        char[] cChar=new char[Math.max(a.length(),b.length())+1];
	        
	        while(true){
	            if(i<0&&j<0&&c==0){
	                break;
	            }
	            
	            int aint=0;
	            int bint=0;
	            
	            if(i>=0){
	                aint=aChar[i]-'0';
	            }
	            if(j>=0){
	                bint=bChar[j]-'0';
	            }
	            if(aint+bint+c>1){
	                cChar[k]=(char)('0'+aint+bint+c-2);
	                c=1;
	            }else{
	                cChar[k]=(char)('0'+aint+bint+c);
	                c=0;
	            }
	            k++;
	            i--;
	            j--;
	        }
	        return new StringBuffer(new String(cChar,0,k)).reverse().toString();
	    }
}
