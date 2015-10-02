package action;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.List;
import java.util.Set;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.ext.Selectable;

import javax.swing.JOptionPane;

import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.GroupsModel;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.SimpleGroupsModel;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.Label;
import org.zkoss.*;

import view_model.CalModel;
import bean.RjCalBean;




public class CalController extends SelectorComposer<Component> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6487307333281118203L;
	/**
	 * 
	 */


	@Wire
	private Label whLabel;
	@Wire
	private Datebox datePk;
	@Wire
	private Checkbox personalChk;
	@Wire
	private Checkbox clientChk;
	@Wire
	private Checkbox teamChk;
	@Wire
	private Checkbox corporateChk;
	@Wire
	private Label wee;
	@Wire
	private Component PersonalC;
	@Wire
	private Listbox calList;

	CalModel evDat=new CalModel();
	public CalModel getData() {
		return	evDat;
	}
	@Listen("onClick= #personalChk")
	public void chkPer(){
		eval();
	}
	@Listen("onClick= #teamChk")
	public void chkTm(){
		eval();
	}
	@Listen("onClick= #clientChk")
	public void chkClnt(){
		eval();
	}
	@Listen("onClick= #corporateChk")
	public void chkCorp(){
		eval();
	}
	@Listen("onChange= #datePk")
	public void pullData(){

		eval();
	}
	@Listen("onCreate= #datePk")
	public void pullData1(){
		eval();
	}	
	public void eval(){
		Date date=datePk.getValue();
		List<RjCalBean> toShow=new ArrayList<RjCalBean>();
		String chkVal="";
		if(corporateChk.isChecked()){
			chkVal="1"+chkVal;
		}else{
			chkVal="0"+chkVal;
		}
		if(clientChk.isChecked()){
			chkVal="1"+chkVal;
		}else{
			chkVal="0"+chkVal;
		}
		if(teamChk.isChecked()){
			chkVal="1"+chkVal;
		}else{
			chkVal="0"+chkVal;
		}
		if(personalChk.isChecked()){
			chkVal="1"+chkVal;
		}else{
			chkVal="0"+chkVal;
		}
		
	
		
//		whLabel.setValue(chkVal);
		toShow=evDat.search(date, chkVal,"1");
		calList.setModel(new ListModelList<RjCalBean>(toShow));
	}
}