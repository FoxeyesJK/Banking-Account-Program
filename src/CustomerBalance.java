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

public class CustomerBalance extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerBalance frame = new CustomerBalance();
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
	private JList listName;
	private JTextField textFieldSearch;
	private JComboBox comboBoxSelect;
	private JTextField textFieldUsername;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	public void refreshTable()
	{
		try {
			String query="select EID,Name,Surname,UserName,Password,DOB,Email,Mobile,Address from CustomerInfo";
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
			String query="select * from CustomerInfo";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			/*while(rs.next())
			{
				comboBoxName.addItem(rs.getString("Name"));
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadList()
	{
		try {
			String query="select * from CustomerInfo";
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
	public CustomerBalance() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	

	JButton btnNewButton = new JButton("Refresh");
	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				String query="select EID,Name,Surname,UserName,Password,DOB,Email,Mobile,Address from CustomerInfo";
				// * instead age,name show everything
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	btnNewButton.setBounds(30, 121, 97, 23);
	contentPane.add(btnNewButton);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(30, 154, 578, 376);
	contentPane.add(scrollPane);
	
	table = new JTable();
	table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			try{
				int row = table.getSelectedRow();
				String EID_=(table.getModel().getValueAt(row, 0)).toString();
				
				String query="select * from CustomerInfo where EID='"+EID_+"' ";
				PreparedStatement pst=connection.prepareStatement(query);
	
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					textFieldEID.setText(rs.getString("EID"));
					textFieldName.setText(rs.getString("Name"));
					textFieldSurname.setText(rs.getString("Surname"));
					
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
	lblEd.setBounds(647, 171, 57, 23);
	contentPane.add(lblEd);
	
	JLabel lblNewLabel = new JLabel("Name");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel.setBounds(647, 193, 57, 23);
	contentPane.add(lblNewLabel);
	
	JLabel lblSurname = new JLabel("Surname");
	lblSurname.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblSurname.setBounds(647, 216, 80, 23);
	contentPane.add(lblSurname);
	
	JLabel lblUsername = new JLabel("Username");
	lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblUsername.setBounds(647, 239, 80, 23);
	contentPane.add(lblUsername);
	
	JButton btnNewButton_1 = new JButton("Save");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				String query="insert into CustomerInfo (EID,Name,Surname,UserName,Password,DOB,Email,Mobile,Address) values (?,?,?,?,?,?,?,?,?)";
				PreparedStatement pst=connection.prepareStatement(query);
				pst.setString(1, textFieldEID.getText() );
				pst.setString(2, textFieldName.getText() );
				pst.setString(3, textFieldSurname.getText() );
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
	btnNewButton_1.setBounds(701, 411, 97, 23);
	contentPane.add(btnNewButton_1);
	
	textFieldEID = new JTextField();
	textFieldEID.setBounds(734, 171, 116, 21);
	contentPane.add(textFieldEID);
	textFieldEID.setColumns(10);
	
	textFieldName = new JTextField();
	textFieldName.setBounds(734, 195, 116, 21);
	contentPane.add(textFieldName);
	textFieldName.setColumns(10);
	
	textFieldSurname = new JTextField();
	textFieldSurname.setBounds(734, 218, 116, 21);
	contentPane.add(textFieldSurname);
	textFieldSurname.setColumns(10);
	
	textFieldUsername = new JTextField();
	textFieldUsername.setColumns(10);
	textFieldUsername.setBounds(734, 241, 116, 21);
	contentPane.add(textFieldUsername);
	
	JButton btnUpdate = new JButton("Modify");
	btnUpdate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			try{
			String query="Update CustomerInfo set EID='"+textFieldEID.getText()+"'  ,name='"+textFieldName.getText()+"'    ,surname='"+textFieldSurname.getText()+"'  where EID='"+textFieldEID.getText()+"'   ";
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
	btnUpdate.setBounds(701, 444, 97, 23);
	contentPane.add(btnUpdate);
	
	JButton btnDelete = new JButton("Delete");
	btnDelete.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			int action=JOptionPane.showConfirmDialog(null, "Do you really Want To Delete","Delete",JOptionPane.YES_NO_OPTION);
			if(action==0){
			try{
				String query="delete from CustomerInfo where EID='"+textFieldEID.getText()+"' ";
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
	btnDelete.setBounds(701, 477, 97, 23);
	contentPane.add(btnDelete);
	
	listName = new JList();
	listName.setBounds(276, 321, 92, 135);
	contentPane.add(listName);
	
	textFieldSearch = new JTextField();
	textFieldSearch.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent arg0) {
			try{
				String selection=(String)comboBoxSelect.getSelectedItem();
				String query="select * from CustomerInfo where "+selection+"=? ";
				//System.out.println(query);
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
	
	textFieldSearch.setBounds(503, 122, 105, 23);
	contentPane.add(textFieldSearch);
	textFieldSearch.setColumns(10);
	
	comboBoxSelect = new JComboBox();
	comboBoxSelect.setModel(new DefaultComboBoxModel(new String[] {"EID", "Name", "Surname","Username","Email","Mobile"}));
	comboBoxSelect.setFont(new Font("Tahoma", Font.PLAIN, 15));
	comboBoxSelect.setBounds(394, 122, 97, 21);
	contentPane.add(comboBoxSelect);
	
	JLabel labelLogo = new JLabel("");
	Image img = new ImageIcon(this.getClass().getResource("JKBANK LOGO.png")).getImage();
	labelLogo.setIcon(new ImageIcon(img));
	labelLogo.setBounds(375, 10, 139, 61);
	contentPane.add(labelLogo);
	
	JLabel lblPassword = new JLabel("Password");
	lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblPassword.setBounds(647, 264, 80, 23);
	contentPane.add(lblPassword);
	
	JLabel lblDob = new JLabel("DOB");
	lblDob.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblDob.setBounds(647, 286, 57, 23);
	contentPane.add(lblDob);
	
	JLabel lblEmail = new JLabel("Email");
	lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblEmail.setBounds(647, 309, 80, 23);
	contentPane.add(lblEmail);
	
	JLabel lblMobile = new JLabel("Mobile");
	lblMobile.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblMobile.setBounds(647, 332, 80, 23);
	contentPane.add(lblMobile);
	

	textField = new JTextField();
	textField.setColumns(10);
	textField.setBounds(734, 264, 116, 21);
	contentPane.add(textField);
	
	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(734, 287, 116, 21);
	contentPane.add(textField_1);
	
	textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(734, 311, 116, 21);
	contentPane.add(textField_2);
	
	textField_3 = new JTextField();
	textField_3.setColumns(10);
	textField_3.setBounds(734, 334, 116, 21);
	contentPane.add(textField_3);
	
	JLabel lblAddress = new JLabel("Address");
	lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblAddress.setBounds(647, 355, 80, 23);
	contentPane.add(lblAddress);
	
	JLabel lblBalance = new JLabel("Balance");
	lblBalance.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblBalance.setBounds(647, 378, 80, 23);
	contentPane.add(lblBalance);
	
	textField_4 = new JTextField();
	textField_4.setColumns(10);
	textField_4.setBounds(734, 380, 116, 21);
	contentPane.add(textField_4);
	
	textField_5 = new JTextField();
	textField_5.setColumns(10);
	textField_5.setBounds(734, 357, 116, 21);
	contentPane.add(textField_5);
	
	JLabel lblAccount = new JLabel("Account Info Change");
	lblAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblAccount.setBounds(671, 132, 166, 23);
	contentPane.add(lblAccount);
	
	JLabel lblndPage = new JLabel("2nd page");
	lblndPage.setBounds(647, 515, 57, 15);
	contentPane.add(lblndPage);
	
	JMenuItem mntmNewMenuItem = new JMenuItem("      Customer Account");
	mntmNewMenuItem.setFont(new Font("Tahoma", Font.BOLD, 16));
	mntmNewMenuItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try{
				
				CustomerInfo emplInfo=new CustomerInfo();
				emplInfo.setVisible(true);
				dispose();
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
			}
		}
	});
	mntmNewMenuItem.setBackground(new Color(135, 206, 235));
	mntmNewMenuItem.setBounds(0, 71, 221, 41);
	contentPane.add(mntmNewMenuItem);
	
	JMenuItem mntmCustomerBalance = new JMenuItem("      Customer Balance");
	mntmCustomerBalance.setFont(new Font("Tahoma", Font.BOLD, 16));
	mntmCustomerBalance.setForeground(new Color(0, 0, 0));
	mntmCustomerBalance.setBackground(new Color(135, 206, 235));
	mntmCustomerBalance.setBounds(222, 71, 221, 41);
	contentPane.add(mntmCustomerBalance);
	
	JMenuItem menuItem = new JMenuItem("      Customer Balance");
	menuItem.setFont(new Font("Tahoma", Font.BOLD, 16));
	menuItem.setForeground(Color.BLACK);
	menuItem.setBackground(new Color(135, 206, 235));
	menuItem.setBounds(444, 71, 221, 41);
	contentPane.add(menuItem);
	
	JMenuItem menuItem_1 = new JMenuItem("      Customer Balance");
	menuItem_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	menuItem_1.setForeground(Color.BLACK);
	menuItem_1.setBackground(new Color(135, 206, 235));
	menuItem_1.setBounds(666, 71, 221, 41);
	contentPane.add(menuItem_1);
	

	

	
	refreshTable();
	fillComboBox();
	loadList();
	
	}	
}
