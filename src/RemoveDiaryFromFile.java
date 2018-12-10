import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RemoveDiaryFromFile {
	
	public static void removeDiary(File f, Diary d) {
	File inputFile = f;
	File tempFile = new File("myTempFile.txt");
	if (d == null) System.out.println("Diary does not exist.");

	BufferedReader reader;
	try {
		reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = d.getMatch().getName() + "===" + d.getMatch().getAge() + "===" + d.getMatch().getBlurb() + "===" + d.getMatch().getPic()+"==="+d.getDate()+"==="+d.getAddress()+"==="+d.getNotes();
		String currentLine;

		while((currentLine = reader.readLine()) != null) {
		    // trim newline when comparing with lineToRemove
		    String trimmedLine = currentLine.trim();
		    if(trimmedLine.equals(lineToRemove)) continue;
		    writer.write(currentLine + System.getProperty("line.separator"));
		}
		writer.close(); 
		reader.close(); 
		boolean successful = tempFile.renameTo(inputFile);
		tempFile.delete();//LUCY: NOT SURE IF THIS IS THE LINE MISSING
		if (successful) System.out.println("Diary removed successfully!");
		else {
			System.out.println("Error removing diary. Please try again.");
		}
		
	} catch (IOException e) {
		System.out.println("Error: User not found");
	}
}
}
