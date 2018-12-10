import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteDiaryToFile {
	public static Diary writeDiary (User currentUser, Diary d) {
		if (currentUser == null) {
			System.out.println("Error locating user.");
			return null;
		}		
		if (d == null) {
			System.out.println("Error reading in diary.");
			return null;
		}
		
		String fileName = currentUser.getUsername() + ".txt";
		
		//If pwd is wrong
		File f = new File (currentUser.getUsername()+ ".txt");
		Scanner scan;
		try {
			scan = new Scanner(f);
			String s = scan.nextLine();
			s = scan.nextLine();
			if (!s.equals(currentUser.getPassword())){
				scan.close();
				return null;
			}
			
		} catch (FileNotFoundException e1) {
			return null;
		}
		
		try {
			FileWriter fw = new FileWriter(fileName, true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw);
		    out.println(d.getMatch().getName() + "===" + d.getMatch().getAge() + "===" + d.getMatch().getBlurb() + "===" + d.getMatch().getPic() + "===" + d.getDate() + "===" + d.getAddress() +"===" + d.getNotes());
			out.close();	
			return d;					
		} catch (IOException e) {
			System.out.println("Diary cannot be created, please try again");
			return null;
		}	
	}
}
