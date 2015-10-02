package view_model;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Path;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.West;

import dao.ClientData;
import dao.HoldingResearchUserRecordDao;
import dao.UserDao;

import bean.Client;
import bean.HoldingResearchUserRecord;
import bean.User;


public class FilterViewModelClient {

	private static final String footerMessage = "A Total of %d Clients";
	private ClientFilter clientFilter = new ClientFilter();
	List<Client> currentClient = ClientData.getAllClients();
	ListModel<Client> clientModel=new ListModelList<Client>(currentClient);
	HoldingResearchUserRecord hrUserRecord;
	HoldingResearchUserRecordDao rjUserRecordDao=new HoldingResearchUserRecordDao();

	@Wire
	private Checkbox equities;

	@Wire
	private Checkbox mutualFund;

	@Wire
	private Checkbox fixedIncome;

	@Wire
	private Checkbox closedEnd;

	@Wire
	private Checkbox uit;

	@Wire
	private West maxCBorder;

	@Wire
	private West minCBorder;

	public FilterViewModelClient(){

		UserDao userDao=new UserDao();
		User user=userDao.findUserByUsername((String)(Sessions.getCurrent().getAttribute("loginName")));

		if(user == null) {
			return;
		}

		hrUserRecord=rjUserRecordDao.findUserRecordByUser(user.getUser_id());

		if(hrUserRecord==null){
			hrUserRecord=new HoldingResearchUserRecord(user, true,
					true, true, true, true,true,"","", true, true,true, true, true,"",true,true,true,true, true,false,
					false, false,false, false);
			rjUserRecordDao.save(hrUserRecord);
		}
	}

	public boolean getName(){
		return hrUserRecord.isName();
	}

	public boolean getCtype(){
		return hrUserRecord.isCtype();
	}

	public boolean getCresearch(){
		return hrUserRecord.isCresearch();
	}

	public boolean getCdate(){
		return hrUserRecord.isCdate();
	}

	public boolean getEquities(){
		String[] split=hrUserRecord.getCfilter_byproductions().split("\\W");
		for(String s:split){
			if(s.equals("equities")){
				return true;
			}
		}
		return false;
	}

	public boolean getMutral(){
		String[] split=hrUserRecord.getCfilter_byproductions().split("\\W");
		for(String s:split){
			if(s.equals("mutual")){
				return true;
			}
		}
		return false;
	}

	public boolean getFixed(){
		String[] split=hrUserRecord.getCfilter_byproductions().split("\\W");
		for(String s:split){
			if(s.equals("fixed")){
				return true;
			}
		}
		return false;
	}

	public boolean getClosed(){
		String[] split=hrUserRecord.getCfilter_byproductions().split("\\W");
		for(String s:split){
			if(s.equals("closed")){
				return true;
			}
		}
		return false;
	}

	public boolean getUit(){
		String[] split=hrUserRecord.getCfilter_byproductions().split("\\W");
		for(String s:split){
			if(s.equals("UIT")){
				return true;
			}
		}
		return false;
	}

	public boolean getMaxCBorder(){
		return hrUserRecord.isMaxCBorder();
	}

