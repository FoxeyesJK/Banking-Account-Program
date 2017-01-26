import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Panel;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.border.EtchedBorder;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDayChooser;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

public class Staff_regi extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldLastName;
	private JTextField textFieldAdd;
	private JTextField textFieldEid;
	private JTextField textFieldUserName;
	private JTextField textFieldPassword;
	private final JLabel lblCover = new JLabel("");
	Connection connection = null;
	private JTextField textFieldFirstName;
	private JTextField textFieldEmail;
	private JTextField textFieldMobile;
	private JComboBox comboBoxDay;
	private JComboBox comboBoxMonth;
	private JComboBox comboBoxYear;
	private JComboBox comboBoxPosition;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private String selection;
	private String gender;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Staff_regi dialog = new Staff_regi();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * Create the dialog.
	 */
	public Staff_regi() {
		connection=sqliteConnection.dbConnector();
		setBounds(100, 100, 669, 515);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 64, 653, 8);
		contentPanel.add(separator);
		{
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(0, 69, 653, 8);
			contentPanel.add(separator_1);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel.setBounds(10, 82, 631, 317);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Last Name :");
				lblNewLabel.setBounds(208, 22, 72, 15);
				panel.add(lblNewLabel);
				lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				textFieldLastName = new JTextField();
				textFieldLastName.setBounds(290, 20, 78, 18);
				panel.add(textFieldLastName);
				textFieldLastName.setColumns(10);
			}
			{
				textFieldAdd = new JTextField();
				textFieldAdd.setBounds(125, 215, 243, 18);
				panel.add(textFieldAdd);
				textFieldAdd.setColumns(10);
			}
			{
				JLabel lblAddress = new JLabel("Address :");
				lblAddress.setBounds(56, 217, 57, 15);
				panel.add(lblAddress);
				lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				JLabel lblPosition = new JLabel("Position :");
				lblPosition.setBounds(22, 248, 91, 15);
				panel.add(lblPosition);
				lblPosition.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			
			comboBoxPosition = new JComboBox();
			comboBoxPosition.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try{
					selection=(String)comboBoxPosition.getSelectedItem();
					
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			comboBoxPosition.setModel(new DefaultComboBoxModel(new String[] {"Choose Position", "Account Manager", "Branch Manager", "Regional Manager", "Operations Manager"}));
			comboBoxPosition.setBounds(125, 245, 141, 21);
			panel.add(comboBoxPosition);
			{
				JLabel lblSex = new JLabel("Sex :");
				lblSex.setBounds(56, 103, 57, 15);
				panel.add(lblSex);
				lblSex.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			
			rdbtnMale = new JRadioButton("Male");
			buttonGroup.add(rdbtnMale);
			rdbtnMale.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gender = "Male";
				}
			});
			rdbtnMale.setBounds(121, 99, 57, 23);
			panel.add(rdbtnMale);
			
			rdbtnFemale = new JRadioButton("Female");
			buttonGroup.add(rdbtnFemale);
			rdbtnFemale.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gender = "Female";
				}
			});
			rdbtnFemale.setBounds(183, 99, 78, 23);
			panel.add(rdbtnFemale);
			{
				JLabel lblDob = new JLabel("DOB :");
				lblDob.setBounds(56, 131, 57, 15);
				panel.add(lblDob);
				lblDob.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			
			comboBoxDay = new JComboBox();
			comboBoxDay.setBounds(125, 128, 48, 21);
			panel.add(comboBoxDay);
			comboBoxDay.setModel(new DefaultComboBoxModel(new String[] {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			{
				comboBoxMonth = new JComboBox();
				comboBoxMonth.setBounds(183, 128, 61, 21);
				panel.add(comboBoxMonth);
				comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] {"Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}));
			}
			{
				comboBoxYear = new JComboBox();
				comboBoxYear.setBounds(256, 128, 61, 21);
				panel.add(comboBoxYear);
				comboBoxYear.setModel(new DefaultComboBoxModel(new String[] {"Year", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017"}));
			}
			{
				JLabel lblEID = new JLabel("EID :");
				lblEID.setBounds(22, 50, 91, 15);
				panel.add(lblEID);
				lblEID.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				textFieldEid = new JTextField();
				textFieldEid.setBounds(125, 47, 243, 18);
				panel.add(textFieldEid);
				textFieldEid.setColumns(10);
			}
			{
				JLabel lblUsername = new JLabel("Username :");
				lblUsername.setBounds(27, 78, 86, 15);
				panel.add(lblUsername);
				lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				textFieldUserName = new JTextField();
				textFieldUserName.setBounds(125, 75, 78, 18);
				panel.add(textFieldUserName);
				textFieldUserName.setColumns(10);
			}
			{
				JLabel lblPassword = new JLabel("Password :");
				lblPassword.setBounds(208, 78, 70, 15);
				panel.add(lblPassword);
				lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				textFieldPassword = new JTextField();
				textFieldPassword.setBounds(290, 77, 78, 18);
				panel.add(textFieldPassword);
				textFieldPassword.setColumns(10);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				panel_1.setBounds(426, 37, 160, 154);
				panel.add(panel_1);
			}
			{
				JButton btnNewButton = new JButton("Brouse Picture");
				btnNewButton.setBounds(426, 210, 160, 23);
				panel.add(btnNewButton);
			}
			
			JLabel lblFristName = new JLabel("Frist Name :");
			lblFristName.setHorizontalAlignment(SwingConstants.RIGHT);
			lblFristName.setBounds(22, 22, 91, 15);
			panel.add(lblFristName);
			
			textFieldFirstName = new JTextField();
			textFieldFirstName.setColumns(10);
			textFieldFirstName.setBounds(125, 20, 78, 18);
			panel.add(textFieldFirstName);
			{
				textFieldEmail = new JTextField();
				textFieldEmail.setColumns(10);
				textFieldEmail.setBounds(125, 159, 243, 18);
				panel.add(textFieldEmail);
			}
			{
				JLabel labelEmail = new JLabel("Email :");
				labelEmail.setHorizontalAlignment(SwingConstants.RIGHT);
				labelEmail.setBounds(56, 161, 57, 15);
				panel.add(labelEmail);
			}
			{
				textFieldMobile = new JTextField();
				textFieldMobile.setColumns(10);
				textFieldMobile.setBounds(125, 187, 243, 18);
				panel.add(textFieldMobile);
			}
			{
				JLabel lblMobile = new JLabel("Mobile :");
				lblMobile.setHorizontalAlignment(SwingConstants.RIGHT);
				lblMobile.setBounds(56, 189, 57, 15);
				panel.add(lblMobile);
			}
		}
		{
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(0, 409, 653, 8);
			contentPanel.add(separator_1);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel.setBounds(10, 420, 631, 46);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JButton btnRegister = new JButton("Register");
				btnRegister.addActionListener(new ActionListener() {
					@SuppressWarnings("null")
					public void actionPerformed(ActionEvent arg0) {
						
						try {
							String query="insert into EmployeeInfo (EID,Name,Surname,Username,Password,DOB,Email,Mobile,Address,Sex,Position) values (?,?,?,?,?,?,?,?,?,?,?)";
							PreparedStatement pst=connection.prepareStatement(query);
							pst.setString(1, textFieldEid.getText() );
							pst.setString(2, textFieldFirstName.getText() );
							pst.setString(3, textFieldLastName.getText() );
							pst.setString(4, textFieldUserName.getText() );
							pst.setString(5, textFieldPassword.getText() );
							pst.setString(7, textFieldEmail.getText() );
							pst.setString(8, textFieldMobile.getText() );
							pst.setString(9, textFieldAdd.getText() );
							
							pst.setString(10, gender);
							String Atype=comboBoxPosition.getSelectedItem().toString();
							pst.setString(11,Atype);
							String day=comboBoxDay.getSelectedItem().toString();
							String month=comboBoxMonth.getSelectedItem().toString();
							String year=comboBoxYear.getSelectedItem().toString();
							String DOB = "";
							DOB = DOB.concat(day + "-" + month +"-" + year);

							pst.setString(6,DOB);
							pst.execute();
							
							JOptionPane.showMessageDialog(null, "Data Saved");
							
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				btnRegister.setActionCommand("OK");
				btnRegister.setBounds(159, 10, 90, 23);
				panel.add(btnRegister);
			}
			{
				JButton button = new JButton("Cancel");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				button.setActionCommand("Cancel");
				button.setBounds(363, 10, 90, 23);
				panel.add(button);
			}
			
			JButton btnNewButton_1 = new JButton("Clear");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textFieldFirstName.setText("");
					textFieldLastName.setText("");
					textFieldEid.setText("");
					textFieldUserName.setText("");
					textFieldPassword.setText("");
					textFieldEmail.setText("");
					textFieldMobile.setText("");
					textFieldAdd.setText("");
					comboBoxDay.setModel(new DefaultComboBoxModel(new String[] {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
					comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] {"Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}));
					comboBoxYear.setModel(new DefaultComboBoxModel(new String[] {"Year", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017"}));
					comboBoxPosition.setModel(new DefaultComboBoxModel(new String[] {"Choose Position", "Account Manager", "Branch Manager", "Regional Manager", "Operations Manager"}));
					buttonGroup.clearSelection();
				}
			});
			btnNewButton_1.setBounds(261, 10, 90, 23);
			panel.add(btnNewButton_1);
		}
		Image img2 = new ImageIcon(this.getClass().getResource("/Cover3.jpg")).getImage();
		lblCover.setIcon(new ImageIcon(img2));
		lblCover.setBounds(0, 0, 653, 63);
		contentPanel.add(lblCover);
	}
}
