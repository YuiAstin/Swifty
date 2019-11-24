package main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONWriter;

import BUS.Controller;
import DAL.database;

public class server extends Thread{

	private ServerSocket serverSocket = null;
	private Socket socket = null;
	public static HashMap<String,Integer> Lobby = new HashMap<String,Integer>();
	
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
				while(true)
				{
					String temp = dis.readUTF();
					try {
						JSONObject obj = new JSONObject(temp);
						data = Controller.Enroute(obj, a);
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
//		server b = new server();
//		b.start_server();

		ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(5050);
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
		
		

		//Test Register func
//		JSONObject obj=null;
//		try {
//			obj = new JSONObject("{\n"
//					+ "\"Type\": New,\n"				 		
//			 		+ "\"Errorcode\": \"Er0\",\n"
//			 		+ "\"player ID\": \"new\",\n"				 		
//			 		+ "\"Username\": \"yon\",\n"
//			 		+ "\"Password\": \"san\",\n"
//			 		+ "\"FnameLname\": \"san\",\n"
//			 		+ "\"Gender\": 0,\n"
//			 		+ "\"Birthday\": \"1999/1/1\"\n"
//			 		+ "}");
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		a.set_registerPlayer(obj);

	}
}


