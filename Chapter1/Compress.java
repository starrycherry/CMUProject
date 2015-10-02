package Chapter1;

public class Compress {
	
	public String compressString(String str){
		int size=1;
		char last=str.charAt(0);
		for(int i=1;i<str.length();i++){
			if(str.charAt(i)!=last){
				size++;
				last=str.charAt(i);
			}
		}
		
		if(size*2>=str.length())
			return str;
		
		StringBuffer sb=new StringBuffer();
		
		last=str.charAt(0);
		int count=1;
		for(int i=1;i<str.length();i++){
			if(str.charAt(i)==last){
				count++;
			}else{
				sb.append(last);
				sb.append(count);
				last=str.charAt(i);
				count=1;
			}
		}
		sb.append(last);
		sb.append(count);
		return sb.toString();
	}
	
	public static void main(String[] args){
		Compress c=new Compress();
		System.out.println(c.compressString("aabcccccaaa"));
	}

}
