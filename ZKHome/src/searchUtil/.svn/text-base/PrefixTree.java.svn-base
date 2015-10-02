package searchUtil;

import java.util.ArrayList;

public class PrefixTree {
	Node root;
	
	public PrefixTree() {
		root = new Node();
		this.addWord("raymond james");
		this.addWord("financial");
		this.addWord("bank of american");
		this.addWord("google");
		this.addWord("stock");
		this.addWord("equities");
		this.addWord("assets");
		this.addWord("citi bank");
		this.addWord("boa");
		this.addWord("top ten stocks");
		this.addWord("financial advisors");
		this.addWord("advisors");
		this.addWord("clients");
		this.addWord("investment");
		this.addWord("quotes");
		this.addWord("accounting");
		this.addWord("tax");
		this.addWord("income tax");
		this.addWord("fixed income");
		this.addWord("npv");
		this.addWord("irr");
		this.addWord("internal rate of return");
		this.addWord("profitability index");
		this.addWord("present value");
		this.addWord("future value");
		this.addWord("holdings");
		this.addWord("amazon");
		this.addWord("linkedIn");
		this.addWord("telsa");
		this.addWord("apple");
		this.addWord("stock symbol");
		this.addWord("mutual fund");
		this.addWord("fund");
		this.addWord("facebook");
		this.addWord("fb");
		this.addWord("ford motor");
		this.addWord("fedex");
		this.addWord("fossil");
		this.addWord("firstenergy");
		this.addWord("flowserve co");
		this.addWord("foot locker inc");
		this.addWord("fifth avenue");
		this.addWord("florida office");
		this.addWord("federal");
		this.addWord("fidelity");
		this.addWord("forms");
		this.addWord("family plan");
		this.addWord("forms");
		this.addWord("face value");
		this.addWord("factors of production");
		this.addWord("fair value");
		this.addWord("federal reserved bank");
		this.addWord("fair trade investing");
		this.addWord("family of funds");
		this.addWord("fibonacci arc");
		this.addWord("finality of payment");
		this.addWord("financial crisis");
		this.addWord("financial engineering");
	}
	
	public ArrayList<String> vagueSearch(String word) {
		ArrayList<String> result = new ArrayList<String>();
		vagueSearch(result, root, "", word);
		return result;
	}
	
	private void vagueSearch(ArrayList<String> result, Node root, String candidate, String word) {
		if(word.length() == 0) {
			if(root.isEnd == true) {
				result.add(candidate);
			}
			for(int i = 0; i < 27; i++) {
				if(root.edges[i] != null) {
					if(i != 26) {
						vagueSearch(result, root.edges[i], candidate + (char) (i + 'a'), "");
					} else {
						vagueSearch(result, root.edges[i], candidate + " ", "");
					}
				}
			}
		} else {
			char c = word.charAt(0);
			if(c != ' ') {
				int idx = c - 'a';
				if(root.edges[idx] != null) {
					vagueSearch(result, root.edges[idx], candidate + c, word.substring(1));
				}
			} else {
				if(root.edges[26] != null) {
					vagueSearch(result, root.edges[26], candidate + c, word.substring(1));
				}
			}
		}
	}
	
	public void addWord(String word) {
		addWord(root, word);
	}
	
	//time complexity is O(n), n is the length of the word
	private void addWord(Node root, String word) {
		if(word.length() == 0) {
			root.isEnd = true;
			return;
		}
		char c = word.charAt(0);
		if(c == ' ') {
			if(root.edges[26] == null) {
				root.edges[26] = new Node();
			}
			addWord(root.edges[26], word.substring(1));
		} else {
			c = Character.toLowerCase(c);
			int idx = c - 'a';
			if(root.edges[idx] == null) {
				root.edges[idx] = new Node();
			}
			addWord(root.edges[idx], word.substring(1));
		}
	}
}

class Node {
	Node[] edges = new Node[27];
	boolean isEnd;
}
