/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.ice4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author mvman
 */
public class ContactManagerTest {
    // testing git


    private ContactManager contactManager ;
    
    public ContactManagerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        contactManager = new ContactManager();

        Contact contact1 = new Contact();
        contact1.setFirstName("Prahalad");
        contact1.setLastName("Prasanna");
        contact1.setEmailAddress("prahalad@gmail.com");

        Contact contact2 = new Contact();
        contact2.setFirstName("john");
        contact2.setLastName("doe");
        contact2.setEmailAddress("john@gmail.com");

        Contact contact3 = new Contact();
        contact3.setFirstName("hollow");
        contact3.setLastName("purple");
        contact3.setEmailAddress("purple@gmail.com");

        Contact contact4 = new Contact();
        contact4.setFirstName("rob");
        contact4.setLastName("bot");
        contact4.setEmailAddress("rob@gmail.com");

        contactManager.addContact(contact1);
        contactManager.addContact(contact2);
        contactManager.addContact(contact3);
        contactManager.addContact(contact4);

    
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addContact method, of class ContactManager.
     */
    @Test
    public void testFindContact() {
        Contact contact = contactManager.findContact("prahalad@gmail.com");

        assertEquals("Prahalad", contact.getFirstName()); //True - They Match
        assertEquals("Prasanna", contact.getLastName()); //True - They Match
        System.out.println("Test 1 (Good): Email Address Matches");
    }

    // Test case for when the contact doesn't exist
    @Test
    public void testFindNonExistentContact() {
        Contact contact = contactManager.findContact("nonexistent@gmail.com");

        assertEquals(null, contact); //True - They Match Because email doesn't exist and method returns null
        System.out.println("Test 2 (Bad): Email Address Does Not Match");
    }

    

    // Test case for invalid email format
    @Test
    public void testFindContactWithInvalidEmail() {
        Contact contact = contactManager.findContact("invalidemail.com");

        assertEquals(null, contact); //True - They Match Because email format is invalid and method returns null
        System.out.println("Test 3 (Bad): Invalid Email Format");
    }

    // Test case for an empty email string
    @Test
    public void testFindContactWithEmptyEmail() {
        Contact contact = contactManager.findContact("");

        assertEquals(null, contact); //True - They Match Because empty email returns null
        System.out.println("Test 4 (Bad): Empty Email Address");
    }

    // Test case for clearing all contacts
    @Test
    public void testClearContacts() {
        contactManager.clearContacts();
        
        // After clearing, no contact should be found
        assertEquals(null, contactManager.findContact("prahalad@gmail.com"));
        assertEquals(null, contactManager.findContact("john@gmail.com"));
        assertEquals(null, contactManager.findContact("purple@gmail.com"));
        
        System.out.println("Test 5 (Good): Contacts Cleared Successfully");
    }
    
    // Test case for finding a contact after clearing the list
    @Test
    public void testFindContactAfterClear() {
        contactManager.clearContacts();
        
        Contact contact = contactManager.findContact("john@gmail.com");
        assertEquals(null, contact); //True - They Match Because list is cleared
        System.out.println("Test 6 (Bad): Find Contact After Clear");
    }

    // Test case for adding a contact and verifying it was added
    @Test
    public void testAddContact() {
        Contact contact = new Contact();
        contact.setFirstName("James");
        contact.setLastName("Arthur");
        contact.setEmailAddress("james@gmail.com");

        contactManager.addContact(contact);
        
        // Verify the contact is added
        assertEquals("James", contactManager.findContact("james@gmail.com").getFirstName());
        System.out.println("Test 7 (Good): Add Contact Successfully");
    }
}