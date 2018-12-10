import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

/**
 * Main method: silk path
 * @author silkpath
 *
 */
public class SilkPath {
	
	public static void main(String[] args) throws IOException {

		/**Sign up		
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
		*/
		
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
		}
		diaries = currentUser.getDiaries();
		System.out.println("Log in successfully...redirecting to your diaries!");
		//scan.close();
		/**
		for (int  i =0 ;i<diaries.size();i++) {
			System.out.println("diary" + i + ": " + diaries.get(i).getMatch().getName());
			System.out.println("diary" + i + ": " + diaries.get(i).getMatch().getAge());
		}
		System.out.println();
		*/
		
		
		//Create a new diary
		System.out.println("Enter match name: ");
		//LUCY: Need to create a place for them to select a picture and we grab the file path
		String picPath = "pic.jpg";
		//LUCY: Need to set up input validation (age cannot be weird symbols etc.)
		Image picture = ImageIO.read(new File(picPath)); //LUCY: This is used for display image (path to image file locally)
		
		//LUCY: Need to change this to the selected match from the dropdown
		//If the match does not exist, send them to Match's constructor after asking them for info (see below hardcoded code)	
		Match match = new Match("Placeholder", 25, "Grad student", picPath); 
		System.out.println("Enter date: ");
		String date = scan.nextLine();
		System.out.println("Enter address: ");
		String address = scan.nextLine();
		System.out.println("Enter notes: ");
		String notes = scan.nextLine();		
		//scan.close();
		Diary d = new Diary(match, date, address, notes);		
		WriteDiaryToFile.writeDiary(currentUser, d);
		diaries.add(d);
		if (d!=null)
		System.out.println("Diary created successfully!");
		else System.out.println("Diary could not be created.");
		//LUCY: make sure to close scan if you used it
		
		
		//Delete a diary
		System.out.println("Enter 'remove' to remove this added diary");
		String command = scan.next();
		if (command.equals("remove")) {
			int i = 0;
			while (!diaries.get(i).equals(d) && i < diaries.size()) {
				i++;
			}
			if (i == diaries.size()) System.out.println("Error: Did not find diary.");
			else {
				File f = new File (currentUser.getUsername() + ".txt");
				RemoveDiaryFromFile.removeDiary(f, d);
				currentUser.getDiaries().remove(i);
			}
		}
		
		/**Edit a diary
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
