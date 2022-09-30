package just_test;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.*;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class imformations extends JFrame {

	private JPanel contentPane;
	
	ImageIcon cond = new ImageIcon("cond.png");
	ImageIcon passe = new ImageIcon("passe.png");
	ImageIcon presant = new ImageIcon("presant.png");
	ImageIcon src = new ImageIcon("src.png");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					imformations frame = new imformations();
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
	public imformations() {
		connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u0639\u0648\u062F\u0629");
		btnNewButton.setBackground(new Color(222, 184, 135));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conj4 c5=new conj4();
				c5.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton.setBounds(41, 549, 232, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon img=new ImageIcon(this.getClass().getResource("/cond.png"));
		lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(90, 70, 223, 172);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon img2=new ImageIcon(this.getClass().getResource("/passe.png"));
		lblNewLabel_1.setIcon(img2);
		lblNewLabel_1.setBounds(384, 70, 198, 162);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(384, 349, 226, 188);
		ImageIcon img3= new ImageIcon(this.getClass().getResource("/presant.png"));
		lblNewLabel_2.setIcon(img3);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(710, 81, 250, 456);
		ImageIcon img4=new ImageIcon(this.getClass().getResource("/src.png"));
		lblNewLabel_3.setIcon(img4);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u0627\u0646\u0648\u0627\u0639 \u0627\u0644\u0627\u0645\u0631");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(125, 25, 148, 34);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("\u0627\u0646\u0648\u0627\u0639 \u0627\u0644\u0645\u0627\u0636\u064A");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4_1.setBounds(423, 25, 148, 34);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("\u0627\u0646\u0648\u0627\u0639 \u0627\u0644\u0645\u0636\u0627\u0631\u0639");
		lblNewLabel_4_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4_2.setBounds(434, 304, 148, 34);
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("\u0627\u0644\u0645\u0635\u0627\u062F\u0631");
		lblNewLabel_4_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4_2_1.setBounds(749, 52, 148, 34);
		contentPane.add(lblNewLabel_4_2_1);
	}
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
