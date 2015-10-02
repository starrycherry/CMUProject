package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import bean.Page;

public class PageDao extends HibernateBaseDao {
	@SuppressWarnings("deprecation")
	public List<Page> findPagesByUser(int id) {
		Object[] params = new Object[]{id};	
		Type[] types = new Type[]{Hibernate.INTEGER};
		List<Object> result = this.findByHQLWithParam("from Page p where p.user = ?", params, types);
		if(result == null) {
			return null;
		}
		List<Page> pages = new ArrayList<Page>();
		for(Object tmp : result) {
			pages.add((Page) tmp);
		}
		return pages;
	}
	
	@SuppressWarnings("deprecation")
	public List<Object> findUserPortalColumnByPageNo(int no) {
		Object[] params = new Object[]{no};	
		Type[] types = new Type[]{Hibernate.INTEGER};
		List<Object> result = this.findByHQLWithParam("from UserPortalColumn u where u.page_no = ?", params, types);
		if(result == null) {
			return null;
		}
		return result;
	}

	public boolean savePage(Page page) {
		return this.save(page);
	}
	
	public boolean delPage(Page page) {
		List<Object> userColumns = this.findUserPortalColumnByPageNo(page.getPage_no());
		for(Object o : userColumns) {
			this.delete(o);
		}
		return this.delete(page);
	}
}
