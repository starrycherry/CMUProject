package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bean.Holding;

import view_model.HoldingFilter;

public class HoldingData {
	
	private static List<Holding> holdings = new ArrayList<Holding>();
	static {
		holdings.add(new Holding("Bank of America", "Mutual Fund", "Nomura Hires Wong, Gupta From BofA to Boost Asia Equity Sales", 6, "2009.01.10", 868, 9862,"up","/images/upArrow2.png"));
		holdings.add(new Holding("JP Morgan", "Fixed Income", "JPMorgan to Pay $23 Million to Settle Suit Over Lehman Notes", 13, "2009.01.09", 739, 870,"down","/images/downArrow2.png"));
		holdings.add(new Holding("General Electric", "Equities", "General Electric Starts Its First Wind Energy Plant in Estonia", 21, "2009.01.08", 828, 8712,"up","/images/upArrow2.png"));
		holdings.add(new Holding("S&P 500", "Mutual Fund", "Stocks close at record highs, S&P ends above 1700 on economic data", 8, "2009.01.07", 598, 8763,"up","/images/upArrow2.png"));
		holdings.add(new Holding("Dow Jones Indus. Avg ", "Mutual Fund", "Dow Jones industrial average falls 200 points on discouraging news from blue-chip companies", 97, "2009.01.06", 791, 6735,"down","/images/downArrow2.png"));
		holdings.add(new Holding("NASDAQ 100 ", "Mutual Fund", "Tesla Rises on Bump Up to Nasdaq-100 Index: Mover", 54, "2009.01.05", 739, 286,"up","/images/upArrow2.png"));
		holdings.add(new Holding("S&P/TSX", "Mutual Fund", "S&P Dow Jones Indices Announces Changes to the S&P/TSX Canadian Indices", 232, "2009.01.04", 692, 9231,"down","/images/downArrow2.png"));
		holdings.add(new Holding("Mexico IPC", "Equities", "CORRECTED-Mexico's IPC stock index down 1 pct | Reuters", 67, "2009.01.03", 812, 987,"down","/images/downArrow2.png"));
		holdings.add(new Holding("Bovespa", "Equities", "Bovespa May Climb to 72000 in 2014, Itau BBA's Constantini Says", 89, "2009.01.02", 893, 9713,"up","/images/upArrow2.png"));
	}
	
	public static List<Holding> getAllHoldings() {
		return new ArrayList<Holding>(holdings);
	}
	
	public static Holding[] getAllHoldingsArray() {
		return holdings.toArray(new Holding[holdings.size()]);
	}

    public static List<Holding> getFilterHoldings(HoldingFilter holdingFilter) {
        List<Holding> someholdings = new ArrayList<Holding>();
        String equ = holdingFilter.getEquities().toLowerCase();
        String type = holdingFilter.getType().toLowerCase();
        String re = holdingFilter.getResearch().toLowerCase();
         
        for (Iterator<Holding> i = holdings.iterator(); i.hasNext();) {
            Holding tmp = i.next();
            if (tmp.getHolding().toLowerCase().contains(equ) &&
                tmp.getType().toLowerCase().contains(type)  &&
                tmp.getResearch().toLowerCase().contains(re)) {
                someholdings.add(tmp);
            }
        }
        return someholdings;
    }
}