import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;

public class EmployeeInfo extends JFrame {
//Second_page modification 
	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBoxName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInfo frame = new EmployeeInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTextField textFieldEID;
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldAge;
	private JList listName;
	private JTextField textFieldSearch;
	private JComboBox comboBoxSelect;

	public void refreshTable()
	{
		try {
			String query="select EID,Name,Surname,Age from EmployeeInfo";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fillComboBox()
	{
		try {
			String query="select * from EmployeeInfo";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				comboBoxName.addItem(rs.getString("Name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadList()
	{
		try {
			String query="select * from EmployeeInfo";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			DefaultListModel DLM=new DefaultListModel();
			
			while(rs.next())
			{
				DLM.addElement(rs.getString("Name"));
			}
			listName.setModel(DLM);
			pst.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public EmployeeInfo() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Table");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select EID,Name,Surname,Age from EmployeeInfo";
					// * instead age,name show everything
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(167, 420, 97, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(393, 236, 347, 186);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					int row = table.getSelectedRow();
					String EID_=(table.getModel().getValueAt(row, 0)).toString();
					
					String query="select * from EmployeeInfo where EID='"+EID_+"' ";
					PreparedStatement pst=connection.prepareStatement(query);
		
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						textFieldEID.setText(rs.getString("EID"));
						textFieldName.setText(rs.getString("Name"));
						textFieldSurname.setText(rs.getString("Surname"));
						textFieldAge.setText(rs.getString("Age"));
						
					}
					
					pst.close();
					}catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblEd = new JLabel("EID");
		lblEd.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEd.setBounds(167, 213, 57, 23);
		contentPane.add(lblEd);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(167, 238, 57, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSurname.setBounds(167, 263, 80, 23);
		contentPane.add(lblSurname);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAge.setBounds(167, 288, 57, 23);
		contentPane.add(lblAge);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="insert into EmployeeInfo (EID,Name,Surname,Age) values (?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, textFieldEID.getText() );
					pst.setString(2, textFieldName.getText() );
					pst.setString(3, textFieldSurname.getText() );
					pst.setString(4, textFieldAge.getText() );
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					
					pst.close();
		
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				refreshTable();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(167, 321, 97, 23);
		contentPane.add(btnNewButton_1);
		
		textFieldEID = new JTextField();
		textFieldEID.setBounds(252, 215, 116, 21);
		contentPane.add(textFieldEID);
		textFieldEID.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(252, 240, 116, 21);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setBounds(252, 265, 116, 21);
		contentPane.add(textFieldSurname);
		textFieldSurname.setColumns(10);
		
		textFieldAge = new JTextField();
		textFieldAge.setBounds(252, 290, 116, 21);
		contentPane.add(textFieldAge);
		textFieldAge.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
				String query="Update EmployeeInfo set EID='"+textFieldEID.getText()+"'  ,name='"+textFieldName.getText()+"'    ,surname='"+textFieldSurname.getText()+"'  , age='"+textFieldAge.getText()+"' where EID='"+textFieldEID.getText()+"'   ";
				PreparedStatement pst=connection.prepareStatement(query);
				
				pst.execute();
				
				JOptionPane.showMessageDialog(null, "Data Updated");
				
				pst.close();
				}catch (Exception e)
				{
					e.printStackTrace();
				}
				refreshTable();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setBounds(167, 354, 97, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action=JOptionPane.showConfirmDialog(null, "Do you really Want To Delete","Delete",JOptionPane.YES_NO_OPTION);
				if(action==0){
				try{
					String query="delete from EmployeeInfo where EID='"+textFieldEID.getText()+"' ";
					PreparedStatement pst=connection.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Deleted");
					
					pst.close();
					}catch (Exception e)
					{
						e.printStackTrace();
					}
				refreshTable();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBounds(167, 387, 97, 23);
		contentPane.add(btnDelete);
		
		comboBoxName = new JComboBox();
		comboBoxName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query="select * from EmployeeInfo where name=? ";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,  (String) comboBoxName.getSelectedItem());
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						textFieldEID.setText(rs.getString("EID"));
						textFieldName.setText(rs.getString("Name"));
						textFieldSurname.setText(rs.getString("Surname"));
						textFieldAge.setText(rs.getString("Age"));
						
					}
					
					pst.close();
					}catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		});
		comboBoxName.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBoxName.setBounds(167, 182, 116, 21);
		contentPane.add(comboBoxName);
		
		listName = new JList();
		listName.setBounds(276, 321, 92, 135);
		contentPane.add(listName);
		
		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try{
					String selection=(String)comboBoxSelect.getSelectedItem();
					String query="select * from EmployeeInfo where "+selection+"=? ";
					System.out.println(query);
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,textFieldSearch.getText());
					ResultSet rs=pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();
					}catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		});
		textFieldSearch.setBounds(544, 184, 146, 42);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		comboBoxSelect = new JComboBox();
		comboBoxSelect.setModel(new DefaultComboBoxModel(new String[] {"EID", "Name", "Surname", "Age"}));
		comboBoxSelect.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxSelect.setBounds(393, 184, 139, 21);
		contentPane.add(comboBoxSelect);
		
		JLabel labelLogo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("JKBANK LOGO.png")).getImage();
		labelLogo.setIcon(new ImageIcon(img));
		labelLogo.setBounds(375, 10, 139, 61);
		contentPane.add(labelLogo);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setForeground(Color.WHITE);
		menuBar_1.setBackground(new Color(135, 206, 250));
		menuBar_1.setBounds(0, 69, 884, 42);
		contentPane.add(menuBar_1);
		
