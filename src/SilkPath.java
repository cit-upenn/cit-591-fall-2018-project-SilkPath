import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SilkPath {
	
	public static void main(String[] args) throws IOException {

		// Sign up		
		Scanner scan = new Scanner(System.in);
		boolean signedUp = false;
		boolean closed = false; //LUCY: If the user closes window, or go back to another screen, closed = true;
		while (!signedUp && !closed) {
			System.out.println("Enter username: ");
			String username = scan.nextLine();
			System.out.println("Enter password: ");
			String pwd = scan.nextLine();
			System.out.println("Please confirm password: ");
			String confirmPwd = scan.nextLine();
			if (confirmPwd.equals(pwd)) {
				User currentUser = SignupLogin.SignUp(username, confirmPwd); //This should create a new user
				if (currentUser != null) signedUp = true;
				scan.close();
			}
		}
		
		/**
		//Log in
		Scanner scan = new Scanner(System.in);
		User currentUser = null;
		ArrayList<Diary> diaries = new ArrayList<>();
		boolean closed = false;
		while (currentUser == null && !closed) { //LUCY: when user closes the window, change closed = true;
			System.out.println("Enter username: ");
			String username = scan.nextLine();
			System.out.println("Enter password: ");
			String pwd = scan.nextLine();
			currentUser = SignupLogin.Login(username, pwd);	
			diaries = currentUser.getDiaries();
		}
		System.out.println("Log in successfully...redirecting to your diaries!");
		scan.close();
		
		/**Create a new diary
		String matchName = scan.next();
		String date = scan.next();
		String address = scan.next();
		String notes = scan.next();		
		Diary d = new Diary(matchName, date, address, notes);
		diaries.add(d);
		
		
		//Edit a diary
		String matchName = scan.next();
		String date = scan.next();
		String address = scan.next();
		String notes = scan.next();
		Diary d = new Diary ("name", "date", "address", "notes");//LUCY: just a filler object, need to delete this
		d.setMatchName(matchName);
		d.setDate(date);
		d.setAddress(address);
		d.setNotes(notes);
		*/
			
}
}
