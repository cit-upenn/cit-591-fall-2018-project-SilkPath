import java.util.ArrayList;

public class User {
	private String username;
	private String password;
	private ArrayList<Diary> diaries;
	
	User(String username, String password){
		this.username = username;
		this.password = password;
		diaries = new ArrayList<>();
	}

	public String getUsername() {
		return username;
	}
	
	//probably shouldn't be public method
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Diary> getDiaries() {
		return diaries;
	}

	public void setDiaries(ArrayList<Diary> diaries) {
		this.diaries = diaries;
	}
		

}
