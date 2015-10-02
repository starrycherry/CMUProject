package action;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.FixedIncomeData;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Footer;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;

import bean.FixedIncome;
import bean.FixedIncomeFormat;




public class FixedIncomeController extends SelectorComposer<Component>{
	private static final long serialVersionUID = 1L;
	private FixedIncomeData incomeData=new FixedIncomeData(); 
	private static final String footerMessage = "A Total of %d FixedIncome Items";
	private List<FixedIncomeFormat> currentIncome=new ArrayList<FixedIncomeFormat>();
	private List<FixedIncomeFormat> firstLoad;
	private List<FixedIncomeFormat> callPendingList=new ArrayList<FixedIncomeFormat>();
	private List<FixedIncomeFormat> isPendingList=new ArrayList<FixedIncomeFormat>();
	     
	private Grid incomeList;
	 
	 @Wire
	 private Checkbox maturity;
	 
	 @Wire
	 private Checkbox callPending;
	 
	 @Wire
	 private Checkbox pending;
	 
	 @Wire
	 private Footer footer;
	
	 public void doAfterCompose(Component comp) throws Exception {
	        super.doAfterCompose(comp);
	        incomeList = (Grid) comp;
	        DecimalFormat df=new DecimalFormat("#,##0.00");
	        firstLoad=new ArrayList<FixedIncomeFormat>();

			for (Iterator<FixedIncome> i = incomeData.getAllIncomes().iterator(); i.hasNext();) {            
				FixedIncome tmp = i.next(); 

				firstLoad.add(new FixedIncomeFormat(tmp.getClientName(),tmp.getCUSIP(),tmp.getDescription(),"$"+df.format(tmp.getMarketPrice()),df.format(tmp.getQuantity()),tmp.getPendingCall(),tmp.getMaturity(),df.format(tmp.getCoupon()),tmp.getRating()));
			} 
	        incomeList.setModel(new ListModelList<FixedIncomeFormat>(firstLoad));
	        footer.setLabel(String.format(footerMessage, firstLoad.size()));
	    }
  
	 @Listen("onCheck = #maturity")    
	 public void changeMaturityFilter(CheckEvent event) {
		boolean decision=maturity.isChecked();
		List<FixedIncomeFormat> tempList=incomeData.getFilterIncome("maturity");
		if(!currentIncome.isEmpty()){
			for(FixedIncomeFormat i:tempList){
				if(!currentIncome.contains(i)&&decision){
					currentIncome.add(i);	
				}else{
					if(!decision)
						currentIncome.remove(i);
				}
			}
		}else{
			if(decision)
				currentIncome.addAll(tempList);
			else
				currentIncome.clear();
		}
		incomeList.setModel(new ListModelList<FixedIncomeFormat>(currentIncome.isEmpty()?firstLoad:currentIncome));
		footer.setLabel(String.format(footerMessage, currentIncome.isEmpty()?firstLoad.size():currentIncome.size()));
		 }
	 
	 @Listen("onCheck = #callPending")    
	 public void changeCallPendingFilter(CheckEvent event) {
		boolean decision=callPending.isChecked();
		callPendingList=incomeData.getFilterIncome("callPending");
		if(!currentIncome.isEmpty()){
			for(FixedIncomeFormat i:callPendingList){
				if(!currentIncome.contains(i)&&decision){
					currentIncome.add(i);	
				}else{
					if(!decision&&!isPendingList.contains(i)){
						currentIncome.remove(i);
					}
						
				}
			}
		}else{
			if(decision)
				currentIncome.addAll(callPendingList);
			else{
				currentIncome.clear();
			}
				
		}
		if(!decision)
			callPendingList.clear();
		incomeList.setModel(new ListModelList<FixedIncomeFormat>(currentIncome.isEmpty()?firstLoad:currentIncome));
		footer.setLabel(String.format(footerMessage, currentIncome.isEmpty()?firstLoad.size():currentIncome.size()));
		 }
	 
	 @Listen("onCheck = #pending")
	 public void changePendingFilter(CheckEvent event) {
		 boolean decision=pending.isChecked();
		isPendingList=incomeData.getFilterIncome("pending");
		if(!currentIncome.isEmpty()){
			for(FixedIncomeFormat i:isPendingList){
				if(!currentIncome.contains(i)&&decision){
					currentIncome.add(i);	
				}else{
					if(!decision&&!callPendingList.contains(i)){
						currentIncome.remove(i);
					}
						
				}
			}
		}else{
			if(decision)
				currentIncome.addAll(isPendingList);
			else{
				currentIncome.clear();
			}
				
		}
		if(!decision)
			isPendingList.clear();
		incomeList.setModel(new ListModelList<FixedIncomeFormat>(currentIncome.isEmpty()?firstLoad:currentIncome));
		footer.setLabel(String.format(footerMessage, currentIncome.isEmpty()?firstLoad.size():currentIncome.size()));
		
		 }
}
