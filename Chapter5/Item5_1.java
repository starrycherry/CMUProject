package Chapter5;

public class Item5_1 {
	public int insertM(int n, int m, int i, int j ){
		int mask=((1<<j)-1)|((1<<(i-1))-1);
		int result=(n&mask)|(m<<i);
		return result;
	}

}
