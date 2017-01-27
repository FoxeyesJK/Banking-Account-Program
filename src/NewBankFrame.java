import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Panel;

public class NewBankFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBankFrame frame = new NewBankFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	public NewBankFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 83, 884, 479);
		contentPane.add(splitPane);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Customer Registration");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					Customer_regi CusReg=new Customer_regi();
					CusReg.setVisible(true);
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnNewButton.setBounds(25, 35, 150, 30);
		panel.add(btnNewButton);
		
		JButton btnStaffRegistration = new JButton("Staff Registration");
		btnStaffRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					Staff_regi CusReg=new Staff_regi();
					CusReg.setVisible(true);
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnStaffRegistration.setBounds(25, 75, 150, 30);
		panel.add(btnStaffRegistration);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					Deposit CusReg=new Deposit();
					CusReg.setVisible(true);
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnDeposit.setBounds(25, 115, 150, 30);
		panel.add(btnDeposit);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Withdrawal CusReg=new Withdrawal();
					CusReg.setVisible(true);
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnWithdraw.setBounds(25, 155, 150, 30);
		panel.add(btnWithdraw);
		
		JButton btnRegisterCustomers = new JButton("Register Customers");
		btnRegisterCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Registered_Customers RegCus=new Registered_Customers();
					RegCus.setVisible(true);
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnRegisterCustomers.setBounds(25, 240, 150, 30);
		panel.add(btnRegisterCustomers);
		
		JLabel lblHistory = new JLabel("HISTORY");
		lblHistory.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHistory.setBounds(63, 215, 87, 15);
		panel.add(lblHistory);
		
		JButton btnWithdrawDetials = new JButton("Withdraw Details");
		btnWithdrawDetials.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnWithdrawDetials.setBounds(25, 280, 150, 30);
		panel.add(btnWithdrawDetials);
		
		JButton btnDepositDetails = new JButton("Deposit Details");
		btnDepositDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDepositDetails.setBounds(25, 320, 150, 30);
		panel.add(btnDepositDetails);
		
		JButton btnLoginDetails = new JButton("Login Details");
		btnLoginDetails.setBounds(25, 360, 150, 30);
		panel.add(btnLoginDetails);
		
		JLabel labelBack = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/Back2.jpg")).getImage();
		labelBack.setIcon(new ImageIcon(img3));
		splitPane.setRightComponent(labelBack);

		
		splitPane.setDividerLocation(200);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 71, 884, 2);
		contentPane.add(separator);
		
	
		JLabel label_1 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/Cover3.jpg")).getImage();
		label_1.setIcon(new ImageIcon(img2));
		label_1.setBounds(205, 0, 679, 73);
		getContentPane().add(label_1);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.WHITE);
		Image img1 = new ImageIcon(this.getClass().getResource("/JKBANK LOGO2.png")).getImage();
		label.setIcon(new ImageIcon(img1));
		label.setBounds(0, 0, 205, 73);
		getContentPane().add(label);
	}
}
