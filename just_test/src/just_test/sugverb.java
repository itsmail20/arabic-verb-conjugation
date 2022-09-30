package just_test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class sugverb extends JFrame {

	private JPanel contentPane;
	private JTextField verb_field;
	private JTextField passe_field;
	private JTextField presant_field;
	private JTextField cond_field;
	private JTextField source_field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sugverb frame = new sugverb();
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
	public sugverb() {
		connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("الفعل");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(736, 63, 153, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("نوع الماضي");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(736, 137, 153, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("نوع المضارع");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(393, 11, 153, 44);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("نوع الامر");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(393, 63, 153, 44);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("المصدر");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(393, 137, 153, 44);
		contentPane.add(lblNewLabel_3);
		
		verb_field = new JTextField();
		verb_field.setHorizontalAlignment(SwingConstants.RIGHT);
		verb_field.setColumns(10);
		verb_field.setBounds(567, 65, 153, 44);
		contentPane.add(verb_field);
		
		passe_field = new JTextField();
		passe_field.setColumns(10);
		passe_field.setBounds(567, 139, 153, 44);
		contentPane.add(passe_field);
		
		presant_field = new JTextField();
		presant_field.setColumns(10);
		presant_field.setBounds(228, 13, 153, 44);
		contentPane.add(presant_field);
		
		cond_field = new JTextField();
		cond_field.setColumns(10);
		cond_field.setBounds(228, 65, 153, 44);
		contentPane.add(cond_field);
		
		source_field = new JTextField();
		source_field.setColumns(10);
		source_field.setBounds(230, 139, 153, 44);
		contentPane.add(source_field);
		
		JButton btnNewButton = new JButton("تأكيد الإضافة");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=number_field.getText();
				String verbe=verb_field.getText();
				String passe=passe_field.getText();
				String presant=presant_field.getText();
				String cond=cond_field.getText();
				String source=source_field.getText();
				try {
					st=con.prepareStatement("insert into suggetion values(?,?,?,?,?,?)");
					st.setString(1, number);
					st.setString(2, verbe);
					st.setString(3, passe);
					st.setString(4, presant);
					st.setString(5, cond);
					st.setString(6, source);
					st.execute();
					JOptionPane.showMessageDialog(null, "تمت الإضافة");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(222, 184, 135));
		btnNewButton.setBounds(493, 273, 316, 71);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("عودة");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conj4 bb=new conj4();
				bb.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(222, 184, 135));
		btnNewButton_1.setBounds(135, 273, 316, 71);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("الرقم");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(736, 8, 153, 44);
		contentPane.add(lblNewLabel_4);
		
		number_field = new JTextField();
		number_field.setHorizontalAlignment(SwingConstants.RIGHT);
		number_field.setColumns(10);
		number_field.setBounds(567, 11, 153, 44);
		contentPane.add(number_field);
	}
	Connection con;
	PreparedStatement st;
	private JTextField number_field;
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
