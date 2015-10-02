package view_model;

import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Button;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import service.StockQuoteUpdateService;

public class StockQuotesWindow extends Window {

	private static final long serialVersionUID = 1L;

	public void onCreate() { 
		Desktop desktop = this.getDesktop();
		if(!desktop.isServerPushEnabled()){
			desktop.enableServerPush(true);
		}

		StockQuoteUpdateService service = StockQuoteUpdateService.lookup();
		ListModel model = service.getProxy(desktop);
		StockGridRowRenderer renderer = new StockGridRowRenderer();

		Grid g1 = (Grid)this.getFellow("g1");
		Grid g2 = (Grid)this.getFellow("g2");
		g1.setRowRenderer((RowRenderer<?>) renderer);
		g2.setRowRenderer((RowRenderer<?>) renderer);

		g1.setModel(model);
		g2.setModel(model);


		((Button)getFellow("addbtn")).addEventListener("onClick",new EventListener(){

			public void onEvent(Event event) throws Exception {
				StockQuoteUpdateService service = StockQuoteUpdateService.lookup();
				service.addStock(((Textbox)getFellow("stock")).getValue());
			}});
	}
}
