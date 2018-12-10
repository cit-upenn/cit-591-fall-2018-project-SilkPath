import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class has a static method to take in one user and find that user's dating diaries and store on that user
 * @author silkpath
 *
 */
public class FindDiaries {
	
	/**
	 * Find diaries of passed in user
	 * @param user
	 * @return an array list of diaries or null
	 */
	public static ArrayList<Diary> find(User user) {
		//Check if parameter is null
		if (user == null) {
			System.out.println("User empty, please try again.");
			return null;
		}
		
		//If not null
		ArrayList<Diary> diaries = null;
		File f = new File (user.getUsername()+ ".txt");
		
		try {
			Scanner scan = new Scanner(f);
			String s = scan.nextLine();
			s = scan.nextLine();
			//Check if password is correct
			if (!s.equals(user.getPassword())){
				scan.close();
				return null;
			}
			
			//If everything is correct, we loop to add each line of dating diary
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
				Diary d;
					
				if (user.getMatches().size() == 0) {
					user.getMatches().add(m);
					d = new Diary(m, date, address, notes);
				}
				else {
					//Check if this match already exists
					int i = 0;
					while (!user.getMatches().get(i).equals(m) && i < user.getMatches().size()) {
						i++;
					}
					
					//1) Found the index
					if (user.getMatches().get(i).equals(m)) {
						//Add this match to diary then go back to while loop to check the next line
						d = new Diary(user.getMatches().get(i), date, address, notes);
					}
					
					//2) While loop stopped because didn't find it
					else {
						user.getMatches().add(m);
						d = new Diary(m, date, address, notes);
					}
				}
				diaries = new ArrayList<>();
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
