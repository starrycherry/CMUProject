package service;

import java.util.ArrayList;
import java.util.List;

import bean.Page;
import dao.PageDao;

public class PageService {
	
	private PageDao pageDao = new PageDao();
	
	public List<Page> getPageList(int id) {
		List<Page> list = pageDao.findPagesByUser(id);
		if(list == null) {
			return new ArrayList<Page>();
		}
		return list;
	}
	
	public void addNewPage(Page page) {
		pageDao.savePage(page);
	}
	
	public void delExistingPage(Page page) {
		pageDao.delPage(page);
	}
	
	public void renameExistingPage(Page toRename, String newName) {
		toRename.setPageName(newName);
		pageDao.update(toRename);
	}
}
