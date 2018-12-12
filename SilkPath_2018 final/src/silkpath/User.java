package silkpath;
import java.util.ArrayList;
/**
 * This class simulates a user
 * @author silkpath
 *
 */
public class User {
	private String username;
	private String password;
	private ArrayList<Diary> diaries;
	
	/**
	 * Constructor
	 * @param username
	 * @param password
	 */
	public User(String username, String password){
		this.username = username;
		this.password = password;
		diaries = new ArrayList<>();
	}

	/**
	 * Get username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Get password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get user's dating diaries
	 * @return diaries
	 */
	public ArrayList<Diary> getDiaries() {
		return diaries;
	}

	/**
	 * Set user's dating diaries
	 * @param diaries
	 */
	public void setDiaries(ArrayList<Diary> diaries) {
		this.diaries = diaries;
	}
	
	/**
	 * Overriding Object class's equals method
	 */
	public boolean equals(Object o) {
		if (o==null) return false;
		User user = (User) o;
		
		if (username.equals(user.getUsername())) {
			return true;
		}
		else return false;
	}
		

}
