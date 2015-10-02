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
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Menupopup;
import org.zkoss.zul.West;

import dao.ClientData;
import dao.HoldingData;
import dao.HoldingResearchUserRecordDao;
import dao.UserDao;
import bean.Client;
import bean.Holding;
import bean.HoldingResearchUserRecord;
import bean.User;

public class FilterViewModelHolding {

	private static final String footerMessage = "A Total of %d Holdings Items";
	private HoldingFilter holdingFilter = new HoldingFilter();
	List<Holding> currentHolding = HoldingData.getAllHoldings();
	ListModel<Holding> holdingModel = new ListModelList<Holding>(currentHolding);
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
	private Checkbox up;

	@Wire
	private Checkbox down;

	@Wire
	private Checkbox neutral;

	@Wire
	private West maxHBorder;

	@Wire
	private Groupbox maxHClientBox;

	@Wire
	private Groupbox maxHChangeBox;

	@Wire
	private Groupbox maxHProductionBox;

	@Wire
	private Checkbox heldClient;

	@Wire
	private West minHBorder;

	@Wire
	private Groupbox minHClientBox;

	@Wire
	private Groupbox minHChangeBox;

	@Wire
	private Groupbox minHProductionBox;

	public FilterViewModelHolding(){
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

	public boolean getHoldings(){
		return hrUserRecord.isHoldings();
	}

	public boolean getHresearch(){
		return hrUserRecord.isHresearch();
	}

	public boolean getHtype(){
		return hrUserRecord.isHtype();
	}

	public boolean getHclients(){
		return hrUserRecord.isHclients();
	}

	public boolean getHdate(){
		return hrUserRecord.isHdate();
	}

	public boolean getUp(){
		String[] split=hrUserRecord.getFilter_by_changes().split("\\W");
		for(String s:split){
			if(s.equals("up")){
				return true;
			}
		}
		return false;
	}

	public boolean getDown(){
		String[] split=hrUserRecord.getFilter_by_changes().split("\\W");
		for(String s:split){
			if(s.equals("down")){
				return true;
			}
		}
		return false;
	}

	public boolean getNeutral(){
		String[] split=hrUserRecord.getFilter_by_changes().split("\\W");
		for(String s:split){
			if(s.equals("neutral")){
				return true;
			}
		}
		return false;
	}

	public boolean getEquities(){
		String[] split=hrUserRecord.getHfilter_by_productions().split("\\W");
		for(String s:split){
			if(s.equals("equities")){
				return true;
			}
		}
		return false;
	}

	public boolean getMutral(){
		String[] split=hrUserRecord.getHfilter_by_productions().split("\\W");
		for(String s:split){
			if(s.equals("mutual")){
				return true;
			}
		}
		return false;
	}

	public boolean getFixed(){
		String[] split=hrUserRecord.getHfilter_by_productions().split("\\W");
		for(String s:split){
			if(s.equals("fixed")){
				return true;
			}
		}
		return false;
	}

	public boolean getClosed(){
		String[] split=hrUserRecord.getHfilter_by_productions().split("\\W");
		for(String s:split){
			if(s.equals("closed")){
				return true;
			}
		}
		return false;
	}

	public boolean getUit(){
		String[] split=hrUserRecord.getHfilter_by_productions().split("\\W");
		for(String s:split){
			if(s.equals("UIT")){
				return true;
			}
		}
		return false;
	}

	public boolean getHeldByClients(){
		return hrUserRecord.isHeld_by_clients();
	}

	public boolean getMaxHBorder(){
		return hrUserRecord.isMaxHBorder();
	}

	public boolean getMaxHClientBox(){
		return hrUserRecord.isMaxHClientBox();
	}

	public boolean getMaxHProductionBox(){
		return hrUserRecord.isMaxHProductionBox();
	}

	public boolean getMaxHChangeBox(){
		return hrUserRecord.isMaxHChangeBox();
	}

	public boolean getMinHBorder(){
		return hrUserRecord.isMinHBorder();
	}

	public boolean getMinHClientBox(){
		return hrUserRecord.isMinHClientBox();
	}

	public boolean getMinHChangeBox(){
		return hrUserRecord.isMinHChangeBox();
	}

	public boolean getMinHProductionBox(){
		return hrUserRecord.isMinHProductionBox();
	}


	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
		Selectors.wireComponents(view, this, false);
	}


