import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class BalanceTrack extends JDialog {

	private final JPanel contentPanel = new JPanel();
	Connection connection=null;
	private JTextField textFieldAcntNum;
	private final JLabel lblCover = new JLabel("");
	private double TempBalance;
	private double TempWithdraw;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BalanceTrack dialog = new BalanceTrack();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BalanceTrack() {
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
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_1.setBounds(0, 144, 631, 173);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 10, 607, 153);
			panel_1.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			
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
						String query="select * from CusBal where AccountNumber=? ";
						PreparedStatement pst=connection.prepareStatement(query);
						pst.setString(1, textFieldAcntNum.getText());
						ResultSet rs=pst.executeQuery();
						
						//while(rs.next())
						//{
							table.setModel(DbUtils.resultSetToTableModel(rs));;
							pst.close();
							rs.close();
							/*textFieldFirstName.setText(rs.getString("Name"));
							textFieldLastName.setText(rs.getString("Surname"));
							textFieldAcntNum1.setText(rs.getString("AccountNumber"));
							textFieldBalance.setText(rs.getString("Balance"));*/
							//TempBalance = rs.getDouble("Balance");
							
						//}
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
					textFieldAcntNum.setText("");
					/*textFieldAcntNum1.setText("");
					textFieldFirstName.setText("");
					textFieldLastName.setText("");
					textFieldBalance.setText("");
					textFieldWithdraw.setText("");
					textFieldAuthStaff.setText("");*/
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