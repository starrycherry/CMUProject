package view_model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import bean.FixedIncome;
import bean.FixedIncomeFormat;

import dao.FixedIncomeData;

public class FixedIncomeViewModel {

	private static final String footerMessage = "A Total of %d FixedIncome Items";    
	private FixedIncomeData incomeData=new FixedIncomeData();    
	List<FixedIncomeFormat> currentIncome = new ArrayList<FixedIncomeFormat>();


	public ListModel<FixedIncomeFormat> getIncomeModel() {        
		DecimalFormat df=new DecimalFormat("#,##0.00");

		for (Iterator<FixedIncome> i = incomeData.getAllIncomes().iterator(); i.hasNext();) {            
			FixedIncome tmp = i.next(); 

			currentIncome.add(new FixedIncomeFormat(tmp.getClientName(),tmp.getCUSIP(),tmp.getDescription(),"$"+df.format(tmp.getMarketPrice()),df.format(tmp.getQuantity()),tmp.getPendingCall(),tmp.getMaturity(),df.format(tmp.getCoupon()),tmp.getRating()));    
		}
		return new ListModelList<FixedIncomeFormat>(currentIncome); 
	}

	public String getFooter() {        
		return String.format(footerMessage, currentIncome.size());    
	}

	@Command    
	@NotifyChange({"incomeModel", "footer"})    
	public void getAllList() {        
		DecimalFormat df=new DecimalFormat("#,##0.00");

		for (Iterator<FixedIncome> i = incomeData.getAllIncomes().iterator(); i.hasNext();) {            
			FixedIncome tmp = i.next(); 

			currentIncome.add(new FixedIncomeFormat(tmp.getClientName(),tmp.getCUSIP(),tmp.getDescription(),"$"+df.format(tmp.getMarketPrice()),df.format(tmp.getQuantity()),tmp.getPendingCall(),tmp.getMaturity(),df.format(tmp.getCoupon()),tmp.getRating()));
		}
	}


}
