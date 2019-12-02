package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONWriter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.Font;
import java.awt.FontFormatException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
					Login frame = new Login(null, null);
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
	
	public Login(DataInputStream dis, DataOutputStream dos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 43, 43));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		SignUp signUp = new SignUp(dis, dos);
		signUp.setVisible(false);
		signUp.loginFrame(Login.this);
		
		
		
//		JLabel lblSwifty = new JLabel("New label");
		JLabel lblSwifty = new JLabel("SWIFTY", SwingConstants.CENTER);
		lblSwifty.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 62));
		lblSwifty.setForeground(new Color(106, 186, 255));
//		contentPane.add(lblSwifty, BorderLayout.NORTH);
		
		
		
		panel = new JPanel();
		panel.setBackground(new Color(44, 43, 43));
		panel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		contentPane.add(panel, BorderLayout.CENTER);
//		TextPrompt password = new TextPrompt("Password", txtPassword);
//		panel.a
		
		txtUsername = new JTextField();
//		txtUsername.setText("Username");
		txtUsername.setColumns(10);
		txtUsername.setBorder(BorderFactory.createCompoundBorder( null, BorderFactory.createEmptyBorder(0, 5, 0, 5)));
//		txtUsername.set
		TextPrompt txtUser = new TextPrompt("Username", txtUsername);
		
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(BorderFactory.createCompoundBorder( null, BorderFactory.createEmptyBorder(0, 5, 0, 5)));
		TextPrompt pass = new TextPrompt("Password", txtPassword);
//		ImageIcon img = new ImageIcon(pathToFileOnDisk);
		
		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = txtUsername.getText();
				String password = txtPassword.getText();
				if (userName.isBlank()) {
					JOptionPane.showMessageDialog(null, "Username is empty!", "Error",JOptionPane.ERROR_MESSAGE);
					return ;
				}
				if (password.isBlank()) {
					JOptionPane.showMessageDialog(null, "Password is empty!", "Error",JOptionPane.ERROR_MESSAGE);
					return ;
				}
				password = passwordMD5(password);
				System.out.println("User: " + userName);
				System.out.println("Pass: " + password);
				
				try {
					String command ="{\n"
							+ "\"Type\": \"Signin\",\n"				 		
					 		+ "\"Errorcode\": \"Er0\",\n"
					 		+ "\"Username\": \""+userName+"\",\n"
					 		+ "\"Password\": \""+password+"\",\n"
					 		+ "}";
					dos.writeUTF(command);
					String respond = dis.readUTF();
					System.out.println("Respond: " + respond);
					if (respond.equals("Er1")) {
						JOptionPane.showMessageDialog(null, "Wrong username or password!", "Error",JOptionPane.ERROR_MESSAGE);
					} else {
						JSONObject obj = new JSONObject(respond);
						if (obj.getString("Errorcode").equals("Er2")) { // Account is logining 
							JOptionPane.showMessageDialog(null, "Account is logining!", "Warning!",JOptionPane.WARNING_MESSAGE);
						} else { // Login success
							JOptionPane.showMessageDialog(null, "Hello " + obj.getString("FnameLname"), "Welcome",JOptionPane.INFORMATION_MESSAGE);
							
							Square10 sq = null;
							switch (obj.getString("Config ID"))
							{
								case "easy": {
									sq = new Square10(dis, dos, obj);
									sq.user(obj);
									break;
								}
								default: {
									break;
								}
							}
							Login.this.dispose();
							sq.setVisible(true);
						}
					}
						
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
					.addGap(57)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSwifty, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblUserLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(txtPassword)
									.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)))
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(68, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(196)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(170, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblSwifty)
					.addGap(16)
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
					.addContainerGap(36, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		this.getRootPane().setDefaultButton(btnNewButton);
	}

	private String passwordMD5(String pass) {
		MessageDigest md;
		StringBuilder sb = null;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] hashInBytes = md.digest(pass.getBytes(StandardCharsets.UTF_8));
			
			sb = new StringBuilder();
			for (byte b : hashInBytes) {
	            sb.append(String.format("%02x", b));
	        }
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return sb.toString();
	}
}
