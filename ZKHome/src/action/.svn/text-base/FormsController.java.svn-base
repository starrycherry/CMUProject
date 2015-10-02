package action;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Radio;

import dao.FormsData;
import bean.Forms;
 
public class FormsController extends SelectorComposer<Component> {
    private static final long serialVersionUID = 1L;
 
    private Grid formsList;

    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        formsList = (Grid) comp;
        formsList.setModel(new ListModelList<Forms>(FormsData.getAllForms()));
    }
    
    @Listen("onCheck = #categorySelector")
    public void selectCategory(CheckEvent event) {
        String selectedCategory = ((Radio) event.getTarget()).getLabel();
        ListModel<Forms> model = null;
        if (selectedCategory.equals("All")) { 
            model = new ListModelList<Forms>(FormsData.getAllForms());
        } else if (selectedCategory.equals("Favorites")){
            model = new ListModelList<Forms>(FormsData.getFormsByFavorite());
        } 
        formsList.setModel(model);
    }
    

}
