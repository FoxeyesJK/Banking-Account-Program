import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
public class HelloWorldClass {

	private JFrame frame;
	private JLabel lblClock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloWorldClass window = new HelloWorldClass();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HelloWorldClass() {
		initialize();
		clock();
	}

	public void clock()
	{
		Thread clock=new Thread()
		{
			public void run()
			{
				try{
					while(true)
					{
					Calendar cal=new GregorianCalendar();
					int day=cal.get(Calendar.DAY_OF_MONTH);
					int month=cal.get(Calendar.MONTH);
					int year=cal.get(Calendar.YEAR);
					
					int second=cal.get(Calendar.SECOND);
					int minute=cal.get(Calendar.MINUTE);
					int hour=cal.get(Calendar.HOUR);
					
					lblClock.setText("Time  "+hour+":"+minute+":"+second+"  Data "+year+"/"+month+"/"+day);
					
				sleep(1000);
					}
				}catch(InterruptedException e){
					
					e.printStackTrace();
				}
			}
				
		};
		
		clock.start();
		
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Mark", "July", "Peter"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(133, 13, 108, 39);
		frame.getContentPane().add(list);
		
		JButton btnNewButton = new JButton("Load value");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel DLM=new DefaultListModel<>();
				DLM.addElement("Mark");
				DLM.addElement("July");
				DLM.addElement("John");
				DLM.addElement("Markus");
				DLM.addElement("Peter");
				list.setModel(DLM);
			
			
			}
		});
		btnNewButton.setBounds(24, 10, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblClock = new JLabel("Clock");
		lblClock.setBounds(73, 76, 308, 124);
		frame.getContentPane().add(lblClock);
	}
}
