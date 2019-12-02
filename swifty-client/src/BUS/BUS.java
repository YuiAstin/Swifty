package BUS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import GUI.Square10;
import main.*;


public class BUS {

	public static void sendNumber(DataOutputStream dos, String a, String nextNum, String Remain, String id, int point,long timeStart, int configTime) {
		// TODO Auto-generated method stub
		try {
			String result ="{\n"
				    +"\"Type\": \"MatchUpdate\",\n"
					+"\"player ID\": \""+id+"\",\n"
					+"\"TimeStart\": "+timeStart+",\n"
					+"\"Time\": "+configTime+",\n"
				    +"\"fieldUpdate\": "+a+",\n"
				    +"\"Point\": "+point+",\n"
				    +"\"NextNumber\": "+nextNum+",\n"
				    +"\"RemainNumber\": "+Remain+"\n"
				+"}";
			result = Encryption.Encrypt(result);
			dos.writeUTF(result);
			if (Integer.parseInt(Remain) < 1) { //Endgame
				sendEndGame(dos,id,null);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void sendEndGame(DataOutputStream dos, String player_id, String reason) throws IOException {
		reason = reason==null ? "EndGame" : reason;
		String result ="{\n"
			    +"\"Type\": \"EndGame\",\n"
				+"\"player ID\": \""+player_id+"\",\n"
				+"\"reason\": \""+reason+"\"\n"
				+"}";
		result = Encryption.Encrypt(result);
		dos.writeUTF(result);
	}
	
	public static void get_rankingList(DataOutputStream dos)
	{
		
		try {
			String result ="{\"Type\": \"Ranking Request\"}";
			result = Encryption.Encrypt(result);
			dos.writeUTF(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void get_playerList(DataOutputStream dos)
	{
		try {
			String result ="{\"Type\": \"Player List Request\"}";
			result = Encryption.Encrypt(result);
			dos.writeUTF(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sendSimpleRequest(DataOutputStream dos, String type, String playerID)
	{
		try {
			String data ="{\n"
				    +"\"Type\": \""+type+"\",\n"
					+"\"player ID\": \""+playerID+"\"\n"
					+"}";
			data = Encryption.Encrypt(data);
			dos.writeUTF(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public static JSONObject startGame()
//	{
//		try {
//			String result ="{\n" + 
//					"    \"Type\": \"Create room\",\n" + 
//					"    \"player ID\": "+Client.player.getInt("player ID")+"\n" + 					 
//					"}";
//			DataOutputStream dos = new DataOutputStream(Client.socket.getOutputStream());
//			dos.writeUTF(result);
//			DataInputStream dis = new DataInputStream(Client.socket.getInputStream());
//			result = dis.readUTF();
//			JSONObject obj = new JSONObject(result);
//			return obj;
//		} catch (JSONException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	}

	public static void get_onlineList(DataOutputStream dos) {
		// TODO Auto-generated method stub
		try {
			String result ="{\"Type\": \"Online List Request\"}";
			result = Encryption.Encrypt(result);
			dos.writeUTF(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
