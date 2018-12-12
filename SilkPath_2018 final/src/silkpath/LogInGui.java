package silkpath;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LogInGui {

	/**
	 * Instance Variables
	 */
	private JFrame SilkPath;
	private JTextField tfUsername;
	private JPasswordField password;
	private JButton btnLogIn;
	private JButton btnSignUp;

	/**
	 * Create the application.
	 */
	public LogInGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		SilkPath = new JFrame();
		SilkPath.setTitle("SilkPath");
		SilkPath.getContentPane().setBackground(new Color(100, 149, 237));
		SilkPath.setBounds(100, 100, 600, 430);
		SilkPath.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lbSilkPath = new JLabel("Silk Path");
		lbSilkPath.setForeground(Color.WHITE);
		lbSilkPath.setBounds(228, 83, 119, 31);
		lbSilkPath.setFont(new Font("Book Antiqua", Font.BOLD, 27));
		
		JLabel lbUsername = new JLabel("Username");
		lbUsername.setBounds(261, 128, 52, 14);
		lbUsername.setForeground(new Color(211, 211, 211));
		lbUsername.setFont(new Font("AR JULIAN", Font.PLAIN, 12));
		
		JLabel lbPassword = new JLabel("Password");
		lbPassword.setBackground(new Color(240, 255, 255));
		lbPassword.setBounds(260, 176, 53, 14);
		lbPassword.setForeground(new Color(211, 211, 211));
		lbPassword.setFont(new Font("AR JULIAN", Font.PLAIN, 12));
		
		tfUsername = new JTextField();
		tfUsername.setBounds(243, 142, 86, 20);
		tfUsername.setFont(new Font("Calibri", Font.PLAIN, 12));
		tfUsername.setColumns(10);
		SilkPath.getContentPane().setLayout(null);
		
		btnLogIn = new JButton("Log In");
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setFont(new Font("AR JULIAN", Font.PLAIN, 12));
		btnLogIn.setBackground(new Color(105, 105, 105));
		btnLogIn.setBounds(243, 229, 87, 23);
		SilkPath.getContentPane().add(btnLogIn);
		SilkPath.getContentPane().add(tfUsername);
		SilkPath.getContentPane().add(lbSilkPath);
		SilkPath.getContentPane().add(lbUsername);
		SilkPath.getContentPane().add(lbPassword);
		
		btnSignUp = new JButton("Sign up");		
		btnSignUp.setForeground(new Color(224, 255, 255));
		btnSignUp.setFont(new Font("AR JULIAN", Font.PLAIN, 12));
		btnSignUp.setBackground(SystemColor.controlDkShadow);
		btnSignUp.setBounds(243, 267, 87, 23);
		SilkPath.getContentPane().add(btnSignUp);
		
		password = new JPasswordField();
		password.setBounds(243, 188, 87, 23);
		SilkPath.getContentPane().add(password);
	}

	/**
	 * Getters and setters
	 */
	public JFrame getSilkPath() {
		return SilkPath;
	}

	public JTextField getTfUsername() {
		return tfUsername;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public JButton getBtnLogIn() {
		return btnLogIn;
	}

	public JButton getBtnSignUp() {
		return btnSignUp;
	}
}

	
	