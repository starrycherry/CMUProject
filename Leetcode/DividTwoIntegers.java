package Leetcode;

public class DividTwoIntegers {
	//Time Limit Exceeds
	public int divide(int dividend, int divisor) {
        if(dividend==0){
            return 0;
        }
        if(divisor==0){
            return Integer.MAX_VALUE;
        }
        if(divisor==1){
            return dividend;
        }
        int absD1=Math.abs(dividend);
        int absD2=Math.abs(divisor);
        int x=0;
        int r=Integer.MIN_VALUE;
        while(r<=absD1){
            x++;
            r=multiply(absD2,x);
        }
        if((dividend<0&&divisor>0)||(dividend>0&&divisor<0)){
            x=negate(x);
        }
        return x;
    }
    
    private int multiply(int a, int b){
        if(a==0||b==0){
            return 0;
        }
        int sum=0;
        if(a<b){
            multiply(b,a);
        }
        for(int i=1;i<=Math.abs(b);i++){
            sum+=a;
        }
        if(b<0){
            sum=negate(sum);
        }
        return sum;
    }
    
    private int negate(int a){
        int b=a<0?1:-1;
        int neg=0;
        while(a!=0){
            neg+=b;
            a+=b;
        }
        return neg;
    }
    
    public int divide1(int dividend, int divisor) { 
        if (dividend == 0 || divisor == 0) { 
            return 0; 
        } 
        boolean isNeg = (dividend > 0 && divisor < 0) 
                || (dividend < 0 && divisor > 0); 
        long a = Math.abs((long) dividend); 
        long b = Math.abs((long) divisor); 
        if (b > a) { 
            return 0; 
        } 
   
        long sum = 0; 
        long pow = 0; 
        long result = 0; 
        while (a >= b) { 
            pow = 1; 
            sum = b; 
            while (sum + sum <= a) { 
                sum += sum; 
                pow += pow; 
            } 
            a -= sum; 
            result += pow; 
        }
 
        result = ((((dividend ^ divisor) >> 31) & 1) == 1) ? -result: result;
          
         if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
         }
          
         return (int)result;
    }
    public static void main(String[] args){
    	DividTwoIntegers d=new DividTwoIntegers();
    	System.out.println(d.divide1(20, 3));
    }

}
