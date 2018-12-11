package Gui;

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

import Code.Diary;
import Code.FindDiaries;
import Code.RemoveDiaryFromFile;
import Code.User;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Toolkit;

public class MainGui{

	private JFrame fJournal;
	private JLabel lblYourDiaries;
	private JScrollPane scrollPane;
	private JPanel pnDiary;
	private JButton btnAddNew;
	 String pwd  ;
	 String username  ;
	 User currentUser = new User(username, pwd);
	 
	 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
     // Determine the new location of the window


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

        
		setFrame(new JFrame());
		getFrame().getContentPane().setBackground(new Color(100, 149, 237));
		getFrame().getContentPane().setForeground(new Color(100, 149, 237));
		
	     int w = fJournal.getSize().width;
	     int h = fJournal.getSize().height;
	     int x = (dim.width-w)/2;
	     int y = (dim.height-h)/2;

	    fJournal.setLocation(x, y);
		
		lblYourDiaries = new JLabel("Your Dating Journals");
		lblYourDiaries.setFont(new Font("AR JULIAN", Font.PLAIN, 18));
		lblYourDiaries.setForeground(new Color(255, 255, 255));
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		btnAddNew = new JButton("Add New Diary");
		btnAddNew.setBackground(new Color(112, 128, 144));
		btnAddNew.setFont(new Font("AR JULIAN", Font.PLAIN, 15));
		btnAddNew.setForeground(new Color(255, 255, 240));
		btnAddNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								
								CreateDiary window = new CreateDiary(currentUser);
								window.getCreateMatch().setVisible(true);
								window.getCreateMatch().setLocation(x-300, y-300);
								window.getCreateMatch().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								fJournal.dispose();
								
								
							
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(fJournal.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblYourDiaries)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnAddNew)))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(lblYourDiaries)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 442, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(btnAddNew)
					.addGap(38))
		);
		
		pnDiary = new JPanel();
		pnDiary.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(pnDiary);
		pnDiary.setLayout(null);
		fJournal.getContentPane().setLayout(groupLayout);
		getFrame().setBounds(100, 100, 544, 626);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		
		ArrayList<Diary> currentUserDiary = FindDiaries.find(currentUser);
		JButton[] arrayButton = new JButton[currentUserDiary.size()];

		if(currentUserDiary.size()<=0) {
			JOptionPane.showMessageDialog(fJournal, "You don't have any diary now, create your first one :)");
		}
		else {
		for(int i = 0 ; i<currentUserDiary.size(); i++) {
			
				Diary currentOneDiary = currentUserDiary.get(i);
				String who = currentOneDiary.getMatchName();
				String when = currentOneDiary.getDate();
				String what = currentOneDiary.getNotes();
				String where = currentOneDiary.getAddress();
				String age = currentOneDiary.getAge();
				String blurb = currentOneDiary.getBlurb();
				String photo = currentOneDiary.getPhoto();
				
				arrayButton[i] = new JButton("Match Name-"+who+" /Dating Date-"+when +" /Place-"+where);
				arrayButton[i].setBounds(10, 10+ 50*i, 390, 50);
				
				pnDiary.add(arrayButton[i]);
				arrayButton[i].setFont(new Font("AR JULIAN", Font.PLAIN, 14));
				arrayButton[i].setBackground(new Color(244,164,96));
				arrayButton[i].setForeground(new Color(255,255,255));
				
			
				arrayButton[i].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
										
										OpenDiaryGui window = new OpenDiaryGui();
										window.getFrame().setLocation(x-200, y-300);
										window.getFrame().setVisible(true);
										window.getBtnWho_put().setText(who);
										window.getLblWhen_put().setText(when);
										window.getLblWhere_put().setText(where);						
										try {
											JlabelWrapText(window.getLblWhat_put(),what);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
										
										ImageIcon image = new ImageIcon(photo);
										window.setLblNewLabel_1(new JLabel("", image, JLabel.CENTER));
										window.getPanel().add(window.getLblNewLabel_1(), BorderLayout.CENTER );
										window.getPanel().invalidate();
										window.getPanel().validate();
										window.getPanel().repaint();
										
										window.getBtnWho_put().addMouseListener(new MouseAdapter() {
											@Override
											public void mouseClicked(MouseEvent arg0) {	
												
												MatchProfileGui window2 = new MatchProfileGui();
												window2.getFrame().setLocation(x-50,y-250);
												window2.getFrame().setVisible(true);
												window2.getLblName_put().setText(who);
												window2.getLblAge_put().setText(age);
												window2.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
												
												try {
													JlabelWrapText(window2.getLblBlurb_put(),blurb);
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
												
												
												
											}
										});
										
										
										window.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
										
										window.getbtnDelete().addMouseListener(new MouseAdapter() {
											@Override
											public void mouseClicked(MouseEvent arg0) {
												getFrame().dispose();
												int n = JOptionPane.showConfirmDialog(null, "Are you sure?","Confirm ",JOptionPane.YES_NO_OPTION);
												if(n==0) {
												File removeFile = new File(currentUser.getUsername()+".txt");
												
												RemoveDiaryFromFile.removeDiary(removeFile,currentOneDiary);
												window.getFrame().dispose();
												
												JOptionPane.showMessageDialog(null, "Diary removed successfully!");
												
												MainGui window = new MainGui(currentUser);
												window.fJournal.setVisible(true);
												window.fJournal.setLocation(450,34);
												
										
												
												
												}
											}
										});
									}
								});	
				}
		}
	}
					
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
	   
			
	
	public JFrame getFrame() {
		return fJournal;
	}

	public void setFrame(JFrame frame) {
		this.fJournal = frame;
		fJournal.setTitle("Journals");
	}
}



