package chartUtil;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.CategoryModel;

public class StockChart {
	 
    CategoryModel model;
    StockChartEngine engine;
 
    @Init
    public void init() {
        engine = new StockChartEngine();
        model = StockChartData.getModel();
    }
 
    public StockChartEngine getEngine() {
        return engine;
    }
 
    public CategoryModel getModel() {
        return model;
    }
}
