/**
 * andrew ID: chenc2
 * name:Chen Chen
 * date:5th Dec
 */
package databeans;

import org.genericdao.PrimaryKey;

@PrimaryKey("favoriteID")
public class FavoriteBean implements Comparable<FavoriteBean>{
	int favoriteID;
	int userID;
	String url;
	String comment;
	int clickCount;
	
	public FavoriteBean(int userID, String url, String comment,
			int clickCount) {
		super();
		this.userID = userID;
		this.url = url;
		this.comment = comment;
		this.clickCount = clickCount;
	}
	
	public FavoriteBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFavoriteID() {
		return favoriteID;
	}
	public void setFavoriteID(int favoriteID) {
		this.favoriteID = favoriteID;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getClickCount() {
		return clickCount;
	}
	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}
	@Override
	public int compareTo(FavoriteBean other) {
		// TODO Auto-generated method stub
		return this.favoriteID-other.favoriteID;
	}
	
}
