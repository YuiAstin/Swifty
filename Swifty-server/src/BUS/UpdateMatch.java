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
		int nextNumber = obj.getInt("fieldUpdate");
		String result = "{\n"				 		
	 			+ "\"Errorcode\": \"Er0\",\n"// Er1 = cannot get setting from db
	 			+ "\"Type\": \"UpdateMatch\",\n"
	 			+ "\"NextNumber\": "+nextNumber+",\n"
	 			+ "\"Point\": "+(1+LuckNumber())+"\n"
	 			+ "}";
		
		server.Point.replace(playerID, server.Point.get(playerID) + obj.getInt("Point")); // Update point
		for (Entry<String, Integer> room : server.Lobby.entrySet()) {	// Update new number
			if (room.getValue() == roomID) { // Player in room
				server.Player.get(room.getKey()).writeUTF(result);
			}
		}
		
		return "\"Errorcode\": \"Er0\"";
	}
	public static int LuckNumber() {
		long tim = System.currentTimeMillis();
		return tim%10==0? 1 : 0;
	}
}
