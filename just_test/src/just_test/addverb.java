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

public class addverb extends JFrame {

	private JPanel contentPane;
	private JTextField verb_field;
	private JTextField passe_field;
	private JTextField presant_field;
	private JTextField cond_fiel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addverb frame = new addverb();
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
	public addverb() {
		connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0627\u0644\u0641\u0639\u0644");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(772, 71, 153, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u0646\u0648\u0639 \u0627\u0644\u0645\u0627\u0636\u064A");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(583, 71, 153, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u0646\u0648\u0639 \u0627\u0644\u0645\u0636\u0627\u0631\u0639");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(400, 71, 153, 44);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u0627\u0644\u0645\u0635\u062F\u0631");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(60, 71, 153, 44);
		contentPane.add(lblNewLabel_3);
		
		verb_field = new JTextField();
		verb_field.setBounds(720, 126, 153, 44);
		contentPane.add(verb_field);
		verb_field.setColumns(10);
		verb_field.setHorizontalAlignment(SwingConstants.RIGHT);
		
		passe_field = new JTextField();
		passe_field.setColumns(10);
		passe_field.setBounds(547, 126, 153, 44);
		contentPane.add(passe_field);
		
		presant_field = new JTextField();
		presant_field.setColumns(10);
		presant_field.setBounds(371, 126, 153, 44);
		contentPane.add(presant_field);
		
		cond_fiel = new JTextField();
		cond_fiel.setColumns(10);
		cond_fiel.setBounds(192, 126, 153, 44);
		contentPane.add(cond_fiel);
		
		JButton btnNewButton = new JButton("\u062A\u0623\u0643\u064A\u062F \u0627\u0644\u0625\u0636\u0627\u0641\u0629");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String verbe=verb_field.getText();
				String passe=passe_field.getText();
				String presant=presant_field.getText();
				String cond=cond_fiel.getText();
				String source=source_field.getText();
				try {
					st=con.prepareStatement("insert into test values(?,?,?,?,?)");
					st.setString(1, verbe);
					st.setString(2, passe);
					st.setString(3, presant);
					st.setString(4, cond);
					st.setString(5, source);
					st.execute();
					JOptionPane.showMessageDialog(null, "تمت الإضافة");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(222, 184, 135));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(499, 250, 316, 71);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u0639\u0648\u062F\u0629");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conj2 ct= new conj2();
				ct.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(222, 184, 135));
		btnNewButton_1.setBounds(71, 250, 316, 71);
		contentPane.add(btnNewButton_1);
		
		source_field = new JTextField();
		source_field.setColumns(10);
		source_field.setBounds(10, 126, 153, 44);
		contentPane.add(source_field);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u0646\u0648\u0639 \u0627\u0644\u0627\u0645\u0631");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(224, 71, 153, 44);
		contentPane.add(lblNewLabel_2_1);
	}
	
	private JButton btnNewButton_1;
	private JTextField source_field;
	Connection con;
	PreparedStatement st;
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
