import java.awt.BorderLayout;
import java.awt.Color;
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

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JPanel panel;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblSwifty = new JLabel("SWIFTY", JLabel.CENTER);
		lblSwifty.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 62));
		lblSwifty.setForeground(new Color(106, 186, 255));
		contentPane.add(lblSwifty, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		contentPane.add(panel, BorderLayout.CENTER);
		
		
		txtPassword = new JTextField();
//		txtPassword.setText("Password");
		txtPassword.setColumns(10);
		TextPrompt password = new TextPrompt("Password", txtPassword);
		
		
		txtUsername = new JTextField();
//		txtUsername.setText("Username");
		txtUsername.setColumns(10);
		TextPrompt user = new TextPrompt("Username", txtUsername);
		
//		ImageIcon img = new ImageIcon(pathToFileOnDisk);
		
		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		
		btnNewButton.setBackground(new Color(38, 153, 251));
//		btnNewButton.setBorder(new RoundedBorder(25));
//		btnNewButton.setBounds(100, 200, 30, 25);
		btnNewButton.setForeground(new Color(242, 249, 255));
		
		
//		Icon icon = IconFontSwing.buildIcon(FontAwesome.SMILE_O, 40, new Color(0, 150, 0));
		JLabel lblUserLabel = new JLabel("User");
		
		JLabel label = new JLabel("Password");
		
		JLabel lblNewLabel = new JLabel("Or sign up");
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
			gl_panel.createParallelGroup(Alignment.TRAILING)
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
								.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))))
					.addGap(428))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(196)
					.addComponent(lblNewLabel)
					.addContainerGap(518, Short.MAX_VALUE))
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
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
	}
}
