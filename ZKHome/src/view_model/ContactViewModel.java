package view_model;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.Init;

import bean.Contact;
import dao.ContactData;
 
public class ContactViewModel {
    private Contact selected;
    private List<Contact> contacts = new ArrayList<Contact>(new ContactData().getContacts());
    private List<Contact> contactsFav = new ArrayList<Contact>(new ContactData().getContactsByFav());
 
    @Init
    public void init() {    // Initialize
        selected = contacts.get(0); // Selected First One
    }
 
    public List<Contact> getContactList() {
        return contacts;
    }
    
    public List<Contact> getContactListf() {
        return contactsFav;
    }
 
    public void setSelectedContact(Contact selected) {
        this.selected = selected;
    }
 
    public Contact getSelectedContact() {
        return selected;
    }
}