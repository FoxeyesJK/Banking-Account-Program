import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;

public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	private JTextField textFieldUN;
	private JPasswordField textpasswordfield;
	//connecting data
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection=sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel usernamefield = new JLabel("Username");
		usernamefield.setForeground(Color.WHITE);
		usernamefield.setFont(new Font("Tahoma", Font.PLAIN, 12));
		usernamefield.setBounds(374, 274, 77, 15);
		frame.getContentPane().add(usernamefield);
		
		JLabel passwordField = new JLabel("Password");
		passwordField.setForeground(Color.WHITE);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordField.setBounds(374, 299, 57, 15);
		frame.getContentPane().add(passwordField);
		
		textFieldUN = new JTextField();
		textFieldUN.setBounds(443, 271, 116, 21);
		frame.getContentPane().add(textFieldUN);
		textFieldUN.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
	
		Image img = new ImageIcon(this.getClass().getResource("/ok-icon.png")).getImage();
		btnLogin.setIcon(new ImageIcon(img));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{ 
					String query= "select * from CustomerInfo where username=? and password=?  ";
					//pass the query can be either upper or lowercase
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, textFieldUN.getText() );
					pst.setString(2, textpasswordfield.getText() );
					
					ResultSet rs=pst.executeQuery(); 
					int count =0;
					while(rs.next()){
						count=count+1;		
					}
					if(count == 1)
					{
						JOptionPane.showMessageDialog(null, "Username and password is correct");
						//second Jframe
						frame.dispose();
						CustomerInfo emplInfo=new CustomerInfo();
						emplInfo.setVisible(true);
					}else if(count>1)
					{
						JOptionPane.showMessageDialog(null, "Duplicate Username and password");
					}else
					{
						JOptionPane.showMessageDialog(null, "Username and password is not correct Try Again..");
					}
					
					//rs.close();
					//pst.close();
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		btnLogin.setBounds(409, 333, 101, 33);
		frame.getContentPane().add(btnLogin);
		
		textpasswordfield = new JPasswordField();
		textpasswordfield.setBounds(443, 302, 116, 21);
		frame.getContentPane().add(textpasswordfield);
		
		JLabel label = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/JKBANK LOGO.png")).getImage();
		label.setIcon(new ImageIcon(img1));
		
		label.setBounds(96, 39, 149, 62);
		frame.getContentPane().add(label);
		
		JLabel lblSignIn = new JLabel("Sign in");
		lblSignIn.setForeground(Color.WHITE);
		lblSignIn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSignIn.setBounds(374, 249, 57, 15);
		frame.getContentPane().add(lblSignIn);
		
		JLabel labelCover = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/Cover2.jpg")).getImage();
		labelCover.setIcon(new ImageIcon(img2));
		labelCover.setBounds(12, 112, 907, 331);
		frame.getContentPane().add(labelCover);
	}
}
