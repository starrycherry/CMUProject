package bean;

public class Client {

	private String name;
    private String type;
    private String research;
    private int quantity;
    private int value;
    private String date;
    
    public Client(String name, String type, String research, int quantity, int value, String date) {
        this.name = name;
        this.type = type;
        this.research = research;
        this.quantity = quantity;
        this.value = value;
        this.date = date;
    }
 
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResearch() {
		return research;
	}

	public void setResearch(String research) {
		this.research = research;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}