package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.lang.*;
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

public class Square3 extends JFrame {
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
					Square3 frame = new Square3(null,null);
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
	public Square3(DataInputStream dis, DataOutputStream dos) {
		getContentPane().setBackground(new Color(0, 0, 51));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 700);
		
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
		
		int SquareNum = 9; 
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
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(button[4], GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(button[7], GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(button[3], GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(button[5], GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblFind, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
										.addComponent(button[0], GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
									.addGap(27)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblPlayer)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblP, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
										.addComponent(button[1], GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblTime)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
									.addComponent(lblPlayerList))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(button[2], GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[6], GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
										.addComponent(button[8], GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
									.addComponent(listPlayer, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSwifty)
							.addGap(857)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnUsername, 0, 0, Short.MAX_VALUE)
						.addComponent(listRanking, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
						.addComponent(lblRanking, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
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
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTime, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblPlayerList, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblRanking, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(listRanking, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE)
										.addComponent(listPlayer, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap(22, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblPlayer, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
									.addComponent(lblFind, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lblP, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(41)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(button[2], GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(button[1], GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(button[0], GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
							.addGap(79)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(button[3], GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(button[5], GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(button[6], GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(button[8], GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(button[4], GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(button[7], GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
							.addGap(26))))
		);
		getContentPane().setLayout(groupLayout);
	}
}
