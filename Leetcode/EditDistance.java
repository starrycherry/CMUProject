package Leetcode;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        if(word1==null||word1.length()==0){
            return word2.length();
        }
        if(word2==null||word2.length()==0){
            return word1.length();
        }
        
        int[][] dis=new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<word1.length();i++){
            for(int j=0;j<word2.length();j++){
                dis[i][j]=Integer.MAX_VALUE;
            }
        }
        if(word1.charAt(0)==word2.charAt(0)){
            dis[0][0]=0;
        }else{
            dis[0][0]=1;
        }
     /*   if(word1.length()==1){
            return dis[0][0]+word2.length()-1;
        }
        if(word2.length()==1){
            return dis[0][0]+word1.length()-1;
        }*/
        for(int i=0;i<word1.length();i++){
            for(int j=0;j<word2.length();j++){
                if(word1.charAt(i)==word2.charAt(j)){
                    dis[i+1][j+1]=dis[i][j];
                }else{
                    dis[i+1][j+1]=Math.min(dis[i][j+1],Math.min(dis[i+1][j],dis[i][j]))+1;
                }
            }
        }
        
        return dis[word1.length()][word2.length()];
    }
	  
	  public static void main(String[] args){
		  EditDistance e=new EditDistance();
		  System.out.println(e.minDistance("sea", "eat"));
	  }
}
