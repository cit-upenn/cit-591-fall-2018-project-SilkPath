import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
/**
 * This class simulates a user's sign up and log in flow
 * @author silkpath
 *
 */
public class SignupLogin {
	
	/**
	 * This method logs user in
	 * @param username
	 * @param pwd
	 * @return user
	 */
	public static User Login (String username, String pwd) {	
		//Check invalid cases
		if (username == null || username.equals("")) {
			System.out.println("Please enter username.");
			return null;
		}
		if (pwd == null || pwd.equals("")) {
			System.out.println("Please enter password.");
			return null;
		}
		
		//If valid
		User currentUser = null;
		boolean closed = false;
		String fileName = username + ".txt";
		File f = new File (fileName);
		
		//Read user's user name and pwd
			try {
				Scanner scan = new Scanner(f);
				String s;
				while (currentUser == null && !closed) { //when user closes window, change this to closed = true;
					scan.useDelimiter("\r");
					s = scan.nextLine();
					s = scan.nextLine();
					
					//Check if pwd is correct
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
						scan.close();
						return null;
					}
				}
				scan.close();
			} catch (FileNotFoundException e) {
				System.out.println("We did not find a user with that username, please try again");
				return null;
			}
			
			//Out of while loop if user closes window
			//LUCY: option to switch to sign up mode 

		return currentUser;
	}
	
	/**
	 * This method signs user up
	 * @param username
	 * @param pwd
	 * @return user
	 */
	public static User SignUp (String username, String pwd) {
		
		//Check for invalid inputs
		if (username == null || pwd == null || username.equals("") || pwd.equals("")) {
			System.out.println("Please check you have entered username and password.");
			return null;
		}
				
		String fileName = username + ".txt";
		File f = new File (fileName);
				
		//Check if the user name is taken
		if (f.exists()) {
			System.out.println("User name already exists, please pick a different user name!");
			return null;
		}

		//Create a file for this new user
		if (createUserFile (username, pwd) == null) {
			System.out.println("Error creating user account.");
			return null;
		}
		else {
			User currentUser = new User (username, pwd);
			return currentUser;
		}		
	}
	
	//This method creates new user's file
	//Only used in sign up method to create the user's ".txt" file
	public static String createUserFile (String username, String pwd) {
		//Check for invalid inputs
		if (username == null || pwd == null || username.equals("") || pwd.equals("")) {
			System.out.println("Please make sure you entered username and password.");
			return null;
		}
		
		//LUCY: Take out sysout when you write GUI
		String fileName = username + ".txt";
		File f = new File (fileName);
		
		//Check again if the user name is taken
		if (f.exists()) {
			System.out.println("User name already exists, please pick a different user name!");
			return null;
		}
		
		//Write user name and pwd to a new file
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
