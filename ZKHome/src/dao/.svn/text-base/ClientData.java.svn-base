package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bean.Client;

import util.CurrencyFormatter;
import view_model.ClientFilter;

public class ClientData {
	
	private static List<Client> clients = new ArrayList<Client>();
	static {
		clients.add(new Client("Cherrie", "Mutual Fund", "US government sues Bank of America", 903, 8972, "2009.08.01"));
		clients.add(new Client("Jason", "Equities", "Stocks close at record highs, S&P ends above 1700 on economic data", 942, 673, "2011.01.07"));
		clients.add(new Client("Scott", "Equities", "CORRECTED-Mexico's IPC stock index down 1 pct | Reuters", 822, 896, "2010.09.10"));
		clients.add(new Client("Eric", "Closed-End Funds", "Bovespa May Climb to 72000 in 2014, Itau BBA's Constantini Says", 932, 906, "2008.05.14"));
		clients.add(new Client("Jason", "Mutual Fund", "CORRECTED-Mexico's IPC stock index down 1 pct | Reuters", 753, 9645, "2009.10.12"));
		clients.add(new Client("William", "Closed-End Funds", "Tesla Rises on Bump Up to Nasdaq-100 Index: Mover", 896, 2982, "2008.12.09"));
	}
	
	public static List<Client> getAllClients() {
		return new ArrayList<Client>(clients);
	}
	
	public static Client[] getAllClientsArray() {
		return clients.toArray(new Client[clients.size()]);
	}

    public static List<Client> getFilterClients(ClientFilter clientFilter) {
        List<Client> someClients = new ArrayList<Client>();
        String name = clientFilter.getName().toLowerCase();
        String type = clientFilter.getType().toLowerCase();
        String re = clientFilter.getResearch().toLowerCase();
         
        for (Iterator<Client> i = clients.iterator(); i.hasNext();) {
            Client tmp = i.next();
            if (tmp.getName().toLowerCase().contains(name) &&
                tmp.getType().toLowerCase().contains(type)  &&
                tmp.getResearch().toLowerCase().contains(re)) {
            	someClients.add(tmp);
            }
        }
        return someClients;
    }
}