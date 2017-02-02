import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class TransactionDetails extends JDialog {

	private final JPanel contentPanel = new JPanel();

	
	public static void main(String[] args) {
		try {
			TransactionDetails dialog = new TransactionDetails();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	Connection connection = null;
	private final JLabel lblCover = new JLabel("");
	private JTable table;
	private JTable tableTran11;
	/**
	 * Create the dialog.
	 */
	public void refreshTable()
	{
		try {
			String query="select AccountNumber,First,Second,Third,Fourth,Fifth,Sixth,Seventh from CusBal";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			rs.close();
			pst.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public TransactionDetails() {
		connection=sqliteConnection.dbConnector();
		setBounds(100, 100, 669, 515);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
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
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel.setBounds(10, 82, 631, 317);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(12, 10, 607, 245);
				panel.add(scrollPane);
				{
					table = new JTable();
					scrollPane.setViewportView(table);
				}
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
				JButton btnPrint = new JButton("Print");
				btnPrint.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							String query="select AccountNumber,First,Second,Third,Fourth,Fifth,Sixth,Seventh from CusBal";
						PreparedStatement pst = connection.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));;	
						
	
						pst.close();
						rs.close();
						} catch (Exception e) {
					
							e.printStackTrace();
						}
						
					}
				});
				btnPrint.setActionCommand("OK");
				btnPrint.setBounds(159, 10, 90, 23);
				panel.add(btnPrint);
			}
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
			

		}
		Image img2 = new ImageIcon(this.getClass().getResource("/Cover3.jpg")).getImage();
		lblCover.setIcon(new ImageIcon(img2));
		lblCover.setBounds(0, 0, 653, 63);
		contentPanel.add(lblCover);
		
		refreshTable();
		
	}

}
