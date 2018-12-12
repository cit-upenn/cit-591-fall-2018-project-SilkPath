package silkpath;
/**
 * This class simulates a "dating diary"
 * @author silkpath
 *
 */

public class Diary {
	private String matchName;
	private String age;
	private String photo;
	private String blurb;

	private String date;
	private String address;
	private String notes;
	
	/**
	 * Constructor
	 * @param matchName
	 * @param age
	 * @param photo
	 * @param blurb
	 * @param date
	 * @param address
	 * @param notes
	 */
	Diary(String matchName,String age,String photo , String blurb, String date, String address, String notes){
		this.matchName = matchName;
		this.age =age;
		this.photo = photo;
		this.blurb = blurb;
		this.date = date;
		this.address = address;
		this.notes = notes;
	}

	/**
	 * Get photo
	 * @return photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * Set photo
	 * @param photo
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * Get match name
	 * @return match name
	 */
	public String getMatchName() {
		return matchName;
	}

	/**
	 * Set match name
	 * @param matchName
	 */
	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	/**
	 * Get date
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Set date
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Get address
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Set address
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Get notes
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
	 * Get age
	 * @return age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * Set age
	 * @param age
	 */
	public void setAge(String age) {
		this.age = age;
	}
 
	/**
	 * Get blurb
	 * @return
	 */
	public String getBlurb() {
		return blurb;
	}

	/**
	 * Set blurb
	 * @param blurb
	 */
	public void setBlurb(String blurb) {
		this.blurb = blurb;
	}

	/**
	 * Overriding Object class's equal method
	 */
	@Override
	public boolean equals(Object o) {
		if (o==null) return false;
		Diary d = (Diary) o;
		
		if (address.equals(d.getAddress()) && date.equals(d.getDate()) && matchName.equals(d.getMatchName()) && (age.equals(d.getAge()) && blurb.equals(d.getBlurb()) && photo.equals(d.getPhoto())&& notes.equals(d.getNotes()))) {
			return true;
		}
		else {
			return false;
		}
			
	}
	
}