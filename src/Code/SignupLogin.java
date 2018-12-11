package Code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javax.swing.JOptionPane;
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
		if (username == null || username.equals("") || pwd == null || pwd.equals("")) {
			System.out.println("Please enter username.");
			return null;
		}

		//If valid
		User currentUser = null;
		String fileName = username + ".txt";
		File f = new File (fileName);
		if (!f.exists()) return null;
			Scanner scan;
			//Read user's user name and pwd
			try {
				scan = new Scanner(f);
				String s;
				//while (currentUser == null && !closed) { //when user closes window, change this to closed = true;
					scan.useDelimiter("\r");
					s = scan.nextLine();
					s = scan.nextLine();
					
					//Check if pwd is correct
					if (s.equals(pwd)) {
						currentUser = new User (username, pwd);
						JOptionPane.showMessageDialog(null,"Hello! "+ username+ " , Nice to see you again!");
						if (scan.hasNextLine()) {
							currentUser.setDiaries(FindDiaries.find(currentUser));
						}
						scan.close();
						return currentUser;
					}
					else {
						JOptionPane.showMessageDialog(null,"Password incorrect. Please try again.");
						scan.close();
						return null;
					}
				//}
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Username not found , please try again or click Sign Up");

			}

		return currentUser;
	}
	
	
	public static User SignUp (String username, String pwd) {
		//Check for invalid inputs
		if (username == null || pwd == null || username.equals("") || pwd.equals("")) {
			System.out.println("Please check you have entered username and password.");
			return null;
		}
		
		String fileName = username + ".txt";
		File f = new File (fileName);
		
		//Check if the user name is taken
		if (f.exists()) return null;

		//Create a file for this new user
		if (createUserFile (username, pwd) == null) return null;
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
			System.out.println("Please check you have entered username and password.");
			return null;
		}
		
		String fileName = username + ".txt";
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