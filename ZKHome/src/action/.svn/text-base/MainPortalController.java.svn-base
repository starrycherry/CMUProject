package action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkmax.zul.Portalchildren;
import org.zkoss.zkmax.zul.Portallayout;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Window;

import bean.DashWidPrevBean;
import bean.UserPortalColumn;
import portletUtil.PortletComparator;
import portletUtil.PortletData;
import portletUtil.PortletInfo;
import portletUtil.PortletPanel;
import service.UserPortalColumnService;
import view_model.DashWidPrev;

public class MainPortalController extends SelectorComposer<Window> {
	 
    private static final long serialVersionUID = -759550281994303480L;
     
    @Wire
    private Label pageLabel;
    
    @Wire
    private Label addPageError;
    
    @Wire
    private Div detailDiv;
    
    @Wire
    private Div preferencePanel;
     
    @Wire
    private Listbox widgetListbox;
     
    @Wire
    private Portallayout portalLayout;
    
    @Wire
    private Image descImg;
    @Wire
    private Label descLab;
    @Wire
    private Checkbox detWid;
    @Wire
    private Button addbtn;
    
    @Wire("portalchildren")
    private List<Portalchildren> portalChildren;
    
    private String loginName = (String) Sessions.getCurrent().getAttribute("loginName");
    
    private UserPortalColumnService portalSer = new UserPortalColumnService();
    
    private int pageNo;
    
    private ListModelList<PortletInfo> listModelList;
    
    DashWidPrev detaDat=new DashWidPrev();
    
 
    public void doAfterCompose(Window win) throws Exception {
        super.doAfterCompose(win);
        
        // Initialize widgets collection list
        listModelList = new ListModelList<PortletInfo>(PortletData.PORTLET_INFOS.values());
        listModelList.sort(new PortletComparator(), true);
        if((Integer) Sessions.getCurrent().getAttribute("loginRole") != 1) {
        	listModelList.remove(PortletData.PORTLET_INFOS.get("Manager Production"));
        }
        listModelList.addToSelection(PortletData.PORTLET_INFOS.get("Holdings Research"));
        widgetListbox.setModel(listModelList);
        this.pageNo = Integer.parseInt(pageLabel.getValue());
    }
 
    // Event Handling
    @Listen("onClick = #addbtn")
    public void addPortlet(Event e) {
    	Listitem selected = widgetListbox.getSelectedItem();
    	int firstColNo = portalLayout.getChildren().get(0).getChildren().size();
    	int secondColNo = portalLayout.getChildren().get(1).getChildren().size();
    	int totalWidgetNo = firstColNo + secondColNo;
        if(selected == null) {
        	addPageError.setValue("Oops! Please select a widget.");
        } else {
        	if(totalWidgetNo >= 8) {
        		addPageError.setValue("Oops! Too many widgets on this page. Why not create a new page?");
        	} else {
		  
		        int selectedColumnIdx = firstColNo <= secondColNo ? 0 : 1;
		    	String widgetName = selected.getValue().toString();
		        Portalchildren pc = (Portalchildren) portalLayout.getChildren().get(selectedColumnIdx);
		        pc.appendChild(
		        		new PortletPanel(PortletData.PORTLET_INFOS.get(widgetName),
		        				loginName, selectedColumnIdx, pageNo, listModelList));
		        listModelList.remove(PortletData.PORTLET_INFOS.get(widgetName));
		        this.saveStatus();
        	}
        }
    	
    }
//    @Listen("onCreate = #addbtn")
//    public void addPortL(){
//    	addPageError.setValue("");
//    	if(listModelList.getSize()==0){
//    		addbtn.setLabel("No Widgets");
//    	}
//    }
    
    @Listen("onSelect= #widgetListbox")
    public void loadD(){
    	addPageError.setValue("");
    	refreshDetails();
    	
    }
    @Listen("onCreate= #widgetListbox")
    public void loadD1(){
    	refreshDetails();
    	addPageError.setValue("");
    }
    @Listen("onCheck= #detWid")
    public void loadD2(){
    //	System.out.println("ksdjdnj");
    	addPageError.setValue("");
    	Listitem selected = widgetListbox.getSelectedItem();
    	if(selected == null) {
        	addPageError.setValue("Oops! Please select a widget.");
        } else{
        	addPageError.setValue("");
    	refreshDetails();
        }
    	
    }
    
    public void refreshDetails(){
    
    	if(detWid.isChecked()){
    		detailDiv.setVisible(true);
    		//System.out.println("  njnjn   "+"   comp   " );
    		//System.out.println(widgetListbox.getSelectedItem().getValue().toString());
//System.out.println();
    		//descImg.setSrc("/images/plus.png");
if (listModelList.getSize()!=0){
    		if(!widgetListbox.getSelectedItem().getValue().toString().equals(null)){
        		String widgetName = widgetListbox.getSelectedItem().getValue().toString();
    			DashWidPrevBean bean= detaDat.getData(widgetName);
    			descImg.setSrc(bean.imageUri);
    			descLab.setValue(bean.disc);
    		}
}
    	}else {
    			detailDiv.setVisible(false);
		}
        
    }
    @Listen("onPortalMove = #portalLayout")
    public void saveStatus() {
        int i = 0;
        for (Component portalChild : portalLayout.getChildren()) {
            List<String> portletIds = new ArrayList<String>();
            for (Component portlet : portalChild.getChildren()) {
                portletIds.add(portlet.getId());
            }
            UserPortalColumn portalColumn = portalSer.getUserPortalColumnByUsernameAndNo(loginName, i, pageNo);
            if(portalColumn != null) {
            	portalColumn.setWidgets_order(portletIds.toString());
                portalSer.updateUserPortalColumn(portalColumn);
            } else {
            	portalSer.updateOrSaveWidgetsOrderInUserPortalColumn(loginName, i, pageNo, portletIds.toString());
            }
            i++;
        }
    }
     
    @Listen("onCreate = #portalLayout")
    public void initStatus() {
        List<Component> panelchildren = portalLayout.getChildren();
        boolean hasWidget = false;
        for (int i = 0; i < panelchildren.size(); i++) {
            String layout = portalSer.getLayoutOnColumnAndPage(loginName, i, Integer.parseInt(pageLabel.getValue()));
            Portalchildren pc = (Portalchildren) panelchildren.get(i);
            if (layout != null && layout.length() != 2) {
        		for (String widget : convertLayout(layout)) {
        			hasWidget = true;
        			pc.appendChild(new PortletPanel(PortletData.PORTLET_INFOS.get(widget),
        	        				loginName, i, pageNo, listModelList));
        			listModelList.remove(PortletData.PORTLET_INFOS.get(widget));
                }
            }
        }
        if(!hasWidget) {
        	preferencePanel.setVisible(true);
        }
    }
    
    private String[] convertLayout(String layoutList) {
    	String tmp = layoutList.substring(1, layoutList.length() - 1);
    	return tmp.split(", ");
    }
}