//package View;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

public class BattleView extends JFrame {
	public BattleView() {
		initComponents();
	}

	private void initComponents() {
		
		label1 = new JLabel();
		button1 = new JButton();
		label2 = new JLabel();
		textField1 = new JTextField();
		panel1 = new JPanel();
		label3 = new JLabel();
		panel3 = new JPanel();
		label6 = new JLabel();
		label7 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		panel2 = new JPanel();
		button2 = new JButton();
		button10 = new JButton();
		button7 = new JButton();
		button18 = new JButton();
		button22 = new JButton();
		button27 = new JButton();
		button32 = new JButton();
		button37 = new JButton();
		button42 = new JButton();
		button47 = new JButton();
		scrollPane1 = new JScrollPane();
		list1 = new JList();
		button4 = new JButton();
		button9 = new JButton();
		button13 = new JButton();
		button19 = new JButton();
		button24 = new JButton();
		button29 = new JButton();
		button33 = new JButton();
		button38 = new JButton();
		button43 = new JButton();
		button44 = new JButton();
		button3 = new JButton();
		button8 = new JButton();
		button14 = new JButton();
		button17 = new JButton();
		button23 = new JButton();
		button28 = new JButton();
		button34 = new JButton();
		button39 = new JButton();
		button48 = new JButton();
		button49 = new JButton();
		button5 = new JButton();
		button11 = new JButton();
		button15 = new JButton();
		button20 = new JButton();
		button25 = new JButton();
		button30 = new JButton();
		button35 = new JButton();
		button40 = new JButton();
		button45 = new JButton();
		button50 = new JButton();
		button6 = new JButton();
		button12 = new JButton();
		button16 = new JButton();
		button21 = new JButton();
		button26 = new JButton();
		button31 = new JButton();
		button36 = new JButton();
		button41 = new JButton();
		button46 = new JButton();
		button51 = new JButton();

		//======== this ========
		setTitle("Swifty - Play & Joy!");
		setForeground(new Color(51, 51, 51));
		setBackground(new Color(51, 51, 51));
		setAlwaysOnTop(true);
		var contentPane = getContentPane();
		contentPane.setLayout(new MigLayout(
			"hidemode 3",
			// columns
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[57,fill]" +
			"[0,fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[0,fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]",
			// rows
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[35]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]"));

		//---- label1 ----
		label1.setText("Swifty");
		label1.setForeground(new Color(0, 153, 204));
		label1.setFont(new Font("Papyrus", Font.BOLD, 40));
		contentPane.add(label1, "cell 0 0 3 14");

		//---- button1 ----
		button1.setText("Username");
		contentPane.add(button1, "cell 27 12 10 2,wmin 100,hmin 30");

		//---- label2 ----
		label2.setText("FIND:");
		label2.setFont(new Font("Tahoma", Font.BOLD, 18));
		label2.setForeground(new Color(0, 153, 204));
		contentPane.add(label2, "cell 0 14 3 1");
		contentPane.add(textField1, "cell 0 14 3 1");

		//======== panel1 ========
		{

			// JFormDesigner evaluation mark
			panel1.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			panel1.setLayout(new MigLayout(
				"hidemode 3",
				// columns
				"[fill]",
				// rows
				"[]"));
		}
		contentPane.add(panel1, "cell 4 14");

		//---- label3 ----
		label3.setText("Player 1");
		label3.setForeground(new Color(0, 153, 204));
		label3.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(label3, "cell 5 14 2 1");

		//======== panel3 ========
		{
			panel3.setLayout(new MigLayout(
				"hidemode 3",
				// columns
				"[fill]",
				// rows
				"[]"));
		}
		contentPane.add(panel3, "cell 8 14");

		//---- label6 ----
		label6.setText("Player 2");
		label6.setForeground(new Color(0, 153, 204));
		label6.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(label6, "cell 10 14 2 1");

		//---- label7 ----
		label7.setText("Player 3");
		label7.setForeground(new Color(0, 153, 204));
		label7.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(label7, "cell 14 14 3 1");

		//---- label4 ----
		label4.setText("Min:Sec");
		label4.setForeground(new Color(0, 153, 204));
		label4.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(label4, "cell 21 14");

		//---- label5 ----
		label5.setText("Player list");
		label5.setForeground(new Color(0, 153, 204));
		label5.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(label5, "cell 28 14");

		//======== panel2 ========
		{
			panel2.setLayout(new MigLayout(
				"hidemode 3",
				// columns
				"[fill]" +
				"[fill]",
				// rows
				"[]" +
				"[]" +
				"[]"));
		}
		contentPane.add(panel2, "cell 31 14");
		contentPane.add(button2, "cell 0 15 1 4,width 50:50,height 50:50");
		contentPane.add(button10, "cell 2 17,width 50:50,height 50:50");
		contentPane.add(button7, "cell 4 17,width 50:50,height 50:50");
		contentPane.add(button18, "cell 6 17,width 50:50,height 50:50");
		contentPane.add(button22, "cell 8 17,width 50:50,height 50:50");
		contentPane.add(button27, "cell 10 17,width 50:50,height 50:50");
		contentPane.add(button32, "cell 12 17,width 50:50,height 50:50");
		contentPane.add(button37, "cell 14 17,width 50:50,height 50:50");
		contentPane.add(button42, "cell 17 17,width 50:50,height 50:50");
		contentPane.add(button47, "cell 20 17,width 50:50,height 50:50");

		//======== scrollPane1 ========
		{
			scrollPane1.setViewportView(list1);
		}
		contentPane.add(scrollPane1, "cell 25 17 11 7,wmin 70,hmin 300");
		contentPane.add(button4, "cell 0 19,width 50:50,height 50:50");
		contentPane.add(button9, "cell 2 19,width 50:50,height 50:50");
		contentPane.add(button13, "cell 4 19,width 50:50,height 50:50");
		contentPane.add(button19, "cell 6 19,width 50:50,height 50:50");
		contentPane.add(button24, "cell 8 19,width 50:50,height 50:50");
		contentPane.add(button29, "cell 10 19,width 50:50,height 50:50");
		contentPane.add(button33, "cell 12 19,width 50:50,height 50:50");
		contentPane.add(button38, "cell 14 19,width 50:50,height 50:50");
		contentPane.add(button43, "cell 17 19,width 50:50,height 50:50");
		contentPane.add(button44, "cell 20 19,width 50:50,height 50:50");
		contentPane.add(button3, "cell 0 21,width 50:50,height 50:50");
		contentPane.add(button8, "cell 2 21,width 50:50,height 50:50");
		contentPane.add(button14, "cell 4 21,width 50:50,height 50:50");
		contentPane.add(button17, "cell 6 21,width 50:50,height 50:50");
		contentPane.add(button23, "cell 8 21,width 50:50,height 50:50");
		contentPane.add(button28, "cell 10 21,width 50:50,height 50:50");
		contentPane.add(button34, "cell 12 21,width 50:50,height 50:50");
		contentPane.add(button39, "cell 14 21,width 50:50,height 50:50");
		contentPane.add(button48, "cell 17 21,width 50:50,height 50:50");
		contentPane.add(button49, "cell 20 21,width 50:50,height 50:50");
		contentPane.add(button5, "cell 0 22,width 50:50,height 50:50");
		contentPane.add(button11, "cell 2 22,width 50:50,height 50:50");
		contentPane.add(button15, "cell 4 22,width 50:50,height 50:50");
		contentPane.add(button20, "cell 6 22,width 50:50,height 50:50");
		contentPane.add(button25, "cell 8 22,width 50:50,height 50:50");
		contentPane.add(button30, "cell 10 22,width 50:50,height 50:50");
		contentPane.add(button35, "cell 12 22,width 50:50,height 50:50");
		contentPane.add(button40, "cell 14 22,width 50:50,height 50:50");
		contentPane.add(button45, "cell 17 22,width 50:50,height 50:50");
		contentPane.add(button50, "cell 20 22,width 50:50,height 50:50");
		contentPane.add(button6, "cell 0 23,width 50:50,height 50:50");
		contentPane.add(button12, "cell 2 23,width 50:50,height 50:50");
		contentPane.add(button16, "cell 4 23,width 50:50,height 50:50");
		contentPane.add(button21, "cell 6 23,width 50:50,height 50:50");
		contentPane.add(button26, "cell 8 23,width 50:50,height 50:50");
		contentPane.add(button31, "cell 10 23,width 50:50,height 50:50");
		contentPane.add(button36, "cell 12 23,width 50:50,height 50:50");
		contentPane.add(button41, "cell 14 23,width 50:50,height 50:50");
		contentPane.add(button46, "cell 17 23,width 50:50,height 50:50");
		contentPane.add(button51, "cell 20 23,width 50:50,height 50:50");
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Vo Hong Son
	private JLabel label1;
	private JButton button1;
	private JLabel label2;
	private JTextField textField1;
	private JPanel panel1;
	private JLabel label3;
	private JPanel panel3;
	private JLabel label6;
	private JLabel label7;
	private JLabel label4;
	private JLabel label5;
	private JPanel panel2;
	private JButton button2;
	private JButton button10;
	private JButton button7;
	private JButton button18;
	private JButton button22;
	private JButton button27;
	private JButton button32;
	private JButton button37;
	private JButton button42;
	private JButton button47;
	private JScrollPane scrollPane1;
	private JList list1;
	private JButton button4;
	private JButton button9;
	private JButton button13;
	private JButton button19;
	private JButton button24;
	private JButton button29;
	private JButton button33;
	private JButton button38;
	private JButton button43;
	private JButton button44;
	private JButton button3;
	private JButton button8;
	private JButton button14;
	private JButton button17;
	private JButton button23;
	private JButton button28;
	private JButton button34;
	private JButton button39;
	private JButton button48;
	private JButton button49;
	private JButton button5;
	private JButton button11;
	private JButton button15;
	private JButton button20;
	private JButton button25;
	private JButton button30;
	private JButton button35;
	private JButton button40;
	private JButton button45;
	private JButton button50;
	private JButton button6;
	private JButton button12;
	private JButton button16;
	private JButton button21;
	private JButton button26;
	private JButton button31;
	private JButton button36;
	private JButton button41;
	private JButton button46;
	private JButton button51;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
}
