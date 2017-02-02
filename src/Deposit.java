import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.Image;

import javax.swing.border.BevelBorder;

public class Deposit extends JDialog {

	private final JPanel contentPanel = new JPanel();

	Connection connection=null;
	private JTextField textFieldFirstName;
	private JTextField textFieldAcntNum1;
	private JTextField textFieldDeposited;
	private JTextField textFieldAuthStaff;
	private JTextField textFieldBalance;
	private JTextField textFieldAcntNum;
	private final JLabel lblCover = new JLabel("");
	private JTextField textFieldLastName;
	private double TempBalance;
	private double TempDeposited;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Deposit dialog = new Deposit();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Deposit() {
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
			panel.setBounds(10, 82, 631, 317);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblFirstName = new JLabel("First Name :");
				lblFirstName.setBounds(138, 168, 75, 15);
				panel.add(lblFirstName);
				lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				textFieldFirstName = new JTextField();
				textFieldFirstName.setBackground(Color.LIGHT_GRAY);
				textFieldFirstName.setBounds(225, 166, 75, 18);
				panel.add(textFieldFirstName);
				textFieldFirstName.setColumns(10);
			}
			{
				textFieldAcntNum1 = new JTextField();
				textFieldAcntNum1.setBackground(Color.LIGHT_GRAY);
				textFieldAcntNum1.setBounds(225, 194, 243, 18);
				panel.add(textFieldAcntNum1);
				textFieldAcntNum1.setColumns(10);
			}
			{
				JLabel lblAccountNum = new JLabel("Account Number :");
				lblAccountNum.setBounds(89, 196, 124, 15);
				panel.add(lblAccountNum);
				lblAccountNum.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				JLabel lblPrevBal = new JLabel("Previous Balance :");
				lblPrevBal.setBounds(78, 224, 135, 15);
				panel.add(lblPrevBal);
				lblPrevBal.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				textFieldBalance = new JTextField();
				textFieldBalance.setBackground(Color.LIGHT_GRAY);
				textFieldBalance.setBounds(225, 222, 243, 18);
				panel.add(textFieldBalance);
				textFieldBalance.setColumns(10);
			}
			{
				JLabel lblAmtDeposit = new JLabel("Amount Deposited :");
				lblAmtDeposit.setBounds(89, 253, 124, 15);
				panel.add(lblAmtDeposit);
				lblAmtDeposit.setHorizontalAlignment(SwingConstants.RIGHT);
				
			}
			{
				textFieldDeposited = new JTextField();
				textFieldDeposited.setBounds(225, 250, 243, 18);
				panel.add(textFieldDeposited);
				textFieldDeposited.setColumns(10);
			}
			{
				JLabel lblAuthID = new JLabel("Authorized Staff ID :");
				lblAuthID.setBounds(70, 278, 143, 15);
				panel.add(lblAuthID);
				lblAuthID.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				textFieldAuthStaff = new JTextField();
				textFieldAuthStaff.setBounds(225, 275, 243, 18);
				panel.add(textFieldAuthStaff);
				textFieldAuthStaff.setColumns(10);
			}
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_1.setBounds(0, 144, 631, 173);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblLastName = new JLabel("Last Name :");
			lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
			lblLastName.setBounds(306, 23, 75, 15);
			panel_1.add(lblLastName);
			
			textFieldLastName = new JTextField();
			textFieldLastName.setBackground(Color.LIGHT_GRAY);
			textFieldLastName.setColumns(10);
			textFieldLastName.setBounds(393, 21, 75, 18);
			panel_1.add(textFieldLastName);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_2.setBounds(0, 20, 468, 85);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblAccountNumber = new JLabel("Account Number :");
			lblAccountNumber.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAccountNumber.setBounds(12, 24, 134, 15);
			panel_2.add(lblAccountNumber);
			
			textFieldAcntNum = new JTextField();
			textFieldAcntNum.setColumns(10);
			textFieldAcntNum.setBounds(158, 22, 243, 18);
			panel_2.add(textFieldAcntNum);
			
