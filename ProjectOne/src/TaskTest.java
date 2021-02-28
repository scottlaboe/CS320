import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class TaskTest{
	Task m_task;
	String testID;
	
	public static void main(String[] args) {
	  Result result = JUnitCore.runClasses(TaskTest.class);
		
	  for (Failure failure : result.getFailures()) {
	     System.out.println(failure.toString());
	  }
		
	  System.out.println(result.wasSuccessful());
   }
	
	@Before
	public void setUp() throws Exception{
		testID = "0123456789";
		m_task = new Task(testID);
	}
	
	@After
	public void tearDown() throws Exception{
		m_task = null;
	}
	
	@Test
	public void testTaskID() {
		//check ID isn't null
		assertNotNull(m_task.getID());
		
		//Check length 10
		try {
			m_task = new Task(testID);
		}
		catch(IllegalArgumentException e) {
			fail("Invalid ID");
		}
		assertEquals(m_task.getID(), testID);
		
		//check length 11
		testID = "01234567891";
		try {
			m_task = new Task(testID);
			fail("Expected IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			
		}
		
		//check length 0
		testID = "";
		try {
			m_task = new Task(testID);
			fail("Expected IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			
		}
	}
	@Test
	public void testTaskName() {
		String name = "";

		//check name isn't null
		assertNotNull(m_task.getName());
		
		//set name to empty string
		assertFalse(m_task.setName(name));
		assertEquals(m_task.getName(), name);
		
		//set name to length above maximum
		name = "JefferyStaaaaaaaaaaar";
		assertFalse(m_task.setName(name));
		
		//set name to "Jeff"
		name = "Jeff";
		assertTrue(m_task.setName(name));
	}
	@Test
	public void testDescription() {
		String description = "";

		//check description isn't null
		assertNotNull(m_task.getDescription());
		
		//set name to empty string
		assertFalse(m_task.setDescription(description));
		
		//set name to length one above maximum
		description = "JefferyStaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaar";
		assertFalse(m_task.setDescription(description));
		
		//set name to "Jeff"
		description = "Jeff";
		assertTrue(m_task.setDescription(description));
	}
}