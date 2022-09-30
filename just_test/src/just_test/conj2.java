package just_test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class conj2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					conj2 frame = new conj2();
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
	public conj2() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
		});
		connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 35, 924, 358);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("\u0644\u0627\u0626\u062D\u0629 \u0627\u0644\u0627\u0642\u062A\u0631\u0627\u062D\u0627\u062A");
		btnNewButton.setBackground(new Color(222, 184, 135));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					st=con.prepareStatement("select * from suggetion");
					ResultSet rs=st.executeQuery();
					ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					int cols=rsmd.getColumnCount();
					String[] colname=new String[cols];
					for(int i=0;i<cols;i++)
					{
						colname[i]=rsmd.getColumnName(i+1);
						
					}
					model.setColumnIdentifiers(colname);
					String id,verbe,passe,presant,cond,source;
					while(rs.next())
					{
						id=rs.getString("id");
						verbe=rs.getString("verbe");
						passe=rs.getString("passe_id");
						presant=rs.getString("presant_id");
						cond=rs.getString("con_id");
						source=rs.getString("source");
						String[] row= {id,verbe,passe,presant,cond,source};
						model.addRow(row);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(796, 404, 179, 67);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\u062D\u0630\u0641");
		btnNewButton_1.setBackground(new Color(222, 184, 135));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conj3 cj = new conj3();
				cj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(550, 404, 179, 67);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("\u0627\u0636\u0627\u0641\u0629 \u0627\u0644\u0641\u0639\u0644");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addverb ad=new addverb();
				ad.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(222, 184, 135));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBounds(298, 404, 179, 67);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("\u062E\u0631\u0648\u062C");
		btnNewButton_3.setBackground(new Color(222, 184, 135));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_3.setBounds(51, 404, 179, 67);
		contentPane.add(btnNewButton_3);
	}
	
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	
	Connection con;
	PreparedStatement st;
	private JButton btnNewButton_3;
	public void connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/conjugaison","root","");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
