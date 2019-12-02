package BUS;

import java.io.IOException;
import java.util.Map.Entry;

import org.json.JSONException;
import org.json.JSONObject;

import DAL.database;
import main.server;

public class UpdateMatch {
	public String S_updateMatch(JSONObject obj)
	{		  
		String result="\"Error code\": \"Er2\",\n";
		try {
			result = "{/n"
					+ "\"Type\": \"MatchUdate\",\n"
					+ "\"fieldUpdate\": "+obj.getInt("fieldUpdate")+",\n";
			return result;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
		
	}
	public static String R_updateMatch(JSONObject obj, database a) throws JSONException, IOException
	{
		String playerID= obj.getString("player ID");
		int roomID = server.Lobby.get(playerID);
		int battleTime = obj.getInt("Time");
		// Validate number
		int submitNumber = obj.getInt("fieldUpdate");
		int curFindNumber = server.Room.get(roomID);
		if (submitNumber != curFindNumber) {
			return "{\n"				 		
		 			+ "\"Errorcode\": \"Er1\",\n"// Er1 = wrong number
		 			+ "\"Type\": \"UpdateMatch\"\n"
		 			+ "}";
		}
		
		int nextNumber = obj.getInt("NextNumber");
		int remain = obj.getInt("RemainNumber");
		String result = "{\n"				 		
	 			+ "\"Errorcode\": \"Er0\",\n"// Er1 = cannot get setting from db
	 			+ "\"Type\": \"UpdateMatch\",\n"
	 			+ "\"FoundNumber\": "+submitNumber+",\n"
	 			+ "\"NextNumber\": "+nextNumber+",\n"
	 			+ "\"Time\": \""+(battleTime-(System.currentTimeMillis()-obj.getLong("TimeStart"))/1000)+"\",\n"
	 			+ "\"RemainNumber\": "+remain+"\n"
	 			+ "}";
		//Update next number
		server.Room.replace(roomID, nextNumber);
		// Update point
		server.Point.replace(playerID, server.Point.get(playerID) + obj.getInt("Point"));
		// Update new number
		for (Entry<String, Integer> room : server.Lobby.entrySet()) {
			if (room.getValue() == roomID) { // Player in room
				server.Player.get(room.getKey()).writeUTF(Encryption.Encrypt(result));
			}
		}
		
		return result;
	}
	public static int LuckNumber() {
		long tim = System.currentTimeMillis();
		return tim%10==0? 1 : 0;
	}
}
