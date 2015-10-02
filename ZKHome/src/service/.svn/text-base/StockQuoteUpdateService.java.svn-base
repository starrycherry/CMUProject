package service;

import java.util.Random;

import org.zkoss.zk.ui.Desktop;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zkex.zul.SimpleListModelSharer;

import bean.Stock;

public class StockQuoteUpdateService {

	ListModelList stockModel;
	SimpleListModelSharer modelSharer;
	Random random = new Random(System.currentTimeMillis());
	static StockQuoteUpdateService instance;

	Thread udpateThread;

	synchronized public static StockQuoteUpdateService lookup(){
		if(instance==null){
			instance = new StockQuoteUpdateService();
		}
		return instance;
	}

	private StockQuoteUpdateService(){
		stockModel = new ListModelList();
		modelSharer = new SimpleListModelSharer(stockModel);

		stockModel.add(new Stock("AAPL",new YahooStockQuoteService("AAPL").getPrice(), new YahooStockQuoteService("AAPL").getChange())); 
		stockModel.add(new Stock("GOOG",new YahooStockQuoteService("GOOG").getPrice(), new YahooStockQuoteService("GOOG").getChange()));
		stockModel.add(new Stock("BAC",new YahooStockQuoteService("BAC").getPrice(), new YahooStockQuoteService("BAC").getChange()));
		stockModel.add(new Stock("FB",new YahooStockQuoteService("FB").getPrice(), new YahooStockQuoteService("FB").getChange()));
//		stockModel.add(new Stock("JPM",new YahooStockQuoteService("JPM").getPrice(), new YahooStockQuoteService("JPM").getChange()));
//		stockModel.add(new Stock("MSFT",new YahooStockQuoteService("MSFT").getPrice(), new YahooStockQuoteService("MSFT").getChange()));
		stockModel.add(new Stock("AMZN",new YahooStockQuoteService("AMZN").getPrice(), new YahooStockQuoteService("AMZN").getChange()));

		udpateThread = new  Thread(new UpdateRunnable());
		udpateThread.start();
	}

	public ListModel getProxy(Desktop desktop){
		return modelSharer.getProxy(desktop);
	}

	public void addStock(String label){
		synchronized(stockModel){
			stockModel.add(new Stock(label,new YahooStockQuoteService(label).getPrice(),new YahooStockQuoteService(label).getChange()));
		}
	}

	public void clearAll(){
		synchronized(stockModel){
			stockModel.clear();
		}
	}

	public void clearRamdom(){
		synchronized(stockModel){
			int index = random.nextInt(stockModel.size());
			stockModel.remove(index);
		}
	}

	class UpdateRunnable implements Runnable{

		boolean running = false;
		public void run() {
			running = true;
			while(running){
				int size = stockModel.size();
				if(size>0){
					int updateCount = random.nextInt(size>3?3:size);
					if(updateCount==0) updateCount=1;
					for(int i=0;i<updateCount;i++){
						int index = random.nextInt(size);

						Stock si = getCurrentStockQuotes(index); //get current stock quotes			
						synchronized(stockModel){
							stockModel.set(index,si); //and update it
						}
					}
				}
				try {
					Thread.currentThread().sleep(200);
				} catch (InterruptedException e) {
					running = false;
				}
			}
		}
		private Stock getCurrentStockQuotes(int index) {
			Stock si = (Stock)stockModel.get(index);
			
			double cPrice = si.getCurrentPrice();
			double newPrice = new YahooStockQuoteService(si.getLabel()).getPrice();
//			double ratio = (newPrice - cPrice)/((newPrice+cPrice)/2) * 100;
			
			si.setPrviousPrice(new YahooStockQuoteService(si.getLabel()).getChange());
//			si.setRatio(ratio);
			si.setCurrentPrice(newPrice);
			
//			System.out.println(new YahooStockQuoteService(si.getLabel()).currentQuote());
			
			return si;
		}
	}
}
