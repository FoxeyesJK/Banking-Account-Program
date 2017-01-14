import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class CustomerSaver extends JInternalFrame {
		
	
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

	}
}
