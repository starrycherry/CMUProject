/**
 * Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23

postfix notation£»¡¡
 */
package Leetcode;

class Result{
    int pos;
    int val;
    public Result(int pos,int val){
        this.pos=pos;
        this.val=val;
    }
}
public class BasicCalculation {
    public int calculate(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        return eval(s,0).val;
    }
    
    private Result eval(String s, int pos){
        Integer total=null;
        char op=0;
        while(pos<s.length()){
            if(s.charAt(pos)==' '){
                pos++;
                continue;
            }else if(s.charAt(pos)=='('){
                Result re=eval(s,++pos);
                pos=re.pos;
                if(total==null){
                    total=re.val;
                }else{
                    total=cal(op,total,re.val);
                }
            }else if(s.charAt(pos)==')'){
                return new Result(++pos,total);
            }else if(s.charAt(pos)=='+'||s.charAt(pos)=='-'){
                op=s.charAt(pos);
                pos++;
            }else{
                int start=pos;
                while(pos<s.length()&&s.charAt(pos)>='0'&&s.charAt(pos)<='9'){
                    pos++;
                }
                int num=Integer.parseInt(s.substring(start,pos));
                if(total==null){
                    total=num;
                }else{
                    total=cal(op,total,num);
                }
            }
            
        }
        
        return new Result(pos,total);
    }
    
    private int cal(char op, int a, int b){
        int re=0;
        if(op=='+'){
            re=a+b;
        }
        if(op=='-'){
            re=a-b;
        }
        return re;
    }
	    
	    public static void main(String[] args){
	    	BasicCalculation c=new BasicCalculation();
	    	System.out.println(c.calculate("(3-(5-(8)-(2+(9-(0-(8-(2))))-(4))-(4)))"));
	    	
	    }
}
