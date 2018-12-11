package Gui;

import Code.FindDiaries;
import Code.SignupLogin;
import Code.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignUpGui {
	/**
	 * Instance Variables
	 */
	private JFrame SignUp;
	private JPasswordField tfPassword;
	private JTextField tfUsername;
	private JPasswordField tfConfirm;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

	/**
	 * Create the application.
	 */
	public SignUpGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		SignUp = new JFrame();
		SignUp.setTitle("Sign Up");
		SignUp.getContentPane().setBackground(new Color(100, 149, 237));
		SignUp.getContentPane().setForeground(new Color(100, 149, 237));
		SignUp.setBounds(100, 100, 600, 430);
		SignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SignUp.getContentPane().setLayout(null);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addMouseListener(new MouseAdapter() {
			boolean signedUp = false;
			@Override
			public void mouseClicked(MouseEvent arg0) {

					while (!signedUp) {

						String username = tfUsername.getText();
						String pwd = tfPassword.getText();
						String confirmPwd = tfConfirm.getText();
		
						boolean repeat = true;
						while(repeat) {
							tfPassword.setText(null);
							tfConfirm.setText(null);
							//check if passwords are the same
							if(!confirmPwd.equals(pwd) ){
							
							JOptionPane.showMessageDialog(null,  " Passwords does not match, please try again.","Notice",JOptionPane.WARNING_MESSAGE);
						
							pwd=null;
							confirmPwd=null;
							username=null;

							}

						else if (confirmPwd.equals(pwd)) {
							User currentUser = SignupLogin.SignUp(username, confirmPwd); //This should create a new user
							SignupLogin.createUserFile(username, confirmPwd);
							//fine the user's data file
							FindDiaries diaries = new FindDiaries();
							diaries.find(currentUser);

									if (currentUser != null) signedUp = true;
									JOptionPane.showMessageDialog(null, username + " , welcome to SilkPath !");
									SignUp.setVisible(false);
									EventQueue.invokeLater(new Runnable() {
										public void run() {
											try {
												String username = tfUsername.getText();
												String pwd = tfPassword.getText();
												
												//show up home page
												MainGui window = new MainGui(new User(username,pwd));
											    int w = window.getFrame().getSize().width;
											    int h = window.getFrame().getSize().height;
											    int x = (dim.width-w)/2;
											    int y = (dim.height-h)/2;
												window.getFrame().setVisible(true);
												window.getFrame().setLocation(x, y);
												
											} catch (Exception e) {
												e.printStackTrace();
											}
										}
									});
						repeat=false;}
					}
				}
			}

		}
		);
		btnSignUp.setForeground(new Color(224, 255, 255));
		btnSignUp.setFont(new Font("AR JULIAN", Font.PLAIN, 12));
		btnSignUp.setBackground(SystemColor.controlDkShadow);
		btnSignUp.setBounds(246, 292, 87, 23);
		SignUp.getContentPane().add(btnSignUp);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(246, 185, 87, 23);
		SignUp.getContentPane().add(tfPassword);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(240, 255, 255));
		lblPassword.setFont(new Font("AR JULIAN", Font.PLAIN, 12));
		lblPassword.setBounds(263, 173, 53, 14);
		SignUp.getContentPane().add(lblPassword);
		
		tfUsername = new JTextField();
		tfUsername.setFont(new Font("Calibri", Font.PLAIN, 12));
		tfUsername.setColumns(10);
		tfUsername.setBounds(246, 139, 86, 20);
		SignUp.getContentPane().add(tfUsername);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(211, 211, 211));
		lblUsername.setFont(new Font("AR JULIAN", Font.PLAIN, 12));
		lblUsername.setBounds(264, 125, 52, 14);
		SignUp.getContentPane().add(lblUsername);
		
		JLabel label_2 = new JLabel("Silk Path");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Book Antiqua", Font.BOLD, 27));
		label_2.setBounds(231, 80, 119, 31);
		SignUp.getContentPane().add(label_2);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(new Color(240, 248, 255));
		lblConfirmPassword.setFont(new Font("AR JULIAN", Font.PLAIN, 12));
		lblConfirmPassword.setBounds(237, 218, 111, 14);
		SignUp.getContentPane().add(lblConfirmPassword);
		
		tfConfirm = new JPasswordField();
		tfConfirm.setBounds(246, 232, 87, 23);
		SignUp.getContentPane().add(tfConfirm);
	}
	/**
	 * Get frame
	 */
	public JFrame getSignUp() {
		return SignUp;
	}
}
