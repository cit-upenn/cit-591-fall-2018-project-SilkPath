import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FindDiaries {
	
	public static ArrayList<Diary> find(User user) {
		ArrayList<Diary> diaries = new ArrayList<>();
		File f = new File (user.getUsername()+ ".txt");
		Scanner scan;
		try {
			scan = new Scanner(f);
			String s = scan.nextLine();
			s = scan.nextLine();
			while (scan.hasNextLine()) {
				String[] parsed = scan.nextLine().split("===");
				String matchName = parsed[0];
				int matchAge = Integer.parseInt(parsed[1]);
				String matchBlurb = parsed[2];
				String matchPic = parsed[3];
				String date = parsed[4];
				String address = parsed[5];
				String notes = parsed[6];
				Match m = new Match (matchName, matchAge, matchBlurb, matchPic);
				Diary d = new Diary(m, date, address, notes);
				diaries.add(d);
			}
			scan.close();
			return diaries;		
		} catch (FileNotFoundException e) {
			System.out.println("Did not find user in our system.");
			return null;
		}
		
	}
	
}
