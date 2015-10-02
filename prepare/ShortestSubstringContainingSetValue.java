package prepare;

import java.util.ArrayList;
import java.util.HashSet;

public class ShortestSubstringContainingSetValue {
	public int searchCharacter(String s, HashSet<Character> target) {
		int count = 0, m = s.length(), n = target.size();
		int start = 0, end = 0, res = m + 1;
		int found[] = new int[256];

		for (; end < m; end++) {
			if (!target.contains(s.charAt(end))) continue;

			// when meeting char needed
			if (found[s.charAt(end)] == 0) count++;
			found[s.charAt(end)]++;
			
			if (count != target.size()) continue;

			// find start position when getting all needed
			for (; start < end; start++) {
				if (!target.contains(s.charAt(start))) continue;
			
				if (found[s.charAt(start)] == 1) break; // Delete all repeated
				
				found[s.charAt(start)]--;

			}
			
			if (res > end - start)
				res = end - start;
	
		}
		
		return (res == m + 1) ? 0 : res+1;
	}
	public static void main(String[] args){
		ShortestSubstringContainingSetValue s=new ShortestSubstringContainingSetValue();
		HashSet<Character> target=new HashSet<Character>();
		target.add('a');
		target.add('b');
		target.add('c');
		
		System.out.println(s.searchCharacter("aaercbrewreadbcerwe", target));
	}
}
