import java.util.Date;

public class Diary {
	private String matchName;
	private String date;
	private String address;
	private String notes;
	
	Diary(String matchName, String date, String address, String notes){
		this.matchName = matchName;
		this.date = date;
		this.address = address;
		this.notes = notes;
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
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