//package Gui;
//
//import java.awt.Color;
//import java.awt.EventQueue;
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.File;
//import java.util.ArrayList;
//
//import javax.swing.GroupLayout;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.ScrollPaneConstants;
//
//import Code.Diary;
//import Code.FindDiaries;
//import Code.RemoveDiaryFromFile;
//import Code.User;
//import javax.swing.LayoutStyle.ComponentPlacement;
//import java.awt.Font;
//
//public class MainGui{
//
//	public JFrame fJournal;
//	private JLabel lblYourDiaries;
//	private JScrollPane scrollPane;
//	private JPanel pnDiary;
//	private JButton btnAddNew;
//	 String pwd  ;
//	 String username  ;
//	 User currentUser = new User(username, pwd);
//
//
//	/**
//	 * Create the application.
//	 */
//	public MainGui(User currentUser) {
//		this.currentUser = currentUser;
//		initialize();
//	
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		setFrame(new JFrame());
//		getFrame().getContentPane().setBackground(new Color(100, 149, 237));
//		getFrame().getContentPane().setForeground(new Color(100, 149, 237));
//		
//		lblYourDiaries = new JLabel("Your Dating Journals");
//		lblYourDiaries.setFont(new Font("AR JULIAN", Font.PLAIN, 18));
//		lblYourDiaries.setForeground(new Color(255, 255, 255));
//		
//		scrollPane = new JScrollPane();
//		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		
//		btnAddNew = new JButton("Add New Match");
//		btnAddNew.setBackground(new Color(112, 128, 144));
//		btnAddNew.setFont(new Font("AR JULIAN", Font.PLAIN, 15));
//		btnAddNew.setForeground(new Color(255, 255, 240));
//		btnAddNew.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				
//					EventQueue.invokeLater(new Runnable() {
//						public void run() {
//							try {
//								
//								CreateDiary window = new CreateDiary(currentUser);
//								window.CreateMatch.setVisible(true);
//								fJournal.dispose();
//								
//							
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//						}
//					});
//				
//			}
//		});
//		
//		GroupLayout groupLayout = new GroupLayout(fJournal.getContentPane());
//		groupLayout.setHorizontalGroup(
//			groupLayout.createParallelGroup(Alignment.LEADING)
//				.addGroup(groupLayout.createSequentialGroup()
//					.addGap(54)
//					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
//						.addComponent(lblYourDiaries)
//						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
//							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)
//							.addComponent(btnAddNew)))
//					.addContainerGap(75, Short.MAX_VALUE))
//		);
//		groupLayout.setVerticalGroup(
//			groupLayout.createParallelGroup(Alignment.LEADING)
//				.addGroup(groupLayout.createSequentialGroup()
//					.addGap(31)
//					.addComponent(lblYourDiaries)
//					.addGap(18)
//					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 442, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
//					.addComponent(btnAddNew)
//					.addGap(38))
//		);
//		
//		pnDiary = new JPanel();
//		pnDiary.setBackground(new Color(255, 255, 255));
//		scrollPane.setViewportView(pnDiary);
//		pnDiary.setLayout(null);
//		fJournal.getContentPane().setLayout(groupLayout);
//		getFrame().setBounds(100, 100, 572, 633);
//		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//
//		
//		ArrayList<Diary> currentUserDiary = FindDiaries.find(currentUser);
//		JButton[] arrayButton = new JButton[currentUserDiary.size()];
//
//	
//		for(int i = 0 ; i<currentUserDiary.size(); i++) {
//			
//				Diary currentOneDiary = currentUserDiary.get(i);
//				String who = currentOneDiary.getMatchName();
//				String when = currentOneDiary.getDate();
//				String what = currentOneDiary.getNotes();
//				String where = currentOneDiary.getAddress();
//				arrayButton[i] = new JButton("Match Name-"+who+" /Dating Date-"+when +" /Place-"+where);
//				arrayButton[i].setBounds(10, 10+ 50*i, 390, 50);
//				
//				pnDiary.add(arrayButton[i]);
//				arrayButton[i].setFont(new Font("AR JULIAN", Font.PLAIN, 14));
//				arrayButton[i].setBackground(new Color(244,164,96));
//				arrayButton[i].setForeground(new Color(255,255,255));
//				
//				pnDiary.add(arrayButton[i]);
//			
//				arrayButton[i].addMouseListener(new MouseAdapter() {
//					@Override
//					public void mouseClicked(MouseEvent arg0) {
//										
//										OpenDiaryGui window = new OpenDiaryGui();
//										window.getFrame().setVisible(true);
//										window.getLblWho_put().setText(who);
//										window.getLblWhen_put().setText(when);
//										window.getLblWhere_put().setText(where);
//										try {
//											JlabelWrapText(window.getLblWhat_put(),what);
//										} catch (InterruptedException e) {
//											// TODO Auto-generated catch block
//											e.printStackTrace();
//										}
//										
//										window.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//										
//										window.getbtnDelete().addMouseListener(new MouseAdapter() {
//											@Override
//											public void mouseClicked(MouseEvent arg0) {
//											
//												int n = JOptionPane.showConfirmDialog(pnDiary, "Are you sure?","Confirm ",JOptionPane.YES_NO_OPTION);
//												if(n==0) {
//												File removeFile = new File(currentUser.getUsername()+".txt");
//												RemoveDiaryFromFile.removeDiary(removeFile,currentOneDiary);
//												
//												fJournal.dispose();
//												MainGui window = new MainGui(currentUser);
//												window.fJournal.setVisible(true);
//												
//												}
//											}
//										});
//									}
//								});	
//				}				
//					
//			   
//			
//	}
//	   private void JlabelWrapText(JLabel jLabel, String longString) 
//	            throws InterruptedException {
//	        StringBuilder builder = new StringBuilder("<html>");
//	        char[] chars = longString.toCharArray();
//	        java.awt.FontMetrics fontMetrics = jLabel.getFontMetrics(jLabel.getFont());
//	        int start = 0;
//	        int len = 0;
//	        while (start + len < longString.length()) {
//	            while (true) {
//	                len++;
//	                if (start + len > longString.length()) break;
//	                if (fontMetrics.charsWidth(chars, start, len) 
//	                        > jLabel.getWidth()) {
//	                    break;
//	                }
//	            }
//	            builder.append(chars, start, len-1).append("<br/>");
//	            start = start + len - 1;
//	            len = 0;
//	        }
//	        builder.append(chars, start, longString.length()-start);
//	        builder.append("</html>");
//	        jLabel.setText(builder.toString());
//	    }
//	public JFrame getFrame() {
//		return fJournal;
//	}
//
//	public void setFrame(JFrame frame) {
//		this.fJournal = frame;
//		fJournal.setTitle("Journals");
//	}
//}
