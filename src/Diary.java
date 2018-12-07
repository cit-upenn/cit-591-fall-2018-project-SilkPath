public class Diary {
	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	private Match match;
	private String date;
	private String address;
	private String notes;
	
	Diary(Match match, String date, String address, String notes){
		this.match = match;
		this.date = date;
		this.address = address;
		this.notes = notes;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
