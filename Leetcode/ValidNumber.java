/**
 * Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

�����迼�Ƕ������:
1. ǰ��ո�Ĵ���
2.С����Ĵ���
a. ������С���㲻���ظ�����
b. e��������С����ǰ����.
3.e��ָ����ʽ����
a. e�������ظ�����
b. e��ǰ�����������
c.e�ĺ��治����ֻ��С����
4. +-�Ĵ���
a. +-��ǰ�治����������
b.+-�����ظ�����
c.ǰ����������С����
d.�������������С�������
e.�����e��Ҫ�����������¿�ʼ�����
 */

package Leetcode;

public class ValidNumber {
	 public boolean isNumber(String s) {
	        s=s.trim();
	        if(s==null||s.length()==0||s.equals(".")){
	            return false;
	        }
	        int count=0;
	        int hasE=0;
	        boolean numberBegin=false;
	        int hasSign=0;
	        for(int i=0;i<s.length();i++){
	            String sub=s.substring(i,i+1);
	            if(sub.matches("[0-9]")){
	                numberBegin=true;
	            }
	            if(!sub.matches("[0-9\\.e+-]")){
	                return false;
	            }
	             if(sub.equals(".")){
	                    count++;
	                    if(count>1||hasE>0){
	                        return false;
	                    }
	                }
	            if(sub.equals("e")){
	                hasE++;
	                if(hasE>1||!numberBegin||i==s.length()-1||(i==s.length()-2 && s.charAt(s.length()-1)=='.')){
	                    return false;
	                }
	                numberBegin=false;
	                hasSign=0;
	                count=0;
	            }
	            if(sub.matches("[+-]")){
	                hasSign++;
	                if(hasSign>1||numberBegin||count>0||i==s.length()-1||(i==s.length()-2 && s.charAt(s.length()-1)=='.')){
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	   
	   public static void main(String[] args){
		   ValidNumber v=new ValidNumber();
		   System.out.println(v.isNumber("005047e+6"));
	   }
}
