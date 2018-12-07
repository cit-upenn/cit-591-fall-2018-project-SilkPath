import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class SignupLogin {
	
	public static User Login (String username, String pwd) {		
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
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println("We did not find a user with that username, please try again");

			}
			
			//Out of while loop if user closes window
			//LUCY: option to switch to sign up mode 

		return currentUser;
	}
	
	
	public static User SignUp (String username, String pwd) {
		if (createUserFile (username, pwd) == null) return null;
		else {
			User currentUser = new User (username, pwd);
			return currentUser;
		}		
	}
	
	//Only used in sign up method to create the user's little txt file
	public static String createUserFile (String username, String pwd) {
		String fileName = username + ".txt";
		try {
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			writer.println(username);
			writer.println(pwd);
			writer.close();	
			return fileName;		

		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.out.println("User cannot be created, please try again");
			return null;
			//e.printStackTrace();
		}	
	}
}
