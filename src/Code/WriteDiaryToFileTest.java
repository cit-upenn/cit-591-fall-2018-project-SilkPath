package Code;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * JUnit test class for WriteDiaryToFile class
 * @author silkpath
 *
 */
class WriteDiaryToFileTest {
	User serena; //User exists and correct pwd
	User lucy; //User exists but wrong password
	User sally; //User is null
	User jen; //User file not found
	Diary d1; //Diary correct
	Diary d2; //Diary is null
		
	@BeforeEach
	void setUp() throws Exception {
		this.serena = new User ("serena", "test123");
		this.lucy = new User ("Lucy", "123");
		this.sally = null;
		this.jen = new User ("jen", "123");
		this.d1 = null;
		this.d2 = null;
		
	}

	@Test
	void test() {
		//Test case 1: krystal, correct diary
		String matchName = "Jack";
		String age = "23";
		String blurb = "Analyst at JPM";
		String photo = "pic.jpg";
		String date = "1/3/2019";
		String address = "Bubble";
		String notes = "OMG I love him!!";		
		d1 = new Diary(matchName, age, photo, blurb, date, address, notes);
		
		assertEquals(d1, WriteDiaryToFile.writeDiary(serena, d1));
		
		//Test case 2: krystal, null diary
		assertNull(WriteDiaryToFile.writeDiary(serena, d2));
		
		//Test case 3: null user, correct diary
		assertNull(WriteDiaryToFile.writeDiary(sally, d1));
		
		//Test case 4: lucy (wrong pwd), correct diary
		assertNull(WriteDiaryToFile.writeDiary(lucy, d1));
		
		//Test case 5: User does not exist in file (file not found exception)
		assertNull(WriteDiaryToFile.writeDiary(jen, d1));
		
	}

}
