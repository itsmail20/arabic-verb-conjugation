package just_test;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class conj {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					conj window = new conj();
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
	public conj() {
		connect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 552, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("الاسم");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(245, 108, 193, 31);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(171, 150, 193, 38);
		frame.getContentPane().add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("كلمة المرور");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(222, 199, 193, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 241, 193, 33);
		frame.getContentPane().add(passwordField);
		
		JButton login_button = new JButton("تسجيل الدخول");
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					st=con.prepareStatement("select * from multi_users where username=? and password=? ");
					st.setString(1, textField.getText());
					st.setString(2, passwordField.getText());
					ResultSet rs =st.executeQuery();
					
					if(rs.next()==false)
					{
						JOptionPane.showMessageDialog(null, "الاسم او كلمة المرور خاطئة");
					}
					else 
					{
						frame.dispose();
						conj2 c=new conj2();
						c.setVisible(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		login_button.setFont(new Font("Times New Roman", Font.BOLD, 20));
		login_button.setBackground(new Color(222, 184, 135));
		login_button.setBounds(70, 296, 167, 46);
		frame.getContentPane().add(login_button);
		
		JButton btnNewButton_1 = new JButton("إلغاء");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(222, 184, 135));
		btnNewButton_1.setBounds(289, 296, 167, 46);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton visitor_button = new JButton("زائر");
		visitor_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				conj4 c4=new conj4();
				c4.setVisible(true);
			}
		});
		visitor_button.setFont(new Font("Times New Roman", Font.BOLD, 20));
		visitor_button.setBackground(new Color(222, 184, 135));
		visitor_button.setBounds(361, 11, 167, 46);
		frame.getContentPane().add(visitor_button);
	}
	Connection con;
	PreparedStatement st;
	private JTextField textField;
	private JPasswordField passwordField;
	
	
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
