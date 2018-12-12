package silkpath;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class OpenDiaryGui {

	/**
	 * Instance Variables
	 */
	private JFrame frmMyDiary;
	private JLabel lblWhat_put;
	private JLabel lblWhere_put;
	private JLabel lblWhen_put;
	private JButton btnWho_put;
	private JButton btnDelete;
	private JLabel lblWho;
	private JLabel lblPhoto;
	private JPanel pnPhoto;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

	/**
	 * Create the application.
	 */
	public OpenDiaryGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmMyDiary = new JFrame();
		frmMyDiary.getContentPane().setBackground(new Color(244, 164, 96));
		frmMyDiary.getContentPane().setForeground(new Color(255, 255, 255));
		frmMyDiary.setTitle("My Diary");
		frmMyDiary.setBounds(100, 100, 562, 506);
		frmMyDiary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyDiary.setLocation(350, 10);
		
		//set the frame in the middle of window
		 int w = frmMyDiary.getSize().width;
	     int h = frmMyDiary.getSize().height;
	     int x = (dim.width-w)/2;
	     int y = (dim.height-h)/2;

	     frmMyDiary.setLocation(x, y);
	     frmMyDiary.setVisible(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(148, 213, 323, 197);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		lblWho = new JLabel("Who : ");
		lblWho.setBounds(58, 49, 71, 19);
		lblWho.setHorizontalAlignment(SwingConstants.LEFT);		
		lblWho.setForeground(new Color(255,255,255));
		lblWho.setFont(new Font("AR JULIAN", Font.PLAIN, 16));
		
		JLabel lblWhen = new JLabel("When :");
		lblWhen.setBounds(58, 133, 48, 18);
		lblWhen.setFont(new Font("AR JULIAN", Font.PLAIN, 15));
		lblWhen.setForeground(new Color(255,255,255));
		
		JLabel lblWhere = new JLabel("Where :");
		lblWhere.setBounds(58, 174, 55, 18);
		lblWhere.setForeground(new Color(255,255,255));
		lblWhere.setFont(new Font("AR JULIAN", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("What:");
		lblNewLabel.setBounds(58, 213, 41, 18);
		lblNewLabel.setFont(new Font("AR JULIAN", Font.PLAIN, 15));
		lblNewLabel.setForeground(new Color(255,255,255));
		
		btnDelete = new JButton("Delete Diary");
		btnDelete.setBounds(341, 420, 130, 23);
		btnDelete.setBackground(new Color(105, 105, 105));
		btnDelete.setForeground(new Color(255, 240, 245));
		btnDelete.setFont(new Font("AR JULIAN", Font.PLAIN, 14));
		
		
		btnWho_put = new JButton(" ");
		btnWho_put.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnWho_put.setBounds(145, 45, 100, 27);
		btnWho_put.setHorizontalAlignment(SwingConstants.LEFT);
		btnWho_put.setForeground(new Color(255, 255, 255));
		btnWho_put.setBackground(new Color(205, 92, 92));

		btnWho_put.setFont(new Font("AR JULIAN", Font.PLAIN, 16));
		
		lblWhen_put = new JLabel(" ");
		lblWhen_put.setBounds(146, 132, 150, 19);
		lblWhen_put.setForeground(new Color(255, 255, 255));
		lblWhen_put.setFont(new Font("AR JULIAN", Font.PLAIN, 16));
		
		lblWhere_put = new JLabel(" ");
		lblWhere_put.setBounds(146, 173, 140, 19);
		lblWhere_put.setForeground(new Color(255, 255, 255));
		lblWhere_put.setFont(new Font("AR JULIAN", Font.PLAIN, 16));
		
		lblWhat_put = new JLabel("    ");		
		lblWhat_put.setVerticalTextPosition(SwingConstants.TOP);
		lblWhat_put.setVerticalAlignment(SwingConstants.TOP);
		lblWhat_put.setFont(new Font("AR JULIAN", Font.PLAIN, 16));
		lblWhat_put.setBackground(new Color(245, 255, 250));
		lblWhat_put.setForeground(new Color(105, 105, 105));
		scrollPane.setColumnHeaderView(lblWhat_put);
		frmMyDiary.getContentPane().setLayout(null);
		frmMyDiary.getContentPane().add(lblWho);
		frmMyDiary.getContentPane().add(btnWho_put);
		frmMyDiary.getContentPane().add(lblNewLabel);
		frmMyDiary.getContentPane().add(lblWhen_put);
		frmMyDiary.getContentPane().add(lblWhere_put);
		frmMyDiary.getContentPane().add(btnDelete);
		frmMyDiary.getContentPane().add(scrollPane);
		frmMyDiary.getContentPane().add(lblWhere);
		frmMyDiary.getContentPane().add(lblWhen);
		
		pnPhoto = new JPanel();
		pnPhoto.setBackground(new Color(244, 164, 96));
		pnPhoto.setBounds(334, 10, 137, 174);
		frmMyDiary.getContentPane().add(pnPhoto);
		
		lblPhoto = new JLabel("   ");
		pnPhoto.add(lblPhoto);
		
		
		
	}
	/**
	 * Getters and Setters
	 */
	public JLabel getLblPhoto() {
		return lblPhoto;
	}

	public void setLblPhoto(JLabel lblPhoto) {
		this.lblPhoto = lblPhoto;
	}

	public JPanel getPnPhoto() {
		return pnPhoto;
	}

	public void setPnPhoto(JPanel pnPhoto) {
		this.pnPhoto = pnPhoto;
	}

	public JFrame getFrame() {
		return frmMyDiary;
	}

	public void setFrame(JFrame frame) {
		this.frmMyDiary = frame;
	}

	public JLabel getLblWhat_put() {
		return lblWhat_put;
	}

	public void setLblWhat_put(JLabel lblWhat_put) {
		this.lblWhat_put = lblWhat_put;
	}

	public JLabel getLblWhere_put() {
		return lblWhere_put;
	}

	public void setLblWhere_put(JLabel lblWhere_put) {
		this.lblWhere_put = lblWhere_put;
	}

	public JLabel getLblWhen_put() {
		return lblWhen_put;
	}

	public void setLblWhen_put(JLabel lblWhen_put) {
		this.lblWhen_put = lblWhen_put;
	}


	public JFrame getFrmMyDiary() {
		return frmMyDiary;
	}

	public void setFrmMyDiary(JFrame frmMyDiary) {
		this.frmMyDiary = frmMyDiary;
	}

	public JButton getBtnWho_put() {
		return btnWho_put;
	}

	public void setBtnWho_put(JButton btnWho_put) {
		this.btnWho_put = btnWho_put;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getbtnDelete() {
		return btnDelete;
		
	}
}