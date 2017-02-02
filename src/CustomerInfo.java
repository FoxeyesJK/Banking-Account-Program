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

public class CustomerInfo extends JFrame {
	//Second_page modification 
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerInfo frame = new CustomerInfo();
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
	public CustomerInfo() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}
}
