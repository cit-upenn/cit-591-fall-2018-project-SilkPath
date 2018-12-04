import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class SignupLogin {

	private String username;
	private String pwd;
	
	
	public static User Login (String username, String pwd) {
		File f = new File(username);
		User currentUser = null;
		boolean closed = false;
		while (currentUser == null && !closed) { //when user closes window, change this to closed = true;
			if(f.exists() && !f.isDirectory()) { 
			    Scanner scan;
				try {
					scan = new Scanner (f);
				    String s = scan.nextLine();
				    s = scan.nextLine();
				    if (s.equals(pwd)) {
				    	currentUser = new User (username, pwd);
				    	currentUser.setDiaries(FindDiaries.find(currentUser));
				    	return currentUser;
				    }
				    else {
				    	System.out.println("Password incorrect. Please enter again.");	
				    }
				} catch (FileNotFoundException e) {
					System.out.println("Seems like you don't have an account yet, click on the button below to register!");
					//LUCY: switch to sign up mode 
				}
	
			}
		}
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
