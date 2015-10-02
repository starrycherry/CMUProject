package portletUtil;

import bean.UserPortalColumn;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.MaximizeEvent;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Include;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Panelchildren;

import portletUtil.PortletInfo.PortletType;
import service.UserPortalColumnService;

public class PortletPanel extends Panel {
	
	private static final long serialVersionUID = -431782012982443982L;
	
	private static final String KEY_PANEL_INFO = "KEY_PANEL_INFO";
	
	public PortletPanel(final PortletInfo info, final String username, final int columnNo, final int pageNo, final ListModelList<PortletInfo> listModelList) {		
		this.setBorder("normal");
		this.setCollapsible(true);
		this.setClosable(true);
		this.setMaximizable(true);
		this.appendChild(new Panelchildren());
		this.setId(info.getName());
		this.addEventListener(Events.ON_CLOSE, new EventListener<Event> () {
			@Override
			public void onEvent(Event event) throws Exception {
				insert(listModelList, PortletData.PORTLET_INFOS.get(info.getName()));
				UserPortalColumnService portalSer = new UserPortalColumnService();
				UserPortalColumn userPortalColumn = portalSer.getUserPortalColumnByUsernameAndNo(username, columnNo, pageNo);
				if(userPortalColumn != null) {
					String layout = userPortalColumn.getWidgets_order();
					if(layout != null) {
						layout = layout.replaceAll(info.getName() + ", ", "");
						layout = layout.replaceAll(", " + info.getName(), "");
						layout = layout.replaceAll(info.getName(), "");
					}
					userPortalColumn.setWidgets_order(layout);
					portalSer.updateUserPortalColumn(userPortalColumn);
				}
			}
		});
		
		this.addEventListener(Events.ON_MAXIMIZE, new EventListener<Event>() {
			// This event listener handle the click of maximize button of panel
			@Override
			public void onEvent(Event event) throws Exception {
				MaximizeEvent maxEvent = (MaximizeEvent) event;
				Panel p = (Panel) maxEvent.getTarget();
				PortletInfo pInfo = (PortletInfo) p.getAttribute(KEY_PANEL_INFO);
				
				Component innerComp = (Component) p.getPanelchildren().getChildren().get(0);
				if (pInfo.getType().equals(PortletType.IFRAME)) { // External Resource
					((Iframe) innerComp).setSrc(maxEvent.isMaximized() ? pInfo.getUrlMax() : pInfo.getUrlMin());
				} else {// Internal Resource - we do not use Iframe
					((Include) innerComp).setSrc(maxEvent.isMaximized() ? pInfo.getUrlMax() : pInfo.getUrlMin());
				}
			}
		});
		
		this.setAttribute(KEY_PANEL_INFO, info);
		this.setHeight(info.getMinSize());
		this.setTitle(info.getName());
		
		if (info.getType().equals(PortletType.IFRAME)) {
			this.getPanelchildren().appendChild(new PortletIframe(info));
		} else {
			this.getPanelchildren().appendChild(new PortletInclude(info));
		}
	}
	
	private class PortletIframe extends Iframe{
		private static final long serialVersionUID = -1687305299974971137L;

		public PortletIframe(PortletInfo info) {
			super();
			
			this.setSrc(info.getUrlMin());
			this.setScrolling(info.getScroll());
			
			this.setWidth("100%");
			this.setHeight("100%");
		}
	}
	
	private class PortletInclude extends Include {
		private static final long serialVersionUID = -8697286520073322551L;

		public PortletInclude(PortletInfo info) {
			super(info.getUrlMin());
			
			this.setWidth("100%");
			this.setHeight("100%");
		}
	}
	
	private void insert(ListModelList<PortletInfo> list, PortletInfo portlet) {
		if(list.get(0).getName().compareTo(portlet.getName()) > 0) {
			list.add(0, portlet);
			return;
		}
		if(list.get(list.getSize() - 1).getName().compareTo(portlet.getName()) < 0) {
			list.add(portlet);
			return;
		}
		for(int i = 0; i < list.size() - 1; i++) {
			if(list.get(i).getName().compareTo(portlet.getName()) < 0 && list.get(i + 1).getName().compareTo(portlet.getName()) > 0) {
				list.add(i + 1, portlet);
				return;
			}
		}
	}
}
