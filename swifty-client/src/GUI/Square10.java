package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.BUS;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JList;

public class Square10 extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Square10 frame = new Square10(null,null);
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					frame.setTitle("SWIFTY - Play & Joy!");
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Square10(DataInputStream dis, DataOutputStream dos) {
		getContentPane().setBackground(new Color(0, 0, 51));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);
		
		JLabel lblSwifty = new JLabel("SWIFTY");
		lblSwifty.setForeground(SystemColor.textHighlight);
		lblSwifty.setFont(new Font("OCR A Extended", Font.BOLD, 58));
		
		JButton btnUsername = new JButton("Username");
		btnUsername.setFont(new Font("Arial", Font.BOLD, 17));
		
		JLabel lblFind = new JLabel("FIND");
		lblFind.setForeground(SystemColor.textHighlight);
		lblFind.setFont(new Font("Arial", Font.BOLD, 25));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblPlayer = new JLabel("P1:");
		lblPlayer.setForeground(SystemColor.textHighlight);
		lblPlayer.setFont(new Font("Arial", Font.BOLD, 25));
		
		JLabel lblP = new JLabel("P2:");
		lblP.setForeground(SystemColor.textHighlight);
		lblP.setFont(new Font("Arial", Font.BOLD, 25));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblTime = new JLabel("TIME:");
		lblTime.setForeground(SystemColor.textHighlight);
		lblTime.setFont(new Font("Arial", Font.BOLD, 25));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JList listPlayer = new JList();
		
		JList listRanking = new JList();
		
		JLabel lblPlayerList = new JLabel("PLAYER LIST");
		lblPlayerList.setForeground(SystemColor.textHighlight);
		lblPlayerList.setFont(new Font("Arial", Font.BOLD, 25));
		
		JLabel lblRanking = new JLabel("RANKING");
		lblRanking.setForeground(SystemColor.textHighlight);
		lblRanking.setFont(new Font("Arial", Font.BOLD, 25));
		
		int SquareNum = 100; 
		JButton button[] = new JButton[SquareNum];
		for (int i = 0; i<button.length; i++)
		{
			/* Title for button */
			
			button[i] = new JButton("X");
			final int j = i;
			
			/* Event for button */
			
			button[i].addActionListener((ActionListener) new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					BUS.sendNumber(String.valueOf(j));
				}
				
			});
			
		}
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(button[0], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblFind, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
								.addComponent(button[10], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(button[11], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(button[12], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(button[13], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(button[14], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(button[15], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(button[16], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(button[17], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(button[18], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addComponent(lblPlayer)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblP, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblTime)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
									.addComponent(lblPlayerList))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(button[1], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[2], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[3], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[4], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[5], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[6], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[7], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addGap(10)
											.addComponent(button[8], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[9], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(button[19], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[28], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[37], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[46], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[55], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[64], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[73], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[82], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[91], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(button[20], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[29], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[38], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[47], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[56], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[65], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[74], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[83], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[92], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(button[21], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[30], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[39], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[48], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[57], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[66], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[75], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[84], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[93], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(button[22], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[31], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[40], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[49], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[58], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[67], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[76], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[85], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[94], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(button[23], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[32], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[41], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[50], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[59], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[68], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[77], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[86], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[95], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(button[24], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[33], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[42], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[51], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[60], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[69], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[78], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[87], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[96], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(button[25], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[34], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[43], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[52], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[61], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[70], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[79], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[88], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[97], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(button[26], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[35], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[44], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[53], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[62], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[71], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[80], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[89], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[98], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(button[27], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[36], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[45], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[54], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[63], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[72], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[81], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[90], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(button[99], GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
									.addComponent(listPlayer, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSwifty)
							.addGap(857)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(listRanking, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnUsername, 0, 0, Short.MAX_VALUE)
							.addComponent(lblRanking, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))
					.addGap(37))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSwifty, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(btnUsername, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTime, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblPlayer, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
									.addComponent(lblFind, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPlayerList, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblRanking, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblP, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(listPlayer, GroupLayout.PREFERRED_SIZE, 518, GroupLayout.PREFERRED_SIZE)
										.addComponent(listRanking, GroupLayout.PREFERRED_SIZE, 518, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(button[6], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
														.addComponent(button[7], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
												.addComponent(button[5], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
												.addComponent(button[4], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
												.addComponent(button[3], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
												.addComponent(button[2], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
												.addComponent(button[1], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
												.addComponent(button[0], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(20)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(button[8], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
												.addComponent(button[9], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(button[10], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[19], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[28], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[37], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[46], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[55], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[64], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[73], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[82], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[91], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(button[11], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[20], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[29], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[38], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[47], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[56], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[65], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[74], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[83], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[92], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(button[12], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[21], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[30], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[39], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[48], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[57], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[66], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[75], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[84], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[93], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(button[13], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[22], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[31], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[40], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[49], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[58], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[67], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[76], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[85], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[94], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(button[14], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[23], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[32], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[41], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[50], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[59], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[68], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[77], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[86], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[95], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(button[15], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[24], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[33], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[42], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[51], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[60], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[69], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[78], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[87], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[96], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(button[16], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[25], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[34], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[43], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[52], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[61], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[70], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[79], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[88], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[97], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(button[17], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[26], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[35], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[44], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[53], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[62], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[71], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[80], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[89], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[98], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(button[99], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[90], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[81], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[72], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[63], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[54], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[45], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[36], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[27], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[18], GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
