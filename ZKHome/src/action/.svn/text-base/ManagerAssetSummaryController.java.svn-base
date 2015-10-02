package action;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Radio;

import bean.Asset;
import dao.ManagerAssetDataDao;

public class ManagerAssetSummaryController extends SelectorComposer<Component> {
    private static final long serialVersionUID = 1L;
    private ManagerAssetDataDao managerAssetDataDao = new ManagerAssetDataDao();
    private Grid foolList;
    int manager_id = 1;
 
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        foolList = (Grid) comp;
        List<Asset> thisasset = managerAssetDataDao.getAssetsByCategory("Asset Class", manager_id);
        foolList.setModel(new ListModelList<Asset>(thisasset));
    }
 
    @Listen("onCheck = #categorySelector")
    public void selectCategory(CheckEvent event) {
        String selectedCategory = ((Radio) event.getTarget()).getLabel();
        ListModel<Asset> model = null;
        if (selectedCategory.equals("Asset Class")) {
        	List<Asset> thisasset = managerAssetDataDao.getAssetsByCategory(selectedCategory, manager_id);
        	model = new ListModelList<Asset>(thisasset);
        } else {
        	
        	List<Asset> thisasset = managerAssetDataDao.getAssetsByCategory(selectedCategory, manager_id);
        	model = new ListModelList<Asset>(thisasset);
        }
        foolList.setModel(model);
    }
}