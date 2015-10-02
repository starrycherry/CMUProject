package action;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublespinner;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import comparators.CashComparator;

import dao.CashBalanceData;
import bean.Cash;

public class CashAvailController extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;

	ArrayList<Cash> cashArray = null;
	Date dateO;

	Double greaterA = 0.0;
	Double greaterP = 0.0;

	private Grid cashList;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, -1);
		dateO = now.getTime();

		cashList = (Grid) comp;
		ListModel<Cash> model = null;
		cashArray = new ArrayList<Cash>(CashBalanceData.getAllCashByGreater(greaterA, greaterP, dateO));
		Collections.sort(cashArray, new CashComparator(true,0));
		model = new ListModelList<Cash>(cashFormat(cashArray));
		cashList.setModel(model);
	}


	@Listen("onChange = #greaterA")
	public void changeGreaterAmount(Event event) throws ParseException{
		ListModel<Cash> model = null;
		greaterA = ((Doublespinner) event.getTarget()).getValue();	
		cashArray.clear();
		cashArray.addAll(CashBalanceData.getAllCashByGreater(greaterA, greaterP, dateO));	
		Collections.sort(cashArray, new CashComparator(true,0));
		model = new ListModelList<Cash>(cashFormat(cashArray));
		cashList.setModel(model);
	}
	
	@Listen("onChange = #greaterP")
	public void changeGreaterPercent(Event event) throws ParseException{
		ListModel<Cash> model = null;
		greaterP = ((Doublespinner) event.getTarget()).getValue() * 100.0;	
		cashArray.clear();
		cashArray.addAll(CashBalanceData.getAllCashByGreater(greaterA, greaterP, dateO));	
		Collections.sort(cashArray, new CashComparator(true,0));
		model = new ListModelList<Cash>(cashFormat(cashArray));
		cashList.setModel(model);
	}

	@Listen("onChange = #dateOn")
	public void changeDateFrom(Event event) throws ParseException{
		ListModel<Cash> model = null;
		dateO = ((Datebox) event.getTarget()).getValue();	
		cashArray.clear();
		cashArray.addAll(CashBalanceData.getAllCashByGreater(greaterA, greaterP, dateO));
		Collections.sort(cashArray, new CashComparator(true,0));		
		model = new ListModelList<Cash>(cashFormat(cashArray));
		cashList.setModel(model);
	}
	
	//helper method to format the available cash amount
	private static ArrayList<Cash> cashFormat(ArrayList<Cash> al) throws ParseException {
		ArrayList<Cash> tmp = new ArrayList<Cash>();
		DecimalFormat df = new DecimalFormat("#,##0.00");
		for (Cash c: al) {           
			tmp.add(new Cash(c.getKey(),c.getFANumber(),c.getRelationship(),c.getAccountName(),c.getAccountNumber(),c.getType(),c.getAmount(),"$"+df.format(Double.parseDouble(c.getAvailCash())),c.getPercentage(),c.getDate()));    
		}		
		return tmp;		
	}
}
