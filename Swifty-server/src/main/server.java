package main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONWriter;

import BUS.Controller;
import BUS.Encryption;
import DAL.database;

public class server extends Thread{

	private ServerSocket serverSocket = null;
	private Socket socket = null;
	public static HashMap<String, Integer> Lobby = new HashMap<String,Integer>(); // PlayerID - ID_room
	public static HashMap<Integer, Integer> Room = new HashMap<Integer, Integer>(); // ID_room - FindingNumber
	public static HashMap<String, DataOutputStream> Player = new HashMap<String,DataOutputStream>(); // PlayerID - socket
	public static HashMap<String, Integer> Point = new HashMap<String,Integer>(); // PlayerID - Match point
	public static HashMap<Socket, DataOutputStream> Client = new HashMap<Socket, DataOutputStream>(); // Socket - DataOutputStream
	
	public server(Socket socket)
	{
		this.socket = socket;
	}
	
	public server() {
	}
	
	public void start_server ()
	{
			try {
				// open socket				
				String data = "";
				JSONObject jOb = new JSONObject();
				JSONWriter jwrite = new JSONStringer(); 
				System.out.println("Client " + socket.getRemoteSocketAddress() + " accepted");
				database a = new database();
				a.initConnection();
				// input & output stream			
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				data="";
			
				Client.put(socket, dos);
				long mainTime = System.currentTimeMillis()/1000;		
				while(true)
				{
					String temp = dis.readUTF();
					temp = Encryption.Decrypt(temp);
					System.out.println("-----------------------------");
					System.out.println("Server receive:\n" + temp);
					try {
						JSONObject obj = new JSONObject(temp);						
						data = Controller.Enroute(obj, a, dos);
						data = Encryption.Encrypt(data);
						dos.writeUTF(data);
						
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						dos.writeUTF("Er999");
					} 
				}
				
			} catch (IOException ex) {
				System.out.println("Client " + socket.getRemoteSocketAddress() + " Disconnected");
				String playerID = "";
				for (Entry<String, DataOutputStream> player : server.Player.entrySet()) {
					if (player.getValue().equals(Client.get(socket))) {
						playerID = player.getKey();
					}
				}
				
				// Other player get win
				int roomID = server.Lobby.get(playerID);
				if (roomID > -1) {
					database a2 = new database();
					a2.initConnection();
					for (Entry<String, Integer> lobby : server.Lobby.entrySet()) {
						if (lobby.getValue() == roomID) {
							if (!lobby.getKey().equals(playerID)) { // Other player
								Lobby.replace(lobby.getKey(), -1);
								a2.recordMatch(Integer.parseInt(lobby.getKey()));
								String mess ="{\n"
									    +"\"Type\": \"EndGame\",\n"
									    +"\"Errorcode\": \"Er0\",\n"
									    +"\"Result\": \"Win\",\n"
										+"\"player ID\": \""+lobby.getKey()+"\"\n" // Win player
										+"}";
								try {
									Player.get(lobby.getKey()).writeUTF(mess);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
				}
				
				
				Lobby.remove(playerID);
				Player.remove(playerID);
				Point.remove(playerID);
				Client.remove(socket);
			}
	}
	public void run()
	{
		start_server();
	}
	static public void main(String[] args)
	{

//		ServerSocket serverSocket = null;
//        Socket socket = null;
//
//        try {
//            serverSocket = new ServerSocket(5000);
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//        while (true) {
//            try {
//                socket = serverSocket.accept();
//            } catch (IOException e) {
//                System.out.println("I/O error: " + e);
//            }
//            // new thread for a client
//            new server(socket).start();
//        }
		database a = new database();
		a.initConnection();

		ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(5000);
        } catch (IOException e) {
            e.printStackTrace();

        }
        while (true) {
            try {
                socket = serverSocket.accept();
        		
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            // new thread for a client
            new server(socket).start();
        }			

	}
}


