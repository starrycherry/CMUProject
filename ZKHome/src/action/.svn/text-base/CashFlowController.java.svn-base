package action;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublespinner;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import comparators.CashComparator;

import dao.CashData;
import bean.Cash;

public class CashFlowController extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;
	
	ArrayList<Cash> cashArray = null;
	Date dateF, dateT;
	String dateSelect = null;
	Boolean all = true;
	Boolean in = true;
	Boolean out = true;
	Boolean buys = true;
	Boolean sells = true;
	Boolean deposits = true;
	Boolean dividends = true;
	Boolean interest = true;
	Boolean withdrawals = true;
	Double greater = 0.0;

	private Grid cashList;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, -1);
		dateF = now.getTime();
		dateT = now.getTime();
		
		cashList = (Grid) comp;
		ListModel<Cash> model = null;
		cashArray = new ArrayList<Cash>(CashData.getAllCashByDate(greater, dateF, dateT));
		Collections.sort(cashArray, new CashComparator(true,0));
		model = new ListModelList<Cash>(cashFormat(cashArray));
		cashList.setModel(model);
	}
	
	@Listen("onChange= #dateSelector")
	public void dateSelect(Event event) throws ParseException {
		ListModel<Cash> model = null;
		dateSelect = ((Combobox)event.getTarget()).getSelectedItem().getId();
		cashArray.clear();
		
		if (dateSelect.equals("yesterday")){
			Calendar now = Calendar.getInstance();
			now.add(Calendar.DATE, -1);
			dateF = now.getTime();
		}
		
		if (dateSelect.equals("last7")){
			Calendar now = Calendar.getInstance();
			now.add(Calendar.DATE, -8);
			dateF = now.getTime();
		}
		
		if (dateSelect.equals("last30")){
			Calendar now = Calendar.getInstance();
			now.add(Calendar.DATE, -31);
			dateF = now.getTime();
		}
		
		if (dateSelect.equals("last90")){
			Calendar now = Calendar.getInstance();
			now.add(Calendar.DATE, -91);
			dateF = now.getTime();
		}
		
		if (dateSelect.equals("YTD")){	
			dateF = new SimpleDateFormat("MM/dd/yyyy").parse("01/01/" + Calendar.YEAR);
		}
		
		if (all) {
			cashArray.addAll(CashData.getAllCashByDate(greater, dateF, dateT));
		} else {
			if (in) cashArray.addAll(CashData.getCashByType("ACATS In",greater, dateF, dateT));
			if (out) cashArray.addAll(CashData.getCashByType("ACATS Out",greater, dateF, dateT));
			if (buys) cashArray.addAll(CashData.getCashByType("Buys",greater, dateF, dateT));
			if (sells) cashArray.addAll(CashData.getCashByType("Sells",greater, dateF, dateT));
			if (dividends) cashArray.addAll(CashData.getCashByType("Dividends",greater, dateF, dateT));
			if (interest) cashArray.addAll(CashData.getCashByType("Interest",greater, dateF, dateT));
			if (withdrawals) cashArray.addAll(CashData.getCashByType("Withdrawals",greater, dateF, dateT));		
		}	
		Collections.sort(cashArray, new CashComparator(true,0));
		model = new ListModelList<Cash>(cashFormat(cashArray));
		cashList.setModel(model);
	}

	
	@Listen("onCheck = #all")
	public void checkAll(CheckEvent event) throws ParseException {
		ListModel<Cash> model = null;
		all = ((Checkbox) event.getTarget()).isChecked();
		cashArray.clear();
		if (all) {
			ArrayList<Cash> cashTmp = new ArrayList<Cash>(CashData.getAllCashByDate(greater, dateF, dateT));
			for (Cash a: cashTmp) {
					cashArray.add(a);
			}

		} else {
			
			cashArray.clear();
		}
		Collections.sort(cashArray, new CashComparator(true,0));
		model = new ListModelList<Cash>(cashFormat(cashArray));
		cashList.setModel(model);
	}

	@Listen("onCheck = #in")
	public void checkIn(CheckEvent event) throws ParseException {
		ListModel<Cash> model = null;
		in = ((Checkbox) event.getTarget()).isChecked();
		if (in) {
			ArrayList<Cash> cashTmp = new ArrayList<Cash>(CashData.getAllCashByDate(greater, dateF, dateT));
			for (Cash a: cashTmp) {
				if (a.getType().equals("ACATS In"))
					cashArray.add(a);
			}

		} else {
			all = false;
			ArrayList<Cash> delList = new ArrayList<Cash>();
			for (Cash a: cashArray){
				if (a.getType().equals("ACATS In"))
					delList.add(a);
			}
			
			cashArray.removeAll(delList);
		}
		Collections.sort(cashArray, new CashComparator(true,0));
		model = new ListModelList<Cash>(cashFormat(cashArray));
		cashList.setModel(model);
	}
	
	@Listen("onCheck = #out")
	public void checkOut(CheckEvent event) throws ParseException {
		ListModel<Cash> model = null;
		out = ((Checkbox) event.getTarget()).isChecked();
		if (out) {
			ArrayList<Cash> cashTmp = new ArrayList<Cash>(CashData.getAllCashByDate(greater, dateF, dateT));
			for (Cash a: cashTmp) {
				if (a.getType().equals("ACATS Out"))
					cashArray.add(a);
			}

		} else {
			all = false;
			ArrayList<Cash> delList = new ArrayList<Cash>();
			for (Cash a: cashArray){
				if (a.getType().equals("ACATS Out"))
					delList.add(a);
			}
			
			cashArray.removeAll(delList);
		}
		Collections.sort(cashArray, new CashComparator(true,0));
		model = new ListModelList<Cash>(cashFormat(cashArray));
		cashList.setModel(model);
	}
	
	@Listen("onCheck = #buys")
	public void checkBuys(CheckEvent event) throws ParseException {
		ListModel<Cash> model = null;
		buys = ((Checkbox) event.getTarget()).isChecked();
		if (buys) {
			ArrayList<Cash> cashTmp = new ArrayList<Cash>(CashData.getAllCashByDate(greater, dateF, dateT));
			for (Cash a: cashTmp) {
				if (a.getType().equals("Buys"))
					cashArray.add(a);
			}

		} else {
			all = false;
			ArrayList<Cash> delList = new ArrayList<Cash>();
			for (Cash a: cashArray){
				if (a.getType().equals("Buys"))
					delList.add(a);
			}
			
			cashArray.removeAll(delList);
		}
		Collections.sort(cashArray, new CashComparator(true,0));
		model = new ListModelList<Cash>(cashFormat(cashArray));
		cashList.setModel(model);
	}
	
	@Listen("onCheck = #sells")
	public void checkSells(CheckEvent event) throws ParseException {
		ListModel<Cash> model = null;
		sells = ((Checkbox) event.getTarget()).isChecked();
		if (sells) {
			ArrayList<Cash> cashTmp = new ArrayList<Cash>(CashData.getAllCashByDate(greater, dateF, dateT));
			for (Cash a: cashTmp) {
				if (a.getType().equals("Sells"))
					cashArray.add(a);
			}

		} else {
			all = false;
			ArrayList<Cash> delList = new ArrayList<Cash>();
			for (Cash a: cashArray){
				if (a.getType().equals("Sells"))
					delList.add(a);
			}
			
			cashArray.removeAll(delList);
		}
		Collections.sort(cashArray, new CashComparator(true,0));
		model = new ListModelList<Cash>(cashFormat(cashArray));
		cashList.setModel(model);
	}
	
	@Listen("onCheck = #deposits")
	public void checkDeposits(CheckEvent event) throws ParseException {
		ListModel<Cash> model = null;
		deposits = ((Checkbox) event.getTarget()).isChecked();
		if (deposits) {
			ArrayList<Cash> cashTmp = new ArrayList<Cash>(CashData.getAllCashByDate(greater, dateF, dateT));
			for (Cash a: cashTmp) {
				if (a.getType().equals("Deposits"))
					cashArray.add(a);
			}

		} else {
			all = false;
			ArrayList<Cash> delList = new ArrayList<Cash>();
			for (Cash a: cashArray){
				if (a.getType().equals("Deposits"))
					delList.add(a);
			}
			
			cashArray.removeAll(delList);
		}
		Collections.sort(cashArray, new CashComparator(true,0));
		model = new ListModelList<Cash>(cashFormat(cashArray));
		cashList.setModel(model);
	}
	
	@Listen("onCheck = #dividends")
	public void checkDividends(CheckEvent event) throws ParseException {
		ListModel<Cash> model = null;
		dividends = ((Checkbox) event.getTarget()).isChecked();
		if (dividends) {
			ArrayList<Cash> cashTmp = new ArrayList<Cash>(CashData.getAllCashByDate(greater, dateF, dateT));
			for (Cash a: cashTmp) {
				if (a.getType().equals("Dividends"))
					cashArray.add(a);
			}

		} else {
			all = false;
			ArrayList<Cash> delList = new ArrayList<Cash>();
			for (Cash a: cashArray){
				if (a.getType().equals("Dividends"))
					delList.add(a);
			}
			
			cashArray.removeAll(delList);
		}
		Collections.sort(cashArray, new CashComparator(true,0));
		model = new ListModelList<Cash>(cashFormat(cashArray));
		cashList.setModel(model);
	}
	
	@Listen("onCheck = #interest")
	public void checkInterest(CheckEvent event) throws ParseException {
		ListModel<Cash> model = null;
		interest = ((Checkbox) event.getTarget()).isChecked();
		if (interest) {
			ArrayList<Cash> cashTmp = new ArrayList<Cash>(CashData.getAllCashByDate(greater, dateF, dateT));
			for (Cash a: cashTmp) {
				if (a.getType().equals("Interest"))
					cashArray.add(a);
			}

		} else {
			all = false;
			ArrayList<Cash> delList = new ArrayList<Cash>();
			for (Cash a: cashArray){
				if (a.getType().equals("Interest"))
					delList.add(a);
			}
			
			cashArray.removeAll(delList);
		}
		Collections.sort(cashArray, new CashComparator(true,0));
		model = new ListModelList<Cash>(cashFormat(cashArray));
		cashList.setModel(model);
	}
	
	@Listen("onCheck = #withdrawals")
	public void checkWithdrawals(CheckEvent event) throws ParseException {
		ListModel<Cash> model = null;
		withdrawals = ((Checkbox) event.getTarget()).isChecked();
		if (withdrawals) {
			ArrayList<Cash> cashTmp = new ArrayList<Cash>(CashData.getAllCashByDate(greater, dateF, dateT));
			for (Cash a: cashTmp) {
				if (a.getType().equals("Withdrawals"))
					cashArray.add(a);
			}

		} else {
			all = false;
			ArrayList<Cash> delList = new ArrayList<Cash>();
			for (Cash a: cashArray){
				if (a.getType().equals("Withdrawals"))
					delList.add(a);
			}
			
			cashArray.removeAll(delList);
		}
		Collections.sort(cashArray, new CashComparator(true,0));
		model = new ListModelList<Cash>(cashFormat(cashArray));
		cashList.setModel(model);
	}
	
	@Listen("onChange = #sGreater")
	public void changeGreater(Event event) throws ParseException{
		ListModel<Cash> model = null;
		greater = ((Doublespinner) event.getTarget()).getValue();	
		cashArray.clear();
		
		if (all) {
			cashArray.addAll(CashData.getAllCashByDate(greater, dateF, dateT));
		} else {
			if (in) cashArray.addAll(CashData.getCashByType("ACATS In",greater, dateF, dateT));
			if (out) cashArray.addAll(CashData.getCashByType("ACATS Out",greater, dateF, dateT));
			if (buys) cashArray.addAll(CashData.getCashByType("Buys",greater, dateF, dateT));
			if (sells) cashArray.addAll(CashData.getCashByType("Sells",greater, dateF, dateT));
			if (dividends) cashArray.addAll(CashData.getCashByType("Dividends",greater, dateF, dateT));
			if (interest) cashArray.addAll(CashData.getCashByType("Interest",greater, dateF, dateT));
			if (withdrawals) cashArray.addAll(CashData.getCashByType("Withdrawals",greater, dateF, dateT));		
		}	
		Collections.sort(cashArray, new CashComparator(true,0));
		model = new ListModelList<Cash>(cashFormat(cashArray));
		cashList.setModel(model);
		
	}
	
	@Listen("onChange = #dateFrom")
	public void changeDateFrom(Event event) throws ParseException{
		ListModel<Cash> model = null;
		dateF = ((Datebox) event.getTarget()).getValue();	
		cashArray.clear();
		
		if (all) {
			cashArray.addAll(CashData.getAllCashByDate(greater, dateF, dateT));
		} else {
			if (in) cashArray.addAll(CashData.getCashByType("ACATS In",greater, dateF, dateT));
			if (out) cashArray.addAll(CashData.getCashByType("ACATS Out",greater, dateF, dateT));
			if (buys) cashArray.addAll(CashData.getCashByType("Buys",greater, dateF, dateT));
			if (sells) cashArray.addAll(CashData.getCashByType("Sells",greater, dateF, dateT));
			if (dividends) cashArray.addAll(CashData.getCashByType("Dividends",greater, dateF, dateT));
			if (interest) cashArray.addAll(CashData.getCashByType("Interest",greater, dateF, dateT));
			if (withdrawals) cashArray.addAll(CashData.getCashByType("Withdrawals",greater, dateF, dateT));		
		}	
		Collections.sort(cashArray, new CashComparator(true,0));
		model = new ListModelList<Cash>(cashFormat(cashArray));
		cashList.setModel(model);
		
	}
	
	@Listen("onChange = #dateTo")
	public void changeDateTo(Event event) throws ParseException{
		ListModel<Cash> model = null;
		dateT = ((Datebox) event.getTarget()).getValue();	
		cashArray.clear();
		
		if (all) {
			cashArray.addAll(CashData.getAllCashByDate(greater, dateF, dateT));
		} else {
			if (in) cashArray.addAll(CashData.getCashByType("ACATS In",greater, dateF, dateT));
			if (out) cashArray.addAll(CashData.getCashByType("ACATS Out",greater, dateF, dateT));
			if (buys) cashArray.addAll(CashData.getCashByType("Buys",greater, dateF, dateT));
			if (sells) cashArray.addAll(CashData.getCashByType("Sells",greater, dateF, dateT));
			if (dividends) cashArray.addAll(CashData.getCashByType("Dividends",greater, dateF, dateT));
			if (interest) cashArray.addAll(CashData.getCashByType("Interest",greater, dateF, dateT));
			if (withdrawals) cashArray.addAll(CashData.getCashByType("Withdrawals",greater, dateF, dateT));		
		}	
		Collections.sort(cashArray, new CashComparator(true,0));
		model = new ListModelList<Cash>(cashFormat(cashArray));
		cashList.setModel(model);
		
	}
	
	//helper method to format the amount
	private static ArrayList<Cash> cashFormat(ArrayList<Cash> al) throws ParseException {
		ArrayList<Cash> tmp = new ArrayList<Cash>();
		DecimalFormat df = new DecimalFormat("#,##0.00");
		for (Cash c: al) {           
			tmp.add(new Cash(c.getKey(),c.getFANumber(),c.getRelationship(),c.getAccountName(),c.getAccountNumber(),c.getType(),"$"+df.format(Double.parseDouble(c.getAmount())),"$"+df.format(Double.parseDouble(c.getAvailCash())),c.getPercentage(),c.getDate()));    
		}		
		return tmp;		
	}
	

}
