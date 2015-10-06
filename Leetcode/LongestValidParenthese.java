/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
�������������������У��Ƚ������뵽��ջ������ݽṹ������˼·����ά��һ��ջ�����������žͽ�ջ���������������ջ�������жϵ�ǰ�Ϸ������Ƿ�Ϊ����С���������⿴��˼·�򵥣����������Ƚϵ���Ĳ��Լ���������˵����Ҫ�����������������ʱ����жϵ�ǰ�ĺϷ����еĳ��ȡ��ȽϽ�׳�ķ�ʽ���£�
(1) �����ǰջΪ�գ���˵�����ϵ�ǰ������û�кϷ����У���Ҳ��֮ǰ�жϹ��ģ���
(2) ���򵯳�ջ��Ԫ�أ����������ջΪ�գ���˵����ǰ����ƥ�䣬���ǻ�ά��һ���Ϸ���ʼ�����start���Ϸ����еĳ��ȼ�Ϊ��ǰԪ�ص�λ��-start+1���������ջ������Ԫ�أ���ǰ�Ϸ����еĳ���Ϊ��ǰջ��Ԫ�ص�λ����һλ����ǰԪ�صľ��룬��Ϊջ��Ԫ�غ�������ŶԿ϶��ǺϷ��ģ����������ų���ջ�ˡ�
��Ϊֻ��Ҫһ��ɨ�裬�㷨��ʱ�临�Ӷ���O(n)���ռ临�Ӷ���ջ�Ŀռ䣬�����Ƕ��������ţ�������O(n)��
 */

package Leetcode;

import java.util.Stack;

public class LongestValidParenthese {
    public int longestValidParentheses(String s) {
        if(s==null){
            return 0;
        }
        Stack<Integer> stack=new Stack<Integer>();
        int start=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                    max = stack.isEmpty()?Math.max(max,i-start+1):Math.max(max,i-stack.peek());
                }else{
                    start=i+1;
                }
            }
        }
        return max;
    }
}
