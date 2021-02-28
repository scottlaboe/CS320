import java.util.Vector;

public class ContactService {

	/*
	 * Class Variables
	 */
	private Vector<Contact> m_contacts = new Vector<Contact>();
	
	/*
	 * Public Methods
	 */
	public boolean addContact(String t_ID) {
		
		if( isUniqueID(t_ID)) {
			try{
				m_contacts.add(new Contact(t_ID));
				return true;
			}
			catch(IllegalArgumentException e) {
				return false;
			}
		}
		return false;
	}
	
	boolean deleteContact(String t_ID) {
		for( int i=0; i<m_contacts.size(); ++i) {
			if( m_contacts.elementAt(i).ID == t_ID ) {
				m_contacts.remove(i);
				return true;
			}
		}

		return false;
	}
	
	public Contact getContact(String t_ID) {
		for( int i=0; i<m_contacts.size(); ++i) {
			if( m_contacts.elementAt(i).ID == t_ID ) {
				return m_contacts.elementAt(i);
			}
			
		}
		//ID doesn't exist!
		throw new IllegalArgumentException(t_ID);
	}
	
	/*
	 * Private Methods
	 */
	private boolean isUniqueID(String t_ID) {
		for( int i = 0; i < m_contacts.size(); ++i) {
			if( m_contacts.elementAt(i).ID == t_ID ) {
				return false;
			}
		}
		return true;
	}
}