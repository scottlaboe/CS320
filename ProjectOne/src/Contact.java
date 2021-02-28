public class Contact {
	/*
	 * Class Variables
	 */
	String ID = "";
	String firstName = "";
	String lastName = "";
	String phone = "";
	String address = "";
	
	/*
	 * Public Methods
	 */
	Contact(String t_ID) throws IllegalArgumentException{
		if(!setID(t_ID)) {
			throw new IllegalArgumentException(t_ID);
		}
	}
	
	public boolean setFirstName(String t_firstName) {
		if(t_firstName.length() > 10) {
			return false;
		}
		if( t_firstName.equals("")) {
			return false;
		}
		
		firstName = t_firstName;
		return true;
	}
	
	public boolean setLastName(String t_lastName) {
		if(t_lastName.length() > 10) {
			return false;
		}
		if( t_lastName.equals("")) {
			return false;
		}
		
		lastName = t_lastName;
		return true;
	}
	
	public boolean setPhone(String t_phone) {
		if(t_phone.length() != 10) {
			return false;
		}
		if( t_phone.equals("")) {
			return false;
		}
		
		phone = t_phone;
		return true;
	}
	
	public boolean setAddress(String t_address) {
		if(t_address.length() > 30) {
			return false;
		}
		if( t_address.equals("")) {
			return false;
		}
		
		address = t_address;
		return true;
	}
	
	public String getID() {
		return ID;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
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