	public HoldingFilter getHoldingFilter() {
		return holdingFilter;
	}

	public ListModel<Holding> getHoldingModel() {

		if(heldClient!=null||up!=null||down!=null||neutral!=null||equities!=null||mutualFund!=null||fixedIncome!=null||closedEnd!=null||uit!=null){


			List<Holding> changeList=this.checkChangeFilters();
			List<Holding> checkList=this.checkFilters();

			List<Holding> result=new ArrayList<Holding>();
			if(changeList.size()<HoldingData.getAllHoldings().size()&&checkList.size()<HoldingData.getAllHoldings().size()){
				for(Holding h:checkList){
					if(changeList.contains(h)){
						result.add(h);
					}
				}
				currentHolding = new ArrayList<Holding>(result);
			}else if(changeList.size()<HoldingData.getAllHoldings().size()){
				currentHolding = new ArrayList<Holding>(changeList);
			}else if(checkList.size()<HoldingData.getAllHoldings().size()){
				currentHolding = new ArrayList<Holding>(checkList);
			}
		}
		holdingModel = new ListModelList<Holding>(currentHolding);
		return holdingModel;
	}

	public String getFooter() {
		return String.format(footerMessage, currentHolding.size());
	}




	@Command
	@NotifyChange({"holdingModel", "footer"})
	public List<Holding> checkFilters(){
		//String path=Path.getPath(minHBorder);
		List<Holding> result = new ArrayList<Holding>();
		List<Holding> holdingList=HoldingData.getAllHoldings();
		if(equities.isChecked()||mutualFund.isChecked()||fixedIncome.isChecked()||closedEnd.isChecked()||uit.isChecked()){
			for(Holding h : holdingList){
				if((equities.isChecked()&&h.getType().equals("Equities"))||
						(mutualFund.isChecked()&&h.getType().equals("Mutual Fund"))||
						(fixedIncome.isChecked()&&h.getType().equals("Fixed Income"))||
						(closedEnd.isChecked()&&h.getType().equals("Closed-End Funds"))||
						(uit.isChecked()&&h.getType().equals("UITs"))){
					result.add(h);
				}
			}
			currentHolding = new ArrayList<Holding>(result);
		}else{
			currentHolding=HoldingData.getAllHoldings();
		}


		holdingModel = new ListModelList<Holding>(currentHolding);
		return currentHolding;
	}

	@Command
	@NotifyChange({"holdingModel", "footer"})
	public List<Holding> checkChangeFilters(){
		List<Holding> result = new ArrayList<Holding>();
		List<Holding> holdingList=HoldingData.getAllHoldings();
		if(up.isChecked()||down.isChecked()||neutral.isChecked()){
			for(Holding h:holdingList){
				if((up.isChecked()&&h.getChange().equals("up"))||(down.isChecked()&&h.getChange().equals("down"))||(neutral.isChecked()&&h.getChange().equals("netural"))){
					result.add(h);
				}
			}
			currentHolding = new ArrayList<Holding>(result);
		}else{
			currentHolding=HoldingData.getAllHoldings();
		}
		holdingModel = new ListModelList<Holding>(currentHolding);
		return currentHolding;
	}

	@Command
	@NotifyChange({"holdingModel", "footer"})
	public void changeFilter() {
		currentHolding = HoldingData.getFilterHoldings(holdingFilter);
		holdingModel = new ListModelList<Holding>(currentHolding);
	}

