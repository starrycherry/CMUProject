package Chapter1;

public class Unique {
	public boolean checkUniqueness(String str){
		if (str.length()>256)
			return false;
		boolean[] checker=new boolean[256];
		for(int i=0;i<str.length();i++){
			char val=str.charAt(i);
			if(checker[val])
				return false;
			checker[val]=true;
		}
		return true;
	}
	public boolean uniqueChar(String s){
		int[] checker =new int[256];
		for(int i=0;i<s.length();i++){
		if(checker[s.charAt(i)]==0){
		checker[s.charAt(i)]++;
	}else{
		return false;
	}
	}
	return true;
	}

	public static void main(String[] args){
		Unique u=new Unique();
		System.out.println(u.checkUniqueness("akdfies"));
		System.out.println(u.uniqueChar("akffies"));
	}

}
