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

public class TaskServiceTest {
	TaskService taskService;
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
		taskService = new TaskService();
		testID = "0123456789";
	}
	
	@After
	public void tearDown() throws Exception{
		taskService = null;
	}
	
	@Test
	public void testAddTask() {

		//Check length 10
		assertTrue(taskService.addTask(testID));
		assertEquals(taskService.getTask(testID).getID(), testID);
	}
	@Test
	public void testDeleteID() {
		
		//add task
		assertTrue(taskService.addTask(testID));
	
		//delete task with incorrect ID
		assertFalse(taskService.deleteTask("012345678"));
		
		//check that task wasn't deleted
		try {
			taskService.getTask(testID);
		}
		catch(IllegalArgumentException e) {
			fail("expected IllegalArgumentException");
		}
		
		//delete task with correct ID
		assertTrue(taskService.deleteTask(testID));

		//check that task was deleted
		try {
			taskService.getTask(testID);
			fail("expected IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			//success
		}
	}
	@Test
	public void testUpdateName() {
		String testID = "0123456789";
		String testName = "Jeff";
		
		//create task
		assertTrue(taskService.addTask(testID));
		assertEquals(taskService.getTask(testID).getID(), testID);
		
		//should be blank before it is set
		assertEquals(taskService.getTask(testID).getName(), "");
		assertTrue(taskService.getTask(testID).setName(testName));
		assertEquals(taskService.getTask(testID).getName(), testName);
		
		testName = "Jeffery";
		assertTrue(taskService.getTask(testID).setName(testName));
		assertEquals(taskService.getTask(testID).getName(), testName);
	}
	
	@Test
	public void testUpdateDescription() {
		String testID = "0123456789";
		String testDescription = "The purpose of this description is to describe.";
		
		//should be blank before it is set
		assertTrue(taskService.addTask(testID));
		assertEquals(taskService.getTask(testID).getID(), testID);
		
		//update description
		assertEquals(taskService.getTask(testID).getName(), "");
		assertTrue(taskService.getTask(testID).setDescription(testDescription));
		assertEquals(taskService.getTask(testID).getDescription(), testDescription);
		
		testDescription = "This description is describing new descriptions.";
		assertTrue(taskService.getTask(testID).setDescription(testDescription));
		assertEquals(taskService.getTask(testID).getDescription(), testDescription);
	}

}
