package Code;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
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
	public static Diary removeDiary(File f, Diary d) {
	
		//Set up file for reading/writing
		File inputFile = f;
		File tempFile = new File("myTempFile.txt");
	
		//Write the original file to a new file, skipping the line to remove
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
	
			String lineToRemove = d.getMatchName()+"==="+d.getAge()+"==="+d.getPhoto()+"==="+d.getBlurb()+"==="+d.getDate()+"==="+d.getAddress()+"==="+d.getNotes();
			String currentLine;
	
			while((currentLine = reader.readLine()) != null) {
			    // trim newline when comparing with lineToRemove
			    String trimmedLine = currentLine.trim();
			  //Skip the line to remove when found
			    if(trimmedLine.equals(lineToRemove)) {
			        System.out.println("Im here");
			    	continue;
			    }
			    writer.write(currentLine + System.getProperty("line.separator"));
			}
			writer.close(); 
			reader.close(); 
			
			//Delete temp file
			inputFile.delete();
			boolean successful = tempFile.renameTo(inputFile);
			if (successful) {
	//			JOptionPane.showMessageDialog(null, "Diary removed successfully!");
				return d;
			}		    
			else {
				JOptionPane.showMessageDialog(null,"Error removing diary. Please try again.");
				return null;
			}
			
		}catch (IOException e) {			
			JOptionPane.showMessageDialog(null,"Error: User not found");
			return null;
		}
	}
}
