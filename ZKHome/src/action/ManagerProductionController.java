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

import bean.ManagerProductionEntity;
import dao.ManagerProductionDataDao;

public class ManagerProductionController extends SelectorComposer<Component>{

	private static final long serialVersionUID = 1L;

	private ManagerProductionDataDao managerProductionDataDao = new ManagerProductionDataDao();
	Random call = new Random();  
	List<ManagerProductionEntity> temp;
	int managerId = 1;
	private Grid foolList;

	
	@Wire
	private Checkbox l1;
	
	@Wire
	private Checkbox l2;
	
	@Wire
	private Checkbox l3;
	
	@Wire
	private Checkbox l4;
	
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		String s[] = Executions.getCurrent().getParameterMap().get("id");
		String ss[] = s[0].split("_");
		System.out.println("------------MANAGER----------------------");
		System.out.println(ss[0]);
		System.out.println(ss[1]);
		System.out.println("----------------------------------");
		
		
		temp = managerProductionDataDao.getSpecificCategoryMyProductionEntitys(ss[0], ss[1], managerId);
		
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
			Iterator<ManagerProductionEntity> itr = temp.iterator();
			while(hashCategory.size() < 4 && itr.hasNext()){
				ManagerProductionEntity m = itr.next();
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
		foolList.setModel(new ListModelList<ManagerProductionEntity>(temp));
	}
}