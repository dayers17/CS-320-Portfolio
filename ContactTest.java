import static org.junit.jupiter.api.Assertions.*; 

import org.junit.jupiter.api.Test; 
 
  

class ContactTest { 

  

    // ------------------------------------------------------- 

    // SUCCESS CASE: valid contact creates correctly 

    // ------------------------------------------------------- 

    @Test 

    void testContactCreatedSuccessfully() { 

        Contact c = new Contact("1234567890", "John", "Doe", 

                                "5551234567", "123 Main St, Boston MA"); 

        assertEquals("1234567890", c.getContactId()); 

        assertEquals("John",       c.getFirstName()); 

        assertEquals("Doe",        c.getLastName()); 

        assertEquals("5551234567", c.getPhone()); 

        assertEquals("123 Main St, Boston MA", c.getAddress()); 

    } 

  

    // ------------------------------------------------------- 

    // Requirement: contactId not null, max 10 chars, not updatable 

    // ------------------------------------------------------- 

    @Test 

    void testContactIdTooLong() { 

        assertThrows(IllegalArgumentException.class, () -> 

            new Contact("12345678901", "John", "Doe", "5551234567", "123 Main St") 

        ); 

    } 

  

    @Test 

    void testContactIdNull() { 

        assertThrows(IllegalArgumentException.class, () -> 

            new Contact(null, "John", "Doe", "5551234567", "123 Main St") 

        ); 

    } 

  

    // contactId has no setter — cannot be updated (enforced by final field) 

  

    // ------------------------------------------------------- 

    // Requirement: firstName not null, max 10 chars 

    // ------------------------------------------------------- 

    @Test 

    void testFirstNameTooLong() { 

        assertThrows(IllegalArgumentException.class, () -> 

            new Contact("1", "Johnathan11", "Doe", "5551234567", "123 Main St") 

        ); 

    } 

  

    @Test 

    void testFirstNameNull() { 

        assertThrows(IllegalArgumentException.class, () -> 

            new Contact("1", null, "Doe", "5551234567", "123 Main St") 

        ); 

    } 

  

    // ------------------------------------------------------- 

    // Requirement: lastName not null, max 10 chars 

    // ------------------------------------------------------- 

    @Test 

    void testLastNameTooLong() { 

        assertThrows(IllegalArgumentException.class, () -> 

            new Contact("1", "John", "Doeeeeeeeeee", "5551234567", "123 Main St") 

        ); 

    } 

  

    @Test 

    void testLastNameNull() { 

        assertThrows(IllegalArgumentException.class, () -> 

            new Contact("1", "John", null, "5551234567", "123 Main St") 

        ); 

    } 

  

    // ------------------------------------------------------- 

    // Requirement: phone not null, exactly 10 digits 

    // ------------------------------------------------------- 

    @Test 

    void testPhoneTooShort() { 

        assertThrows(IllegalArgumentException.class, () -> 

            new Contact("1", "John", "Doe", "555123", "123 Main St") 

        ); 

    } 

  

    @Test 

    void testPhoneTooLong() { 

        assertThrows(IllegalArgumentException.class, () -> 

            new Contact("1", "John", "Doe", "55512345678", "123 Main St") 

        ); 

    } 

  

    @Test 

    void testPhoneNull() { 

        assertThrows(IllegalArgumentException.class, () -> 

            new Contact("1", "John", "Doe", null, "123 Main St") 

        ); 

    } 

  

    @Test 

    void testPhoneNonDigits() { 

        assertThrows(IllegalArgumentException.class, () -> 

            new Contact("1", "John", "Doe", "555ABC4567", "123 Main St") 

        ); 

    } 

  

    // ------------------------------------------------------- 

    // Requirement: address not null, max 30 chars 

    // ------------------------------------------------------- 

    @Test 

    void testAddressTooLong() { 

        assertThrows(IllegalArgumentException.class, () -> 

            new Contact("1", "John", "Doe", "5551234567", 

                        "1234567890123456789012345678901") // 31 chars 

        ); 

    } 

  

    @Test 

    void testAddressNull() { 

        assertThrows(IllegalArgumentException.class, () -> 

            new Contact("1", "John", "Doe", "5551234567", null) 

        ); 

    } 

} 