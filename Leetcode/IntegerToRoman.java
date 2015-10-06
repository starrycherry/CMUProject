/**
 * Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
 */
package Leetcode;

import java.util.ArrayList;

public class IntegerToRoman {
    public String intToRoman(int num) {
        if(num>3999||num<1){
            return "";
        }
        
        int digit=1000;
        ArrayList<Integer> list=new ArrayList<Integer>();
        while(digit>0){
            list.add(num/digit);
            num%=digit;
            digit/=10;
        }
        
        StringBuffer sb=new StringBuffer();
        sb.append(inToRomainHelper(list.get(0), "M","",""));
        sb.append(inToRomainHelper(list.get(1),"C","D","M"));
        sb.append(inToRomainHelper(list.get(2),"X","L","C"));
        sb.append(inToRomainHelper(list.get(3),"I","V","X"));
        
        return sb.toString();
    }
    private String inToRomainHelper(int num, String one, String five, String ten){
        StringBuffer sb=new StringBuffer();
        switch(num){
            case 9:
                sb.append(one);
                sb.append(ten);
                break;
            case 8:
            case 7:
            case 6:
            case 5:
                sb.append(five);
                for(int i=5; i<num;i++){
                    sb.append(one);
                }
                break;
            case 4:
                sb.append(one);
                sb.append(five);
                break;
            case 3:
            case 2:
            case 1:
                for(int i=1;i<=num;i++){
                    sb.append(one);
                }
                break;
            default:
                break;
        }
        return sb.toString();
    }
}
