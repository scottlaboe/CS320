import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class AppointmentTest{
	public static void main(String[] args) {
	  Result result = JUnitCore.runClasses(ContactTestService.class);
		
	  for (Failure failure : result.getFailures()) {
	     System.out.println(failure.toString());
	  }
		
	  System.out.println(result.wasSuccessful());
   }
	
	Appointment m_appointment;
	String testID;
	
	@Before
	public void setUp() throws Exception{
		testID = "0123456789";
		m_appointment = new Appointment(testID);
	}
	
	@After
	public void tearDown() throws Exception{
		m_appointment = null;
	}
	
	@Test
	public void testAppointmentIDIsValid() {
		//check ID isn't null
		assertNotNull(m_appointment.getID());
		
		//check ID over 10 character limit
		testID = "01234567891";
		
		//check empty ID exception
		testID = "";
		try {
			m_appointment = new Appointment(testID);
			fail("Expected IllegalArgumentException not thrown");
		}
		catch(IllegalArgumentException e) {
			
		}
		
		//check valid ID
		testID = "0123456789";
		try {
			m_appointment = new Appointment(testID);
		}
		catch(IllegalArgumentException e) {
			fail("IllegalArgumentException thrown");
		}
	}
	@Test
	public void testDateIsValid() {
		Date testDate = new GregorianCalendar(2020, 6, 2).getTime();
		
		//check date isn't null
		assertNotNull(m_appointment.getDate());

		//date in the past
		assertFalse(m_appointment.setDate(testDate));
		//date in the future
		testDate = new GregorianCalendar(2030, 6, 2).getTime();
		assertTrue(m_appointment.setDate(testDate));
	}
	@Test
	public void testDescriptionIsValid() {
		String testDescription = "This is the description that will be tested for len";
		
		//check description isn't null
		assertNotNull(m_appointment.getDescription());
		
		//description that is too long
		assertFalse(m_appointment.setDescription(testDescription));
		//description that is just below tolerable length
		testDescription = "This is the description that will be tested.";
		assertTrue(m_appointment.setDescription(testDescription));
	}
}