	@Command
	public void doMaxHBorder(){
		hrUserRecord.setMaxHBorder(maxHBorder.isOpen());
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doMaxHClientBox(){
		hrUserRecord.setMaxHClientBox(maxHClientBox.isOpen());
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doMaxHChangeBox(){
		hrUserRecord.setMaxHChangeBox(maxHChangeBox.isOpen());
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doMaxHProductionBox(){
		hrUserRecord.setMaxHProductionBox(maxHProductionBox.isOpen());
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doHeldClient(){
		hrUserRecord.setHclients(heldClient.isChecked());
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doUp(){
		if(up.isChecked()){
			hrUserRecord.setFilter_by_changes(hrUserRecord.getFilter_by_changes()+"up;");
		}else{
			String[] split=hrUserRecord.getFilter_by_changes().split("\\W");
			String fliterByChanges="";
			for(String s:split){
				if(!s.equals("up")){
					fliterByChanges=fliterByChanges+";"+s;
				}
			}
			hrUserRecord.setFilter_by_changes(fliterByChanges);
		}
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doDown(){
		if(down.isChecked()){
			hrUserRecord.setFilter_by_changes(hrUserRecord.getFilter_by_changes()+"down;");
		}else{
			String[] split=hrUserRecord.getFilter_by_changes().split("\\W");
			String fliterByChanges="";
			for(String s:split){
				if(!s.equals("down")){
					fliterByChanges=fliterByChanges+";"+s;
				}
			}
			hrUserRecord.setFilter_by_changes(fliterByChanges);
		}
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doNeutral(){
		if(neutral.isChecked()){
			hrUserRecord.setFilter_by_changes(hrUserRecord.getFilter_by_changes()+"neutral;");
		}else{
			String[] split=hrUserRecord.getFilter_by_changes().split("\\W");
			String fliterByChanges="";
			for(String s:split){
				if(!s.equals("neutral")){
					fliterByChanges=fliterByChanges+";"+s;
				}
			}
			hrUserRecord.setFilter_by_changes(fliterByChanges);
		}
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doEquities(){
		if(equities.isChecked()){
			hrUserRecord.setHfilter_by_productions(hrUserRecord.getHfilter_by_productions()+"equities;");
		}else{
			String[] split=hrUserRecord.getFilter_by_changes().split("\\W");
			String fliterByChanges="";
			for(String s:split){
				if(!s.equals("equities")){
					fliterByChanges=fliterByChanges+";"+s;
				}
			}
			hrUserRecord.setHfilter_by_productions(fliterByChanges);
		}
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doMutual(){
		if(mutualFund.isChecked()){
			hrUserRecord.setHfilter_by_productions(hrUserRecord.getHfilter_by_productions()+"mutual;");
		}else{
			String[] split=hrUserRecord.getFilter_by_changes().split("\\W");
			String fliterByChanges="";
			for(String s:split){
				if(!s.equals("mutual")){
					fliterByChanges=fliterByChanges+";"+s;
				}
			}
			hrUserRecord.setHfilter_by_productions(fliterByChanges);
		}
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doFixedIncome(){
		if(fixedIncome.isChecked()){
			hrUserRecord.setHfilter_by_productions(hrUserRecord.getHfilter_by_productions()+"fixed;");
		}else{
			String[] split=hrUserRecord.getFilter_by_changes().split("\\W");
			String fliterByChanges="";
			for(String s:split){
				if(!s.equals("fixed")){
					fliterByChanges=fliterByChanges+";"+s;
				}
			}
			hrUserRecord.setHfilter_by_productions(fliterByChanges);
		}
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doClosedEnd(){
		if(closedEnd.isChecked()){
			hrUserRecord.setHfilter_by_productions(hrUserRecord.getHfilter_by_productions()+"closed;");
		}else{
			String[] split=hrUserRecord.getFilter_by_changes().split("\\W");
			String fliterByChanges="";
			for(String s:split){
				if(!s.equals("closed")){
					fliterByChanges=fliterByChanges+";"+s;
				}
			}
			hrUserRecord.setHfilter_by_productions(fliterByChanges);
		}
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doUit(){
		if(uit.isChecked()){
			hrUserRecord.setHfilter_by_productions(hrUserRecord.getHfilter_by_productions()+"UIT;");
		}else{
			String[] split=hrUserRecord.getFilter_by_changes().split("\\W");
			String fliterByChanges="";
			for(String s:split){
				if(!s.equals("UIT")){
					fliterByChanges=fliterByChanges+";"+s;
				}
			}
			hrUserRecord.setHfilter_by_productions(fliterByChanges);
		}
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doMinHBorder(){
		hrUserRecord.setMinHBorder(minHBorder.isOpen());
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doMinHClientBox(){
		hrUserRecord.setMinHClientBox(minHClientBox.isOpen());
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doMinHChangeBox(){
		hrUserRecord.setMinHChangeBox(minHChangeBox.isOpen());
		rjUserRecordDao.update(hrUserRecord);
	}

	@Command
	public void doMinHProductionBox(){
		hrUserRecord.setMinHProductionBox(minHProductionBox.isOpen());
		rjUserRecordDao.update(hrUserRecord);
	}

}