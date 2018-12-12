package silkpath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for SignupLogin class
 * @author silkpath
 *
 */
class SignupLoginTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testLogin() {
		//Test case 1: krystal, correct username and pwd
		String username = "krystal";
		String pwd = "test";
		User krystal = new User("krystal", "test");
		System.out.println(SignupLogin.Login(username, pwd));
		assertEquals(krystal, SignupLogin.Login(username, pwd));
		
		//Test case 2: incorrect pwd
		assertNull(SignupLogin.Login("krystal", "123"));
		
		//Test case 3: User name doesn't exist (file not found exception)
		assertNull(SignupLogin.Login("kendall", "123"));
		
		//Test case 4: User name is null or empty
		assertNull(SignupLogin.Login(null, "123"));
		assertNull(SignupLogin.Login("", "123"));
		
		//Test case 5: Pwd is null or empty
		assertNull(SignupLogin.Login("krystal", null));
		assertNull(SignupLogin.Login("krystal", ""));
	
	}

	@Test
	void testSignup() {
		//Test case 1: new user name, password, success
		String username = "jeremy";
		String pwd = "test";
		User krystal = new User("jeremy", "test");
		assertEquals(krystal, SignupLogin.SignUp(username, pwd));
		
		//Test case 2: user name exists
		assertNull(SignupLogin.SignUp("krystal", "Abc"));
		
		//Test case 3: User name is null or empty
		assertNull(SignupLogin.SignUp(null, "123"));
		assertNull(SignupLogin.SignUp("", "123"));
		
		//Test case 4: Pwd is null or empty
		assertNull(SignupLogin.SignUp("krystal", null));
		assertNull(SignupLogin.SignUp("krystal", ""));
	
	}
	
	@Test
	void testCreateUserFile() {
		//Test case 1: new user name, password, success
		String username = "christine";
		String pwd = "test";
		assertEquals("christine.txt", SignupLogin.createUserFile(username, pwd));
		
		//Test case 2: user name exists
		assertNull(SignupLogin.SignUp("krystal", "Abc"));
		
		//Test case 3: User name is null or empty
		assertNull(SignupLogin.SignUp(null, "123"));
		assertNull(SignupLogin.SignUp("", "123"));
		
		//Test case 4: Pwd is null or empty
		assertNull(SignupLogin.SignUp("krystal", null));
		assertNull(SignupLogin.SignUp("krystal", ""));
	
	}

}