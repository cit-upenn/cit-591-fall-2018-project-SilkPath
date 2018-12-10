import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * This class has a static method to remove a diary from a user (a line in the user's file)
 * @author silkpath
 *
 */
public class RemoveDiaryFromFile {
	
	/**
	 * Remove a dating diary from a user/delete that line of diary from the user's file
	 * @param file
	 * @param diary
	 */
	public static void removeDiary(File f, Diary d) {
		//Check diary exists
		if (d == null) System.out.println("Diary does not exist.");
		
		//Set up file for reading/writing
		File inputFile = f;
		File tempFile = new File("myTempFile.txt");
		
		//Write the original file to a new file, skipping the line to remove
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
	
			String lineToRemove = d.getMatch().getName() + "===" + d.getMatch().getAge() + "===" + d.getMatch().getBlurb() + "===" + d.getMatch().getPic()+"==="+d.getDate()+"==="+d.getAddress()+"==="+d.getNotes();
			String currentLine;
	
			while((currentLine = reader.readLine()) != null) {
			    // trim newline when comparing with lineToRemove
			    String trimmedLine = currentLine.trim();
			    
			    //Skip the line to remove when found
			    if(trimmedLine.equals(lineToRemove)) continue;
			    writer.write(currentLine + System.getProperty("line.separator"));
			}
			writer.close(); 
			reader.close(); 
			boolean successful = tempFile.renameTo(inputFile);
			
			//Delete temp file
			tempFile.delete();//LUCY: NOT SURE IF THIS IS THE LINE MISSING
			
			//Check if successful
			if (successful) System.out.println("Diary removed successfully!");
			else {
				System.out.println("Error removing diary. Please try again.");
			}
			
		} catch (IOException e) {
			//If file not found
			System.out.println("Error: User not found");
		}
	}
}
