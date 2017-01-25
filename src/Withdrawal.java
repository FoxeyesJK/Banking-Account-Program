import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class Withdrawal extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_2;
	private final JLabel lblCover = new JLabel("");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Withdrawal dialog = new Withdrawal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Withdrawal() {
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
				JLabel lblName = new JLabel("Name :");
				lblName.setBounds(156, 168, 57, 15);
				panel.add(lblName);
				lblName.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				textField = new JTextField();
				textField.setBounds(225, 166, 243, 18);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(225, 194, 243, 18);
				panel.add(textField_1);
				textField_1.setColumns(10);
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
				textField_7 = new JTextField();
				textField_7.setBounds(225, 222, 243, 18);
				panel.add(textField_7);
				textField_7.setColumns(10);
			}
			{
				JLabel lblAmtWith = new JLabel("Amount Withdrawn :");
				lblAmtWith.setBounds(89, 253, 124, 15);
				panel.add(lblAmtWith);
				lblAmtWith.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				textField_4 = new JTextField();
				textField_4.setBounds(225, 250, 243, 18);
				panel.add(textField_4);
				textField_4.setColumns(10);
			}
			{
				JLabel lblAuthID = new JLabel("Authorized Staff ID :");
				lblAuthID.setBounds(70, 278, 143, 15);
				panel.add(lblAuthID);
				lblAuthID.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				textField_5 = new JTextField();
				textField_5.setBounds(225, 275, 243, 18);
				panel.add(textField_5);
				textField_5.setColumns(10);
			}
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_1.setBounds(0, 144, 631, 173);
			panel.add(panel_1);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_2.setBounds(0, 20, 468, 85);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblAccountNumber = new JLabel("Account Number :");
			lblAccountNumber.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAccountNumber.setBounds(12, 24, 134, 15);
			panel_2.add(lblAccountNumber);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(158, 22, 243, 18);
			panel_2.add(textField_2);
			
			JButton btnCheck = new JButton("Check");
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
				JButton btnWithDraw = new JButton("Withdraw");
				btnWithDraw.setActionCommand("OK");
				btnWithDraw.setBounds(159, 10, 90, 23);
				panel.add(btnWithDraw);
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
		Image img2 = new ImageIcon(this.getClass().getResource("/Cover3.jpg")).getImage();
		lblCover.setIcon(new ImageIcon(img2));
		lblCover.setBounds(0, 0, 653, 63);
		contentPanel.add(lblCover);
	}
}


