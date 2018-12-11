package Gui;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

public class MatchProfileGui {

	/**
	 * Instance Variables
	 */
	private JFrame fMatch;
	private JLabel lblBlurb_put;
	private JLabel lblName_put;
	private JLabel lblBlurb;
	private JLabel lblAge;
	private JLabel lblName;
	private JScrollPane scrollPane;
	private JLabel lblAge_put;


	/**
	 * Create the application.
	 */
	public MatchProfileGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fMatch = new JFrame();
		fMatch.getContentPane().setBackground(new Color(188, 143, 143));
		fMatch.getContentPane().setForeground(new Color(255, 255, 255));
		fMatch.setTitle("My Diary");
		fMatch.setBounds(100, 100, 454, 212);
		fMatch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(100, 149, 237));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		lblName = new JLabel("Name :");
		lblName.setFont(new Font("AR JULIAN", Font.PLAIN, 15));
		lblName.setForeground(new Color(255, 255, 255));
		
		lblAge = new JLabel("Age :");
		lblAge.setBackground(new Color(255, 255, 255));
		lblAge.setForeground(new Color(255, 255, 255));
		lblAge.setFont(new Font("AR JULIAN", Font.PLAIN, 15));
		
		lblBlurb = new JLabel("Blurb:");
		lblBlurb.setFont(new Font("AR JULIAN", Font.PLAIN, 15));
		lblBlurb.setForeground(new Color(255, 255, 255));
		
		
		lblName_put = new JLabel(" ");
		lblName_put.setForeground(new Color(245, 255, 250));
		lblName_put.setFont(new Font("AR JULIAN", Font.PLAIN, 15));
		
		lblAge_put = new JLabel(" ");
		lblAge_put.setForeground(new Color(245, 255, 250));
		lblAge_put.setFont(new Font("AR JULIAN", Font.PLAIN, 15));
		
		GroupLayout groupLayout = new GroupLayout(fMatch.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblName)
							.addGap(18)
							.addComponent(lblName_put, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAge)
								.addComponent(lblBlurb))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAge_put, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))))
					.addGap(197))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(lblName_put, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblAge)
						.addComponent(lblAge_put, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addComponent(lblBlurb))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
					.addGap(308))
		);
		
		lblBlurb_put = new JLabel("    ");		
		lblBlurb_put.setAlignmentY(1.0f);
		lblBlurb_put.setAlignmentX(1.0f);
		lblBlurb_put.setForeground(new Color(105, 105, 105));
		lblBlurb_put.setVerticalTextPosition(SwingConstants.TOP);
		lblBlurb_put.setVerticalAlignment(SwingConstants.TOP);
		lblBlurb_put.setFont(new Font("AR JULIAN", Font.PLAIN, 14));
		lblBlurb_put.setBackground(new Color(100, 149, 237));
		scrollPane.setViewportView(lblBlurb_put);
		fMatch.getContentPane().setLayout(groupLayout);
	}

	/**
	 * Getters and Setters
	 */
	public JFrame getfMatch() {
		return fMatch;
	}

	public void setfMatch(JFrame fMatch) {
		this.fMatch = fMatch;
	}

	public JLabel getLblBlurb_put() {
		return lblBlurb_put;
	}

	public void setLblBlurb_put(JLabel lblBlurb_put) {
		this.lblBlurb_put = lblBlurb_put;
	}

	public JLabel getLblName_put() {
		return lblName_put;
	}

	public void setLblName_put(JLabel lblName_put) {
		this.lblName_put = lblName_put;
	}

	public JLabel getLblAge_put() {
		return lblAge_put;
	}

	public void setLblAge_put(JLabel lblAge_put) {
		this.lblAge_put = lblAge_put;
	}

	public JFrame getFrame() {

		return fMatch;
	}


}


