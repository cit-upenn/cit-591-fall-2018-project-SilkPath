import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteDiaryToFile {
	public static Diary writeDiary (User currentUser, Diary d) {
		String fileName = currentUser.getUsername() + ".txt";
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
