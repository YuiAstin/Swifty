package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import BUS.Encryption;

import com.jgoodies.forms.layout.FormSpecs;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class EditProfile extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtFirstname;
	private JTextField txtLastname;
	private JPasswordField txtPassword;
	private JPasswordField txtConPassword;
	private JComboBox selGender;
	private JFormattedTextField txtBirthday;
	private JFrame mainFrame;
	private JSONObject user = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditProfile frame = new EditProfile(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws JSONException 
	 */
	public EditProfile(DataInputStream dis, DataOutputStream dos) throws JSONException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 43, 43));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(44, 43, 43));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblUser = new JLabel("Username");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUser.setForeground(new Color(106, 186, 255));
		
		txtUser = new JTextField();
		lblUser.setLabelFor(txtUser);
		txtUser.setColumns(10);
		txtUser.setBorder(BorderFactory.createCompoundBorder( null, BorderFactory.createEmptyBorder(0, 5, 0, 5)));
		txtUser.setEnabled(false);
		TextPrompt user = new TextPrompt("Username", txtUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setForeground(new Color(106, 186, 255));
		
		JLabel lblConfirmPassword = new JLabel("Confirm password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConfirmPassword.setForeground(new Color(106, 186, 255));
		
		JLabel lblFullname = new JLabel("Fullname");
		lblFullname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFullname.setForeground(new Color(106, 186, 255));
		
		txtFirstname = new JTextField();
		lblFullname.setLabelFor(txtFirstname);
		txtFirstname.setColumns(10);
		txtFirstname.setBorder(BorderFactory.createCompoundBorder( null, BorderFactory.createEmptyBorder(0, 5, 0, 5)));
		TextPrompt firstName = new TextPrompt("First Name", txtFirstname);
		
		txtLastname = new JTextField();
		txtLastname.setColumns(10);
		txtLastname.setBorder(BorderFactory.createCompoundBorder( null, BorderFactory.createEmptyBorder(0, 5, 0, 5)));
		TextPrompt lastName = new TextPrompt("Last Name", txtLastname);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGender.setForeground(new Color(106, 186, 255));
		
		selGender = new JComboBox();
		selGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBirthday.setForeground(new Color(106, 186, 255));
		
		txtPassword = new JPasswordField();
		lblPassword.setLabelFor(txtPassword);
		txtPassword.setBorder(BorderFactory.createCompoundBorder( null, BorderFactory.createEmptyBorder(0, 5, 0, 5)));
		TextPrompt password = new TextPrompt("Password", txtPassword);
		
		txtConPassword = new JPasswordField();
		lblConfirmPassword.setLabelFor(txtConPassword);
		txtConPassword.setBorder(BorderFactory.createCompoundBorder( null, BorderFactory.createEmptyBorder(0, 5, 0, 5)));
		TextPrompt conPassword = new TextPrompt("Confirm password", txtConPassword);
		
		MaskFormatter formatter = new TimeFormatter();
		formatter.setValueClass(java.util.Date.class);
		txtBirthday = new JFormattedTextField(formatter);
		lblBirthday.setLabelFor(txtBirthday);
		txtBirthday.setBorder(BorderFactory.createCompoundBorder( null, BorderFactory.createEmptyBorder(0, 5, 0, 5)));
		
		
		JLabel label = new JLabel("SWIFTY", SwingConstants.CENTER);
		label.setForeground(new Color(106, 186, 255));
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 62));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Class mainClass = EditProfile.this.mainFrame.getClass();
				if (mainClass == Square10.class) {
					((Square10) EditProfile.this.mainFrame).user(EditProfile.this.user);
				}
				setVisible(false);
				EditProfile.this.mainFrame.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBackground(new Color(38, 153, 251));
		btnBack.setForeground(new Color(255, 255, 255));
		
		JLabel lblErrorMessage = new JLabel("Error message");
		lblErrorMessage.setLabelFor(txtUser);
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrorMessage.setVisible(false);
		
		JLabel lblErrorMessage_1 = new JLabel("Error message");
		lblErrorMessage_1.setLabelFor(txtPassword);
		lblErrorMessage_1.setForeground(Color.RED);
		lblErrorMessage_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrorMessage_1.setVisible(false);
		
		JLabel lblErrorMessage_2 = new JLabel("Error message");
		lblErrorMessage_2.setLabelFor(txtConPassword);
		lblErrorMessage_2.setForeground(Color.RED);
		lblErrorMessage_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrorMessage_2.setVisible(false);
		
		JLabel lblErrorMessage_3 = new JLabel("Error message");
		lblErrorMessage_3.setLabelFor(txtLastname);
		lblErrorMessage_3.setForeground(Color.RED);
		lblErrorMessage_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrorMessage_3.setVisible(false);
		
		JButton btnClearFields = new JButton("Clear");
		btnClearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPassword.setText(null);
				txtConPassword.setText(null);
				txtFirstname.setText(null);
				txtLastname.setText(null);
			}
		});
		btnClearFields.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClearFields.setBackground(new Color(38, 153, 251));
		btnClearFields.setForeground(new Color(255, 255, 255));
		
		JButton btnSaveChanges = new JButton("Save changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String _user =  txtUser.getText();
				String _pass =  txtPassword.getText();
				String _conPass =  txtConPassword.getText();
				String _firstName =  txtFirstname.getText();
				String _lastName =  txtLastname.getText();
				int _gender =  selGender.getSelectedIndex(); // 0: Male -- 1: Female
				String _birthday =  txtBirthday.getText();
				
				if (_user.isBlank()) {
					JOptionPane.showMessageDialog(null, "Username is empty!", "Error",JOptionPane.ERROR_MESSAGE);
					lblErrorMessage.setText("Username is empty!");
					lblErrorMessage.setVisible(true);
					return ;
				} else lblErrorMessage.setVisible(false);
				
				if (!_pass.contentEquals(_conPass)) {
					JOptionPane.showMessageDialog(null, "Confirm password does not match!", "Error",JOptionPane.ERROR_MESSAGE);
					lblErrorMessage_1.setText("Confirm password does not match!");
					lblErrorMessage_1.setVisible(true);
					lblErrorMessage_2.setText("Confirm password does not match!");
					lblErrorMessage_2.setVisible(true);
					return ;
				} else { lblErrorMessage_1.setVisible(false); lblErrorMessage_2.setVisible(false); }
				
				if (_firstName.isBlank()) {
					JOptionPane.showMessageDialog(null, "First name is empty!", "Error",JOptionPane.ERROR_MESSAGE);
					lblErrorMessage_3.setText("First name is empty!");
					lblErrorMessage_3.setVisible(true);
					return ;
				} else lblErrorMessage_3.setVisible(false);
				
				if (_lastName.isBlank()) {
					JOptionPane.showMessageDialog(null, "Last name is empty!", "Error",JOptionPane.ERROR_MESSAGE);
					lblErrorMessage_3.setText("Last name is empty!");
					lblErrorMessage_3.setVisible(true);
					return ;
				} else lblErrorMessage_3.setVisible(false);
				
				if (_pass.isBlank()) {
					try {
						_pass = EditProfile.this.user.getString("Password");
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					_pass = passwordMD5(_pass);
				}
				
				System.out.println("User: " + _user);
				System.out.println("Pass: " + _pass);
				System.out.println("Confirm Password: " + _conPass);
				System.out.println("Firstname: " + _firstName);
				System.out.println("Lastname: " + _lastName);
				System.out.println("Gender: " + _gender);
				System.out.println("Birthday: " + _birthday);
				System.out.println(_pass.contentEquals(_conPass));
				System.out.println(_pass.equals(_conPass));
				
				try {
					String command ="{\n"
							+ "\"Type\": \"EditProfile\",\n"
					 		+ "\"Errorcode\": \"Er0\",\n"
					 		+ "\"player ID\": \""+EditProfile.this.user.getString("player ID")+"\",\n"
					 		+ "\"Username\": \""+_user+"\",\n"
					 		+ "\"Password\": \""+_pass+"\",\n"
					 		+ "\"FnameLname\": \""+ _firstName.replace(" ", "") + " " + _lastName.replace(" ", "") +"\",\n"
			 				+ "\"Gender\": \""+_gender+"\",\n"
					 		+ "\"Birthday\": \""+_birthday+"\"\n"
					 		+ "}";
					command = Encryption.Encrypt(command);
					dos.writeUTF(command);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSaveChanges.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSaveChanges.setBackground(new Color(38, 153, 251));
		btnSaveChanges.setForeground(new Color(255, 255, 255));
		
		
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnBack)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtUser)
								.addComponent(lblFullname)
								.addComponent(lblConfirmPassword)
								.addComponent(lblPassword)
								.addComponent(lblUser)
								.addComponent(txtPassword)
								.addComponent(txtConPassword)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnClearFields, 0, 0, Short.MAX_VALUE)
										.addComponent(lblGender, Alignment.LEADING)
										.addComponent(txtFirstname, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
										.addComponent(selGender, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(txtBirthday, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblBirthday)
											.addComponent(txtLastname, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
										.addComponent(btnSaveChanges))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblErrorMessage_3)
								.addComponent(lblErrorMessage_2)
								.addComponent(lblErrorMessage_1)
								.addComponent(lblErrorMessage)))
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUser)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblErrorMessage))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPassword)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblErrorMessage_1))
					.addGap(11)
					.addComponent(lblConfirmPassword)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtConPassword, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblErrorMessage_2))
					.addGap(11)
					.addComponent(lblFullname)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFirstname, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtLastname, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblErrorMessage_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGender)
						.addComponent(lblBirthday))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(selGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBirthday, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnSaveChanges, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnClearFields, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addContainerGap(81, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		
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
	public void mainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	public void user(JSONObject user) {
		this.user = user;
	}
	public void loadProfile() throws JSONException {
		if (this.user == null) return;
		JSONObject obj = this.user;
		txtUser.setText(obj.getString("Username"));
		txtPassword.setText(null);
		txtConPassword.setText(null);
		String tmp[] = obj.getString("FnameLname").split(" ");
		txtFirstname.setText(tmp[0]);
		if (tmp.length > 1) txtLastname.setText(tmp[1]);
		selGender.setSelectedIndex(obj.getInt("Gender"));
		txtBirthday.setText(obj.getString("Birthday").replace("-", "/"));
	}
	
}