	public boolean getMinCBorder(){
		return hrUserRecord.isMinCBorder();
	}


	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
		Selectors.wireComponents(view, this, false);
	}

	public ClientFilter getClientFilter() {
		return clientFilter;
	}

	public ListModel<Client> getClientModel() {
		if(equities!=null||mutualFund!=null||fixedIncome!=null||closedEnd!=null||uit!=null){
			this.checkClientFilters();
		}
		
		return clientModel;
	}

	public String getFooter() {
		return String.format(footerMessage, currentClient.size());
	}

	@Command
	@NotifyChange({"clientModel", "footer"})
	public void checkClientFilters(){
		//String path=Path.getPath(equities);
		List<Client> result=new ArrayList<Client>();
		List<Client> clientList=ClientData.getAllClients();
		if(equities.isChecked()||mutualFund.isChecked()||fixedIncome.isChecked()||closedEnd.isChecked()||uit.isChecked()){
			for(Client c:clientList){
				if((equities.isChecked()&&c.getType().equals("Equities"))||
						(mutualFund.isChecked()&&c.getType().equals("Mutual Fund"))||
						(fixedIncome.isChecked()&&c.getType().equals("Fixed Income"))||
						(closedEnd.isChecked()&&c.getType().equals("Closed-End Funds"))||
						(uit.isChecked()&&c.getType().equals("UITs"))){
					result.add(c);
				}
			}
			currentClient=new ArrayList<Client>(result);
		}else{
			currentClient=ClientData.getAllClients();
		}
		clientModel=new ListModelList<Client>(currentClient);
	}

	@Command
	@NotifyChange({"clientModel", "footer"})
	public void changeFilter() {
		currentClient = ClientData.getFilterClients(clientFilter);
	}

	@Command
	public void doMaxCBorder(){
		hrUserRecord.setMaxCBorder(maxCBorder.isOpen());
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doMinCBorder(){
		hrUserRecord.setMinCBorder(minCBorder.isOpen());
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doEquities(){
		if(equities.isChecked()){
			hrUserRecord.setCfilter_byproductions(hrUserRecord.getCfilter_byproductions()+"equities;");
		}else{
			String[] split=hrUserRecord.getFilter_by_changes().split("\\W");
			String fliterByChanges="";
			for(String s:split){
				if(!s.equals("equities")){
					fliterByChanges=fliterByChanges+";"+s;
				}
			}
			hrUserRecord.setCfilter_byproductions(fliterByChanges);
		}
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doMutual(){
		if(mutualFund.isChecked()){
			hrUserRecord.setCfilter_byproductions(hrUserRecord.getCfilter_byproductions()+"mutual;");
		}else{
			String[] split=hrUserRecord.getFilter_by_changes().split("\\W");
			String fliterByChanges="";
			for(String s:split){
				if(!s.equals("mutual")){
					fliterByChanges=fliterByChanges+";"+s;
				}
			}
			hrUserRecord.setCfilter_byproductions(fliterByChanges);
		}
		rjUserRecordDao.update(hrUserRecord);
	}


	@Command
	public void doFixedIncome(){
		if(fixedIncome.isChecked()){
			hrUserRecord.setCfilter_byproductions(hrUserRecord.getCfilter_byproductions()+"fixed;");
		}else{
			String[] split=hrUserRecord.getFilter_by_changes().split("\\W");
			String fliterByChanges="";
			for(String s:split){
				if(!s.equals("fixed")){
					fliterByChanges=fliterByChanges+";"+s;
				}
			}
			hrUserRecord.setCfilter_byproductions(fliterByChanges);
		}
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doClosedEnd(){
		if(closedEnd.isChecked()){
			hrUserRecord.setCfilter_byproductions(hrUserRecord.getCfilter_byproductions()+"closed;");
		}else{
			String[] split=hrUserRecord.getFilter_by_changes().split("\\W");
			String fliterByChanges="";
			for(String s:split){
				if(!s.equals("closed")){
					fliterByChanges=fliterByChanges+";"+s;
				}
			}
			hrUserRecord.setCfilter_byproductions(fliterByChanges);
		}
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doUit(){
		if(uit.isChecked()){
			hrUserRecord.setCfilter_byproductions(hrUserRecord.getCfilter_byproductions()+"UIT;");
		}else{
			String[] split=hrUserRecord.getFilter_by_changes().split("\\W");
			String fliterByChanges="";
			for(String s:split){
				if(!s.equals("UIT")){
					fliterByChanges=fliterByChanges+";"+s;
				}
			}
			hrUserRecord.setCfilter_byproductions(fliterByChanges);
		}
		rjUserRecordDao.update(hrUserRecord);
	}
}