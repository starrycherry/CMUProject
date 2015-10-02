package action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;

import bean.MyProductionEntity;
import dao.ProductionDataDao;

public class MyProductionController extends SelectorComposer<Component>{

	private static final long serialVersionUID = 1L;

	private ProductionDataDao productionDataDao = new ProductionDataDao();
	Random call = new Random();  
	private Grid foolList;
	private List<Checkbox> selectedCheckboxs;

	public void onModifySelectedList(ForwardEvent event){
		System.out.println(selectedCheckboxs.size());
		Checkbox checkbox = (Checkbox) event.getOrigin().getTarget();		
		if (checkbox.isChecked()) 
			selectedCheckboxs.add(checkbox);
		else selectedCheckboxs.remove(checkbox);
	}

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		selectedCheckboxs = new ArrayList<Checkbox>();
		
		String s[] = Executions.getCurrent().getParameterMap().get("id");
		String ss[] = s[0].split("_");
		System.out.println("----------------------------------");
		System.out.println(ss[0]);
		System.out.println(ss[1]);
		System.out.println("----------------------------------");
		
		foolList = (Grid) comp;
		foolList.setModel(new ListModelList<MyProductionEntity>(productionDataDao.getSpecificCategoryMyProductionEntitys(ss[0], ss[1])));
	}
}