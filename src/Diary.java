/**
 * This class simulates a "dating diary"
 * @author silkpath
 *
 */
public class Diary {

	private Match match;
	private String date;
	private String address;
	private String notes;
	
	/**
	 * Constructor
	 * @param match
	 * @param date
	 * @param address
	 * @param notes
	 */
	Diary(Match match, String date, String address, String notes){
		this.match = match;
		this.date = date;
		this.address = address;
		this.notes = notes;
	}
	
	/**
	 * Get match object
	 * @return
	 */
	public Match getMatch() {
		return match;
	}

	/**
	 * Set match object
	 * @param match
	 */
	public void setMatch(Match match) {
		this.match = match;
	}

	/**
	 * Get date of the date
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Set date of the date
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Get date address
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Set date address
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Get date notes
	 * @return notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * Set notes
	 * @param notes
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	/**
	 * Overriding Object class's equal method
	 */
	public boolean equals(Object o) {
		if (o==null) return false;
		Diary d = (Diary) o;
		
		if (address.equals(d.getAddress()) && date.equals(d.getDate()) && match.equals(d.getMatch()) && notes.equals(d.getNotes())) {
			return true;
		}
		else return false;
	}
}
