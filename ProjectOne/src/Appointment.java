import java.util.Date;

public class Appointment {
	/*
	 * Class Variables
	 */
	String ID = "";
	Date appointmentDate = new Date();
	String description = "";
	
	/*
	 * Public Methods
	 */
	Appointment(String t_ID) throws IllegalArgumentException{
		if(!setID(t_ID)) {
			throw new IllegalArgumentException(t_ID);
		}
	}
	
	boolean setDate(Date t_date) {
		if( t_date.after(new Date())){
			appointmentDate = t_date;
			return true;
		}
		
		return false;
	}
	
	boolean setDescription(String t_description) {
		if( t_description.length() <= 50 && t_description != null && t_description != "") {
			description = t_description;
			return true;
		}
		
		return false;
	}
	
	String getID() {
		return ID;
	}
	
	Date getDate() {
		return appointmentDate;
	}
	
	String getDescription() {
		return description;
	}
	
	/*
	 * Private Methods
	 */
	private boolean setID(String t_ID) {
		if( ID == "" ) {//check that ID has not already been set
			if( t_ID.length() <= 10 && t_ID != null && t_ID != "") {//check if ID is valid
				ID = t_ID;
				return true;
			}
		}
		return false;
	}
}