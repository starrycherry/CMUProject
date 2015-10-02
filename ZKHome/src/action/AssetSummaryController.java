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
import dao.AssetDataDao;

public class AssetSummaryController extends SelectorComposer<Component> {
    private static final long serialVersionUID = 1L;
    private AssetDataDao assetDataDao = new AssetDataDao();
    private Grid foolList;
    int fa_number = 2;
 
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        foolList = (Grid) comp;
        List<Asset> thisasset = assetDataDao.getAssetsByCategory("Account Type", fa_number);
        foolList.setModel(new ListModelList<Asset>(thisasset));
    }
 
    @Listen("onCheck = #categorySelector")
    public void selectCategory(CheckEvent event) {
        String selectedCategory = ((Radio) event.getTarget()).getLabel();
        ListModel<Asset> model = null;
        if (selectedCategory.equals("Account Type")) {
        	List<Asset> thisasset = assetDataDao.getAssetsByCategory(selectedCategory, fa_number);
        	model = new ListModelList<Asset>(thisasset);
        } else {
        	
        	List<Asset> thisasset = assetDataDao.getAssetsByCategory(selectedCategory, fa_number);
        	model = new ListModelList<Asset>(thisasset);
        }
        foolList.setModel(model);
    }
}