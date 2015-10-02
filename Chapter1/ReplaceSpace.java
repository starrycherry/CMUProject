package Chapter1;

public class ReplaceSpace {
	public String replace(String str){
		char[] array=str.toCharArray();
		int countSpace=0;
		for (int i=0;i<array.length;i++){
			if(array[i]==' '){
				countSpace++;
			}
		}
		
		int newLength=array.length+countSpace*2;
		
		for(int i=array.length-1;i>0;i--){
			if(array[i]==' '){
				array[newLength-1]='0';
				array[newLength-2]='2';
				array[newLength-3]='%';
				newLength=newLength-3;
			}else{
				array[newLength-1]=array[i];
				newLength--;
			}
		}
		String aStr=new String(array);
		return aStr;
	}
	
	/**
	 * If there is two arrays
	 */
	
	public String replaceWith2Arrays(String str){
		char[] a=str.toCharArray();
		int countSpace=0;
		for(int i=0;i<a.length;i++){
			if(a[i]==' '){
				countSpace++;
			}
		}
		
		char[] b=new char[a.length+countSpace*2];
		
		for(int i=0,j=0;i<a.length;i++,j++){
			if(a[i]==' '){
				b[j]='%';
				b[j+1]='2';
				b[j+2]='0';
				j=j+2;
			}else{
				b[j]=a[i];
			}
		}
		String bStr=new String(b);
		return bStr;
	}

	public static void main(String[] args){
		ReplaceSpace r=new ReplaceSpace();
		System.out.println(r.replaceWith2Arrays("a bdc e"));
	}
}
