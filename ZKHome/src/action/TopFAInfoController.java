package action;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import bean.TopFA;
import dao.TopFADataDao;

public class TopFAInfoController extends SelectorComposer<Component> {
	
	private static final long serialVersionUID = 1L;
	
	private TopFADataDao topFADataDao = new TopFADataDao();
	private Grid foolList;
	int manager_id = 1;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		List<TopFA> thisasset = topFADataDao.getTOPFAByCategory("Top Production", manager_id);

		foolList = (Grid) comp;
		foolList.setModel(new ListModelList<TopFA>(thisasset));
	}
}