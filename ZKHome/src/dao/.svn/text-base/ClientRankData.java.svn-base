package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bean.ClientRank;
 
public class ClientRankData {
 
    private static List<ClientRank> clients = new ArrayList<ClientRank>();
    static {
        clients.add(new ClientRank("Cherrie", "$2,750,000", "High", "Good","Sammy Smith"));
        clients.add(new ClientRank("Davidsons", "$123,000", "High", "Good","Sammy Smith"));
        clients.add(new ClientRank("Mark Johnson", "$9,282,000", "Medium", "Fair","Sammy Smith"));
        clients.add(new ClientRank("Henrietta Davis", "$50,000", "Medium", "Fair","Sammy Smith"));
        clients.add(new ClientRank("Andersons", "$103,034", "Medium", "Poor","Cathy"));
        clients.add(new ClientRank("Dave Johnson", "$1,053,321", "High", "Good","Cathy"));
        clients.add(new ClientRank("Joanne Thompson", "$5,333", "Low", "Good","Cathy"));
    }
 
    public static List<ClientRank> getAllClientRanks() {
        return new ArrayList<ClientRank>(clients);
    }
    public static ClientRank[] getAllClientRanksArray() {
        return clients.toArray(new ClientRank[clients.size()]);
    }
    

 
}