			JButton btnCheck = new JButton("Check");
			btnCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try{
						String query="select * from CustomerInfo where AccountNumber=? ";
						PreparedStatement pst=connection.prepareStatement(query);
						pst.setString(1, textFieldAcntNum.getText());
						ResultSet rs=pst.executeQuery();
						
						while(rs.next())
						{
							textFieldFirstName.setText(rs.getString("Name"));
							textFieldLastName.setText(rs.getString("Surname"));
							textFieldAcntNum1.setText(rs.getString("AccountNumber"));
							textFieldBalance.setText(rs.getString("Balance"));
							TempBalance = rs.getDouble("Balance");
							
						}
						pst.close();
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
			});
		
			btnCheck.setBounds(158, 50, 90, 25);
			panel_2.add(btnCheck);
			
			JLabel lblEnterAccountNumber = new JLabel("Enter Account Number and Click Check");
			lblEnterAccountNumber.setFont(new Font("±¼¸²", Font.BOLD, 10));
			lblEnterAccountNumber.setBounds(12, 0, 288, 15);
			panel.add(lblEnterAccountNumber);
			
			JLabel lblFillCarefullly = new JLabel("Fill Carefullly");
			lblFillCarefullly.setFont(new Font("±¼¸²", Font.BOLD, 10));
			lblFillCarefullly.setBounds(12, 119, 93, 15);
			panel.add(lblFillCarefullly);
			{
				JPanel panel_3 = new JPanel();
				panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				panel_3.setBounds(495, 2, 124, 125);
				panel.add(panel_3);
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
				JButton btnDeposit = new JButton("Deposit");
				btnDeposit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							TempDeposited = Double.parseDouble(textFieldDeposited.getText());
							TempBalance += TempDeposited;
							
							String query1="select * from CustomerInfo where AccountNumber=? ";
							PreparedStatement pst1=connection.prepareStatement(query1);
							pst1.setString(1, textFieldAcntNum.getText());
							ResultSet rs1=pst1.executeQuery();
							
							String query5="select * from CusBal where AccountNumber=? ";
							PreparedStatement pst5=connection.prepareStatement(query5);
							pst5.setString(1, textFieldAcntNum.getText());
							ResultSet rs5=pst5.executeQuery();
														
							//while(rs1.next(
							
							String query3="insert into CusBal (AccountNumber,First,Second) values (?,?,?)";
							
								if(rs1.getString("Balance") == null)
								{
									PreparedStatement pst3=connection.prepareStatement(query3);
									pst3.setString(1, textFieldAcntNum.getText());;
									pst3.setDouble(2, Double.parseDouble(textFieldDeposited.getText()));
									pst3.execute();
									pst3.close();
								}else
								{
									int column_index;
									for(column_index=2;column_index<11;column_index++){
										if(rs5.getString(column_index)==null)
										{
										//System.out.print(column_index);
										break;
										}
									}
									switch(column_index)
									{
									case 3: query3="Update CusBal set Second='"+TempDeposited+"'  where AccountNumber='" + textFieldAcntNum.getText()+"'   "; break;
									case 4: query3="Update CusBal set Third='"+TempDeposited+"'  where AccountNumber='" + textFieldAcntNum.getText()+"'   "; break;
									case 5: query3="Update CusBal set Fourth='"+TempDeposited+"'  where AccountNumber='" + textFieldAcntNum.getText()+"'   "; break;
									case 6: query3="Update CusBal set Fifth='"+TempDeposited+"'  where AccountNumber='" + textFieldAcntNum.getText()+"'   "; break;
									case 7: query3="Update CusBal set Sixth='"+TempDeposited+"'  where AccountNumber='" + textFieldAcntNum.getText()+"'   "; break;
									case 8: query3="Update CusBal set Seventh='"+TempDeposited+"'  where AccountNumber='" + textFieldAcntNum.getText()+"'   "; break;
									default : System.out.println("No more transactions available.");
									}
									PreparedStatement pst3=connection.prepareStatement(query3);
									pst3.execute();
									pst3.close();
								
								}
								
			
		
							String query="Update CustomerInfo set Balance='"+TempBalance+"'  where AccountNumber='" + textFieldAcntNum.getText()+"'   ";
							PreparedStatement pst=connection.prepareStatement(query);
							pst.execute();
							JOptionPane.showMessageDialog(null, "Data Saved");
								
							pst.close();
							pst5.close();
							pst1.close();
							} catch (Exception e) {
								e.printStackTrace();
							}		
						
					}
				});
				btnDeposit.setActionCommand("OK");
				btnDeposit.setBounds(159, 10, 90, 23);
				panel.add(btnDeposit);
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
				public void actionPerformed(ActionEvent arg0) {
					textFieldAcntNum.setText("");
					textFieldAcntNum1.setText("");
					textFieldFirstName.setText("");
					textFieldLastName.setText("");
					textFieldBalance.setText("");
					textFieldDeposited.setText("");
					textFieldAuthStaff.setText("");
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