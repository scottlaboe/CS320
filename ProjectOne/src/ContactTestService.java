import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ContactTestService {
	public static void main(String[] args) {
	  Result result = JUnitCore.runClasses(ContactTestService.class);
		
	  for (Failure failure : result.getFailures()) {
	     System.out.println(failure.toString());
	  }
		
	  System.out.println(result.wasSuccessful());
   }
	
	ContactService contactService;
	String testID;
	
	@Before
	public void setUp() throws Exception{
		contactService = new ContactService();
		testID = "0123456789";
	}
	
	@After
	public void tearDown() throws Exception{
		contactService = null;
	}
	@Test
	public void testAddContact() {
		
		//add contact
		assertTrue(contactService.addContact(testID));
		assertEquals(contactService.getContact(testID).getID(), testID);
		
		//try adding the same ID
		assertFalse(contactService.addContact(testID));
	}

	@Test
	public void testDeleteContact() {
		//add contact
		assertTrue(contactService.addContact(testID));
	
		//delete contact with incorrect ID
		assertFalse(contactService.deleteContact("012345678"));
		
		//check that contact wasn't deleted
		try {
			contactService.getContact(testID);
		}
		catch(IllegalArgumentException e) {
			fail("expected IllegalArgumentException");
		}
		
		//delete contact with correct ID
		assertTrue(contactService.deleteContact(testID));

		//check that contact was deleted
		try {
			contactService.getContact(testID);
			fail("expected IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			//success
		}

	}
	@Test
	public void testUpdateFirstName() {	
		String testName = "Jeff";

		//add contact
		assertTrue(contactService.addContact(testID));
	
		//should be empty before it is set
		assertEquals(contactService.getContact(testID).getFirstName(), "");
		assertTrue(contactService.getContact(testID).setFirstName(testName));
		assertEquals(contactService.getContact(testID).getFirstName(), testName);
		
	}
	@Test
	public void testUpdateLastName() {
		String testName = "Jackson";

		//add contact
		assertTrue(contactService.addContact(testID));
	
		//should be empty before it is set
		assertEquals(contactService.getContact(testID).getLastName(), "");
		assertTrue(contactService.getContact(testID).setLastName(testName));
		assertEquals(contactService.getContact(testID).getLastName(), testName);
		
	}
	@Test
	public void testUpdatePhoneNumber() {
		String testPhone = "0123456789";

		//add contact
		assertTrue(contactService.addContact(testID));
	
		//should be empty before it is set
		assertEquals(contactService.getContact(testID).getPhone(), "");
		assertTrue(contactService.getContact(testID).setPhone(testPhone));
		assertEquals(contactService.getContact(testID).getPhone(), testPhone);
		
	}
	
	@Test
	public void testUpdateAddress() {
		String testAddress = "1600 Pennsylvania Avenue NW";

		//add contact
		assertTrue(contactService.addContact(testID));
	
		//should be empty before it is set
		assertEquals(contactService.getContact(testID).getAddress(), "");
		assertTrue(contactService.getContact(testID).setAddress(testAddress));
		assertEquals(contactService.getContact(testID).getAddress(), testAddress);
		
	}
}