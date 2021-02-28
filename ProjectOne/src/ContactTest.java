import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;

public class ContactTest{
	public static void main(String[] args) {
	  Result result = JUnitCore.runClasses(ContactTestService.class);
		
	  for (Failure failure : result.getFailures()) {
	     System.out.println(failure.toString());
	  }
		
	  System.out.println(result.wasSuccessful());
   }
	
	String testID;
	Contact m_contact;
	
	@Before
	public void setUp() throws Exception{
		testID = "0123456789";
		m_contact = new Contact(testID);
	}
	
	@After
	public void tearDown() throws Exception{
		m_contact = null;
	}
	
	@Test
	public void testContactID() {
		//check that ID is not null
		assertNotNull(m_contact.getID());
		
		//Check valid ID
		try {
			m_contact = new Contact(testID);
		}
		catch(IllegalArgumentException e) {
			fail("Invalid ID");
		}
		
		assertEquals(m_contact.getID(), testID);
		
		//check length 11
		testID = "01234567891";
		try {
			m_contact = new Contact(testID);
			fail("Expected IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			
		}
		
		//check empty string
		testID = "";
		try {
			m_contact = new Contact(testID);
			fail("expected IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			
		}
	}
	@Test
	public void testContactFirstName() {
		String firstName = "";
		
		//Check that first name is not null
		assertNotNull(m_contact.getFirstName());
		
		//set name to empty string
		assertFalse(m_contact.setFirstName(firstName));
		assertEquals(m_contact.getFirstName(), firstName);
		
		//set name to "JefferyStar"
		firstName = "JefferyStar";
		assertFalse(m_contact.setFirstName(firstName));
		
		//set name to "Jeff"
		firstName = "Jeff";
		assertTrue(m_contact.setFirstName(firstName));
	}
	@Test
	public void testContactLastName() {
		String lastName = "";

		//check last name isn't null
		assertNotNull(m_contact.getLastName());
		
		//set name to empty string
		assertFalse(m_contact.setLastName(lastName));
		
		//set name to "JefferyStar"
		lastName = "JefferyStar";
		assertFalse(m_contact.setLastName(lastName));
		
		//set name to "Jeff"
		lastName = "Jeff";
		assertTrue(m_contact.setLastName(lastName));
	}
	@Test
	public void testPhoneNumber() {
		String testPhone;

		//check that phone number isn't null
		assertNotNull(m_contact.getPhone());
		
		//set phone to 11 digits
		testPhone = "01234567890";
		assertFalse(m_contact.setPhone(testPhone));
		assertEquals(m_contact.getPhone(), "");
		
		//set phone to 9 digits
		testPhone = "012345678";
		assertFalse(m_contact.setPhone(testPhone));
		assertEquals(m_contact.getPhone(), "");

		//set phone to 0 digits
		testPhone = "";
		assertFalse(m_contact.setPhone(testPhone));
		assertEquals(m_contact.getPhone(), "");
		
		//set phone to 10 digits
		testPhone = "0123456789";
		assertTrue(m_contact.setPhone(testPhone));
		assertEquals(m_contact.getPhone(), testPhone);
	}
	@Test
	public void testAddress() {
		String testAddress;
		
		//check address isn't null
		assertNotNull(m_contact.getAddress());
		
		//set address to 0 length
		testAddress = "";
		assertFalse(m_contact.setAddress(testAddress));
		assertEquals(m_contact.getAddress(), testAddress);
		
		//set address with 31 character length
		testAddress = "1234567891011121314151617181920";
		assertFalse(m_contact.setAddress(testAddress));
		assertEquals(m_contact.getAddress(), "");
		
		//set valid address
		testAddress = "1600 Pennsylvania Avenue NW";
		assertTrue(m_contact.setAddress(testAddress));
		assertEquals(m_contact.getAddress(), testAddress);
	}
}
