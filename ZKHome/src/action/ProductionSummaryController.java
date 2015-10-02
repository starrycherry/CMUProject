package action;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;

import bean.FAProductionSummaryEntity;
import dao.FAProductionDataDao;
import dao.PopulateDataDao;

public class ProductionSummaryController extends SelectorComposer<Component>{

	private static final long serialVersionUID = 1L;

	private FAProductionDataDao productionDataDao = new FAProductionDataDao();

	private Grid foolList;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

//		PopulateDataDao populateDataDao = new PopulateDataDao();
//		populateDataDao.populateData();
		
		int fa_number = 2;
		
		foolList = (Grid) comp;
		foolList.setModel(new ListModelList<FAProductionSummaryEntity>(productionDataDao.getAllMyProductionSummaryEntitys(fa_number)));
	}

	
}