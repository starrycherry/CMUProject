package action;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;

import bean.ManagerProductionSummaryEntity;
import dao.ManagerProductionDataDao;
import dao.RoleTestDao;

public class ManagerProductionSummaryController extends SelectorComposer<Component>{

	private static final long serialVersionUID = 1L;

	private RoleTestDao roleTestDao = new RoleTestDao();
	private ManagerProductionDataDao managerProductionDataDao = new ManagerProductionDataDao();

	private Grid foolList;
	private List<Checkbox> selectedCheckboxs;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		selectedCheckboxs = new ArrayList<Checkbox>();
		int manager_id = 1;
		foolList = (Grid) comp;
		foolList.setModel(new ListModelList<ManagerProductionSummaryEntity>(managerProductionDataDao.getAllMyProductionSummaryEntitys(manager_id)));
	}

	public void onModifySelectedList(ForwardEvent event){
		System.out.println(selectedCheckboxs.size());
		Checkbox checkbox = (Checkbox) event.getOrigin().getTarget();		
		if (checkbox.isChecked()) 
			selectedCheckboxs.add(checkbox);
		else selectedCheckboxs.remove(checkbox);
	}
}