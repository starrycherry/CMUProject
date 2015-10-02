package bean;

import org.zkoss.bind.annotation.DependsOn;

public class Contact {

	private String firstName;
    private String lastName;
    private String title;
    private String company;
    private String phone;
    private String email;
    private String address;
    private String photo;
    private String favorite;
 
    public Contact(String firstName, String lastName, String title, 
    		String company, String phone, String email, String address, String photo, String favorite) {
        setFirstName(firstName);
        setLastName(lastName);
        setTitle(title);
        setCompany(company);
        setPhone(phone);
        setEmail(email);
        setAddress(address);
        setPhoto(photo);
        setFavorite(favorite);
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String fn) {
        firstName = fn;
    }
 
    public String getFavorite() {
        return favorite;
    }
 
    public void setFavorite(String fav) {
        favorite = fav;
    }
    
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String ln) {
        lastName = ln;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String tl) {
        title = tl;
    }
    
    public void setCompany(String company) {
    	this.company = company;
    }
 
    public String getCompany() {
        return company;
    }
 
    public void setPhone(String phone) {
    	this.phone = phone;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getEmail() {
		return email;
	}
    
    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
 
    @DependsOn({ "firstName", "lastName" })
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}
