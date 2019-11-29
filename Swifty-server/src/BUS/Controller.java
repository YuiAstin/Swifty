package BUS;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import org.json.JSONException;
import org.json.JSONObject;

import DAL.database;
import main.server;

public class Controller {
	
	static public String Enroute(JSONObject obj, database a, DataOutputStream dos) throws IOException
	{
		try {
			switch(obj.getString("Type"))
			{
//				case "Signin": return a.get_aPlayerInfo(obj.getString("username"));
				case "Signin": return a.signin(obj.getString("Username"), obj.getString("Password"), dos);
				case "Signup": return a.set_registerPlayer(obj);
				case "Win": return a.recordMatch(obj.getInt("player ID"));
				case "Ranking Request": return a.get_rankingArray();
				case "Player List Request": return a.get_playerArray();
				case "Quit": return cleanupRoom(obj); // Out room
				case "Logout": return cleanupLobby(obj); // Logout
				case "Create room": return createRoom(obj);
				case "Join room": return joinRoom(obj); // Quick match -- Create new room if no empty room
				case "MatchUpdate": return UpdateMatch.R_updateMatch(obj, a);
				case "StartGame": return StartGame(obj,a);
			}
			return "Er4"; // Er4 = Controller error
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Er4"; 
		}
	}

	private static String StartGame(JSONObject obj, database a) throws JSONException {
		// TODO Auto-generated method stub
		int player_id = obj.getInt("player ID");
		int room_id = server.Lobby.get(player_id);
		ArrayList<String> players = new ArrayList<String>();
		for (Entry<String, Integer> room : server.Lobby.entrySet()) {
			String Player_id = room.getKey();
			int number = room.getValue();
			if (number == room_id) {
				String json = a.get_aPlayerInfo(Player_id);
				JSONObject js = new JSONObject(json);
				String uname = js.getString("username");
				players.add(uname);
				// Reset point
				server.Point.replace(Player_id, 0);
				
			}
		}
		
		String unames = String.join("\",\"", players);
		
		String s = a.get_matchSetting();
		// Add first number
		int range = 100;
		int first_number = (int)(Math.random() *range) + 1;
		s += "\"NextNumber\": "+first_number+",\n";
		s += "\"Players\": [\""+ unames +"\"]}";
		
		return s;
	}

	private static String cleanupLobby(JSONObject obj) throws JSONException {
		// TODO Auto-generated method stub
		String playerID = obj.getString("player ID");
		if (server.Lobby.containsKey(playerID)) {
			server.Lobby.remove(playerID);
		}
		if (server.Player.containsKey(playerID)) {
			server.Player.remove(playerID);
		}
		
		return "\"Error code:\" \"Er0\"";
	}

	private static String cleanupRoom(JSONObject obj) throws JSONException {
		// TODO Auto-generated method stub
		String playerID = obj.getString("player ID");
		if (server.Lobby.containsKey(playerID)) {
			server.Lobby.replace(playerID, -1);
		}
		return "\"Error code:\" \"Er0\"";
	}

	private static String joinRoom(JSONObject obj) throws JSONException {
		// TODO Auto-generated method stub
		int max_player = 3;
		String id_room = obj.getString("player ID");
		HashMap<Integer,Integer> rooms = new HashMap<Integer,Integer>();
		
		for (Entry<String, Integer> room : server.Lobby.entrySet()) {
	          int number = room.getValue();
	          if (rooms.get(number) == null) rooms.put(number, 1);
	          else rooms.put(number, rooms.get(number)+1);
        }

		for (Entry<Integer, Integer> room : rooms.entrySet()) {
			int room_id =  room.getKey();
			int number = room.getValue();
			if (number < max_player) {
				server.Lobby.put(id_room, room_id);
				return "\"Error code:\" \"Er0\"";
				}
		}
		
		return createRoom(obj);
	}

	private static String createRoom(JSONObject obj) throws JSONException {
		// TODO Auto-generated method stub

		for (int i=1;i<=server.Lobby.size()+1;i++) {
			if (server.Lobby.containsValue(i)) continue;
			else {
				server.Lobby.put(obj.getString("player ID"), i);
				if (!obj.getString("player2 ID").isEmpty()) {
					server.Lobby.put(obj.getString("player2 ID"), i);
				}
				
				break;
			}
		}
		return "\"Error code:\" \"Er0\"";
	}

}
