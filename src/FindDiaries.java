import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FindDiaries {
	
	public static ArrayList<Diary> find(User user) {
		ArrayList<Diary> diaries = new ArrayList<>();
		Scanner scan = new Scanner(user.getUsername() + ".txt");
		scan.nextLine();
		scan.nextLine();
		while (scan.hasNextLine()) {
			String matchName = scan.next();
			String date = scan.next();
			String address = scan.next();
			String notes = scan.next();
			Diary d = new Diary(matchName, date, address, notes);
			diaries.add(d);
		}
		scan.close();
		return diaries;		
	}
	
}
