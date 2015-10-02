package view_model;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Path;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.West;

import dao.HoldingResearchUserRecordDao;
import dao.UserDao;

import bean.HoldingResearchUserRecord;
import bean.User;

public class HoldingResearchHomeViewModel {

	@Command
	public void saveSetting(){
		Checkbox heldClient= (Checkbox) Path.getComponent("/tp1/heldClient");
		Checkbox up=(Checkbox) Path.getComponent("/tp1/up");
		Checkbox down=(Checkbox) Path.getComponent("/tp1/down");
		Checkbox neutral=(Checkbox) Path.getComponent("/tp1/neutral");
		Checkbox equities=(Checkbox) Path.getComponent("/tp1/equities");
		Checkbox mutualFund=(Checkbox) Path.getComponent("/tp1/mutualFund");
		Checkbox fixedIncome=(Checkbox) Path.getComponent("/tp1/fixedIncome");
		Checkbox closedEnd=(Checkbox) Path.getComponent("/tp1/closedEnd");
		Checkbox uit=(Checkbox) Path.getComponent("/tp1/uit");
		Column holdingColumn=(Column) Path.getComponent("/tp1/holdingColumn");
		Column researchColumn=(Column) Path.getComponent("/tp1/researchColumn");
		Column typeColumn=(Column) Path.getComponent("/tp1/typeColumn");
		Column clientColumn=(Column) Path.getComponent("/tp1/clientColumn");
		Column dateColumn=(Column) Path.getComponent("/tp1/dateColumn");
		West maxHBorder=(West)Path.getComponent("/tp1/maxHBorder");
		Groupbox maxHClientBox=(Groupbox)Path.getComponent("/tp1/maxHClientBox");
		Groupbox maxHChangeBox=(Groupbox)Path.getComponent("/tp1/maxHChangeBox");
		Groupbox maxHProductionBox=(Groupbox)Path.getComponent("/tp1/maxHProductionBox");
		West minHBorder=(West)Path.getComponent("/tp1/minHBorder");
		Groupbox minHClientBox=(Groupbox)Path.getComponent("/tp1/minHClientBox");
		Groupbox minHChangeBox=(Groupbox)Path.getComponent("/tp1/minHChangeBox");
		Groupbox minHProductionBox=(Groupbox)Path.getComponent("/tp1/minHProductionBox");

		Checkbox cequities=(Checkbox) Path.getComponent("/tp2/equities");
		Checkbox cmutualFund=(Checkbox) Path.getComponent("/tp2/mutualFund");
		Checkbox cfixedIncome=(Checkbox) Path.getComponent("/tp2/fixedIncome");
		Checkbox cclosedEnd=(Checkbox) Path.getComponent("/tp2/closedEnd");
		Checkbox cuit=(Checkbox) Path.getComponent("/tp2/uit"); 
		Column cnameColumn=(Column) Path.getComponent("/tp2/nameColumn");
		Column ctypeColumn=(Column) Path.getComponent("/tp2/typeColumn");
		Column cresearchColumn=(Column) Path.getComponent("/tp2/researchColumn");
		Column cdateColumn=(Column) Path.getComponent("/tp2/dateColumn");
		West maxCBorder=(West)Path.getComponent("/tp2/maxCBorder");
		West minCBorder=(West)Path.getComponent("/tp2/minCBorder");

		String filterByChanges=(up.isChecked()?"up;":"")+(down.isChecked()?"down;":"")+(neutral.isChecked()?"neutral":"");
		String hfilterByProductions=(equities.isChecked()?"equities;":"")+(mutualFund.isChecked()?"mutual;":"")+(fixedIncome.isChecked()?"fixed;":"")+(closedEnd.isChecked()?"closed":"")+(uit.isChecked()?"UIT":"");
		String cfilterByProductions=(cequities.isChecked()?"equities;":"")+(cmutualFund.isChecked()?"mutual;":"")+(cfixedIncome.isChecked()?"fixed;":"")+(cclosedEnd.isChecked()?"closed":"")+(cuit.isChecked()?"UIT":"");

		HoldingResearchUserRecordDao rjUserRecordDao=new HoldingResearchUserRecordDao();
		UserDao userDao=new UserDao();
		User user=userDao.findUserByUsername((String)(Sessions.getCurrent().getAttribute("loginName")));

		if(user == null) {
			return;
		}

		HoldingResearchUserRecord hrUserRecord=rjUserRecordDao.findUserRecordByUser(user.getUser_id());

		hrUserRecord.setHoldings(holdingColumn.isVisible());
		hrUserRecord.setHtype(typeColumn.isVisible());
		hrUserRecord.setHresearch(researchColumn.isVisible());
		hrUserRecord.setHclients(clientColumn.isVisible());
		hrUserRecord.setHdate(dateColumn.isVisible());
		hrUserRecord.setHeld_by_clients(heldClient.isChecked());
		hrUserRecord.setFilter_by_changes(filterByChanges);
		hrUserRecord.setHfilter_by_productions(hfilterByProductions);
		hrUserRecord.setName(cnameColumn.isVisible());
		hrUserRecord.setCtype(ctypeColumn.isVisible());
		hrUserRecord.setCresearch(cresearchColumn.isVisible());
		hrUserRecord.setCdate(cdateColumn.isVisible());
		hrUserRecord.setCfilter_byproductions(cfilterByProductions);

		if(maxHBorder!=null){
			hrUserRecord.setMaxHBorder(maxHBorder.isOpen());
			hrUserRecord.setMaxHClientBox(maxHClientBox.isOpen());
			hrUserRecord.setMaxHChangeBox(maxHChangeBox.isOpen());
			hrUserRecord.setMaxHProductionBox(maxHProductionBox.isOpen());
			hrUserRecord.setMaxCBorder(maxCBorder.isOpen());
		}else if(minHBorder!=null){
			hrUserRecord.setMinHBorder(minHBorder.isOpen());
			hrUserRecord.setMinHClientBox(minHClientBox.isOpen());
			hrUserRecord.setMinHChangeBox(minHChangeBox.isOpen());
			hrUserRecord.setMinHProductionBox(minHProductionBox.isOpen());
			hrUserRecord.setMinCBorder(minCBorder.isOpen());
		}

		rjUserRecordDao.update(hrUserRecord);

	}


}
