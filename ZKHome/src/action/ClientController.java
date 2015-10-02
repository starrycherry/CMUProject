package action;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;

import dao.ClientRankData;
import bean.ClientRank;
 
public class ClientController extends SelectorComposer<Component> {
    private static final long serialVersionUID = 1L;
 
    private Grid reportList;

    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        reportList = (Grid) comp;
        reportList.setModel(new ListModelList<ClientRank>(ClientRankData.getAllClientRanks()));
    }    

}
