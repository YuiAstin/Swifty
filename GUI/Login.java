import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Font;
import java.awt.FontFormatException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPanel panel;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 43, 43));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		SignUp signUp = new SignUp();
		signUp.setVisible(false);
		signUp.loginFrame(Login.this);
		
		JLabel lblSwifty = new JLabel("SWIFTY", JLabel.CENTER);
		lblSwifty.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 62));
		lblSwifty.setForeground(new Color(106, 186, 255));
		contentPane.add(lblSwifty, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setBackground(new Color(44, 43, 43));
		panel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		contentPane.add(panel, BorderLayout.CENTER);
//		TextPrompt password = new TextPrompt("Password", txtPassword);
		
		
		txtUsername = new JTextField();
//		txtUsername.setText("Username");
		txtUsername.setColumns(10);
		txtUsername.setBorder(BorderFactory.createCompoundBorder( null, BorderFactory.createEmptyBorder(0, 5, 0, 5)));
//		txtUsername.set
		TextPrompt user = new TextPrompt("Username", txtUsername);
		
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(BorderFactory.createCompoundBorder( null, BorderFactory.createEmptyBorder(0, 5, 0, 5)));
		TextPrompt pass = new TextPrompt("Password", txtPassword);
//		ImageIcon img = new ImageIcon(pathToFileOnDisk);
		
		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		
		btnNewButton.setBackground(new Color(38, 153, 251));
//		btnNewButton.setBorder(new RoundedBorder(25));
//		btnNewButton.setBounds(100, 200, 30, 25);
		btnNewButton.setForeground(new Color(242, 249, 255));
		
		
//		Icon icon = IconFontSwing.buildIcon(FontAwesome.SMILE_O, 40, new Color(0, 150, 0));
		JLabel lblUserLabel = new JLabel("User");
		lblUserLabel.setForeground(new Color(106, 186, 255));
		JLabel label = new JLabel("Password");
		label.setForeground(new Color(106, 186, 255));
		
		JLabel lblNewLabel = new JLabel("Or sign up");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				lblNewLabel.setText("<HTML><U>Or sign up</U></HTML>");
				setVisible(false);
				signUp.setVisible(true);
			}
		});
//		JLabel lblNewLabel = new JLabel("<HTML><U>Or sign up</U></HTML>");

		lblNewLabel.setForeground(new Color(106, 186, 255));
		
		
		
		
//		JLabel lblPassLabel = new JLabel("Password");
//		Icon icon = IconFontSwing.buildIcon(FontAwesome.SMILE_O, 40, new Color(0, 150, 0));
		
		
		
//		btnNewButton.setOpaque(false);
//		btnNewButton.setFocusPainted(false);
		
//		btnNewButton.setBorderPainted(false);
//		btnNewButton.setContentAreaFilled(false);
//		btnNewButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(57)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblUserLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtPassword)
										.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(195)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(90, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUserLabel))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
	}
}
