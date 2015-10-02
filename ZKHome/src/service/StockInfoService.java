package service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.constraint.StrMinMax;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;
import org.zkoss.zk.ui.Session;

import bean.StockInfo;

public class StockInfoService implements Runnable {
	
	Session session;
	
    List<StockInfo> stocks = new ArrayList<StockInfo>();
    
    static final CellProcessor[] userProcessors = new CellProcessor[] {
    		new StrMinMax(1, 10),
    		new StrMinMax(1, 50),
    		new StrMinMax(1, 50),
    		new StrMinMax(1, 50),
    		new StrMinMax(1, 50),
    		new StrMinMax(1, 50),
    		new StrMinMax(1, 50)
    };
    	
    static final String[] header = new String[] {"symbol", "name", "price", "open", "high", "low", "range"};
    
    public StockInfoService(Session session) {
    	this.session = session;
    }
    
	public void getStocks() {
		ICsvBeanReader reader = null;
		try {
			reader = new CsvBeanReader(
					new InputStreamReader(
							new URL("http://finance.yahoo.com/d/quotes.csv?s=LNKD+GOOG+AAPL+AMZN+FB+ORCL+MSFT+TSLA&f=snl1ohgw").openStream()),CsvPreference.EXCEL_PREFERENCE);
			stocks = new ArrayList<StockInfo>();
			StockInfo stock;
			while((stock = reader.read(StockInfo.class, header, userProcessors)) != null) {
				stocks.add(new StockInfo(stock));
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
        	try {
        		if(reader != null) {
        			reader.close();
        		}
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
	}
	
	public void storeInSession() {
		session.setAttribute("stocks", stocks);
	}

	@Override
	public void run() {
		while(session.getAttribute("loginName") != null && !session.getAttribute("loginName").equals("")) {
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			getStocks();
			storeInSession();
		}
	}
}
