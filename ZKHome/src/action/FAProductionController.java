package action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;

import bean.FAProductionEntity;
import bean.ManagerProductionEntity;
import dao.FAProductionDataDao;

public class FAProductionController extends SelectorComposer<Component>{

	private static final long serialVersionUID = 1L;

	private FAProductionDataDao productionDataDao = new FAProductionDataDao();
	Random call = new Random();  
	List<FAProductionEntity> temp;
	private Grid foolList;

	@Wire
	private Checkbox l1;
	
	@Wire
	private Checkbox l2;
	
	@Wire
	private Checkbox l3;
	
	@Wire
	private Checkbox l4;
	
	int fa_number = 2;
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		String s[] = Executions.getCurrent().getParameterMap().get("id");
		String ss[] = s[0].split("_");
		System.out.println("----------------------------------");
		System.out.println(ss[0]);
		System.out.println(ss[1]);
		System.out.println("----------------------------------");
		
		 temp = productionDataDao.getSpecificCategoryMyProductionEntitys(ss[0], ss[1], fa_number);
		if(ss[0].equals("Commissions"))
			l1.setChecked(true);
		
		if(ss[0].equals("Fees"))
			l2.setChecked(true);
		
		if(ss[0].equals("Trails"))
			l3.setChecked(true);
		
		if(ss[0].equals("Directs"))
			l4.setChecked(true);		
		
		if(ss[0].equals("Total")){
			HashSet<String> hashCategory = new HashSet<String>();
			Iterator<FAProductionEntity> itr = temp.iterator();
			while(hashCategory.size() < 4 && itr.hasNext()){
				FAProductionEntity m = itr.next();
				hashCategory.add(m.getCategory());
			}
			if(hashCategory.contains("Commissions"))
				l1.setChecked(true);
			
			if(hashCategory.contains("Fees"))
				l2.setChecked(true);
			
			if(hashCategory.contains("Trails"))
				l3.setChecked(true);
			
			if(hashCategory.contains("Directs"))
				l4.setChecked(true);
		}
		
		foolList = (Grid) comp;
		foolList.setModel(new ListModelList<FAProductionEntity>(temp));
	}
}