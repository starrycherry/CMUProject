/**
 * Given a real number between 0 an 1(eg, 0.72) that is passed in as a double, print the binary representation. If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR".
 */
package Chapter5;

public class Item5_2 {
	public String printBinary(double n){
		if(n<=0||n>=1){
			return "ERROR";
		}
		
		StringBuffer sb=new StringBuffer();
		sb.append(".");
		while(n>0){
			if(sb.length()>32){
				return "ERROR";
			}
			double r=n*2;
			if(n>=1){
				sb.append("1");
				n=r-1;
			}else{
				sb.append("0");
				n=r;
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args){
		Item5_2 i=new Item5_2();
		System.out.println(i.printBinary(0.72));
	}
}
