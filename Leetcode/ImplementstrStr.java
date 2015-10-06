/**
 * Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Update (2014-11-02):
The signature of the function had been updated to return the index instead of the pointer. If you still see your function signature returns a char * or String, 
please click the reload button  to reset your code definition.
 */

package Leetcode;

public class ImplementstrStr {
	   public int strStr(String haystack, String needle) {
	        if(haystack==null||needle==null){
	            return -1;
	        }
	        
	        int left=0;
	        int right=needle.length();
	        while(left==right-needle.length()&&right<=haystack.length()){
	            if(haystack.substring(left,right).equals(needle)){
	                return left;
	            }
	            left++;
	            right++;
	        }
	        
	        return -1;
	    }
}
