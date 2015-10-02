package view_model;

import java.util.Date;
import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;

import bean.ManagerProductionEntity;
import dao.ManagerProductionDataDao;

public class MyProductionViewModel {

	private ManagerProductionDataDao managerProductionDataDao = new ManagerProductionDataDao();
	List<ManagerProductionEntity> holdingModel;
	int managerId = 1;
	Date dateToDt;
	Date dateFromDt;

	@Wire
	private Checkbox l1;

	@Wire
	private Checkbox l2;

	@Wire
	private Checkbox l3;

	@Wire
	private Checkbox l4;

	@Wire
	private Datebox dateTo;

	@Wire
	private Datebox dateFrom;

	@Listen("onChange= #dateTo")
	public void pullDateTo(){
		dateToDt = ((Datebox) dateTo).getValue();	
	}

	@Listen("onChange= #dateFrom")
	public void pullDateFrom(){
		dateFromDt = ((Datebox) dateFrom).getValue();	
	}

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
		Selectors.wireComponents(view, this, false);
	}

	public List<ManagerProductionEntity> getHoldingModel() {
		return holdingModel;
	}

	public void setHoldingModel(List<ManagerProductionEntity> holdingModel) {
		this.holdingModel = holdingModel;
	}

	@Command
	@NotifyChange({"holdingModel", "footer"})
	public void checkChangeFilters(){
		StringBuffer s = new StringBuffer();

		if(l1.isChecked()){
			s.append("Commissions");
		}
		if(l2.isChecked()){
			if(s.length() == 0){
				s.append("Fees");
			}
			else
				s.append("_Fees");
		}
		if(l3.isChecked()){
			if(s.length() == 0){
				s.append("Trails");
			}
			else
				s.append("_Trails");

		}
		if(l4.isChecked()){
			if(s.length() == 0){
				s.append("Directs");
			}
			else
				s.append("_Directs");
		}
		pullDateTo();
		pullDateFrom();

//		System.out.println(dateToDt.toString());
//		System.out.println(dateFromDt.toString());

		holdingModel = managerProductionDataDao.getFilteredMyProductionEntitys(s.toString(), dateToDt.toString(), dateFromDt.toString(), managerId);
	}


}