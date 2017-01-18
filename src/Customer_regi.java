import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Panel;
import java.awt.CardLayout;
import javax.swing.border.EtchedBorder;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Customer_regi extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Customer_regi dialog = new Customer_regi();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Customer_regi() {
		setBounds(100, 100, 669, 515);
		getContentPane().setLayout(new BorderLayout());
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
				JLabel lblNewLabel = new JLabel("Name :");
				lblNewLabel.setBounds(56, 37, 57, 15);
				panel.add(lblNewLabel);
				lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				textField = new JTextField();
				textField.setBounds(125, 35, 243, 18);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(125, 60, 243, 18);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				JLabel lblAddress = new JLabel("Address :");
				lblAddress.setBounds(56, 62, 57, 15);
				panel.add(lblAddress);
				lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				JLabel lblAccountType = new JLabel("Account Type :");
				lblAccountType.setBounds(22, 88, 91, 15);
				panel.add(lblAccountType);
				lblAccountType.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Choose Account Type", "Current Account", "Savings Account"}));
			comboBox.setBounds(125, 85, 243, 21);
			panel.add(comboBox);
			{
				JLabel lblAge = new JLabel("Age :");
				lblAge.setBounds(56, 114, 57, 15);
				panel.add(lblAge);
				lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				textField_7 = new JTextField();
				textField_7.setBounds(125, 111, 243, 18);
				panel.add(textField_7);
				textField_7.setColumns(10);
			}
			{
				JLabel lblSex = new JLabel("Sex :");
				lblSex.setBounds(56, 139, 57, 15);
				panel.add(lblSex);
				lblSex.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			
			JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
			rdbtnNewRadioButton.setBounds(121, 135, 57, 23);
			panel.add(rdbtnNewRadioButton);
			
			JRadioButton rdbtnFemale = new JRadioButton("Female");
			rdbtnFemale.setBounds(183, 135, 78, 23);
			panel.add(rdbtnFemale);
			{
				JLabel lblDob = new JLabel("DOB :");
				lblDob.setBounds(56, 164, 57, 15);
				panel.add(lblDob);
				lblDob.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			
			JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setBounds(125, 161, 78, 21);
			panel.add(comboBox_1);
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			{
				JComboBox comboBox_2 = new JComboBox();
				comboBox_2.setBounds(215, 161, 72, 21);
				panel.add(comboBox_2);
				comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}));
			}
			{
				JComboBox comboBox_2 = new JComboBox();
				comboBox_2.setBounds(299, 161, 62, 21);
				panel.add(comboBox_2);
				comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Year", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017"}));
			}
			{
				JLabel lblOccupation = new JLabel("Occupation :");
				lblOccupation.setBounds(41, 189, 72, 15);
				panel.add(lblOccupation);
				lblOccupation.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				textField_6 = new JTextField();
				textField_6.setBounds(125, 186, 243, 18);
				panel.add(textField_6);
				textField_6.setColumns(10);
			}
			{
				JLabel lblEID = new JLabel("Account #:");
				lblEID.setBounds(22, 214, 91, 15);
				panel.add(lblEID);
				lblEID.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				textField_3 = new JTextField();
				textField_3.setBounds(125, 211, 243, 18);
				panel.add(textField_3);
				textField_3.setColumns(10);
			}
			{
				JLabel lblUsername = new JLabel("Username :");
				lblUsername.setBounds(27, 239, 86, 15);
				panel.add(lblUsername);
				lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				textField_4 = new JTextField();
				textField_4.setBounds(125, 236, 243, 18);
				panel.add(textField_4);
				textField_4.setColumns(10);
			}
			{
				JLabel lblPassword = new JLabel("Password :");
				lblPassword.setBounds(22, 264, 91, 15);
				panel.add(lblPassword);
				lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				textField_5 = new JTextField();
				textField_5.setBounds(125, 261, 243, 18);
				panel.add(textField_5);
				textField_5.setColumns(10);
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
				btnRegister.setActionCommand("OK");
				btnRegister.setBounds(159, 10, 90, 23);
				panel.add(btnRegister);
			}
			{
				JButton button = new JButton("Cancel");
				button.setActionCommand("Cancel");
				button.setBounds(363, 10, 90, 23);
				panel.add(button);
			}
			
			JButton btnNewButton_1 = new JButton("Clear");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
				}
			});
			btnNewButton_1.setBounds(261, 10, 90, 23);
			panel.add(btnNewButton_1);
		}
	}
}
