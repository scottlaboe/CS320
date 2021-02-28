import java.util.Vector; 

public class AppointmentService {
	/*
	 * Class Variables
	 */
	private Vector<Appointment> m_appointments = new Vector<Appointment>();
	
	/*
	 * Public methods
	 */
	boolean addAppointment(String t_ID) {
		if( !isUniqueID(t_ID) ) {
			return false;
		}
		try{
			m_appointments.add(new Appointment(t_ID));
			return true;
		}
		catch(IllegalArgumentException e) {
			return false;
		}
	}
	
	boolean deleteAppointment(String t_ID) {
		for( int i=0; i<m_appointments.size(); ++i) {
			if( m_appointments.elementAt(i).ID == t_ID ) {
				m_appointments.remove(i);
				return true;
			}
			
		}

		return false;
	}
	
	Appointment getAppointment(String t_ID) throws IllegalArgumentException{
		for( int i=0; i<m_appointments.size(); ++i) {
			if( m_appointments.elementAt(i).ID == t_ID ) {
				return m_appointments.elementAt(i);
			}
			
		}
		//ID doesn't exist!
		throw new IllegalArgumentException(t_ID);
	}
	
	/*
	 * Private Methods
	 */
	private boolean isUniqueID(String t_ID) {
		for( int i = 0; i < m_appointments.size(); ++i) {
			if( m_appointments.elementAt(i).ID == t_ID ) {
				return false;
			}
		}
		return true;
	}
	
}
