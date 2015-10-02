package bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "page")
public class Page implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private User user;
	private int page_no;
	private String pageName;
	private String url;
	
	public Page() {
		
	}
	
	public Page(User user, int page_no, String pageName, String url) {
		this.user = user;
		this.page_no = page_no;
		this.pageName = pageName;
		this.url = url;
	}
	
	@Id
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Id
	@Column(name = "page_no")
	public int getPage_no() {
		return page_no;
	}
	public void setPage_no(int page_no) {
		this.page_no = page_no;
	}
	
	@Column(name = "pageName")
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	
	@Column(name = "url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}