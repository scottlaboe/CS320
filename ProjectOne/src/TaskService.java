import java.util.Vector;

public class TaskService {
	/*
	 * Class Variables
	 */
	private Vector<Task> m_tasks = new Vector<Task>();
	
	/*
	 * Public Methods
	 */
	
	boolean addTask(String t_ID) {
		if( isUniqueID(t_ID) ) {
			try{
				m_tasks.add(new Task(t_ID));
				return true;
			}
			catch(IllegalArgumentException e) {
				return false;
			}
		}
		return false;
	}
	
	boolean deleteTask(String t_ID) {
		for( int i=0; i<m_tasks.size(); ++i) {
			if( m_tasks.elementAt(i).ID == t_ID ) {
				m_tasks.remove(i);
				return true;
			}
		}

		return false;
	}
	
	Task getTask(String t_ID) {
		for( int i=0; i<m_tasks.size(); ++i) {
			if( m_tasks.elementAt(i).ID == t_ID ) {
				return m_tasks.elementAt(i);
			}
			
		}
		//ID doesn't exist!
		throw new IllegalArgumentException(t_ID);
	}
	
	/*
	 * Private Methods
	 */
	private boolean isUniqueID(String t_ID) {
		for( int i = 0; i < m_tasks.size(); ++i) {
			if( m_tasks.elementAt(i).ID == t_ID ) {
				return false;
			}
		}
		return true;
	}
}
