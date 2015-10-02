package action;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.ObjectUtils.Null;
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
import org.zkoss.zul.Iframe;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.SimpleGroupsModel;
import org.zkoss.zul.Window;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.Label;
import org.zkoss.*;

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

import bean.RjNewsBean;
import bean.RjNewsSubsBean;
import view_model.RjNewsModel;

public class RjNewsController {

	@Wire
	private Window rjNews;
	
	@Wire
	private Listbox list;
	
	@Wire
	private Listheader lkjh;
	
	@Wire
	private Iframe miniWindow;

	static boolean[] subFilterBool=new boolean[5];
	
	RjNewsModel evDat=new RjNewsModel(subFilterBool);
	RjNewsSubsBean onlyBean=new RjNewsSubsBean();
	String subFilter=null;
	


	public RjNewsModel getevDat() {
		
		return evDat;
	}

	@Command
	@NotifyChange("evDat")
	public void setUrl(@BindingParam("ent") RjNewsBean entity) {
		//evDat.deleteMail(myMail);
		System.out.println(entity.getUrl());
		//miniWindow.setSrc(entity.getUrl());

	}
	@Command
	@NotifyChange("evDat")
	public void setReco(@BindingParam("ent") RjNewsBean entity) {
		evDat.incRecoById(entity.id);
		evDat.refresh();
		System.out.println(evDat.beanById(entity.id).recommend);
		//System.out.println(entity.getUrl());
		
		//miniWindow.setSrc(entity.getUrl());

	}
	public void RefreshFilter(){
//		subFilter=null;
		for (int i = 0; i < 5; i++) 
			subFilterBool[i]=false;
		
		if(onlyBean.isTechnology()) subFilterBool[0]=true;
		if(onlyBean.isPharmaceuticals()) subFilterBool[1]=true;
		if(onlyBean.isInfrastructure()) subFilterBool[2]=true;
		if(onlyBean.isPower()) subFilterBool[3]=false;
		if(onlyBean.isAutomobile()) subFilterBool[4]=true;
		System.out.println(subFilterBool[2]);
		
		
	}
}