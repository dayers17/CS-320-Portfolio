import java.util.HashMap; 

import java.util.Map; 

  

public class ContactService { 

  

    private final Map<String, Contact> contacts = new HashMap<>(); 

  

    // Add a contact with a unique ID 

    public void addContact(Contact contact) { 

        if (contact == null) { 

            throw new IllegalArgumentException("Contact cannot be null"); 

        } 

        if (contacts.containsKey(contact.getContactId())) { 

            throw new IllegalArgumentException("Contact ID already exists"); 

        } 

        contacts.put(contact.getContactId(), contact); 

    } 

  

    // Delete a contact by ID 

    public void deleteContact(String contactId) { 

        if (!contacts.containsKey(contactId)) { 

            throw new IllegalArgumentException("Contact not found"); 

        } 

        contacts.remove(contactId); 

    } 

  

    // Update firstName 

    public void updateFirstName(String contactId, String firstName) { 

        getContactOrThrow(contactId).setFirstName(firstName); 

    } 

  

    // Update lastName 

    public void updateLastName(String contactId, String lastName) { 

        getContactOrThrow(contactId).setLastName(lastName); 

    } 

  

    // Update phone number 

    public void updatePhone(String contactId, String phone) { 

        getContactOrThrow(contactId).setPhone(phone); 

    } 

  

    // Update address 

    public void updateAddress(String contactId, String address) { 

        getContactOrThrow(contactId).setAddress(address); 

    } 

  

    // Helper to retrieve a contact or throw if not found 

    public Contact getContact(String contactId) { 

        return getContactOrThrow(contactId); 

    } 

  

    private Contact getContactOrThrow(String contactId) { 

        Contact c = contacts.get(contactId); 

        if (c == null) { 

            throw new IllegalArgumentException("Contact not found"); 

        } 

        return c; 

    } 

} 