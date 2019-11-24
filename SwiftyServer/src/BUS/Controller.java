package BUS;

import java.util.HashMap;
import java.util.Map.Entry;

import org.json.JSONException;
import org.json.JSONObject;

import DAL.database;
import main.server;

public class Controller {
	
	static public String Enroute(JSONObject obj, database a)
	{
		try {
			switch(obj.getString("Type"))
			{
//				case "Signin": return a.get_aPlayerInfo(obj.getString("username"));
				case "Signin": return a.signin(obj.getString("Username"), obj.getString("Password"));
				case "Signup": return a.set_registerPlayer(obj);
				case "Win": return a.recordMatch(obj.getInt("player ID"));
				case "Ranking Request": return a.get_rankingArray();
				case "Player List Request": return a.get_playerArray();
				case "Quit": return cleanupRoom(obj.getString("Id_room"));
				case "Logout": return cleanupLobby();
				case "Create room": return createRoom();
				case "Join room": return joinRoom();
				case "MatchUpdate": return UpdateMatch.R_updateMatch(obj.getInt("player_id"), a);
			}
			return "Er4"; // Er4 = Controller error
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Er4"; 
		}
	}

	private static String cleanupLobby() {
		// TODO Auto-generated method stub
		
		return "\"Error code:\" \"Er0\"";
	}

	private static String cleanupRoom(String id_room) {
		// TODO Auto-generated method stub
		int number = server.Lobby.get(id_room);
		if (number > 0) {
			number--;
			server.Lobby.remove(id_room, number);
		}
		else server.Lobby.remove(id_room);
		return "\"Error code:\" \"Er0\"";
	}

	private static String joinRoom() {
		// TODO Auto-generated method stub
		for (Entry<String, Integer> room : server.Lobby.entrySet()) {
	          String id_room = room.getKey();
	          int number = room.getValue();
	          if (number < 10) { //Max player in a room
	        	  server.Lobby.replace(id_room, ++number);
	        	  break;
	          }
	          
        }
		return "\"Error code:\" \"Er0\"";
	}

	private static String createRoom() {
		// TODO Auto-generated method stub
		int id_room = 0;
		for (int i=0;i<=server.Lobby.size();i++) {
			if (server.Lobby.containsKey(i)) continue;
			else {
				server.Lobby.put(i+"", 1);
				break;
			}
		}
		return "\"Error code:\" \"Er0\"";
	}

}
