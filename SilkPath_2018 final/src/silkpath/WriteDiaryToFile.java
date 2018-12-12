package silkpath;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * This class takes in a user, a diary and writes the diary into user's file
 * @author silkpath
 *
 */
public class WriteDiaryToFile {
	
	/**
	 * This class writes a diary to user's file
	 * @param currentUser
	 * @param diary
	 * @return diary
	 */
	public static Diary writeDiary (User currentUser, Diary d) {
		
		//Check for invalid inputs
		if (currentUser == null) {
			System.out.println("Error locating user.");
			return null;
		}		
		if (d == null) {
			System.out.println("Error reading in diary.");
			return null;
		}
		
		//Check if username or pwd is wrong (only needed for JUnit)
		String fileName = currentUser.getUsername() + ".txt";
		File f = new File (fileName);
		try {
			Scanner scan = new Scanner(f);
			String s = scan.nextLine();
			s = scan.nextLine();
			if (!s.equals(currentUser.getPassword())){
				scan.close();
				return null;
			}
			scan.close();
			
		} catch (FileNotFoundException e1) {
			return null;
		}
				
		//Write diary to file
		try {
			FileWriter fw = new FileWriter(fileName, true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw);
		    out.println(d.getMatchName() + "===" + d.getAge() + "===" + d.getPhoto() + "===" + d.getBlurb() + "===" + d.getDate() + "===" + d.getAddress() +"===" + d.getNotes());
			out.close();	
			return d;					
		} catch (IOException e) {
			System.out.println("Diary cannot be created, please try again");
			return null;
		}	
	}
}