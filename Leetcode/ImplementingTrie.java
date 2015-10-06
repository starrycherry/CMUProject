/**
 * Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
 */
package Leetcode;
public class ImplementingTrie {
    private TrieNode root;

    public ImplementingTrie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            int c=word.charAt(i)-'a';
            if(node.children[c]==null){
                node.children[c]=new TrieNode();
            }
            node=node.children[c];
        }
        node.have=true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word==null){
            return false;
        }
        return searchHelper(word, root, 0,word.length());
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return startsWithHelper(prefix,root,0,prefix.length());
    }
    
     private boolean startsWithHelper(String word, TrieNode node, int pos, int len){
         if(node==null){
            return false;
        }
        if(pos==len){
            return true;
        }
       
        int c=word.charAt(pos)-'a';
        return startsWithHelper(word,node.children[c],pos+1,len);
    }
    
    private boolean searchHelper(String word, TrieNode node, int pos, int len){
         if(node==null||(pos==len&&!node.have)){
            return false;
        }
        if(node.have&&pos==len){
            return true;
        }
       
        int c=word.charAt(pos)-'a';
        return searchHelper(word,node.children[c],pos+1,len);
    }
    
    public static void main(String[] args){
    	ImplementingTrie i=new ImplementingTrie();
    	i.insert("ab");
    	System.out.println(i.search("a"));
    	System.out.println(i.startsWith("a"));
    }
}
