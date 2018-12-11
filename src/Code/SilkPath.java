package Code;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Gui.LogInGui;
import Gui.MainGui;
import Gui.SignUpGui;
/**
 * Main method: silk path
 * @author silkpath
 *
 */
public class SilkPath {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInGui window = new LogInGui();
					window.getSilkPath().setVisible(true);
					
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					// Determine the new location of the window
				    int w = window.getSilkPath().getSize().width;
				    int h = window.getSilkPath().getSize().height;
				    int x = (dim.width-w)/2;
				    int y = (dim.height-h)/2;
				    
				    window.getSilkPath().setLocation(x,y);

					window.getBtnLogIn().addMouseListener(new MouseAdapter() {
						
						@Override
						public void mouseClicked(MouseEvent arg0) {
							User currentUser = null;				
							if (currentUser == null ) { 
								String username = window.getTfUsername().getText();					
								String pwd = window.getPassword().getText();
								currentUser = SignupLogin.Login(username, pwd);	
								FindDiaries.find(currentUser);
								window.getSilkPath().setVisible(false);		
								EventQueue.invokeLater(new Runnable() {
									public void run() {
										try {
											MainGui window = new MainGui(new User(username, pwd));
											window.getFrame().setVisible(true);
											window.getFrame().setLocation(x,y-100);
											
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								});
								
								}
						}
					});
					window.getBtnSignUp().addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							window.getSilkPath().setVisible(false);
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										SignUpGui window2 = new SignUpGui();
										window2.getSignUp().setVisible(true);
										window2.getSignUp().setLocation(x, y);
										
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						}

					});
				} catch (Exception e) {
					e.printStackTrace();
					}
		
			  
			}
		});
		
	}
}

