import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
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
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtFirstname;
	private JTextField txtLastname;
	private JPasswordField txtPassword;
	private JPasswordField txtConPassword;
	private JFrame loginFrame; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
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
		
		JLabel lblUser = new JLabel("Username (Email)");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUser.setForeground(new Color(106, 186, 255));
		
		txtUser = new JTextField();
		lblUser.setLabelFor(txtUser);
		txtUser.setColumns(10);
		txtUser.setBorder(BorderFactory.createCompoundBorder( null, BorderFactory.createEmptyBorder(0, 5, 0, 5)));
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
		
		JComboBox selGender = new JComboBox();
		
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
		
		JFormattedTextField txtBirthday = new JFormattedTextField();
		lblBirthday.setLabelFor(txtBirthday);
		txtBirthday.setBorder(BorderFactory.createCompoundBorder( null, BorderFactory.createEmptyBorder(0, 5, 0, 5)));
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSignUp.setBackground(new Color(38, 153, 251));
		btnSignUp.setForeground(new Color(255, 255, 255));
		
		JLabel label = new JLabel("SWIFTY", SwingConstants.CENTER);
		label.setForeground(new Color(106, 186, 255));
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 62));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginFrame.setVisible(true);
				SignUp.this.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBackground(new Color(38, 153, 251));
		btnBack.setForeground(new Color(255, 255, 255));
		
		JLabel lblErrorMessage = new JLabel("Error message");
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblErrorMessage_1 = new JLabel("Error message");
		lblErrorMessage_1.setForeground(Color.RED);
		lblErrorMessage_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblErrorMessage_2 = new JLabel("Error message");
		lblErrorMessage_2.setForeground(Color.RED);
		lblErrorMessage_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblErrorMessage_3 = new JLabel("Error message");
		lblErrorMessage_3.setForeground(Color.RED);
		lblErrorMessage_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnBack)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtUser, GroupLayout.DEFAULT_SIZE, 202, GroupLayout.DEFAULT_SIZE)
								.addComponent(lblFullname)
								.addComponent(lblConfirmPassword)
								.addComponent(lblPassword)
								.addComponent(lblUser)
								.addComponent(txtPassword)
								.addComponent(txtConPassword)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblGender, Alignment.LEADING)
										.addComponent(txtFirstname, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
										.addComponent(selGender, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtBirthday, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBirthday)
										.addComponent(txtLastname, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
								.addComponent(btnSignUp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
						.addComponent(txtLastname, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGender)
						.addComponent(lblBirthday))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(selGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBirthday, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblErrorMessage_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSignUp, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(79, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		
	}

	public void loginFrame(JFrame loginFrame) {
		this.loginFrame = loginFrame;
	}
}
