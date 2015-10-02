package bean;


public class MarketNews {

	int id;
	String content;
	String title;
	String image;
	
	
	public MarketNews(String content, String title,String image,int id){
		this.id=id;
		this.content=content;
		this.title=title;
		this.image=image;

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

}
