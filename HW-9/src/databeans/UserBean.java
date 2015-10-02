/**
 * andrew ID: chenc2
 * name:Chen Chen
 * date:5th Dec
 */
package databeans;

import org.genericdao.PrimaryKey;

@PrimaryKey("userID")
public class UserBean implements Comparable<UserBean> {
	int userID;
	String emailAdd;
	String firstName;
	String lastName;
	String password;
	
	public UserBean(String emailAdd, String firstName,
			String lastName, String password) {
		super();
		this.emailAdd = emailAdd;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getEmailAdd() {
		return emailAdd;
	}
	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int compareTo(UserBean other) {
		// Order first by lastName and then by firstName
		int c = lastName.compareTo(other.lastName);
		if (c != 0) return c;
		c = firstName.compareTo(other.firstName);
		if (c != 0) return c;
		return emailAdd.compareTo(other.emailAdd);
	}
}
