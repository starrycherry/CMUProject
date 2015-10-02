package dao;

import java.util.ArrayList;
import java.util.List;

import bean.Contact;
 
public class ContactData {
	
    private List<Contact> contacts = new ArrayList<Contact>();
 
    public ContactData() {
    	contacts.add(new Contact("Carey", "Chen", "Analyst", "Raymond James", "412-234-5678", "chen@gmail.com", "Fifth Avenue", "/images/contact1.png", "Y"));
    	contacts.add(new Contact("Vivian", "Dong", "Analyst", "Raymond James", "412-234-5679", "chen@gmail.com", "Fifth Avenue", "/images/contact2.png", "Y"));
    	contacts.add(new Contact("Kobe", "Bryant", "Analyst", "Raymond James", "412-234-5671", "chen@gmail.com", "Fifth Avenue", "/images/contact3.png", "Y"));
    	contacts.add(new Contact("Leborn", "James", "Analyst", "Raymond James", "412-234-5672", "chen@gmail.com", "Fifth Avenue", "/images/contact1.png", "Y"));
    	contacts.add(new Contact("David", "Li", "Analyst", "Raymond James", "412-234-5678", "chen@gmail.com", "Fifth Avenue", "/images/contact2.png", "N"));
    	contacts.add(new Contact("Tom", "James", "Analyst", "Raymond James", "412-234-5678", "chen@gmail.com", "Fifth Avenue", "/images/contact3.png", "N"));
    	contacts.add(new Contact("Terry", "Lee", "Analyst", "Raymond James", "412-234-5678", "chen@gmail.com", "Fifth Avenue", "/images/contact1.png", "N"));
    	contacts.add(new Contact("Ted", "James", "Analyst", "Raymond James", "412-234-5678", "chen@gmail.com", "Fifth Avenue", "/images/contact2.png", "N"));
    	contacts.add(new Contact("Barney", "James", "Analyst", "Raymond James", "412-234-5678", "chen@gmail.com", "Fifth Avenue", "/images/contact3.png", "N"));
    	contacts.add(new Contact("Robin", "James", "Analyst", "Raymond James", "412-234-5678", "chen@gmail.com", "Fifth Avenue", "/images/contact1.png", "N"));
    	contacts.add(new Contact("Carey", "Chen", "Analyst", "Raymond James", "412-234-5678", "chen@gmail.com", "Fifth Avenue", "/images/contact1.png", "N"));
    	contacts.add(new Contact("Vivian", "Dong", "Analyst", "Raymond James", "412-234-5678", "chen@gmail.com", "Fifth Avenue", "/images/contact2.png", "N"));
    	contacts.add(new Contact("Kobe", "Bryant", "Analyst", "Raymond James", "412-234-5678", "chen@gmail.com", "Fifth Avenue", "/images/contact3.png", "N"));
    	contacts.add(new Contact("Leborn", "James", "Analyst", "Raymond James", "412-234-5678", "chen@gmail.com", "Fifth Avenue", "/images/contact1.png", "N"));
    	contacts.add(new Contact("David", "Li", "Analyst", "Raymond James", "412-234-5678", "chen@gmail.com", "Fifth Avenue", "/images/contact2.png", "N"));
    	contacts.add(new Contact("Tom", "James", "Analyst", "Raymond James", "412-234-5678", "chen@gmail.com", "Fifth Avenue", "/images/contact3.png", "N"));
    	contacts.add(new Contact("Terry", "Lee", "Analyst", "Raymond James", "412-234-5678", "chen@gmail.com", "Fifth Avenue", "/images/contact1.png", "N"));
    	contacts.add(new Contact("Ted", "James", "Analyst", "Raymond James", "412-234-5678", "chen@gmail.com", "Fifth Avenue", "/images/contact2.png", "N"));
    	contacts.add(new Contact("Barney", "James", "Analyst", "Raymond James", "412-234-5678", "chen@gmail.com", "Fifth Avenue", "/images/contact3.png", "N"));
    	contacts.add(new Contact("Robin", "James", "Analyst", "Raymond James", "412-234-5678", "chen@gmail.com", "Fifth Avenue", "/images/contact1.png", "N"));
    }
 
    public List<Contact> getContacts() {
        return contacts;
    }
    
    public List<Contact> getContactsByFav() {
    	List<Contact> contactsFav = new ArrayList<Contact>();
    	for (Contact c: contacts){
    		if (c.getFavorite().equals("Y")){
    			contactsFav.add(c);
    		}
    	}
    	
        return contactsFav;
    }
 
}
