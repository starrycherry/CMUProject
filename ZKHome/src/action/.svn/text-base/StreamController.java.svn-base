package action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Radio;
 
import dao.StreamData;
import bean.Stream;
 
public class StreamController extends SelectorComposer<Component> {
    private static final long serialVersionUID = 1L;
    public static List<Stream> streams = StreamController.getAllStreams();
    public List<Stream> favoriteStreams = StreamController.getStreamsByFavorite();
    public List<Stream> assignStreams = StreamController.getStreamsByAssign();
    public List<Stream> hiddenStreams = StreamController.getStreamsByHidden();
    
    @Wire
    private Listbox streamList;
    
    public static List<Stream> getAllStreams() {
    	List<Stream> someStreams = new ArrayList<Stream>();
    	for (Iterator<Stream> i = StreamData.getAllStreams().iterator(); i.hasNext();) {
            Stream tmp = i.next();
            someStreams.add(tmp);
        }
        return someStreams;
    }
    
    
    public static List<Stream> getStreamsByFavorite() {
    	List<Stream> someStreams = new ArrayList<Stream>();
        for (Iterator<Stream> i = streams.iterator(); i.hasNext();) {
            Stream tmp = i.next();
            if (tmp.getFavorite().equals(true)){
            	someStreams.add(tmp);
            }
        }
        return someStreams;
    }
    
    public static List<Stream> getStreamsByAssign() {
    	List<Stream> someStreams = new ArrayList<Stream>();
        for (Iterator<Stream> i = streams.iterator(); i.hasNext();) {
            Stream tmp = i.next();
            if (tmp.getAssign().equals(true)){
            	someStreams.add(tmp);
            }
        }
        return someStreams;
    }
    
    public static List<Stream> getStreamsByHidden() {
    	List<Stream> someStreams = new ArrayList<Stream>();
        for (Iterator<Stream> i = streams.iterator(); i.hasNext();) {
            Stream tmp = i.next();
            if (tmp.getHidden().equals(true)){
            	someStreams.add(tmp);
            }
        }
        return someStreams;
    }
    
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        streamList = (Listbox) comp;
        streamList.setModel(new ListModelList<Stream>(StreamData.getAllStreams()));
    }
    
    @Listen("onCheck = #categorySelector")
    public void selectCategory(Event event) {
        String selectedCategory = ((Radio) event.getTarget()).getLabel();
        ListModel<Stream> model = null;
        if (selectedCategory.equals("All")) { 
            model = new ListModelList<Stream>(streams);
        } else if (selectedCategory.equals("Favorites")){
            favoriteStreams = StreamController.getStreamsByFavorite();
        	model = new ListModelList<Stream>(favoriteStreams);
        } else if (selectedCategory.equals("Assigned")){
        	assignStreams = StreamController.getStreamsByAssign();
            model = new ListModelList<Stream>(assignStreams);
        } else if (selectedCategory.equals("Hidden")){
        	hiddenStreams = StreamController.getStreamsByHidden();
        	model = new ListModelList<Stream>(hiddenStreams);
        }
        streamList.setModel(model);
    }
    
    /*@Listen("onCheck = #favorite0")
    public void doFavorite(Event event) {
    	
    	if(((Checkbox) event.getTarget()).isChecked()) {
    		streams.get(0).setFavorite(true);
    	} else{
    		streams.get(0).setFavorite(false);
    	}
    }*/
    
}

