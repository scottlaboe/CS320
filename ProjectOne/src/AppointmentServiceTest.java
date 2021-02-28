import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class AppointmentServiceTest {
	public static void main(String[] args) {
	  Result result = JUnitCore.runClasses(AppointmentServiceTest.class);
		
	  for (Failure failure : result.getFailures()) {
	     System.out.println(failure.toString());
	  }
		
	  System.out.println(result.wasSuccessful());
   }
	
	AppointmentService m_appointmentService;
	
	@Before
	public void setUp() throws Exception{
		m_appointmentService = new AppointmentService();
	}
	
	@After
	public void tearDown() throws Exception{
		m_appointmentService = null;
	}
	
	@Test
	public void testAddAppointment() {
		String testID = "0123456789";
		assertTrue(m_appointmentService.addAppointment(testID));
		assertEquals(m_appointmentService.getAppointment(testID).ID, testID);
		
		//try to add appointment with the same ID
		assertFalse(m_appointmentService.addAppointment(testID));
		
		//add appointment with different ID
		testID = "012778678";
		assertTrue(m_appointmentService.addAppointment(testID));
		assertEquals(m_appointmentService.getAppointment(testID).ID, testID);
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testgetAppointmentThrowsIllegalArgumentException() {
		String testID = "012778678";
		assertTrue(m_appointmentService.addAppointment(testID));
		//pass ID that doesn't exist
		m_appointmentService.getAppointment("12345678");
	}
	
	@Test
	public void testSetDate() {
		Appointment appointmentTemp;
		String testID = "0123456789";
		Date testDate = new GregorianCalendar(2030, 6, 2).getTime();
		assertTrue(m_appointmentService.addAppointment(testID));
		
		appointmentTemp = m_appointmentService.getAppointment(testID);
		assertTrue(appointmentTemp.setDate(testDate));
		
		assertEquals(m_appointmentService.getAppointment(testID), appointmentTemp);
		assertEquals(m_appointmentService.getAppointment(testID).getDate(), testDate);
	}
	
	@Test
	public void testSetDescription() {
		Appointment appointmentTemp;
		String testID = "0123456789";
		String testDescription = "This is the description that will be tested.";

		assertTrue(m_appointmentService.addAppointment(testID));
		
		appointmentTemp = m_appointmentService.getAppointment(testID);
		assertTrue(appointmentTemp.setDescription(testDescription));
		
		assertEquals(m_appointmentService.getAppointment(testID), appointmentTemp);
		assertEquals(m_appointmentService.getAppointment(testID).getDescription(), testDescription);
	}
	
	@Test
	public void testDeleteAppointment() {
		String testID = "0123456789";
		assertTrue(m_appointmentService.addAppointment(testID));
		assertTrue(m_appointmentService.deleteAppointment(testID));
		
		try {
			m_appointmentService.getAppointment(testID);
			fail("expected exception not thrown");
		}
		catch(IllegalArgumentException e){
			
		}
		//try deleting object that doesn't exist
		assertTrue(m_appointmentService.addAppointment(testID));
		assertFalse(m_appointmentService.deleteAppointment("123457"));
		assertTrue(m_appointmentService.deleteAppointment(testID));
		
		//try deleting with more object in appointment structure
		assertTrue(m_appointmentService.addAppointment(testID));
		String testIDTwo = "012342349";
		assertTrue(m_appointmentService.addAppointment(testIDTwo));
		String testIDThree = "01247349";
		assertTrue(m_appointmentService.addAppointment(testIDThree));
		String testIDFour = "05756789";
		assertTrue(m_appointmentService.addAppointment(testIDFour));
		assertTrue(m_appointmentService.deleteAppointment(testIDThree));
		assertTrue(m_appointmentService.deleteAppointment(testID));
		assertTrue(m_appointmentService.deleteAppointment(testIDTwo));
	}
}
	