import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RemoveDiaryFromFile {
	
	public static void removeDiary(File f, Diary d) {
	File inputFile = f;
	File tempFile = new File("myTempFile.txt");

	BufferedReader reader;
	try {
		reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = d.getMatchName()+"==="+d.getDate()+"==="+d.getAddress()+"==="+d.getNotes();
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
		if (successful) System.out.println("Diary removed successfully!");
		else {
			System.out.println("Error removing diary. Please try again.");
		}
		
	} catch (IOException e) {
		System.out.println("Error: User not found");
	}
}
}
