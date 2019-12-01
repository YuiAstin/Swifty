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
	public static HashMap<Integer, ArrayList<Integer>> Room = new HashMap<Integer, ArrayList<Integer>>(); // ID_room - Number - IsLucky
	public static HashMap<String, DataOutputStream> Player = new HashMap<String,DataOutputStream>(); // PlayerID - socket
	public static HashMap<String, Integer> Point = new HashMap<String,Integer>(); // PlayerID - Match point
	
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


