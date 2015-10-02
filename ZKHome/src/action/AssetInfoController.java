package action;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;

import bean.AssetInfoEntity;
import dao.AssetDataDao;

public class AssetInfoController extends SelectorComposer<Component>{

	private static final long serialVersionUID = 1L;

	private AssetDataDao assetDataDao = new AssetDataDao();
	private Grid foolList;
	int fa_number = 2;
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		String s[] = Executions.getCurrent().getParameterMap().get("id");
		String ss[] = s[0].split("_");
		System.out.println("----------------------------------");
		System.out.println(ss[0]);
		System.out.println(ss[1]);
		System.out.println("----------------------------------");
		
		foolList = (Grid) comp;
		foolList.setModel(new ListModelList<AssetInfoEntity>(assetDataDao.getSpecificCategoryAssetInfoEntitys(ss[0], ss[1], fa_number)));
	}
}