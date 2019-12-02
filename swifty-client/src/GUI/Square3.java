package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.lang.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import BUS.BUS;
import BUS.Encryption;

import javax.swing.DefaultListCellRenderer;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Square3 extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JList listPlayer;
	private JList listRanking;
	private JButton btnStart;
	private JButton btnUsername;
	private EditProfile prof;
	private JSONObject user = null;
	private JSONObject match = null;
	private JButton button[];
	private ArrayList<Integer> number;
	private ArrayList<Integer> remainNumber;
	private ArrayList<String> playerList;
	private ArrayList<String> onlineList;
	private ArrayList<String> rankingList;
	private Timer t;
	private Timer game_status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Square3 frame = new Square3(null,null,null);
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
	 * @throws JSONException 
	 */
	public Square3(DataInputStream dis, DataOutputStream dos, JSONObject user) throws JSONException {
		getContentPane().setBackground(new Color(0, 0, 51));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 700);
		
		if (user != null) this.user = user;
		
		prof = new EditProfile(dis, dos);
		prof.setVisible(false);
		
		JLabel lblSwifty = new JLabel("SWIFTY");
		lblSwifty.setForeground(SystemColor.textHighlight);
		lblSwifty.setFont(new Font("OCR A Extended", Font.BOLD, 58));
		
		btnUsername = new JButton(this.user == null ? "Username" : this.user.getString("Username"));
		btnUsername.setFont(new Font("Arial", Font.BOLD, 17));
		btnUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String func = btnUsername.getText();
					switch (func) {
						case "Quit": {
							BUS.sendEndGame(dos, Square3.this.user.getInt("player ID")+"","Quit");
							break;
						}
						default: { //Edit profile
							// Edit information
							setVisible(false);
							prof.mainFrame(Square3.this);
							prof.user(Square3.this.user);
							prof.loadProfile();
							prof.setVisible(true);
							break;
						}
					}} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		btnStart = new JButton("Start Game");
        btnStart.setText("Match");
        btnStart.setBounds(250,80,250,80);
        btnStart.setLocation(350,10);
        btnStart.setVisible(true);
        btnStart.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 24));
        add(btnStart);
		
		JLabel lblFind = new JLabel("FIND");
		lblFind.setForeground(SystemColor.textHighlight);
		lblFind.setFont(new Font("Arial", Font.BOLD, 25));
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setEnabled(false);
		textField.setForeground(SystemColor.BLACK);
		
		JLabel lblPlayer = new JLabel("P1:");
		lblPlayer.setForeground(SystemColor.textHighlight);
		lblPlayer.setFont(new Font("Arial", Font.BOLD, 25));
		
		JLabel lblP = new JLabel("P2:");
		lblP.setForeground(SystemColor.textHighlight);
		lblP.setFont(new Font("Arial", Font.BOLD, 25));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setEnabled(false);
		textField_1.setForeground(SystemColor.BLACK);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setEnabled(false);
		textField_2.setForeground(SystemColor.BLACK);
		
		JLabel lblTime = new JLabel("TIME:");
		lblTime.setForeground(SystemColor.textHighlight);
		lblTime.setFont(new Font("Arial", Font.BOLD, 25));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		listPlayer = new JList();
		listRanking = new JList();
		
		
		listPlayer.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index,
                      boolean isSelected, boolean cellHasFocus) {
                 Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                 
                 if (Square3.this.playerList == null || Square3.this.playerList.size() < 1) return c;
                 String nextUser = value.toString();
                 setText(nextUser);
                 if (Square3.this.onlineList == null || Square3.this.onlineList.size() < 1) return c;
                 if (Square3.this.onlineList.contains(nextUser)) setBackground(Color.GREEN);
                 else setBackground(Color.WHITE);
                 if (isSelected) setBackground(getBackground().darker());
                 return c;
            }
		});
		
		listRanking.setCellRenderer(new DefaultListCellRenderer() {
			@Override
            public Component getListCellRendererComponent(JList list, Object value, int index,
                      boolean isSelected, boolean cellHasFocus) {
                 Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                 setBackground(Color.WHITE);
                 if (Square3.this.rankingList == null || Square3.this.rankingList.size() < 1) return c;
                 String nextUser = value.toString();
                 setText(nextUser);
                 try {
					if (nextUser.equals(Square3.this.user.getString("Username"))) setBackground(Color.YELLOW);
                 } catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
                 }
                 if (isSelected) setBackground(getBackground().darker());
                 return c;
            }
		});
		
		JLabel lblPlayerList = new JLabel("PLAYER LIST");
		lblPlayerList.setForeground(SystemColor.textHighlight);
		lblPlayerList.setFont(new Font("Arial", Font.BOLD, 25));
		
		JLabel lblRanking = new JLabel("RANKING");
		lblRanking.setForeground(SystemColor.textHighlight);
		lblRanking.setFont(new Font("Arial", Font.BOLD, 25));
		
		int SquareNum = 9;
		this.button = new JButton[SquareNum];
		this.number = new ArrayList<>();
		
		for (int i = 0; i<button.length; i++)
		{
			/* Title for button */
			this.number.add(i+1);
			button[i] = new JButton("X");
			final int j = i;
			/* Event for button */
			button[i].addActionListener((ActionListener) new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						if (textField_3.getText().isBlank()) return;
						if (Time2Seconds(textField_3.getText()) == 0) return;
						int findVal = Square3.this.match.getInt("NextNumber");
						String btnVal = String.valueOf(Square3.this.number.get(j));
						if (findVal == Integer.parseInt(btnVal)) {
							Square3.this.remainNumber.remove(new Integer(btnVal));
							int remain = Square3.this.remainNumber.size();
							int nextNum = findVal;
							if (remain > 0) {
								Collections.shuffle(Square3.this.remainNumber);
								nextNum = Square3.this.remainNumber.get(0);
							}
							
							int point = 1;
							JSONArray a = Square3.this.match.getJSONArray("SpedupNum");
							for (int k=0;k<a.length();k++) {
								if (Integer.parseInt(a.get(k).toString()) == findVal) {
									point++;
									break;
								}
							}
							
							String playerID = Square3.this.user.getString("player ID");
							long timeStart = Square3.this.match.getLong("TimeStart");
							int timeConfig = Square3.this.match.getInt("configTime");
							BUS.sendNumber(dos, btnVal, nextNum+"", remain+"", playerID, point, timeStart, timeConfig);
						}
						else {
							JOptionPane.showMessageDialog(null, "Ahhhh! Wrong number!!!", "Wrong",JOptionPane.ERROR_MESSAGE);
						}
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
		}
		
		btnStart.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String func = btnStart.getText();
					switch (func) {
						case "Match": {
							btnStart.setText("Matching...");
							btnStart.setEnabled(false);
							btnUsername.setEnabled(false);
							BUS.sendSimpleRequest(dos, "Join room",Square3.this.user.getString("player ID"));
							break;
						}
						case "Start Game": {
							BUS.sendSimpleRequest(dos, "StartGame",Square3.this.user.getString("player ID"));
							break;
						}
						default: {
							JOptionPane.showMessageDialog(null, "Somthing went wrong!", "Error",JOptionPane.ERROR_MESSAGE);
							break;
						}
					}
					
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		if (!(this.user == null)) {
			initInfor(dis,dos);
			Thread handleRespond = clientListener(dis,dos);
			handleRespond.start();	
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
	public void user(JSONObject user) {
		this.user = user;
	}
	private void initInfor(DataInputStream dis, DataOutputStream dos) {
		BUS.get_playerList(dos);
		BUS.get_rankingList(dos);
		BUS.get_onlineList(dos);
		Square3.this.game_status = new Timer(60000, new ActionListener() {	
    		public void actionPerformed(ActionEvent e) {	
    			// Do the task here	
    			BUS.get_playerList(dos);	
    			BUS.get_rankingList(dos);	
    			BUS.get_onlineList(dos);	
		    }	
		});	
		Square3.this.game_status.start();
	}
	private Thread clientListener(DataInputStream dis, DataOutputStream dos) {
		// readMessage thread 
        Thread readMessage = new Thread(new Runnable()  
        { 
            @Override
            public void run() { 
  
                while (true) { 
                    try { 
                        // read the message sent to this client 
                        String msg = dis.readUTF();
                        msg = Encryption.Decrypt(msg);
                        JSONObject obj = new JSONObject(msg);
                        System.out.println(msg); 
                        if (!obj.has("Type")) continue;
                        switch (obj.getString("Type")) {
	                        case "Player List": {
	                			Square3.this.playerList = json2Array(obj.getJSONArray("Player"));
	                			Square3.this.listPlayer.setListData(Square3.this.playerList.toArray());
	                			Square3.this.listPlayer.updateUI();
	                        	break;
	                        }
							case "Ranking List": {
								Square3.this.rankingList = json2Array(obj.getJSONArray("Player"));
								Square3.this.listRanking.setListData(Square3.this.rankingList.toArray());
								Square3.this.listRanking.updateUI();
								break;
							}
							case "Online List": {
								Square3.this.onlineList = json2Array(obj.getJSONArray("Player"));
								Square3.this.listPlayer.updateUI();
								break;
							}
							case "EditProfile": {
								if (obj.has("Errorcode") && obj.getString("Errorcode").equals("Er0")) { //Success
									JOptionPane.showMessageDialog(null, "Updated!", "Success",JOptionPane.INFORMATION_MESSAGE);
									Square3.this.prof.user(obj);
									Square3.this.prof.loadProfile();
								}
								else {
									JOptionPane.showMessageDialog(null, "Something went wrong!", "Error",JOptionPane.ERROR_MESSAGE);
									
								}
								break;
							}
	                        case "UpdateMatch": {
	                        	if (obj.getString("Errorcode").equals("Er1")) break;
	                        	
	                        	int FoundNumber = obj.getInt("FoundNumber");
                    			for (int i=0;i<Square3.this.button.length;i++) {
                    				if (Integer.parseInt(Square3.this.button[i].getText()) == FoundNumber) {
                    					Square3.this.button[i].setEnabled(false);
                    				}
                    			}
                    			Square3.this.remainNumber.remove(new Integer(FoundNumber));
                    			
	                        	int number = obj.getInt("NextNumber");
	                        	int time = obj.getInt("Time");
	                        	textField_3.setText(TimerFormat(time));
	                        	Square3.this.match.put("NextNumber", number);
	                        	UpdateMatch();
	                        }
	                        case "CreateRoom": {
	                        	textField_1.setText(Square3.this.user.getString("Username"));
	                        	break;
	                        }
	                        case "JoinRoom": {
	                        	textField_1.setText(obj.getString("player1 Name"));
	                        	textField_2.setText(obj.getString("player2 Name"));
	                        	btnStart.setText("Start Game");
	                        	btnStart.setEnabled(true);
	                        	
	                        	if (!obj.getString("player1 Name").equals(user.getString("Username"))) {
	                        		btnStart.setVisible(false);
	                        	}
	                        	JOptionPane.showMessageDialog(null, "Enjoy the game", "Fighting!!!",JOptionPane.INFORMATION_MESSAGE);
	                        	
	                        	break;
	                        }
	                        case "StartGame": {
	                        	Square3.this.match = obj;
	                        	Square3.this.t = new Timer(1000, new ActionListener() {
	                        		public void actionPerformed(ActionEvent e) {
	                        			// Do the task here
	                        			int battleTime = 210;
	                        			try {
											battleTime = Square3.this.match.getInt("Time");
										} catch (JSONException e2) {
											// TODO Auto-generated catch block
											e2.printStackTrace();
										}
	                        			String curTime = textField_3.getText();
	                        			int timeSetInSeconds = curTime.isBlank() ? battleTime : Time2Seconds(curTime);
	                        			
	                        			String timeSet = TimerFormat(timeSetInSeconds-1);
	                        			textField_3.setText(timeSet);
	                        			if((timeSetInSeconds-1) == 0){// Endgame
	                        				textField_3.setText(null);
	                        				try {
												BUS.sendEndGame(dos, Square3.this.user.getInt("player ID")+"",null);
											} catch (IOException | JSONException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
	                        				Square3.this.t.stop();
                        			    }
                        		    }
                        		});
                        		t.start();
                        		StartGame();
	                        	UpdateMatch();
	                        	break;
	                        }
	                        case "EndGame": {
	                        	if (btnStart.getText().equals("Match")) break;
	                        	if (obj.getString("Result").equals("Win")) {
	                        		if (obj.getString("player ID").equals(Square3.this.user.getString("player ID"))) {
	                        			JOptionPane.showMessageDialog(null, "You're the winner!", "Congratulations!!!",JOptionPane.INFORMATION_MESSAGE);
	                        		} else {
	                        			JOptionPane.showMessageDialog(null, "Loser!", "Boo!!!",JOptionPane.INFORMATION_MESSAGE);
	                        		}
	                        	}
	                        	else {
	                        		JOptionPane.showMessageDialog(null, "Tie!", "Tie!!!",JOptionPane.INFORMATION_MESSAGE);
	                        	}
	                        	
	                        	if (t.isRunning()) t.stop();
	                        	
	                        	btnStart.setText("Match");
	                        	btnStart.setEnabled(true);
	                        	btnStart.setVisible(true);
	                        	
	                        	btnUsername.setText(Square3.this.user.getString("Username"));
	                        	btnUsername.setEnabled(true);
	                        	
	                        	textField.setText(null);
	                        	textField_1.setText(null);
	                        	textField_2.setText(null);
	                        	textField_3.setText(null);
	                        	
	                        	for (int i=0;i<Square3.this.button.length;i++) {
	                        		Square3.this.button[i].setText("X");
	                        		Square3.this.button[i].setEnabled(true);
	                        	}

	                        	break;
	                        }
	                        default: {
	                        	break;
	                        }
                        }
                        
                    } catch (Exception e) { 
  
                        e.printStackTrace(); 
                    } 
                } 
            } 
        });
        return readMessage;
	}

	public void StartGame() throws IOException, JSONException {
		btnStart.setText("Fighting...(>_<)");
		btnStart.setEnabled(false);
		btnStart.setVisible(true);
		
		btnUsername.setText("Quit");
    	btnUsername.setEnabled(true);
		Collections.shuffle(this.number);
		this.remainNumber = new ArrayList<Integer>(this.number);
		// Get match infor from server --todo later
		for (int i = 0; i<this.button.length; i++) {
			this.button[i].setText(this.number.get(i).toString());
			this.button[i].setEnabled(true);
		}
//		Thread sendMessage = new Thread(new Runnable()  
//        { 
//            @Override
//            public void run() { 
//                while (true) { 
//  
//                    // read the message to deliver. 
//                    String msg = scn.nextLine(); 
//                      
//                    try { 
//                        // write on the output stream 
//                        dos.writeUTF(msg); 
//                    } catch (IOException e) { 
//                        e.printStackTrace(); 
//                    } 
//                } 
//            } 
//        });
	}
	
	public void  UpdateMatch() throws JSONException {
		int number = this.match.getInt("NextNumber");
		textField.setBackground(SystemColor.WHITE);
		JSONArray a = this.match.getJSONArray("SpedupNum");
		for (int i=0;i<a.length();i++) {
			if (Integer.parseInt(a.get(i).toString()) == number) {
				textField.setBackground(SystemColor.RED);
			}
		}
		textField.setText(number+"");
	}
	public String TimerFormat(int seconds) {
		LocalTime timeOfDay = LocalTime.ofSecondOfDay(seconds);
		String time = timeOfDay.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
//		System.out.println(time);
		String time_formated = time.substring(3);
		return time_formated;
	}
	public int Time2Seconds(String time) {
		int minutes = Integer.parseInt(time.substring(0,2));
		int seconds = Integer.parseInt(time.substring(3,time.length()));
		return (minutes*60 + seconds);
	}
	public ArrayList<String> json2Array(JSONArray a) throws JSONException{
		ArrayList<String> result = new ArrayList<String>();
		for (int i=0;i<a.length();i++) {
			result.add(a.get(i).toString());
		}
		return result;
	}
}
