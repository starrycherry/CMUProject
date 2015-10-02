package view_model;

import java.text.DecimalFormat;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.RowRendererExt;

import bean.Stock;

public class StockGridRowRenderer implements RowRenderer, RowRendererExt{

	DecimalFormat format = new DecimalFormat("##0.00");
	DecimalFormat format2 = new DecimalFormat("#0.##");

	public int getControls() {
		return 0; //DETACH_ON_UNLOAD
		//RowRendererExt.DETACH_ON_UNLOAD is not available so hardcoding to 0
	}

	public Component newCell(Row row) {
		return new Label("Updating");
	}

	public Row newRow(Grid grid) {
		return new Row();
	}

	@Override
	public void render(Row row, Object data, int arg2) throws Exception {
		row.getChildren().remove(0);
		Stock si = (Stock)data;
		double curr = si.getCurrentPrice();
		double dif = si.getChange();
		double prev = curr - dif;
		double priceChange = (100 * dif)/curr;

		Label label = new Label(si.getLabel());
		Label price = new Label(format.format(curr));
		Label change = new Label((dif>=0?"+":"")+ format.format(dif)+"("+
				format2.format(priceChange)+"%)");

		if(priceChange>=0){
			change.setStyle("color:green");
		}else if(priceChange<0){
			change.setStyle("color:red");
		}

		row.appendChild(label);
		row.appendChild(price);
		row.appendChild(change);

	}
}
