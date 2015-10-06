package Leetcode;

import java.util.HashMap;

/**
 * ����Ĺؼ������ҵ��ַ�֮��Ķ�Ӧ��ϵ.
 * @author Cherrie
 *
 */
public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        if((s==null&&t==null)||(s.length()==0&&t.length()==0)){
            return true;
        }else if(s==null||t==null){
                return false;
            }
        
        HashMap<Character,Character> map=new HashMap<Character,Character>();
        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(map.containsKey(c1)){
                if(c2==map.get(c1)){
                    continue;
                }else{
                    return false;
                }
            }else{
                if(map.containsValue(c2)){
                    return false;
                }else{
                    map.put(c1,c2);
                }
            }
        }
        return true;
    }
}
