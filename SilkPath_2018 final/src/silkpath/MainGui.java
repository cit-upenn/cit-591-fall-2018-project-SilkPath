package silkpath;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Toolkit;

public class MainGui{
	/**
	* Instance Variables
	*/
	private JFrame fJournal;
	private JLabel lblYourDiaries;
	private JScrollPane scrollPane;
	private JPanel pnDiary;
	private JButton btnAddNew;
	private String pwd  ;
	private String username  ;
	private User currentUser = new User(username, pwd);	 
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();


	/**
	 * Create the application.
	 */
	public MainGui(User currentUser) {
		this.currentUser = currentUser;
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		fJournal = new JFrame();
		fJournal.getContentPane().setBackground(new Color(100, 149, 237));
		fJournal.setBounds(100, 100, 553, 672);
		fJournal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set the frame in the middle of the window
	     int w = fJournal.getSize().width;
	     int h = fJournal.getSize().height;
	     int x = (dim.width-w)/2;
	     int y = (dim.height-h)/2;

	    fJournal.setLocation(x, y);
	    fJournal.setVisible(true);
	    
		lblYourDiaries = new JLabel("Your Dating Journals");
		lblYourDiaries.setFont(new Font("AR JULIAN", Font.PLAIN, 18));
		lblYourDiaries.setForeground(new Color(255, 255, 255));
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		btnAddNew = new JButton("Add New");
		btnAddNew.setBackground(new Color(204, 102, 102));
		btnAddNew.setFont(new Font("AR JULIAN", Font.PLAIN, 15));
		btnAddNew.setForeground(new Color(255, 255, 255));
		btnAddNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								fJournal.setVisible(false);
								//call the create diary window
								CreateDiaryGui window = new CreateDiaryGui(currentUser);
								window.getCreateMatch().setVisible(true);;
								
								fJournal.invalidate();
								fJournal.validate();
								fJournal.repaint();
								
								
							
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				
			}
		});
		pnDiary = new JPanel();
		pnDiary.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(pnDiary);
		pnDiary.setLayout(null);
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?" , "Confirm", JOptionPane.YES_NO_OPTION);
				if (n==0) {
					fJournal.dispose();
					Main_SilkPath window = new Main_SilkPath();
				}
			}
		});
		btnLogOut.setForeground(new Color(255, 255, 224));
		btnLogOut.setFont(new Font("AR JULIAN", Font.PLAIN, 15));
		btnLogOut.setBackground(new Color(105, 105, 105));
		
		GroupLayout groupLayout = new GroupLayout(fJournal.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblYourDiaries)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnAddNew)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnLogOut)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addComponent(lblYourDiaries)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 442, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddNew)
						.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(30, Short.MAX_VALUE))
		);
	

		fJournal.getContentPane().setLayout(groupLayout);
		
		//find the diaries of the logged in user
		ArrayList<Diary> currentUserDiary = FindDiaries.find(currentUser);
		JButton[] arrayButton = new JButton[currentUserDiary.size()];

		
		for(int i = 0 ; i<currentUserDiary.size(); i++) {
			
				//save the diary information into Strings
				Diary currentOneDiary = currentUserDiary.get(i);
				String who = currentOneDiary.getMatchName();
				String when = currentOneDiary.getDate();
				String what = currentOneDiary.getNotes();
				String where = currentOneDiary.getAddress();
				String age = currentOneDiary.getAge();
				String blurb = currentOneDiary.getBlurb();
				String photo = currentOneDiary.getPhoto();
				
				//add a button for the diary
				arrayButton[i] = new JButton("Match Name-"+who+" /Dating Date-"+when +" /Place-"+where);
				arrayButton[i].setBounds(10, 10+ 50*i, 395, 50);
				
				pnDiary.add(arrayButton[i]);
				arrayButton[i].setFont(new Font("AR JULIAN", Font.PLAIN, 14));
				arrayButton[i].setBackground(new Color(244,164,96));
				arrayButton[i].setForeground(new Color(255,255,255));
				
				//add alistenerr to the button being added
				arrayButton[i].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
										
						//shows the diary's details
						OpenDiaryGui window = new OpenDiaryGui();
						window.getFrame().setVisible(true);
						window.getBtnWho_put().setText(who);
						window.getLblWhen_put().setText(when);
						window.getLblWhere_put().setText(where);						
							try {
							JlabelWrapText(window.getLblWhat_put(),what);
							} catch (InterruptedException e) {
							e.printStackTrace();
							}
							
						//print out the photo that's been saved				
						ImageIcon image = new ImageIcon(photo);
						window.setLblPhoto(new JLabel("", image, JLabel.CENTER));
						window.getPnPhoto().add(window.getLblPhoto(), BorderLayout.NORTH);
						window.getPnPhoto().invalidate();
						window.getPnPhoto().validate();
						window.getPnPhoto().repaint();
						
						//add a listener to the name's button				
						window.getBtnWho_put().addMouseListener(new MouseAdapter() {
						@Override
							public void mouseClicked(MouseEvent arg0) {	
								//shows up the match's profile				
								MatchProfileGui window2 = new MatchProfileGui();
								window2.getFrame().setVisible(true);
								window2.getLblName_put().setText(who);
								window2.getLblAge_put().setText(age);
								window2.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								
								//wrap the blurb		
									try {
									JlabelWrapText(window2.getLblBlurb_put(),blurb);
									} catch (InterruptedException e) {
									e.printStackTrace();
									}																														
							}
						});
										
										
						window.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);										
						//add a listener to delete button
						window.getbtnDelete().addMouseListener(new MouseAdapter() {
						@Override
							public void mouseClicked(MouseEvent arg0) {
							
							//confirm the action					
							int n = JOptionPane.showConfirmDialog(null, "Are you sure?","Confirm ",JOptionPane.YES_NO_OPTION);
							if(n==0) {										    
								File removeFile = new File(currentUser.getUsername()+".txt");											
								
								//remove the data from the file
								RemoveDiaryFromFile.removeDiary(removeFile,currentOneDiary);
								window.getFrame().dispose();
								JOptionPane.showMessageDialog(null, "Diary removed successfully!");
								fJournal.setVisible(false);
								
								//update the home page
								MainGui window = new MainGui(currentUser);
								window.fJournal.setVisible(true);																															
							}
							}
							});
						}
				});	
		}
		
		//if no diary, message shows up
		if(currentUserDiary.size()<=0) {
			JOptionPane.showMessageDialog(fJournal, "You don't have any diary now, create your first one :)");
		}}
	
	    /**
	     * A method that can wrap the text to fit the panel
	     * @param jLabel
	     * @param longString
	     * @throws InterruptedException
	     */
	    private void JlabelWrapText(JLabel jLabel, String longString) 
	            throws InterruptedException {
	        StringBuilder builder = new StringBuilder("<html>");
	        char[] chars = longString.toCharArray();
	        java.awt.FontMetrics fontMetrics = jLabel.getFontMetrics(jLabel.getFont());
	        int start = 0;
	        int len = 0;
	        while (start + len < longString.length()) {
	            while (true) {
	                len++;
	                if (start + len > longString.length()) break;
	                if (fontMetrics.charsWidth(chars, start, len) 
	                        > jLabel.getWidth()) {
	                    break;
	                }
	            }
	            builder.append(chars, start, len-1).append("<br/>");
	            start = start + len - 1;
	            len = 0;
	        }
	        builder.append(chars, start, longString.length()-start);
	        builder.append("</html>");
	        jLabel.setText(builder.toString());
	    }
	    
	    /**
		* Getters and setters
		*/
		public JFrame getfJournal() {
			return fJournal;
		}

		public void setfJournal(JFrame fJournal) {
			this.fJournal = fJournal;
		}
	
}