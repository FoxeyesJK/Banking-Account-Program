import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CustomerSaver extends JInternalFrame {
	private JTextField textFieldName;
		
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerSaver frame = new CustomerSaver();
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
	public CustomerSaver() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(94, 46, 57, 15);
		getContentPane().add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(163, 43, 211, 18);
		getContentPane().add(textFieldName);
		textFieldName.setColumns(10);

	}
}
