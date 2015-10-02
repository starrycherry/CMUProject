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
@Table(name = "user_portal_column")
public class UserPortalColumn implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int column_no;
	private int page_no;
	private String widgets_order;
	private User user;
	
	public UserPortalColumn() {
		
	}
	
	public UserPortalColumn(User user, int column_no, int page_no, String widgets_order) {
		this.user = user;
		this.column_no = column_no;
		this.page_no = page_no;
		this.widgets_order = widgets_order;
	}
	
	@Id
	@Column(name = "column_no")
	public int getColumn_no() {
		return column_no;
	}
	public void setColumn_no(int column_no) {
		this.column_no = column_no;
	}
	
	@Id
	@Column(name = "page_no")
	public int getPage_no() {
		return page_no;
	}
	public void setPage_no(int page_no) {
		this.page_no = page_no;
	}
	
	@Column(name = "widgets_order")
	public String getWidgets_order() {
		return widgets_order;
	}
	public void setWidgets_order(String widgets_order) {
		this.widgets_order = widgets_order;
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
}
