import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class SignupLogin {
	
	public static User Login (String username, String pwd) {	
		if (username == null || username.equals("")) {
			System.out.println("Please enter username.");
			return null;
		}
		if (pwd == null || pwd.equals("")) {
			System.out.println("Please enter password.");
			return null;
		}
		User currentUser = null;
		boolean closed = false;
		String fileName = username + ".txt";
		File f = new File (fileName);
			Scanner scan;
			try {
				scan = new Scanner(f);
				String s;
				while (currentUser == null && !closed) { //when user closes window, change this to closed = true;
					scan.useDelimiter("\r");
					s = scan.nextLine();
					s = scan.nextLine();
					if (s.equals(pwd)) {
						currentUser = new User (username, pwd);
						if (scan.hasNextLine()) {
							currentUser.setDiaries(FindDiaries.find(currentUser));
						}
						scan.close();
						return currentUser;
						}
					else {
						System.out.println("Password incorrect. Please enter again.");
						return null;
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println("We did not find a user with that username, please try again");
				return null;
			}
			
			//Out of while loop if user closes window
			//LUCY: option to switch to sign up mode 

		return currentUser;
	}
	
	
	public static User SignUp (String username, String pwd) {
		String fileName = username + ".txt";
		File f = new File (fileName);
		if (f.exists()) {
			System.out.println("User name already exists, please pick a different user name!");
			return null;
		}
		
		
		if (username == null || pwd == null || username.equals("") || pwd.equals("")) {
			System.out.println("Please check you have entered username and password.");
			return null;
		}
		if (createUserFile (username, pwd) == null) {
			System.out.println("Error creating user account.");
			return null;
		}
		else {
			User currentUser = new User (username, pwd);
			return currentUser;
		}		
	}
	
	//Only used in sign up method to create the user's little txt file
	public static String createUserFile (String username, String pwd) {
		if (username == null || pwd == null || username.equals("") || pwd.equals("")) {
			System.out.println("Please make sure you entered username and password.");
			return null;
		}
		//LUCY: Take out sysout when you write GUI
		String fileName = username + ".txt";
		File f = new File (fileName);
		if (f.exists()) {
			System.out.println("User name already exists, please pick a different user name!");
			return null;
		}
		try {
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			writer.println(username);
			writer.println(pwd);
			writer.close();	
			return fileName;		

		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.out.println("User cannot be created, please try again");
			return null;
		}	
	}
}
