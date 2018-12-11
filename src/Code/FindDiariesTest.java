package Code;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for FindDiaries class
 * @author silkpath
 *
 */
class FindDiariesTest {

	User krystal; //User exists and has diaries
	User lucy; //User exists and has no diaries
	User sally; //User exists but password wrong
	User stella; //User does not exist
	User nini; //User is null
	ArrayList<Diary> krystal_d;
	
	@BeforeEach
	void setUp() throws Exception {
		this.krystal = new User ("krystal", "test");
		this.lucy = new User ("lucy", "test!");
		this.sally = new User ("lucy", "123");
		this.stella = new User ("stella", "test!");
		this.nini = null;
		this.krystal_d = new ArrayList<Diary>();
	}

	@Test
	void testFind() {
		//Test case 1: Krystal
		String matchName = "Placeholder";
		String age = "25";
		String photo = "pic.jpg";
		String blurb = "Grad student";
		String date = "1/1/2019";
		String address = "Jamonera";
		String notes = "Great date. I would go on a second date with him";
		
		Diary d = new Diary(matchName, age, photo, blurb, date, address, notes);	
		krystal_d.add(d);
		krystal.setDiaries(krystal_d);
		
		assertIterableEquals(krystal_d, FindDiaries.find(krystal));

//		//Test case 2: Lucy
//		assertNull(FindDiaries.find(lucy));
//		
//		//Test case 3: Sally
//		assertNull(FindDiaries.find(sally));
		
		//Test case 4: Stella
		assertNull(FindDiaries.find(stella));
		
//		//Test case 5: Nini
//		assertNull(FindDiaries.find(nini));
	}
}
