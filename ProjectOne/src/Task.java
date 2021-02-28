
public class Task {
	/*
	 * Class Variables
	 */
	String ID = "";
	String name = "";
	String description = "";
	
	/*
	 * Public Methods
	 */
	Task(String t_ID) throws IllegalArgumentException{
		if(!setID(t_ID)) {
			throw new IllegalArgumentException(t_ID);
		}
	}
	
	public boolean setName(String t_name) {
		if( t_name.length() > 20 || t_name == "" || t_name == null) {
			return false;
		}
		name = t_name;
		return true;
	}
	
	public boolean setDescription(String t_description) {
		if( t_description.length() > 50 || t_description == "") {
			return false;
		}
		description = t_description;
		return true;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getID() {
		return ID;
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
