package BUS;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONWriter;
import DAL.database;

public class start {

	private ServerSocket serverSocket = null;
	private Socket socket = null;
	
	public start ()
	{
			try {
				// open socket
				System.out.println("Server started at port 5000");
				serverSocket = new ServerSocket(5000);
				// processing input from client
				String data = "",command = "",key = "country";
				JSONObject jOb = new JSONObject();
				JSONWriter jwrite = new JSONStringer(); 
				socket = serverSocket.accept();
				System.out.println("Client " + socket.getRemoteSocketAddress() + " accepted");
				
				// input & output stream			
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				data="";
				while(true)
				{
					String temp = dis.readUTF();
					try {
						JSONObject obu = new JSONObject(temp);
						
						
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						dos.writeUTF("Er999");
					} 
				}
				
			} catch (IOException ex) {
				System.out.println("Error: " + ex);
			}
	}
	static public void main(String[] args)
	{
		database a = new database();
		a.initConnection();
		a.get_matchsetting();
	}
}


