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
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JTextPane;

public class conj4 extends JFrame {

	private JPanel contentPane;
	private JTextField verb_text;
	private JTextField passe_text;
	private JTextField presant_text;
	private JTextField cond_text;
	private JTextField source_text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					conj4 frame = new conj4();
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
	public conj4() {
		connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1078, 652);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ادخل الفعل : ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(906, 57, 148, 40);
		contentPane.add(lblNewLabel);
		
		verb_text = new JTextField();
		verb_text.setHorizontalAlignment(SwingConstants.RIGHT);
		verb_text.setFont(new Font("Times New Roman", Font.BOLD, 20));
		verb_text.setColumns(10);
		verb_text.setBounds(657, 51, 192, 57);
		contentPane.add(verb_text);
		
		JLabel lblNewLabel_1 = new JLabel("نوع الماضي");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_1.setBounds(906, 182, 148, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("نوع المضارع");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_2.setBounds(906, 262, 148, 40);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("نوع الامر");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_3.setBounds(906, 345, 148, 40);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("المصدر");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_4.setBounds(906, 414, 148, 40);
		contentPane.add(lblNewLabel_4);
		
		passe_text = new JTextField();
		passe_text.setHorizontalAlignment(SwingConstants.RIGHT);
		passe_text.setForeground(Color.BLACK);
		passe_text.setFont(new Font("Times New Roman", Font.BOLD, 20));
		passe_text.setColumns(10);
		passe_text.setBounds(657, 176, 192, 57);
		contentPane.add(passe_text);
		
		presant_text = new JTextField();
		presant_text.setHorizontalAlignment(SwingConstants.RIGHT);
		presant_text.setFont(new Font("Times New Roman", Font.BOLD, 20));
		presant_text.setColumns(10);
		presant_text.setBounds(657, 256, 192, 57);
		contentPane.add(presant_text);
		
		cond_text = new JTextField();
		cond_text.setHorizontalAlignment(SwingConstants.RIGHT);
		cond_text.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cond_text.setColumns(10);
		cond_text.setBounds(657, 339, 192, 57);
		contentPane.add(cond_text);
		
		source_text = new JTextField();
		source_text.setHorizontalAlignment(SwingConstants.RIGHT);
		source_text.setFont(new Font("Times New Roman", Font.BOLD, 20));
		source_text.setColumns(10);
		source_text.setBounds(657, 421, 192, 57);
		contentPane.add(source_text);
		
		JButton search_button = new JButton("بحت");
		search_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String verb=verb_text.getText();
				try {
					st=con.prepareStatement("select pa.passe_id ,p.presant_id ,c.cond_id,s.source_id "
								+ "from test t,presant p,passe pa , srce s,conditionel c "
								+ "where t.verbe=? and t.passe_id=pa.id and t.presant_id=p.id and t.cond_id=c.id and t.source_id=s.id; ");
					st.setString(1, verb);
                    ResultSet rs=st.executeQuery();
                    if(rs.next()==false)
                    {
                    	
                    	JOptionPane.showMessageDialog(null,"الفعل غير موجود في قاعدة البيانات");
                    }
                    else
                    {
                    	String passt=rs.getString(1);
                    	String present=rs.getString(2);
                    	String cond=rs.getString(3);
                    	String source=rs.getString(4);
                    	
                    	passe_text.setText(passt);
                    	presant_text.setText(present);
                    	cond_text.setText(cond);
                    	source_text.setText(source);
                    	
                    }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		search_button.setBackground(new Color(222, 184, 135));
		search_button.setFont(new Font("Times New Roman", Font.BOLD, 26));
		search_button.setBounds(221, 50, 278, 53);
		contentPane.add(search_button);
		
		JButton cancel_button = new JButton("خروج");
		cancel_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cancel_button.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cancel_button.setBackground(new Color(222, 184, 135));
		cancel_button.setBounds(10, 551, 171, 53);
		contentPane.add(cancel_button);
		
		JPanel panel = new JPanel();
		panel.setBounds(191, 182, 435, 422);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 24));
		textArea.setBounds(10, 11, 313, 400);
		panel.add(textArea);
		textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JButton passe_button = new JButton("تصريف");
		passe_button.setBounds(333, 6, 89, 46);
		panel.add(passe_button);
		passe_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String verbe=verb_text.getText();
				try {
					st=con.prepareStatement("select p.passe_id from passe p , test t where t.verbe=? and t.passe_id=p.id");
					st.setString(1, verbe);
					ResultSet rs = st.executeQuery();
					if(rs.next()==false)
					{
						JOptionPane.showMessageDialog(null,"الفعل غير موجود حاليا");
					}
					else
					{
						String genre1=rs.getString(1);
						textArea.setText(" انا   "+genre1.replace(genre1.charAt(0), verbe.charAt(0)).replace(genre1.charAt(2), verbe.charAt(2)).replace(genre1.charAt(4), verbe.charAt(4))+"\n"
								         + " انتَ   "+genre1.replace(genre1.charAt(0), verbe.charAt(0)).replace(genre1.charAt(2), verbe.charAt(2)).replace(genre1.charAt(4), verbe.charAt(4)).replaceAll("تُ", "تَ")+"\n"
						                 + " انتِ   "+genre1.replace(genre1.charAt(0), verbe.charAt(0)).replace(genre1.charAt(2), verbe.charAt(2)).replace(genre1.charAt(4), verbe.charAt(4)).replaceAll("تُ", "تِ")+"\n"
						                 + " هو    "+genre1.replace(genre1.charAt(0), verbe.charAt(0)).replace(genre1.charAt(2), verbe.charAt(2)).replace(genre1.charAt(4), verbe.charAt(4)).replace("ْ","َ").replaceAll("تُ", "")+"\n"
						                 + " هي     "+genre1.replace(genre1.charAt(0), verbe.charAt(0)).replace(genre1.charAt(2), verbe.charAt(2)).replace(genre1.charAt(4), verbe.charAt(4)).replace("ْ","َ").replaceAll("تُ", "ت")+"\n"
						                 + " نحن   "+genre1.replace(genre1.charAt(0), verbe.charAt(0)).replace(genre1.charAt(2), verbe.charAt(2)).replace(genre1.charAt(4), verbe.charAt(4)).replaceAll("تُ", "نا")+"\n"
						                 +" انتما   "+genre1.replace(genre1.charAt(0), verbe.charAt(0)).replace(genre1.charAt(2), verbe.charAt(2)).replace(genre1.charAt(4), verbe.charAt(4))+"ما"+"\n"
						                 +" انتما   "+genre1.replace(genre1.charAt(0), verbe.charAt(0)).replace(genre1.charAt(2), verbe.charAt(2)).replace(genre1.charAt(4), verbe.charAt(4))+"ما"+"\n"
		                                 + " هما    "+genre1.replace(genre1.charAt(0), verbe.charAt(0)).replace(genre1.charAt(2), verbe.charAt(2)).replace(genre1.charAt(4), verbe.charAt(4)).replaceAll("ْ", "ا").replaceAll("تُ", "")+"\n"
		                                 + " هما    "+genre1.replace(genre1.charAt(0), verbe.charAt(0)).replace(genre1.charAt(2), verbe.charAt(2)).replace(genre1.charAt(4), verbe.charAt(4)).replaceAll("ْ", "ا").replaceAll("تُ", "")+"\n"
		                                 +" انتم    "+genre1.replace(genre1.charAt(0), verbe.charAt(0)).replace(genre1.charAt(2), verbe.charAt(2)).replace(genre1.charAt(4), verbe.charAt(4))+"م"+"\n"
		                                 +" انتن     "+genre1.replace(genre1.charAt(0), verbe.charAt(0)).replace(genre1.charAt(2), verbe.charAt(2)).replace(genre1.charAt(4), verbe.charAt(4))+"نَّ"+"\n"
		                                 + " هم     "+genre1.replace(genre1.charAt(0), verbe.charAt(0)).replace(genre1.charAt(2), verbe.charAt(2)).replace(genre1.charAt(4), verbe.charAt(4)).replaceAll("ْ", "ُ").replaceAll("تُ", "وا")+"\n"
		                                 + " هن   "+genre1.replace(genre1.charAt(0), verbe.charAt(0)).replace(genre1.charAt(2), verbe.charAt(2)).replace(genre1.charAt(4), verbe.charAt(4)).replaceAll("تُ", "نَ")+"\n");


					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		passe_button.setFont(new Font("Times New Roman", Font.BOLD, 20));
		passe_button.setBackground(new Color(222, 184, 135));
		
		JButton presant_button = new JButton("تصريف");
		presant_button.setBounds(333, 79, 89, 46);
		panel.add(presant_button);
		presant_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String verbe1=verb_text.getText();
				try {
					st=con.prepareStatement("select pr.presant_id from presant pr, test t where t.verbe=? and t.presant_id=pr.id");
					st.setString(1, verbe1);
					ResultSet rs=st.executeQuery();
					if(rs.next()==false)
					{
						JOptionPane.showMessageDialog(null,"الفعل غير موجود حاليا");
					}
					else
					{
						String genre2=rs.getString(1);
						textArea.setText("انا  "+genre2.replace(genre2.charAt(1), verbe1.charAt(0)).replace(genre2.charAt(2), verbe1.charAt(2)).replace(genre2.charAt(4), verbe1.charAt(4))+"\n"
								+"انتَ   "+genre2.replace("أ", "ت").replace(genre2.charAt(1), verbe1.charAt(0)).replace(genre2.charAt(2), verbe1.charAt(2)).replace(genre2.charAt(4), verbe1.charAt(4))+"\n"
								+"انتِ   "+genre2.replace("أ", "ت").replace(genre2.charAt(1), verbe1.charAt(0)).replace(genre2.charAt(2), verbe1.charAt(2)).replace(genre2.charAt(4), verbe1.charAt(4))+"ين"+"\n"
								+"هو    "+genre2.replace("أ", "ي").replace(genre2.charAt(1), verbe1.charAt(0)).replace(genre2.charAt(2), verbe1.charAt(2)).replace(genre2.charAt(4), verbe1.charAt(4))+"\n"
								+"هي    "+genre2.replace("أ", "ت").replace(genre2.charAt(1), verbe1.charAt(0)).replace(genre2.charAt(2), verbe1.charAt(2)).replace(genre2.charAt(4), verbe1.charAt(4))+"\n"
								+"نحن   "+genre2.replace("أ", "ن").replace(genre2.charAt(1), verbe1.charAt(0)).replace(genre2.charAt(2), verbe1.charAt(2)).replace(genre2.charAt(4), verbe1.charAt(4))+"\n"
								+"انتما   "+genre2.replace("أ", "ت").replace(genre2.charAt(1), verbe1.charAt(0)).replace(genre2.charAt(2), verbe1.charAt(2)).replace(genre2.charAt(4), verbe1.charAt(4))+"ان"+"\n"
								+"انتما   "+genre2.replace("أ", "ت").replace(genre2.charAt(1), verbe1.charAt(0)).replace(genre2.charAt(2), verbe1.charAt(2)).replace(genre2.charAt(4), verbe1.charAt(4))+"ان"+"\n"
								+"هما    "+genre2.replace("أ", "ي").replace(genre2.charAt(1), verbe1.charAt(0)).replace(genre2.charAt(2), verbe1.charAt(2)).replace(genre2.charAt(4), verbe1.charAt(4))+"ان"+"\n"
								+"هما    "+genre2.replace("أ", "ي").replace(genre2.charAt(1), verbe1.charAt(0)).replace(genre2.charAt(2), verbe1.charAt(2)).replace(genre2.charAt(4), verbe1.charAt(4))+"ان"+"\n"
								+"انتم    "+genre2.replace("أ", "ت").replace(genre2.charAt(1), verbe1.charAt(0)).replace(genre2.charAt(2), verbe1.charAt(2)).replace(genre2.charAt(4), verbe1.charAt(4))+"ون"+"\n"
								+"انتن    "+genre2.replace("أ", "ت").replace(genre2.charAt(1), verbe1.charAt(0)).replace(genre2.charAt(2), verbe1.charAt(2)).replace(genre2.charAt(4), verbe1.charAt(4))+"ن"+"\n"
								+"هم     "+genre2.replace("أ", "ي").replace(genre2.charAt(1), verbe1.charAt(0)).replace(genre2.charAt(2), verbe1.charAt(2)).replace(genre2.charAt(4), verbe1.charAt(4))+"ون"+"\n"
								+"هن     "+genre2.replace("أ", "ي").replace(genre2.charAt(1), verbe1.charAt(0)).replace(genre2.charAt(2), verbe1.charAt(2)).replace(genre2.charAt(4), verbe1.charAt(4))+"ن"+"\n");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		presant_button.setFont(new Font("Times New Roman", Font.BOLD, 20));
		presant_button.setBackground(new Color(222, 184, 135));
		
		JButton cond_button = new JButton("تصريف");
		cond_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String verbe3=verb_text.getText();
				try {
					st=con.prepareStatement("select c.cond_id from conditionel c,test t where t.verbe=? and t.cond_id=c.id");
					st.setString(1, verbe3);
					ResultSet rs = st.executeQuery();
					if(rs.next()==false)
					{
						JOptionPane.showMessageDialog(null,"الفعل غير موجود حاليا");
					}
					else
					{
						String genre3=rs.getString(1);
						textArea.setText("انتَ "+genre3.replace(genre3.charAt(1), verbe3.charAt(0)).replace(genre3.charAt(2), verbe3.charAt(2)).replace(genre3.charAt(4), verbe3.charAt(4))+"\n"
								+"انتِ  "+genre3.replace(genre3.charAt(1), verbe3.charAt(0)).replace(genre3.charAt(2), verbe3.charAt(2)).replace(genre3.charAt(4), verbe3.charAt(4))+"ي"+"\n"
								+"انتما   "+genre3.replace(genre3.charAt(1), verbe3.charAt(0)).replace(genre3.charAt(2), verbe3.charAt(2)).replace(genre3.charAt(4), verbe3.charAt(4))+"ا"+"\n"
								+"انتما   "+genre3.replace(genre3.charAt(1), verbe3.charAt(0)).replace(genre3.charAt(2), verbe3.charAt(2)).replace(genre3.charAt(4), verbe3.charAt(4))+"ا"+"\n"
								+"انتم    "+genre3.replace(genre3.charAt(1), verbe3.charAt(0)).replace(genre3.charAt(2), verbe3.charAt(2)).replace(genre3.charAt(4), verbe3.charAt(4))+"وا"+"\n"
								+"انتن     "+genre3.replace(genre3.charAt(1), verbe3.charAt(0)).replace(genre3.charAt(2), verbe3.charAt(2)).replace(genre3.charAt(4), verbe3.charAt(4))+"ن"+"\n");
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		cond_button.setBounds(333, 162, 89, 46);
		panel.add(cond_button);
		cond_button.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cond_button.setBackground(new Color(222, 184, 135));
		
		JButton btnNewButton = new JButton("اقتراح  فعل");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sugverb adsv=new sugverb();
				adsv.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(222, 184, 135));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(10, 182, 171, 53);
		contentPane.add(btnNewButton);
		
		JButton cancel_button_1 = new JButton("معلومات");
		cancel_button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imformations m=new imformations();
				m.setVisible(true);
				dispose();
			}
		});
		cancel_button_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cancel_button_1.setBackground(new Color(222, 184, 135));
		cancel_button_1.setBounds(10, 258, 171, 53);
		contentPane.add(cancel_button_1);
		
		
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
