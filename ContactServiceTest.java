import static org.junit.jupiter.api.Assertions.*; 

import org.junit.jupiter.api.BeforeEach; 

import org.junit.jupiter.api.Test; 

  

class ContactServiceTest { 

  

    private ContactService service; 

    private Contact contact1; 

  

    @BeforeEach 

    void setUp() { 

        service = new ContactService(); 

        contact1 = new Contact("1", "John", "Doe", "5551234567", "123 Main St"); 

    } 

  

    // ------------------------------------------------------- 

    // Requirement: add contacts with a unique ID 

    // ------------------------------------------------------- 

    @Test 

    void testAddContact() { 

        service.addContact(contact1); 

        assertEquals("John", service.getContact("1").getFirstName()); 

    } 

  

    @Test 

    void testAddDuplicateContactThrows() { 

        service.addContact(contact1); 

        Contact duplicate = new Contact("1", "Jane", "Smith", "5559876543", "456 Elm St"); 

        assertThrows(IllegalArgumentException.class, () -> 

            service.addContact(duplicate) 

        ); 

    } 

  

    @Test 

    void testAddNullContactThrows() { 

        assertThrows(IllegalArgumentException.class, () -> 

            service.addContact(null) 

        ); 

    } 

  

    // ------------------------------------------------------- 

    // Requirement: delete contacts per contact ID 

    // ------------------------------------------------------- 

    @Test 

    void testDeleteContact() { 

        service.addContact(contact1); 

        service.deleteContact("1"); 

        assertThrows(IllegalArgumentException.class, () -> 

            service.getContact("1") 

        ); 

    } 

  

    @Test 

    void testDeleteNonExistentContactThrows() { 

        assertThrows(IllegalArgumentException.class, () -> 

            service.deleteContact("999") 

        ); 

    } 

  

    // ------------------------------------------------------- 

    // Requirement: update contact fields per contact ID 

    // ------------------------------------------------------- 

    @Test 

    void testUpdateFirstName() { 

        service.addContact(contact1); 

        service.updateFirstName("1", "Jane"); 

        assertEquals("Jane", service.getContact("1").getFirstName()); 

    } 

  

    @Test 

    void testUpdateLastName() { 

        service.addContact(contact1); 

        service.updateLastName("1", "Smith"); 

        assertEquals("Smith", service.getContact("1").getLastName()); 

    } 

  

    @Test 

    void testUpdatePhone() { 

        service.addContact(contact1); 

        service.updatePhone("1", "9879876543"); 

        assertEquals("9879876543", service.getContact("1").getPhone()); 

    } 

  

    @Test 

    void testUpdateAddress() { 

        service.addContact(contact1); 

        service.updateAddress("1", "456 Elm St, Suite 2"); 

        assertEquals("456 Elm St, Suite 2", service.getContact("1").getAddress()); 

    } 

  

    @Test 

    void testUpdateNonExistentContactThrows() { 

        assertThrows(IllegalArgumentException.class, () -> 

            service.updateFirstName("999", "Jane") 

        ); 

    } 

  

    @Test 

    void testUpdateFirstNameInvalidThrows() { 

        service.addContact(contact1); 

        assertThrows(IllegalArgumentException.class, () -> 

            service.updateFirstName("1", null) 

        ); 

    } 

} 