		JMenu mnPersonal = new JMenu("              Account Manage");
		mnPersonal.setHorizontalTextPosition(SwingConstants.LEADING);
		mnPersonal.setPreferredSize(new Dimension(225, 22));
		mnPersonal.setForeground(Color.WHITE);
		mnPersonal.setBackground(new Color(135, 206, 250));
		mnPersonal.setFont(new Font("Tahoma", Font.BOLD, 16));
		menuBar_1.add(mnPersonal);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("                        My Account");
		mntmNewMenuItem.setBackground(new Color(135, 206, 250));
		mntmNewMenuItem.setForeground(Color.WHITE);
		mntmNewMenuItem.setPreferredSize(new Dimension(218, 22));
		mnPersonal.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnPersonal.add(separator);
		
		JMenuItem mntmPaymenttransfer = new JMenuItem("                   Payment/Transfer");
		mntmPaymenttransfer.setPreferredSize(new Dimension(218, 22));
		mntmPaymenttransfer.setForeground(Color.WHITE);
		mntmPaymenttransfer.setBackground(new Color(135, 206, 250));
		mnPersonal.add(mntmPaymenttransfer);
		
		JSeparator separator_1 = new JSeparator();
		mnPersonal.add(separator_1);
		
		JMenuItem mntmSetting = new JMenuItem("                            Setting");
		mntmSetting.setPreferredSize(new Dimension(218, 22));
		mntmSetting.setBackground(new Color(135, 206, 250));
		mntmSetting.setForeground(Color.WHITE);
		mnPersonal.add(mntmSetting);
		
		JMenu mnCorporate = new JMenu("              Balance Manage");
		mnCorporate.setPreferredSize(new Dimension(225, 22));
		mnCorporate.setHorizontalTextPosition(SwingConstants.LEADING);
		mnCorporate.setForeground(Color.WHITE);
		mnCorporate.setFont(new Font("Tahoma", Font.BOLD, 16));
		mnCorporate.setBackground(new Color(135, 206, 250));
		menuBar_1.add(mnCorporate);
		
		JMenu mnCustomerCenter = new JMenu("       Empolyee Manage");
		mnCustomerCenter.setPreferredSize(new Dimension(225, 22));
		mnCustomerCenter.setHorizontalTextPosition(SwingConstants.LEADING);
		mnCustomerCenter.setForeground(Color.WHITE);
		mnCustomerCenter.setFont(new Font("Tahoma", Font.BOLD, 16));
		mnCustomerCenter.setBackground(new Color(135, 206, 250));
		menuBar_1.add(mnCustomerCenter);
		
		JMenu mnAboutUs = new JMenu("           About Us");
		mnAboutUs.setPreferredSize(new Dimension(225, 22));
		mnAboutUs.setHorizontalTextPosition(SwingConstants.LEADING);
		mnAboutUs.setForeground(Color.WHITE);
		mnAboutUs.setFont(new Font("Tahoma", Font.BOLD, 16));
		mnAboutUs.setBackground(new Color(135, 206, 250));
		menuBar_1.add(mnAboutUs);
		
		refreshTable();
		fillComboBox();
		loadList();
	}
}
