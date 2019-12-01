package BUS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import main.*;


public class BUS {

	public static void sendNumber(DataOutputStream dos, String a) {
		// TODO Auto-generated method stub
		try {
			String result ="{\n"
				    +"\"Type\": \"MatchUpdate\",\n"
					+"\"player ID\": "+Client.player.getInt("player ID")+",\n"
				    +"\"fieldUpdate\": "+a+",\n"
				    +"\"Point\": "+1+"\n"
				+"}";
			dos.writeUTF(result);
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static JSONArray get_rankingList()
	{
		
		try {
			String result ="{\"Type\": \"Ranking Request\"}";
			DataOutputStream dos = new DataOutputStream(Client.socket.getOutputStream());
			dos.writeUTF(result);
			DataInputStream dis = new DataInputStream(Client.socket.getInputStream());
			result = dis.readUTF();
			JSONObject obj = new JSONObject(result);
			return obj.getJSONArray("Player");
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static JSONArray get_playerList()
	{
		
		try {
			String result ="{\"Type\": \"Player List Request\"}";
			DataOutputStream dos = new DataOutputStream(Client.socket.getOutputStream());
			dos.writeUTF(result);
			DataInputStream dis = new DataInputStream(Client.socket.getInputStream());
			result = dis.readUTF();
			JSONObject obj = new JSONObject(result);
			return obj.getJSONArray("Player");
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static JSONObject startGame()
	{
		try {
			String result ="{\n" + 
					"    \"Type\": \"Create room\",\n" + 
					"    \"player ID\": "+Client.player.getInt("player ID")+"\n" + 					 
					"}";
			DataOutputStream dos = new DataOutputStream(Client.socket.getOutputStream());
			dos.writeUTF(result);
			DataInputStream dis = new DataInputStream(Client.socket.getInputStream());
			result = dis.readUTF();
			JSONObject obj = new JSONObject(result);
			return obj;
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
